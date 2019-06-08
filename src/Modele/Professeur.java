/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;


/**
 *
 * @author AYMERIC
 */
public class Professeur extends Personne{
    private int idProfesseur;
    
    
    public Professeur(int _idPersonne,  String _type_pers, String _nom_pers, String _prenom_pers, int _idProfesseur){
        super(_idPersonne, _type_pers, _nom_pers, _prenom_pers);
        idProfesseur = _idProfesseur;
    }

    public Professeur() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdProfesseur() {
        return idProfesseur;
    }

    public void setIdProfesseur(int idProfesseur) {
        this.idProfesseur = idProfesseur;
    }
    
}
