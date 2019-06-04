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
public class Personne {
    protected int idPersonne;
    protected String type_pers;
    protected String nom_pers;
    protected String prenom_pers;
    
    
    public Personne(int _idPersonne, String _type_pers, String _nom_pers, String _prenom_pers){
        idPersonne = _idPersonne;
         type_pers = _type_pers;
         nom_pers = _nom_pers;
         prenom_pers = _prenom_pers;
        
                
    }

    public Personne() {
    // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getType_pers() {
        return type_pers;
    }

    public void setType_pers(String type_pers) {
        this.type_pers = type_pers;
    }

    public String getNom_pers() {
        return nom_pers;
    }

    public void setNom_pers(String nom_pers) {
        this.nom_pers = nom_pers;
    }

    public String getPrenom_pers() {
        return prenom_pers;
    }

    public void setPrenom_pers(String prenom_pers) {
        this.prenom_pers = prenom_pers;
    }

    
    
    
}
