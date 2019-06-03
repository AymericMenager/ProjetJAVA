/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.GregorianCalendar;

/**
 *
 * @author AYMERIC
 */
public class Personne {
    protected int idPersonne;
    protected String type_pers;
    protected String nom_pers;
    protected String prenom_pers;
    protected GregorianCalendar DateDeNaissance;
    
    public Personne(int _idPersonne, String _type_pers, String _nom_pers, String _prenom_pers, GregorianCalendar _dob){
        idPersonne = _idPersonne;
         type_pers = _type_pers;
         nom_pers = _nom_pers;
         prenom_pers = _prenom_pers;
        DateDeNaissance = _dob;
                
    }
    
    
    
}
