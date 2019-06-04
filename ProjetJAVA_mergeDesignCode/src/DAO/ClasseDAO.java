/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Classe;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laure
 */
public class ClasseDAO extends DAO<Classe>{

    public ClasseDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Classe obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
           statement.executeUpdate("INSERT INTO classe(IdClasse, NomClasse, Niveau, IdAnneeSco)"+"VALUES(NULL, '"+obj.getNomClasse()+"', '"+obj.getNiveauClasse()+"', 1)");
        }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }
    
    @Override
    public Classe returnClasse(String nom, String niveau){
         Classe classe = new Classe();
       try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE NomClasse = " + nom+" AND Niveau = "+niveau);

            if (resultat.first()) {
                classe = new Classe(resultat.getInt("IdClasse"), nom, resultat.getString("Niveau"), resultat.getInt("IdAnneeSco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classe;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe find(int id) {
        Classe classe = new Classe();
        try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM classe WHERE IdClasse = " + id);

            if (resultat.first()) {
                    classe = new Classe(id, resultat.getString("NomClasse"), resultat.getString("Niveau"), resultat.getInt("IdAnneeSco"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classe;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

}
