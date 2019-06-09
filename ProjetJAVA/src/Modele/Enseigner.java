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
public class Enseigner {
    
    private int idClasse, idProf, idMatiere;
    
    public Enseigner(int _idClasse, int _idProf, int _idMatiere){
        idClasse = _idClasse;
        idProf =_idProf;
        idMatiere = _idMatiere;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }
}
