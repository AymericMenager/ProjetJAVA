/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Bulletin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public class BulletinDAO extends DAO<Bulletin>{

    public BulletinDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Bulletin obj) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
            System.out.println("appreciation: "+obj.getAppreciation_generale()+", idtrimestre: "+obj.getIdTrimestre()+", ideleve: "+obj.getIdEleve());
           statement.executeUpdate("INSERT INTO bulletin(IdBulletin,  Appreciation_generale, IdTrimestre, IdEleve)"
                   +" VALUES (NULL, '"+obj.getAppreciation_generale()+"',"+obj.getIdTrimestre()+","+obj.getIdEleve()+" )");
           
          }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }

    @Override
    public boolean delete(Bulletin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Bulletin obj, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
   public Bulletin find(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Bulletin bull=new Bulletin();
        
        try {
            DAO<Bulletin> bullDao = FactoryDAO.getBulletinDAO();
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM bulletin WHERE IdEleve = " + id);

            if (resultat.first()) {
                    bull = new Bulletin(resultat.getInt("IdBulletin"), resultat.getString("Appreciation_generale"), resultat.getInt("IdTrimestre"), resultat.getInt("IdEleve"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bull;
    }

    @Override
    public Bulletin returnClasse(String nom, String niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Bulletin find_bis(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
