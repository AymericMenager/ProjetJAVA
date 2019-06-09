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
public class Notes {
    private int idNote;
    private float valeurNote;
    private String appreciation;
    private int idMatiere;
    private int idEleve;
    private int idBulletin;
    
    
    public Notes(int _idNote, float _valeurNote, String _appreciation, int _idMatiere, int _idEleve, int _idBulletin){
        idNote = _idNote;
        valeurNote = _valeurNote;
        appreciation = _appreciation;
        idMatiere = _idMatiere;
        idEleve = _idEleve;
        idBulletin = _idBulletin;
    }

    public Notes() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdBulletin() {
        return idBulletin;
    }

    public void setIdBulletin(int idBulletin) {
        this.idBulletin = idBulletin;
    }


    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public float getValeurNote() {
        return valeurNote;
    }

    public void setValeurNote(float valeurNote) {
        this.valeurNote = valeurNote;
    }

    public String getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(String appreciation) {
        this.appreciation = appreciation;
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }
    
}
