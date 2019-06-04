/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Eleve;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laure
 */
public class EleveDAO extends DAO<Eleve> {

    public EleveDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Eleve obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
          try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
            System.out.print("id classe de lobjet: "+obj.getIdClasse());
           statement.executeUpdate("INSERT INTO eleve(IdEleve, IdPersonne, IdClasse)"+"VALUES(NULL, "+obj.getIdPersonne()+", "+obj.getIdClasse()+")");
            
          }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }

    @Override
    public boolean delete(Eleve obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Eleve obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Eleve find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Eleve returnClasse(String nom, String niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
