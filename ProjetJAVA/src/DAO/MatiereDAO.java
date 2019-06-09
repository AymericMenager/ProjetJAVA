/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Matiere;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public class MatiereDAO extends DAO<Matiere> {

    public MatiereDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Matiere obj) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
           statement.executeUpdate("INSERT INTO matiere(IdMatiere, Nom_matiere)"
                   +" VALUES (NULL,"+obj.getNom_matiere()+")");
           
          }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }

    @Override
    public boolean delete(Matiere obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public boolean update(Matiere obj, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matiere find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matiere returnClasse(String nom, String niveau) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         Matiere matiere = new Matiere();
       try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM matiere WHERE Nom_matiere ="+nom);

            if (resultat.first()) {
                matiere = new Matiere(resultat.getInt("IdMatiere"), nom);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matiere;
    }

    @Override
    public int returnMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int returnSizeTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList returnIDs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Matiere find_bis(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
