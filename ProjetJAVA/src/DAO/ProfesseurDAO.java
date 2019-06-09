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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
           statement.executeUpdate("INSERT INTO professeur( IdProf, IdPersonne)"
                   +" VALUES (NULL, "+obj.getIdPersonne()+")");
           
          }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
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
    public boolean update(Professeur obj, String nom, String prenom) {
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
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM professeur WHERE IdPersonne = " + id);

            if (resultat.first()) {
                professeur = new Professeur(id, persDao.find(resultat.getInt("IdPersonne")).getType_pers(),
                        persDao.find(resultat.getInt("IdPersonne")).getNom_pers(), persDao.find(resultat.getInt("IdPersonne")).getPrenom_pers(),resultat.getInt("IdProf"));
            }
        }catch(SQLException e )
        {
            e.printStackTrace();
        }
        return professeur ;
    }
     
     @Override
     public Professeur find_bis(int id){
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
           Professeur professeur = new Professeur();
       try {
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM professeur WHERE Nom_pers ="+nom+" AND Prenom_pers="+niveau);

            if (resultat.first()) {
               // professeur = new Professeur(resultat.getInt("IdPersonne"),resultat.getString("Type_pers"), nom, niveau);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professeur;
    }

    @Override
    public int returnMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int returnSizeTable() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         int size_table=0;
        try{
              
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM professeur");				
            //Extact result from ResultSet rs
            while(rs.next()){
                System.out.println("Nombre de prof SQL: "+rs.getInt("COUNT(*)"));				
              }
             size_table =  rs.getInt("COUNT(*)");
            // close ResultSet rs

        }catch (SQLException e )
        {
            e.getStackTrace(); 
             
        }
        return size_table;
    }

    @Override
    public ArrayList returnIDs() {
        ArrayList list_id = new ArrayList();
    
    try{
        Statement statement = connect.createStatement();
       ResultSet res =  statement.executeQuery("SELECT IdProf FROM professeur");
       int i=0;
         while(res.next()){
             list_id.add(res.getInt("IdProf"));
                System.out.println("ID: "+res.getInt("IdProf"));
                i++;
              }
        
    }catch (SQLException e )
        {
            e.getStackTrace();  
        }
    return list_id;
    }

    
}
