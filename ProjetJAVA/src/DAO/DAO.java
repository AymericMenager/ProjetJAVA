/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modele.Personne;
import java.sql.Connection;  
import java.util.ArrayList;

/**
 *
 * @author Laure
 */
public abstract class DAO <T>{
    protected Connection connect = null; 
    
    public DAO(Connection _connect){
        connect = _connect ; 
        
    }
    
    public abstract boolean create (T obj); 
    public abstract boolean delete (T obj);
     public abstract boolean update (T obj , String nom, String prenom); 
    public abstract T find (int id); 
    public abstract T returnClasse(String nom, String niveau); 
    public abstract int returnMaxID();
    public abstract int returnSizeTable();
    public abstract ArrayList returnIDs();
     public abstract T find_bis(int id);

    public boolean delete(DAO<Personne> persDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
