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
public class Bulletin {
    private int idBulletin;
    private String appreciation_generale;
    
    public Bulletin(int _idBulletin, String ag){
        idBulletin = _idBulletin;
        appreciation_generale = ag;
    }

    public int getIdBulletin() {
        return idBulletin;
    }

    public void setIdBulletin(int idBulletin) {
        this.idBulletin = idBulletin;
    }

    public String getAppreciation_generale() {
        return appreciation_generale;
    }

    public void setAppreciation_generale(String appreciation_generale) {
        this.appreciation_generale = appreciation_generale;
    }
    
    
}
