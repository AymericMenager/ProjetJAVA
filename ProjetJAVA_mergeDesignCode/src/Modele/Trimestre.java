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
public class Trimestre extends AnneeSco{
    private int idTrimestre;
    private int numero_trimestre;
    private GregorianCalendar date_deb;
    private GregorianCalendar date_fin;
    
    public Trimestre(int idAnneeSco, int idTrimestre, int numero_trimestre, GregorianCalendar date_deb, GregorianCalendar date_fin){
        super(idAnneeSco);
        this.idTrimestre = idTrimestre;
        this.numero_trimestre = numero_trimestre;
        this.date_deb = date_deb;
        this.date_fin = date_fin;
    }

    public int getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public int getNumero_trimestre() {
        return numero_trimestre;
    }

    public void setNumero_trimestre(int numero_trimestre) {
        this.numero_trimestre = numero_trimestre;
    }

    public GregorianCalendar getDate_deb() {
        return date_deb;
    }

    public void setDate_deb(GregorianCalendar date_deb) {
        this.date_deb = date_deb;
    }

    public GregorianCalendar getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(GregorianCalendar date_fin) {
        this.date_fin = date_fin;
    }
    
}
