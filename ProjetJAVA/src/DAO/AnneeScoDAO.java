/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modele.*; 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Laure
 */
public class AnneeScoDAO extends DAO<AnneeSco>{

    public AnneeScoDAO (Connection conn){
        super (conn); // ce constrcteur va récupérer la classe AnneSco du package Modele 
        
    }

    @Override
    public boolean create(AnneeSco obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(AnneeSco obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     @Override
    public boolean update(AnneeSco obj, String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnneeSco find(int id) {
        AnneeSco anneeSco = new AnneeSco(); 
        
        try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, 
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM annee_scolaire WHERE idAnneeSco = " +id); 
            if (resultat.first())
            {
                anneeSco = new AnneeSco(id, resultat.getInt("Annee_deb"), resultat.getInt("Annee_fin")); 
                
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            //Logger.getLogger(AnneeScoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return anneeSco; 
       }

    @Override
    public AnneeSco returnClasse(String nom, String niveau) {
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
    public AnneeSco find_bis(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
