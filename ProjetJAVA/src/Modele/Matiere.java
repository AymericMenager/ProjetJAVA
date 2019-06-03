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
public class Matiere {
    private int idMatiere;
    private String nom_matiere;
    
    public Matiere(int _idMatiere, String _nom_matiere){
        idMatiere = _idMatiere;
        nom_matiere = _nom_matiere;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

}
