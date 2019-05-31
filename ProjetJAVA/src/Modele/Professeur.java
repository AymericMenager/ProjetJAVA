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
public class Professeur extends Personne{
    private int idProfesseur;
    
    
    public Professeur(int _idPersonne,  String _type_pers, String _nom_pers, String _prenom_pers, GregorianCalendar _dob, int _idProfesseur){
        super(_idPersonne, _type_pers, _nom_pers, _prenom_pers,_dob );
        idProfesseur = _idProfesseur;
    }

    public int getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }
    
}
