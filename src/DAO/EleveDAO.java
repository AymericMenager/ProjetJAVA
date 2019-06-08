/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Eleve;
import Modele.Personne;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
            System.out.print("id personne de lobjet: "+obj.getIdPersonne());
           statement.executeUpdate("INSERT INTO eleve(IdEleve, IdPersonne, IdClasse)"+" VALUES (NULL, "+obj.getIdPersonne()+", "+obj.getIdClasse()+")");
            
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         
          Eleve eleve = new Eleve();
        try {
            DAO<Personne> persDao = FactoryDAO.getPersonneDAO();
            ResultSet resultat = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE IdEleve = " + id);

            if (resultat.first()) {
                eleve = new Eleve(resultat.getInt("IdPersonne"), persDao.find(resultat.getInt("IdPersonne")).getType_pers(),
                        persDao.find(resultat.getInt("IdPersonne")).getNom_pers(), persDao.find(resultat.getInt("IdPersonne")).getPrenom_pers(),  resultat.getInt("IdClasse"), id);
            }
            /* System.out.println(resultat.getInt("IdPersonne"));
              System.out.println(persDao.find(resultat.getInt("IdPersonne")).getType_pers());
               System.out.println(persDao.find(resultat.getInt("IdPersonne")).getNom_pers());
               System.out.println(persDao.find(resultat.getInt("IdPersonne")).getPrenom_pers());
               System.out.println(resultat.getInt("IdClasse"));*/
              

        } catch (SQLException e) {
            e.printStackTrace();
        }
       
        return eleve;
    }

    @Override
    public Eleve returnClasse(String nom, String niveau) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int returnMaxID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int returnSizeTable(){
      int size_table=0;
        try{
              
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM eleve");				
            //Extact result from ResultSet rs
            while(rs.next()){
                System.out.println("Nombre d'eleve SQL: "+rs.getInt("COUNT(*)"));				
              }
             size_table =  rs.getInt("COUNT(*)");
            // close ResultSet rs

        }catch (SQLException e )
        {
            e.getStackTrace(); 
             
        }
        return size_table;
    }
    
    
    // TOUCHE A RIEN CA MARCHE !!!
    @Override
    public ArrayList returnIDs(){
        ArrayList list_id = new ArrayList();
    
    try{
        Statement statement = connect.createStatement();
       ResultSet res =  statement.executeQuery("SELECT IdEleve FROM eleve");
       int i=0;
         while(res.next()){
             list_id.add(res.getInt("IdEleve"));
                System.out.println("ID: "+res.getInt("IdEleve"));
                i++;
              }
        
    }catch (SQLException e )
        {
            e.getStackTrace();  
        }
    return list_id;
    }
}
