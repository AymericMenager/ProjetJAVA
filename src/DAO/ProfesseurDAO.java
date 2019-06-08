/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Personne;
import Modele.Professeur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public class ProfesseurDAO extends DAO<Professeur>{

    public ProfesseurDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Professeur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Professeur obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            Statement statement = connect.createStatement(); 
            System.out.println(obj.getIdProfesseur());
            statement.executeUpdate("DELETE FROM professeur WHERE IdProf = "+obj.getIdProfesseur()+" "); 
            
        }catch(SQLException e)
        {
            e.getStackTrace(); 
            return false; 
            
        }return true ; 
    }

    @Override
    public boolean update(Professeur obj, String nom, String Prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professeur find(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Professeur professeur = new Professeur();
        try{
            DAO<Personne> persDao = FactoryDAO.getPersonneDAO();
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM professeur WHERE IdProf = " + id);

            if (resultat.first()) {
                professeur = new Professeur(resultat.getInt("IdPersonne"), persDao.find(resultat.getInt("IdPersonne")).getType_pers(),
                        persDao.find(resultat.getInt("IdPersonne")).getNom_pers(), persDao.find(resultat.getInt("IdPersonne")).getPrenom_pers(), id);
            }
        }catch(SQLException e )
        {
            e.printStackTrace();
        }
        return professeur ;
    }

    @Override
    public Professeur returnClasse(String nom, String niveau) {
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
