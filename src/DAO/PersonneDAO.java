/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Classe;
import Modele.Personne;
import Modele.Professeur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Laure
 */
public class PersonneDAO extends DAO<Personne> {

    public PersonneDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Personne obj) {

        
        try {

            Statement statement = connect.createStatement();

            statement.executeUpdate("INSERT INTO personne (IdPersonne, Type_pers, Nom_pers, Prenom_pers)"
                    + " VALUES (NULL, '" + obj.getType_pers() + "','" + obj.getNom_pers() + "','" + obj.getPrenom_pers() + "')");

        } catch (SQLException e) {
            e.printStackTrace();
            return false;

        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }
    
    

    @Override
    public boolean delete(Personne obj) {
        try {
            Statement statement = connect.createStatement();

            // on veut supprimer la personne de la table personne en passant par l'item 
            statement.executeUpdate("DELETE FROM personne WHERE IdPersonne ='" + obj.getIdPersonne() + "'");
            //statement.executeUpdate("DELETE FROM personne WHERE IdPersonne ='"+idPersonne+"'"); 

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("erreur de suppression");
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return true;
    }

    @Override
    public boolean update(Personne obj, String nom, String prenom) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Statement statement = connect.createStatement(); 
            //Scanner sc = new Scanner(System.in); 
            
            statement.executeUpdate("UPDATE personne SET Nom_pers='"+nom+"', Prenom_pers ='"+prenom+"' "
                    + "WHERE Nom_pers = '"+obj.getNom_pers()+"' AND Prenom_pers = '"+obj.getPrenom_pers()+"' ");// nom prenom 
        }catch(SQLException e)
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true; 
    }

    @Override
    public Personne find(int id) {
        Personne personne = new Personne();
        try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE IdPersonne = " + id);

            if (resultat.first()) {
                personne = new Personne(id, resultat.getString("Type_pers"), resultat.getString("Nom_pers"), resultat.getString("Prenom_pers"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personne;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Personne returnClasse(String nom, String prenom) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Personne personne = new Personne();
       try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM personne WHERE Nom_pers ="+nom+" AND Prenom_pers="+prenom);

            if (resultat.first()) {
                personne = new Personne(resultat.getInt("IdPersonne"),resultat.getString("Type_pers"), nom, prenom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personne;
    }
    
    

    @Override
    public int returnMaxID() {
         Personne personne = new Personne();
        try{ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT MAX(IdPersonne) FROM personne");

        
            if (resultat.first()) {
                personne = new Personne(7/*Integer.parseInt(resultat.getString("IdPersonne"))*/, resultat.getString("Type_pers"), resultat.getString("Nom_pers"), resultat.getString("Prenom_pers"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(personne.getIdPersonne()>=0)
        return personne.getIdPersonne();
        else{
            return -1;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int returnSizeTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList returnIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
