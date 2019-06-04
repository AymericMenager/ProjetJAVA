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
public class Eleve extends Personne  {
    private int idClasse;
    private int idEleve;
    
    public Eleve(int _idPersonne,  String _type_pers, String _nom_pers, String _prenom_pers, int _idClasse, int _idEleve){
        super(_idPersonne, _type_pers, _nom_pers, _prenom_pers );
        idClasse = _idClasse;
        idEleve = _idEleve;
    }

    public int getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(int idClasse) {
        this.idClasse = idClasse;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }
}
