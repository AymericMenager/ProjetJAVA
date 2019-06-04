/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.*; 
import java.sql.Connection;
import java.util.*; 
import java.util.logging.Level;
import java.util.logging.Logger;


public class FactoryDAO {
    /**
     * constante static qui contien une varibale de connexion de la class
     */

    protected static final Connection connect;
    
    /*
     *  moyen pour initier la dernière variable et générer des exception 
     */
    static{
        
        Connection tempo = null; 
        
        try 
        {
            // identifiant de connexion 
            String user ="root";
            String password = ""; 

            // ouverture d'une connexion sur une base MySQL et résupération d'un objet de type class 
            // chargement de la classe par son nom 
            Class.forName("com.mysql.jdbc.Driver");

            // enregistrement du pilote auprèsdes gestionnaires de pilotes JDBC de la machine Java soit un protocole de connexion 
            // jdbc::mysql:// : protocol URI 
            tempo = DriverManager.getConnection("jdbc:mysql://localhost/projet_java", user, password);


        } catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(FactoryDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur de connection");
        }
	
        connect = tempo; 
	
      }
    
    public static DAO getAnneScoDAO(){
        return new AnneeScoDAO(connect); 
    }
    
    public static DAO getBulletinDAO(){
        return new BulletinDAO(connect); 
    }
    
    public static DAO getClasseDAO(){
        return new ClasseDAO(connect); 
    }
    
    public static DAO getEleveDAO(){
        return new EleveDAO(connect); 
    }
    
    public static DAO getMatiereDAO(){
        return new MatiereDAO(connect); 
    }
    
    public static DAO getNotesDAO(){
        return new NotesDAO(connect); 
    }
    
    public static DAO getPersonneDAO(){
        return new PersonneDAO(connect); 
    }
    
    public static DAO getProfesseurDAO(){
        return new ProfesseurDAO(connect); 
    }
    
    public static DAO getTrimestreDAO(){
        return new TrimestreDAO(connect); 
    }
    

}



