/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Modele.Personne;
import java.sql.Connection;  

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
    public abstract boolean update (T obj); 
    public abstract T find (int id); 
    public abstract T returnClasse(String nom, String niveau); 

    public boolean delete(DAO<Personne> persDAO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
