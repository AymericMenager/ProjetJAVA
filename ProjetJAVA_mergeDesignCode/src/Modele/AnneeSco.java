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
public class AnneeSco {
    protected  int idAnneeSco;
    protected int annee_deb;
    protected int annee_fin;
    
    public AnneeSco(int _idAnneeSco, int _annee_deb, int _annee_fin){
        idAnneeSco = _idAnneeSco;
        annee_deb = _annee_deb;
       annee_fin = _annee_fin;
    }
     public AnneeSco(int _idAnneeSco){
        idAnneeSco = _idAnneeSco;
    }

    public AnneeSco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdAnneeSco() {
        return idAnneeSco;
    }

    public void setIdAnneeSco(int idAnneeSco) {
        this.idAnneeSco = idAnneeSco;
    }

    public int getAnnee_deb() {
        return annee_deb;
    }

    public void setAnnee_deb(int annee_deb) {
        this.annee_deb = annee_deb;
    }

    public int getAnnee_fin() {
        return annee_fin;
    }

    public void setAnnee_fin(int annee_fin) {
        this.annee_fin = annee_fin;
    }

    
    
}
