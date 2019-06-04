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

        Scanner sc = new Scanner(System.in);
        try {

            Statement statement = connect.createStatement();

            statement.executeUpdate("INSERT INTO personne (IdPersonne, Type_pers, Nom_pers, Prenom_pers)"
                    + " VALUES (NULL, '" + obj.getType_pers() + "','" + obj.getNom_pers() + "','" + obj.getPrenom_pers() + "')");

          /*  if ("eleve".equals(obj.getType_pers())) {

                String nom_classe, niveau;
                System.out.println("Quel nom de classe ?");
                nom_classe = sc.next();
                System.out.println("Quel niveau de classe ?");
                niveau = sc.next();
                System.out.println("bg");
               // ResultSet result = statement.executeQuery("SELECT * FROM classe WHERE NomClasse='TD08' AND Niveau='ING3' ");
System.out.println("bg7");
              //  System.out.println(result.getString(1));
                //statement.executeUpdate("INSERT INTO classe(IdClasse, NomClasse, Niveau, IdAnneeSco)"+"VALUES(NULL, '"+classe+"', '"+niveau+"', NULL)");
                statement.executeUpdate("INSERT INTO eleve (IdEleve, IdPersonne, IdClasse)"
                        + " VALUES (NULL, ' " + obj.getIdPersonne() + " ',1)");
                System.out.println("la personne a ete mise dans eleve");
            }*/

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
    public boolean update(Personne obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

}
