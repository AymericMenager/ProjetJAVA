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
    private int idBulletin, idTrimestre, idEleve;
    private String appreciation_generale;
    
    public Bulletin(int _idBulletin, String ag, int _idTrimestre, int _idEleve){
        idBulletin = _idBulletin;
        appreciation_generale = ag;
        idTrimestre = _idTrimestre;
        idEleve = _idEleve;
    }

    public Bulletin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdTrimestre() {
        return idTrimestre;
    }

    public void setIdTrimestre(int idTrimestre) {
        this.idTrimestre = idTrimestre;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
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
