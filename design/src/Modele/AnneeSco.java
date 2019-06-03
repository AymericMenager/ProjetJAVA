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
    
}
