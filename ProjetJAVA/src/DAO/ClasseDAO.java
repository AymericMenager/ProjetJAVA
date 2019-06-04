/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modele.Classe;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Laure
 */
public class ClasseDAO extends DAO<Classe>{

    public ClasseDAO(Connection _connect) {
        super(_connect);
    }

    @Override
    public boolean create(Classe obj) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            // on veut créer la classe de l'élève 
            Statement statement = connect.createStatement();
            statement.executeUpdate("INSERT INTO classe(IdClasse, NomClasse, Niveau, IdAnneeSco)"+"VALUES(NULL, '"+obj.getNomClasse()+"', '"+obj.getNiveauClasse()+"', 1)");
            
            
                 
        }catch (SQLException e )
        {
            e.getStackTrace(); 
            return false ; 
        }
        return true ; 
    }

    @Override
    public boolean delete(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Classe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
