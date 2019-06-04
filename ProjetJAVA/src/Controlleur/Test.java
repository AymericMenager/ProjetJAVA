/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import DAO.*;
import Modele.Classe;
import Modele.Eleve;
import Modele.Personne;

import java.util.Scanner;

/**
 *
 * @author AYMERIC
 */
public class Test {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("MENU");
        System.out.println("1. Ajouter une personne élève ou professeur");
        System.out.println("2. Supprimer un élément de la table personne");
        System.out.println("ajout d'éleve et prof");
        Scanner sc = new Scanner(System.in);

        int choix = 0;

        choix = sc.nextInt();
        switch (choix) {
            case 1:
                System.out.println("on veut créer une nouvelle personne");
                int id_pers;
                String type;
                String nom;
                String prenom;

                System.out.println("Veuillez entrer son nom et son prénom, son niveau et sa classe");
                id_pers = 0;
                type = "eleve";
                nom = sc.next();
                prenom = sc.next();

                int idClasse = 0;
                int idAnneeSco = 0;

                Personne pers = new Personne(id_pers, type, nom, prenom);

                DAO<Personne> persDao = FactoryDAO.getPersonneDAO();
                
               

                if (persDao.create(pers)) {
                    System.out.println("la personne " + prenom + " a été créée avec succès");
                

                if ("eleve".equals(pers.getType_pers())) {
                    String nom_classe, niveau;
                    System.out.println("Quel nom de classe ?");
                    nom_classe = sc.next();
                    System.out.println("Quel niveau de classe ?");
                    niveau = sc.next();
                    Classe classe = new Classe(idClasse, nom_classe, niveau, idAnneeSco);
                     DAO<Classe>classeDAO = FactoryDAO.getClasseDAO();
                    if(classeDAO.create(classe)){
                         System.out.println("la classe " + nom_classe + " a été créée avec succès");
                         Eleve eleve = new Eleve(id_pers, type,nom, prenom , 16,2);
                         DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
                         if(eleveDAO.create(eleve)){
                             System.out.println("l'élève " + pers.getPrenom_pers() + " a été créée avec succès");
                         }else{
                        System.out.println("l'eleve bug");
                    }
                    }else{
                        System.out.println("la classe bug");
                    }
                }
        }

                break;

            case 2:
                System.out.println("\n");
                //il faut déjà trouver l'élément à supprimer(avec la méthode find) puis le supprimer en appelant la méthode delete
                int id_pers_sup;
                System.out.println("Veuillez entrer l'id de la personne que vous voulez supprimer de la bdd : ");
                id_pers_sup = sc.nextInt();

                DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();

                Personne pers_sup = persDAO.find(id_pers_sup);
                System.out.println(pers_sup.getIdPersonne());
                if (persDAO.delete(pers_sup)) {
                    System.out.println("personne supprimé");
                }
                // affichage de la personne recherchée 
                /* System.out.println("Personne N°"+personne_sup.getIdPersonne()+", Type : "+personne_sup.getType_pers()+
                        ", Nom : "+personne_sup.getNom_pers()+", Prenom : "+personne_sup.getPrenom_pers());*/

                // condition pour supprimer cette personne à partir de son id 
                /*if (persDAO.delete(personne_sup))
                {
                    System.out.println("la personne "+personne_sup.getPrenom_pers()+"a été supprimée avec succès\n");
                }*/
                break;

            case 3:
                break;
        }

        //Fenetre f = new Fenetre();
    }

}
