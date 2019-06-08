/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Notes;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public class NotesDAO extends DAO<Notes>{

    public NotesDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Notes obj) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
            System.out.println("SQL: Valeur note: "+obj.getValeurNote()+", appreciation: "+ obj.getAppreciation()+", idNote: "+ obj.getIdNote()+", idMatiere: "+obj.getIdMatiere()+", idEleve: "+obj.getIdEleve());
        
            
           statement.executeUpdate("INSERT INTO note(IdNote, Valeur_note, Appreciation_note, IdMatiere, IdEleve)"
                   +" VALUES (NULL, "+obj.getValeurNote()+",'"+obj.getAppreciation()+"',"+obj.getIdMatiere()+","+obj.getIdEleve()+" )");
           
          }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }

    @Override
    public boolean delete(Notes obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Notes obj, String nom, String Prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notes find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Notes returnClasse(String nom, String niveau) {
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
    
}
