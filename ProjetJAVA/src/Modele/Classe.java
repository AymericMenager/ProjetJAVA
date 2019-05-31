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
public class Classe {
    private int idClasse;
    private String nomClasse;
    private String niveauClasse;
    private String idAnneeSco;
    
    public Classe(int _idClasse, String _nomClasse, String _niveauClasse, String _idAnneeSco){
        idClasse = _idClasse;
        nomClasse = _nomClasse;
        niveauClasse = _niveauClasse;
        idAnneeSco = _idAnneeSco;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getNiveauClasse() {
        return niveauClasse;
    }

    public void setNiveauClasse(String niveauClasse) {
        this.niveauClasse = niveauClasse;
    }

    public String getIdAnneeSco() {
        return idAnneeSco;
    }

    public void setIdAnneeSco(String idAnneeSco) {
        this.idAnneeSco = idAnneeSco;
    }
}
