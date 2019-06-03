/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Classe;
import Modele.Eleve;
import Vue.Fenetre;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 *
 * @author AYMERIC
 */
public class Test {

    public static void main(String[] args) {
        // TODO code application logic here
        // Fenetre f = new Fenetre();
        GregorianCalendar dob = new GregorianCalendar(1998, 10, 16);
        Eleve eleve = new Eleve(1, "eleve", "MENAGER", "Aymeric", dob, 1, 1);
        Classe classe = new Classe(1, "TD08", "ING3", 1);
        try {
             System.out.println("yo");
            Connexion connexion = new Connexion("famille", "root", "");
            connexion.ajouterRequete("SELECT * FROM membre;");
            System.out.println(connexion.remplirChampsRequete("SELECT * FROM membre;"));

        } catch (ClassNotFoundException cnfe) {
            System.out.println("marche ap cnf");
        } catch (SQLException sqle) {
            System.out.println("marche ap sql");
        }

    }

}
