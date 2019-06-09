/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.DAO;
import DAO.FactoryDAO;
import DAO.Reporting;
import Modele.Bulletin;
import Modele.Classe;
import Modele.Eleve;
import Modele.Enseigner;
import Modele.Matiere;
import Modele.Notes;
import Modele.Personne;
import Modele.Professeur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author AYMERIC
 */
public class Fenetre extends JFrame implements ActionListener {

    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */
    private final JButton backFromResearchToMenu, backFromMajToMenu, backFromInscToMaj, backFromEditNoteToMaj, backFromBulletinToResearch, backFromReportingToMenu;

    //Attribut de la page de connexion
    private final JLabel Accueil, Identifiant, Password, nameBDD, trash, trash1, trash2, trash3;
    private final JTextField IdTexte, NomBDDTexte;
    private final JPasswordField PwTexte;
    private final JButton connect;
    private final JPanel title_panel, form_panel, p2, grid_connexion;

    //Attribut de la page du menu
    private final JButton rechercher_info, maj, reporting, afficher_prof;
    private final JPanel panel_menu, grid_menu;

    //Attributs de la page de résultat de la recherche
    private final JPanel panel_result, grid_tab, grid_result, eleve_display;
    private final JLabel title_result, id_eleve_txt, nom_eleve_txt, prenom_eleve_txt, niveau_txt, nom_classe_txt, annee_sco_txt;

    //Attributs de la page des bulletins
    private final JPanel panel_bull, grid_tab_bull, grid_bull, bull_display;
    private final JLabel title_bull, bull_nom_txt, bull_prenom_txt, bull_appreciation_txt, bull_note_txt;
    
    //Attribut de lapage enseignement
    private final JPanel panel_ens, grid_ens;
    private final JLabel title_ens;

    //Attributs de la page du reporting
    private final JPanel panel_reporting, reporting_display;

    //Attributs de la page de mise à jour
    private final JPanel panel_maj, grid_maj;
    private final JButton inscription_eleve, editer_note, creer_bulletin, ajouter_prof, update_eleve, delete_eleve, delete_prof;

    //Attribut de la page inscription eleve
    private final JPanel panel_inscription, form_inscription, grid_inscription;
    private final JButton submit_inscription;
    private final JTextField nom_eleve_insc, prenom_eleve_insc, niveau_insc, nom_classe_insc;
    private final JLabel title_inscription, nom_eleve_champ, prenom_eleve_champ, niveau_champ, classe_champ;

    //Attribut de la page edit note
    private final JLabel title_note, nom_eleve_note_txt, prenom_eleve_note_txt, id_eleve_note_txt;
    private final JButton research_eleve_note;
    private final JTextField nom_eleve_note, prenom_eleve_note, id_eleve_note, appreciation_note;
    private final JPanel container, panel_note, form_note, grid_note, validate_btn;
    private final JLabel title_ajout_note, matiere_ajout_note_txt, trimestre_ajout_note_txt, annee_sco_ajout_note_txt, valeur_ajout_note_txt, appreciation_note_txt;
    private final JTextField matiere_ajout_note, trimestre_ajout_note, annee_sco_ajout_note, valeur_ajout_note;
    private final JButton valider_ajout_note;
    private final JPanel panel_ajout_note, form_ajout_note, grid_ajout_note, validate_btn_note;

    //Attribut de la page créer bulletin
    private final JPanel container_bulletin, grid_bulletin, form_bulletin, form_recherche_eleve_bulletin;
    private final JButton recherche_eleve_bulletin, valider_ajout_bulletin;
    private final JTextField title_bulletin, nom_eleve_bulletin, prenom_eleve_bulletin, id_eleve_bulletin, appreciation_bulletin, id_trimestre_bulletin;
    private final JLabel title_bulletin_txt, nom_eleve_bulletin_txt, prenom_eleve_bulletin_txt, id_eleve_bulletin_txt, appreciation_bulletin_txt, id_trimestre_bulletin_txt;

    //Attribut de la page ajout prof
    private final JPanel container_ajouter_prof, container_form_ajouter_prof, form_ajouter_prof;
    private final JLabel title_ajouter_prof, nom_ajouter_prof_txt, prenom_ajouter_prof_txt, matiere_ajouter_prof_txt, nom_classe_ajouter_prof_txt, niveau_classe_ajouter_prof_txt;
    private final JTextField nom_ajouter_prof, prenom_ajouter_prof, matiere_ajouter_prof, nom_classe_ajouter_prof, niveau_classe_ajouter_prof;
    private final JButton valider_ajouter_prof;

    //Attribut de la page de Modification de l'élève 
    private final JPanel big_container_modifier, container_modifier, grid_layout_modif, form_recherche, form_modifier, panel_recherche, panel_nom_prenom;
    private final JButton Rechercher_id_eleve_modifie, Update_eleve_modifie;
    private final JTextField selectionner_id_eleve, nom_eleve, prenom_eleve;
    private final JLabel titre_selection_eleve_mofifie_txt, id_recherche_eleve_modifier_txt, title_modification_eleve_txt, nom_modifier_eleve_txt, prenom_modifier_eleve_txt;

    //Attribut de suppression de l'eleve
    private final JPanel container_suppression, form_suppression, grid_suppression;
    private final JButton supprimer_eleve;
    private JTextField selection_id_eleve_supprime;
    private JLabel titre_suppression_eleve_txt, id_eleve_supprimer_txt;

    //Attribut de la suppression d'un professeur 
    private final JPanel container_suppression_prof, form_suppression_prof, grid_suppression_prof;
    private final JButton supprimer_prof;
    private JTextField selection_id_prof_supprime;
    private JLabel titre_suppression_prof_txt, id_prof_supprimer_txt;

    /**
     * Constructeur qui initialise tous les objets graphiques de la fenetre
     */
    public Fenetre() {

        // creation par heritage de la fenetre
        super("SchoolMonitor - Gestion d'Ecole");

        // mise en page (layout) de la fenetre visible
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setLocationRelativeTo(null);
        setResizable(true);
        setVisible(true);

        // CREATION DES BOUTTONS
        //Bouttons retour
        backFromResearchToMenu = new JButton("Retour");
        backFromMajToMenu = new JButton("Retour");
        backFromInscToMaj = new JButton("Retour");
        backFromEditNoteToMaj = new JButton("Retour");
        backFromBulletinToResearch = new JButton("Retour");
        backFromReportingToMenu = new JButton("Retour");

        //Page connexion
        connect = new JButton("Se Connecter");

        //Page menu
        rechercher_info = new JButton("Rechercher des informations");
        maj = new JButton("Mettre à jour les données");
        reporting = new JButton("Reporting");
        afficher_prof = new JButton("Afficher les enseignements");

        //Page mise à jour
        inscription_eleve = new JButton("Inscrire un élève");
        editer_note = new JButton("Entrer/Modifier une note");
        creer_bulletin = new JButton("Creer le bulletin d'un élève");
        ajouter_prof = new JButton("Ajouter un professeur");
        update_eleve = new JButton("Modifier un élève");
        delete_eleve = new JButton("Supprmier un élève");
        delete_prof = new JButton("Supprimer un professeur");

        //Page inscription eleve
        submit_inscription = new JButton("Inscrire");

        //Page edit note
        research_eleve_note = new JButton("Rechercher");

        //Page ajout note
        valider_ajout_note = new JButton("Valider");

        //Page créer bulletin
        recherche_eleve_bulletin = new JButton("Rechercher");
        valider_ajout_bulletin = new JButton("Valider");

        //Page ajout prof
        valider_ajouter_prof = new JButton("Valider");

        //Page update eleve
        Rechercher_id_eleve_modifie = new JButton("Rechercher");
        Update_eleve_modifie = new JButton("Update");

        //Page suppression de l'eleve 
        supprimer_eleve = new JButton("Supprimer");

        //Page suppression de professeur 
        supprimer_prof = new JButton("Supprimer");

        // CREATION DES EDIT-TEXT
        //Page de connexion
        IdTexte = new JTextField(8);
        IdTexte.setPreferredSize(new Dimension(15, 25));
        NomBDDTexte = new JTextField(8);
        PwTexte = new JPasswordField(8);

        //Page de inscription eleve
        nom_eleve_insc = new JTextField(10);
        prenom_eleve_insc = new JTextField(10);
        niveau_insc = new JTextField(4);
        nom_classe_insc = new JTextField(4);

        //Page edit note
        nom_eleve_note = new JTextField(8);
        prenom_eleve_note = new JTextField(8);
        id_eleve_note = new JTextField(8);

        //Page ajout note
        matiere_ajout_note = new JTextField(8);
        trimestre_ajout_note = new JTextField(8);
        annee_sco_ajout_note = new JTextField(8);
        valeur_ajout_note = new JTextField(8);
        appreciation_note = new JTextField(8);

        //Page ajout prof
        nom_ajouter_prof = new JTextField(8);
        prenom_ajouter_prof = new JTextField(8);
        matiere_ajouter_prof = new JTextField(8);
        nom_classe_ajouter_prof = new JTextField(8);
        niveau_classe_ajouter_prof = new JTextField(8);

        //Page update bulletin
        title_bulletin = new JTextField(8);
        nom_eleve_bulletin = new JTextField(8);
        prenom_eleve_bulletin = new JTextField(8);
        appreciation_bulletin = new JTextField(8);
        id_trimestre_bulletin = new JTextField(8);
        id_eleve_bulletin = new JTextField(8);

        //Page update eleve       
        selectionner_id_eleve = new JTextField(8);
        nom_eleve = new JTextField(8);
        prenom_eleve = new JTextField(8);

        //Page de suppression de l'eleve 
        selection_id_eleve_supprime = new JTextField(8);

        //Page de suppression de professeur
        selection_id_prof_supprime = new JTextField(8);

        // CREATION DES LABELS (Textes)
        //Page de Connexion
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        Accueil = new JLabel("Bienvenue !");
        Accueil.setForeground(Color.WHITE);
        Accueil.setFont(font);
        Identifiant = new JLabel("Login :    ", JLabel.RIGHT);
        Identifiant.setForeground(Color.WHITE);
        Password = new JLabel("Password :    ", JLabel.RIGHT);
        Password.setForeground(Color.WHITE);
        nameBDD = new JLabel("Nom de la BDD :    ", JLabel.RIGHT);
        nameBDD.setForeground(Color.WHITE);

        trash = new JLabel("");
        trash1 = new JLabel("");
        trash2 = new JLabel("");
        trash3 = new JLabel("");

        //Page de Résultat de la recherche
        title_result = new JLabel("Informations de l'école", JLabel.CENTER);
        title_result.setForeground(Color.WHITE);
        title_result.setFont(font);
        id_eleve_txt = new JLabel("id eleve");
        nom_eleve_txt = new JLabel("Nom");
        prenom_eleve_txt = new JLabel("Prenom");
        niveau_txt = new JLabel("Niveau");
        nom_classe_txt = new JLabel("Classe");
        annee_sco_txt = new JLabel("Année Sco.");

        //Page de bulletins
        title_bull = new JLabel("Informations de l'école", JLabel.CENTER);
        title_bull.setForeground(Color.WHITE);
        title_bull.setFont(font);
        bull_nom_txt = new JLabel("Nom");
        bull_prenom_txt = new JLabel("Prenom");
        bull_appreciation_txt = new JLabel("Appreciation");
        bull_note_txt = new JLabel("Moyenne");
        
        //Page des enseignements
        title_ens = new JLabel("Information des Enseignements");
        title_ens.setForeground(Color.WHITE);
        title_ens.setFont(font);

        //Page de inscription eleve
        title_inscription = new JLabel("INSCRIPTION", JLabel.CENTER);
        title_inscription.setForeground(Color.WHITE);
        title_inscription.setFont(font);
        nom_eleve_champ = new JLabel("Nom de l'élève:");
        nom_eleve_champ.setForeground(Color.WHITE);
        prenom_eleve_champ = new JLabel("Prénom de l'élève:");
        prenom_eleve_champ.setForeground(Color.WHITE);
        niveau_champ = new JLabel("Niveau:");
        niveau_champ.setForeground(Color.WHITE);
        classe_champ = new JLabel("Classe:");
        classe_champ.setForeground(Color.WHITE);

        //Page edit note
        title_note = new JLabel("Veuillez selectionner l'élève", JLabel.CENTER);
        title_note.setForeground(Color.WHITE);
        title_note.setFont(font);
        nom_eleve_note_txt = new JLabel("Nom de l'élève");
        nom_eleve_note_txt.setForeground(Color.WHITE);
        prenom_eleve_note_txt = new JLabel("Prénom de l'élève");
        prenom_eleve_note_txt.setForeground(Color.WHITE);
        id_eleve_note_txt = new JLabel("ID de l'élève");
        id_eleve_note_txt.setForeground(Color.WHITE);

        //Page ajout note
        title_ajout_note = new JLabel("Ajouter une note", JLabel.CENTER);
        title_ajout_note.setFont(font);
        title_ajout_note.setForeground(Color.WHITE);
        matiere_ajout_note_txt = new JLabel("Matiere");
        matiere_ajout_note_txt.setForeground(Color.WHITE);
        trimestre_ajout_note_txt = new JLabel("Bulletin");
        trimestre_ajout_note_txt.setForeground(Color.WHITE);
        annee_sco_ajout_note_txt = new JLabel("Annee sco.");
        annee_sco_ajout_note_txt.setForeground(Color.WHITE);
        valeur_ajout_note_txt = new JLabel("Note/20");
        valeur_ajout_note_txt.setForeground(Color.WHITE);
        appreciation_note_txt = new JLabel("Appréciation");
        appreciation_note_txt.setForeground(Color.WHITE);

        //Page créer bulletin
        title_bulletin_txt = new JLabel("Création d'un bulletin");
        title_bulletin_txt.setFont(font);
        nom_eleve_bulletin_txt = new JLabel("Nom:");
        nom_eleve_bulletin_txt.setForeground(Color.WHITE);
        prenom_eleve_bulletin_txt = new JLabel("Prenom: ");
        prenom_eleve_bulletin_txt.setForeground(Color.WHITE);
        appreciation_bulletin_txt = new JLabel("Appreciation: ");
        appreciation_bulletin_txt.setForeground(Color.WHITE);
        id_trimestre_bulletin_txt = new JLabel("Trimestre");
        id_trimestre_bulletin_txt.setForeground(Color.WHITE);
        id_eleve_bulletin_txt = new JLabel("ID: ");
        id_eleve_bulletin_txt.setForeground(Color.WHITE);

        //Page ajout prof
        title_ajouter_prof = new JLabel("Ajouter un Professeur");
        title_ajouter_prof.setFont(font);
        title_ajouter_prof.setForeground(Color.WHITE);
        nom_ajouter_prof_txt = new JLabel("Nom du professeur:");
        nom_ajouter_prof_txt.setForeground(Color.WHITE);
        prenom_ajouter_prof_txt = new JLabel("Prenom du professeur:");
        prenom_ajouter_prof_txt.setForeground(Color.WHITE);
        matiere_ajouter_prof_txt = new JLabel("Matière:");
        matiere_ajouter_prof_txt.setForeground(Color.WHITE);
        nom_classe_ajouter_prof_txt = new JLabel("Nom de la classe:");
        nom_classe_ajouter_prof_txt.setForeground(Color.WHITE);
        niveau_classe_ajouter_prof_txt = new JLabel("Niveau de la classe");
        niveau_classe_ajouter_prof_txt.setForeground(Color.WHITE);

        //Page update eleve 
        titre_selection_eleve_mofifie_txt = new JLabel("Veuillez selectionner l'Id d'un élève", JLabel.CENTER);
        titre_selection_eleve_mofifie_txt.setFont(font);
        titre_selection_eleve_mofifie_txt.setForeground(Color.WHITE);
        id_recherche_eleve_modifier_txt = new JLabel("id de l'élève");
        id_recherche_eleve_modifier_txt.setForeground(Color.WHITE);
        title_modification_eleve_txt = new JLabel("Modifiez son Nom et Prénom", JLabel.CENTER);
        title_modification_eleve_txt.setFont(font);
        title_modification_eleve_txt.setForeground(Color.WHITE);
        nom_modifier_eleve_txt = new JLabel("Nom");
        nom_modifier_eleve_txt.setForeground(Color.WHITE);
        prenom_modifier_eleve_txt = new JLabel("Prenom");
        prenom_modifier_eleve_txt.setForeground(Color.WHITE);

        //Page suppression de l'eleve 
        titre_suppression_eleve_txt = new JLabel("Supprimer un élève de l'ecole", JLabel.CENTER);
        titre_suppression_eleve_txt.setFont(font);
        titre_suppression_eleve_txt.setForeground(Color.WHITE);
        id_eleve_supprimer_txt = new JLabel("Id de l'eleve : ");
        id_eleve_supprimer_txt.setFont(font);
        id_eleve_supprimer_txt.setForeground(Color.WHITE);

        //Page de suppression de professeur 
        titre_suppression_prof_txt = new JLabel("Supprimer un professeur", JLabel.CENTER);
        titre_suppression_prof_txt.setFont(font);
        titre_suppression_prof_txt.setForeground(Color.WHITE);
        id_prof_supprimer_txt = new JLabel("Id du professeur : ");
        id_prof_supprimer_txt.setFont(font);
        id_prof_supprimer_txt.setForeground(Color.WHITE);

        // CREATION DES PANNEAUX
        //Page de connexion
        title_panel = new JPanel();
        title_panel.setBackground(Color.BLUE);
        form_panel = new JPanel();
        form_panel.setLayout(new GridLayout(5, 2));
        form_panel.setBackground(Color.BLUE);
        p2 = new JPanel();
        p2.setBackground(Color.BLUE);
        grid_connexion = new JPanel();
        grid_connexion.setLayout(new GridLayout(3, 1));

        //Page du menu
        panel_menu = new JPanel();
        panel_menu.setBackground(Color.BLUE);
        grid_menu = new JPanel(new GridLayout(4, 1));
        grid_menu.setBackground(Color.BLUE);

        //Page de resultat de la recherche
        grid_tab = new JPanel(new GridLayout(1, 6));
        panel_result = new JPanel();
        panel_result.setBackground(Color.BLUE);
        grid_result = new JPanel(new GridLayout(3, 1));
        grid_result.setBackground(Color.BLUE);
        eleve_display = new JPanel();
        
        panel_ens = new JPanel();
        panel_ens.setBackground(Color.BLUE);
        grid_ens = new JPanel();
        grid_ens.setBackground(Color.BLUE);

        //Page des bulletins
        grid_tab_bull = new JPanel(new GridLayout(1, 6));
        panel_bull = new JPanel();
        panel_bull.setBackground(Color.BLUE);
        grid_bull = new JPanel(new GridLayout(3, 1));
        grid_bull.setBackground(Color.BLUE);
        bull_display = new JPanel();

        //Page du reporting
        panel_reporting = new JPanel();
        panel_reporting.setBackground(Color.BLUE);
        reporting_display = new JPanel();

        //Page de mise à jour
        grid_maj = new JPanel(new GridLayout(7, 1));
        grid_maj.setBackground(Color.BLUE);
        panel_maj = new JPanel();
        panel_maj.setBackground(Color.BLUE);

        //Page de inscription eleve
        panel_inscription = new JPanel();
        panel_inscription.setBackground(Color.BLUE);
        form_inscription = new JPanel(new GridLayout(8, 1));
        form_inscription.setBackground(Color.BLUE);
        grid_inscription = new JPanel(new GridLayout(3, 1));
        grid_inscription.setBackground(Color.BLUE);

        //Page edit note
        container = new JPanel(new GridLayout(2, 1));
        container.setBackground(Color.BLUE);
        panel_note = new JPanel();
        panel_note.setBackground(Color.BLUE);
        form_note = new JPanel(new GridLayout(6, 1));
        form_note.setBackground(Color.BLUE);
        grid_note = new JPanel(new GridLayout(3, 1));
        grid_note.setBackground(Color.BLUE);
        validate_btn = new JPanel();
        validate_btn.setBackground(Color.BLUE);
        panel_ajout_note = new JPanel();
        panel_ajout_note.setBackground(Color.BLUE);
        form_ajout_note = new JPanel(new GridLayout(2, 5));
        form_ajout_note.setBackground(Color.BLUE);
        validate_btn_note = new JPanel();
        validate_btn_note.setBackground(Color.BLUE);
        grid_ajout_note = new JPanel(new GridLayout(3, 1));
        grid_ajout_note.setBackground(Color.BLUE);

        //Page créer bulletin
        container_bulletin = new JPanel();
        container_bulletin.setBackground(Color.BLUE);
        grid_bulletin = new JPanel(new GridLayout(6, 1));
        grid_bulletin.setBackground(Color.BLUE);
        form_recherche_eleve_bulletin = new JPanel(new GridLayout(4, 1));
        form_recherche_eleve_bulletin.setBackground(Color.BLUE);
        form_bulletin = new JPanel(new GridLayout(4, 1));
        form_bulletin.setBackground(Color.BLUE);

        //Page ajout prof
        container_ajouter_prof = new JPanel();
        container_ajouter_prof.setBackground(Color.BLUE);
        container_form_ajouter_prof = new JPanel(new GridLayout(3, 1));
        container_form_ajouter_prof.setBackground(Color.BLUE);
        form_ajouter_prof = new JPanel(new GridLayout(10, 1));
        form_ajouter_prof.setBackground(Color.BLUE);

        //Page update eleve 
        container_modifier = new JPanel();
        container_modifier.setBackground(Color.BLUE);

        grid_layout_modif = new JPanel(new GridLayout(3, 1));
        grid_layout_modif.setBackground(Color.BLUE);

        form_recherche = new JPanel(new GridLayout(4, 1));
        form_recherche.setBackground(Color.BLUE);

        panel_recherche = new JPanel(new GridLayout(3, 1));
        panel_recherche.setBackground(Color.BLUE);

        form_modifier = new JPanel(new GridLayout(2, 1));
        form_modifier.setBackground(Color.BLUE);

        panel_nom_prenom = new JPanel(new GridLayout(4, 1));
        panel_nom_prenom.setBackground(Color.BLUE);

        big_container_modifier = new JPanel();
        big_container_modifier.setBackground(Color.BLUE);

        //Page de suppression de l'élève 
        container_suppression = new JPanel();
        container_suppression.setBackground(Color.BLUE);
        form_suppression = new JPanel(new GridLayout(2, 2));
        form_suppression.setBackground(Color.BLUE);
        grid_suppression = new JPanel(new GridLayout(2, 1));
        grid_suppression.setBackground(Color.BLUE);

        //Pae de suppression du professeur 
        container_suppression_prof = new JPanel();
        container_suppression_prof.setBackground(Color.BLUE);
        form_suppression_prof = new JPanel(new GridLayout(2, 2));
        form_suppression_prof.setBackground(Color.BLUE);
        grid_suppression_prof = new JPanel(new GridLayout(2, 1));
        grid_suppression_prof.setBackground(Color.BLUE);

        //AJOUT DES OBJETS GRAPHIQUES DANS LES PANNEAUX
        // Page de connexion
        title_panel.add(Accueil);
        form_panel.add(Identifiant);
        form_panel.add(IdTexte);
        form_panel.add(trash2);
        form_panel.add(trash1);
        form_panel.add(Password);
        form_panel.add(PwTexte);
        form_panel.add(trash3);
        form_panel.add(trash);
        form_panel.add(nameBDD);
        form_panel.add(NomBDDTexte);
        p2.add(connect);
        grid_connexion.add(title_panel);
        grid_connexion.add(form_panel);
        grid_connexion.add(p2);
        this.setContentPane(grid_connexion); //C'est la première page du programme
        this.setVisible(true);

        //Page du menu
        grid_menu.add(rechercher_info);
        grid_menu.add(maj);
        grid_menu.add(reporting);
        grid_menu.add(afficher_prof);
        panel_menu.add(grid_menu);

        //Page de recherche
        panel_result.add(backFromResearchToMenu);
        grid_result.add(title_result);
        /* grid_tab.add(id_eleve_txt);
        grid_tab.add(nom_eleve_txt);
        grid_tab.add(prenom_eleve_txt);
        grid_tab.add(niveau_txt);
        grid_tab.add(nom_classe_txt);
        grid_tab.add(annee_sco_txt);*/
        grid_result.add(eleve_display);
        panel_result.add(grid_result);

        //Page de bulletins
        panel_bull.add(backFromBulletinToResearch);
        grid_bull.add(title_bull);
        grid_tab_bull.add(bull_nom_txt);
        grid_tab_bull.add(bull_prenom_txt);
        grid_tab_bull.add(bull_appreciation_txt);
        grid_tab_bull.add(bull_note_txt);
        grid_bull.add(grid_tab_bull);
        grid_bull.add(bull_display);
        panel_bull.add(grid_bull);

        //Page du reporting
        panel_reporting.add(backFromReportingToMenu);
        
        //Page des enseignements
        panel_ens.add(title_ens);
        panel_ens.add(grid_ens);

        //Page de mise à jour
        panel_maj.add(backFromMajToMenu);
        grid_maj.add(inscription_eleve);
        grid_maj.add(editer_note);
        grid_maj.add(creer_bulletin);
        grid_maj.add(ajouter_prof);
        grid_maj.add(update_eleve);
        grid_maj.add(delete_eleve);
        grid_maj.add(delete_prof);
        panel_maj.add(grid_maj);

        //Page de inscription eleve
        panel_inscription.add(backFromInscToMaj);
        form_inscription.add(nom_eleve_champ);
        form_inscription.add(nom_eleve_insc);
        form_inscription.add(prenom_eleve_champ);
        form_inscription.add(prenom_eleve_insc);
        form_inscription.add(niveau_champ);
        form_inscription.add(niveau_insc);
        form_inscription.add(classe_champ);
        form_inscription.add(nom_classe_insc);
        grid_inscription.add(title_inscription);
        grid_inscription.add(form_inscription);
        panel_inscription.add(grid_inscription);
        panel_inscription.add(submit_inscription);

        //Page edit note
        panel_note.add(backFromEditNoteToMaj);
        grid_note.add(title_note);
        form_note.add(nom_eleve_note_txt);
        form_note.add(nom_eleve_note);
        form_note.add(prenom_eleve_note_txt);
        form_note.add(prenom_eleve_note);
        form_note.add(id_eleve_note_txt);
        form_note.add(id_eleve_note);
        grid_note.add(form_note);
        validate_btn.add(research_eleve_note);
        grid_note.add(validate_btn);
        panel_note.add(grid_note);

        //Page ajout note
        grid_ajout_note.add(title_ajout_note);
        form_ajout_note.add(matiere_ajout_note_txt);
        form_ajout_note.add(trimestre_ajout_note_txt);
        form_ajout_note.add(annee_sco_ajout_note_txt);
        form_ajout_note.add(valeur_ajout_note_txt);
        form_ajout_note.add(appreciation_note_txt);
        form_ajout_note.add(matiere_ajout_note);
        form_ajout_note.add(trimestre_ajout_note);
        form_ajout_note.add(annee_sco_ajout_note);
        form_ajout_note.add(valeur_ajout_note);
        form_ajout_note.add(appreciation_note);
        validate_btn_note.add(valider_ajout_note);
        grid_ajout_note.add(form_ajout_note);
        grid_ajout_note.add(validate_btn_note);
        panel_ajout_note.add(grid_ajout_note);
        container.add(panel_note);
        container.add(panel_ajout_note);

        //Page creation bulletin
        grid_bulletin.add(title_bulletin_txt);
        form_recherche_eleve_bulletin.add(nom_eleve_bulletin_txt);
        form_recherche_eleve_bulletin.add(nom_eleve_bulletin);
        form_recherche_eleve_bulletin.add(prenom_eleve_bulletin_txt);
        form_recherche_eleve_bulletin.add(prenom_eleve_bulletin);
        form_recherche_eleve_bulletin.add(id_eleve_bulletin_txt);
        form_recherche_eleve_bulletin.add(id_eleve_bulletin);
        form_recherche_eleve_bulletin.add(recherche_eleve_bulletin);
        grid_bulletin.add(form_recherche_eleve_bulletin);
        form_bulletin.add(appreciation_bulletin_txt);
        form_bulletin.add(appreciation_bulletin);
        form_bulletin.add(id_trimestre_bulletin_txt);
        form_bulletin.add(id_trimestre_bulletin);
        form_bulletin.add(valider_ajout_bulletin);
        grid_bulletin.add(form_bulletin);
        container_bulletin.add(grid_bulletin);

        //Page ajout prof
        container_ajouter_prof.add(title_ajouter_prof);
        container_form_ajouter_prof.add(nom_ajouter_prof_txt);
        container_form_ajouter_prof.add(nom_ajouter_prof);
        container_form_ajouter_prof.add(prenom_ajouter_prof_txt);
        container_form_ajouter_prof.add(prenom_ajouter_prof);
        container_form_ajouter_prof.add(matiere_ajouter_prof_txt);
        container_form_ajouter_prof.add(matiere_ajouter_prof);
        container_form_ajouter_prof.add(nom_classe_ajouter_prof_txt);
        container_form_ajouter_prof.add(nom_classe_ajouter_prof);
        container_form_ajouter_prof.add(niveau_classe_ajouter_prof_txt);
        container_form_ajouter_prof.add(niveau_classe_ajouter_prof);
        container_ajouter_prof.add(container_form_ajouter_prof);
        container_ajouter_prof.add(valider_ajouter_prof);

        //Page update eleve 
        grid_layout_modif.add(titre_selection_eleve_mofifie_txt);

        panel_recherche.add(id_recherche_eleve_modifier_txt);
        panel_recherche.add(selectionner_id_eleve);
        panel_recherche.add(Rechercher_id_eleve_modifie);

        form_recherche.add(panel_recherche);
        grid_layout_modif.add(form_recherche);

        form_modifier.add(title_modification_eleve_txt);

        panel_nom_prenom.add(nom_modifier_eleve_txt);
        panel_nom_prenom.add(nom_eleve);
        panel_nom_prenom.add(prenom_modifier_eleve_txt);
        panel_nom_prenom.add(prenom_eleve);
        panel_nom_prenom.add(Update_eleve_modifie);

        form_modifier.add(panel_nom_prenom);
        grid_layout_modif.add(form_modifier);
        container_modifier.add(grid_layout_modif);
        big_container_modifier.add(container_modifier);

        //Page de suppression de l'élève 
        grid_suppression.add(titre_suppression_eleve_txt);
        form_suppression.add(id_eleve_supprimer_txt);
        form_suppression.add(selection_id_eleve_supprime);
        form_suppression.add(supprimer_eleve);
        grid_suppression.add(form_suppression);
        container_suppression.add(grid_suppression);

        //Page de suppression du professeur 
        grid_suppression_prof.add(titre_suppression_prof_txt);
        form_suppression_prof.add(id_prof_supprimer_txt);
        form_suppression_prof.add(selection_id_prof_supprime);
        form_suppression_prof.add(supprimer_prof);
        grid_suppression_prof.add(form_suppression_prof);
        container_suppression_prof.add(grid_suppression_prof);

        // ajout des listeners
        backFromResearchToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_fenetre();
            }
        });

        backFromMajToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_fenetre();
            }
        });

        backFromInscToMaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maj_fenetre();
            }
        });

        backFromEditNoteToMaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maj_fenetre();
            }
        });

        backFromBulletinToResearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche_fenetre();
            }
        });

        backFromReportingToMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu_fenetre();
            }
        });

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                IdTexte.getText();
                PwTexte.getPassword();
                if (("root".equals(IdTexte.getText())) && ("projet_java".equals(NomBDDTexte.getText()))) {
                    menu_fenetre();
                    System.out.println("Connecté");
                } else {
                    System.out.println("Problème de connexion");
                }

            }
        });

        rechercher_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche_fenetre();
                //associer_enseignement();
            }
        });

        maj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maj_fenetre();

            }
        });

        reporting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reporting_fenetre();

            }
        });
        
        afficher_prof.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                afficher_prof();
            }
        });

        inscription_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscription_fenetre();

            }
        });

        submit_inscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inscription_eleve();
                back_to_menu();
            }
        });

        editer_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit_note_fenetre();
            }

        });

        research_eleve_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                research_eleve_note();
            }
        });

        valider_ajout_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouter_note();

                back_to_menu();
            }
        });

        creer_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creer_bulletin();
                // back_to_menu();
            }
        });

        ajouter_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouter_prof();

            }
        });

        recherche_eleve_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                research_eleve_bulletin();
            }
        });
        valider_ajout_bulletin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajout_bulletin();
                back_to_menu();
            }
        });

        valider_ajouter_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                associer_enseignement();
                back_to_menu();
            }
        });

        update_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifier_eleve();
                //this.setContentPane(container_modifier); 
            }
        });

        Rechercher_id_eleve_modifie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_eleve();
            }

        });

        Update_eleve_modifie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_eleve();
                back_to_menu();
            }

        });

        delete_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimer_eleve();

                //this.setContentPane(container_modifier); 
            }
        });

        supprimer_eleve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_eleve();
                back_to_menu();
                //this.setContentPane(container_modifier); 
            }
        });

        delete_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimer_prof(); // c'est le bouton normalement s
                //back_to_menu(); 
                //this.setContentPane(container_modifier); 
            }
        });

        supprimer_prof.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_prof();
                back_to_menu();
                //this.setContentPane(container_modifier); 
            }
        });

        // couleurs des objets graphiques
        // disposition geographique des panneaux
        // pour fermer la fenetre
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0); // tout fermer												System.exit(0); // tout fermer
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void menu_fenetre() {
        this.setContentPane(panel_menu);
        this.revalidate();
    }

    public void recherche_fenetre() {

        eleve_display.removeAll();

        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        DAO<Classe> classeDAO = FactoryDAO.getClasseDAO();
        
        int size_table = eleveDAO.returnSizeTable();

        System.out.println("Nombre deleve: " + size_table);
        ArrayList listID = new ArrayList();
        listID = eleveDAO.returnIDs();
        System.out.println("Taille de la liste: " + listID.size());
        Object[][] donnees = new Object[listID.size()][6];

        for (int i = 0; i < listID.size(); i++) {

            donnees[i][0] = eleveDAO.find((int) listID.get(i)).getIdPersonne();
            donnees[i][1] = persDAO.find(eleveDAO.find((int) listID.get(i)).getIdPersonne()).getNom_pers();
            donnees[i][2] = persDAO.find(eleveDAO.find((int) listID.get(i)).getIdPersonne()).getPrenom_pers();
            donnees[i][3] = classeDAO.find(eleveDAO.find((int) listID.get(i)).getIdClasse()).getNiveauClasse();
            donnees[i][4] = classeDAO.find(eleveDAO.find((int) listID.get(i)).getIdClasse()).getNomClasse();

        }

        String[] titreColonnes = {
            "IdPersonne", "Nom", "Prenom", "Niveau", "NomClasse"};
        JTable jTable1 = new JTable(
                donnees, titreColonnes);

        eleve_display.add(jTable1);
        grid_result.add(eleve_display);
        this.setContentPane(panel_result);
        this.revalidate();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (jTable1.getSelectedRow() > -1) {
                    bulletin_fenetre(parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()));
                }
            }

        });

    }

    public void bulletin_fenetre(int idel) {
        bull_display.removeAll();

        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        DAO<Bulletin> bullDAO = FactoryDAO.getBulletinDAO();
        DAO<Notes> noteDAO = FactoryDAO.getNotesDAO();
        Eleve eleve = new Eleve();

        Object[][] donnees = new Object[1][4];

        for (int i = 0; i < 1; i++) {

            donnees[i][0] = persDAO.find(eleveDAO.find(idel).getIdPersonne()).getNom_pers();
            donnees[i][1] = persDAO.find(eleveDAO.find(idel).getIdPersonne()).getPrenom_pers();
            donnees[i][2] = bullDAO.find(idel).getAppreciation_generale();
            donnees[i][3] = noteDAO.find(idel).getValeurNote();

        }

        String[] titreColonnes = {
            "Nom", "Prenom", "Appreciation", "Moyenne"};
        JTable jTable1 = new JTable(
                donnees, titreColonnes);

        bull_display.add(jTable1);
        grid_bull.add(bull_display);
        this.setContentPane(panel_bull);
        this.revalidate();

    }
    
    public void afficher_prof(){
        grid_ens.removeAll();
        
        DAO<Enseigner>enseignerDAO = FactoryDAO.getEnseignerDAO();
        DAO<Matiere>matiereDAO = FactoryDAO.getMatiereDAO();
        DAO<Professeur>professeurDAO = FactoryDAO.getProfesseurDAO();
        DAO<Personne>personneDAO = FactoryDAO.getPersonneDAO();
        DAO<Classe>classeDAO = FactoryDAO.getClasseDAO();
        
         int size_table = professeurDAO.returnSizeTable();

        System.out.println("Nombre de prof: " + size_table);
        ArrayList listID = new ArrayList();
        listID = professeurDAO.returnIDs();
        System.out.println("Taille de la liste: " + listID.size());
        Object[][] donnees = new Object[listID.size()][3];

        for (int i = 0; i < listID.size(); i++) {

            donnees[i][0] = professeurDAO.find_bis((int) listID.get(i)).getIdPersonne();
            donnees[i][1] = personneDAO.find(professeurDAO.find_bis((int) listID.get(i)).getIdPersonne()).getNom_pers();
            donnees[i][2] = professeurDAO.find(professeurDAO.find_bis((int) listID.get(i)).getIdPersonne()).getPrenom_pers();
           

        }

        String[] titreColonnes = {
            "IdPersonne", "Nom", "Prenom"};
        JTable jTable1 = new JTable(
                donnees, titreColonnes);

        grid_ens.add(jTable1);
        panel_ens.add(grid_ens);
       
        
        this.setContentPane(panel_ens);
        this.revalidate();
    }

    public void reporting_fenetre() {
        this.setContentPane(panel_reporting);
        Reporting repo = FactoryDAO.getReporting();
        repo.report();
        this.revalidate();
    }

    public void maj_fenetre() {
        this.setContentPane(panel_maj);
        this.revalidate();
    }

    public void inscription_eleve() {
        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        DAO<Classe> classeDAO = FactoryDAO.getClasseDAO();
        int id_pers = 0;
        Personne personne = new Personne(id_pers, "eleve", nom_eleve_insc.getText(), prenom_eleve_insc.getText());

        if (persDAO.create(personne)) {
            System.out.println(persDAO.returnClasse("'" + nom_eleve_insc.getText() + "'", "'" + prenom_eleve_insc.getText() + "'").getIdPersonne());

            Eleve eleve = new Eleve(persDAO.returnClasse("'" + nom_eleve_insc.getText() + "'", "'" + prenom_eleve_insc.getText() + "'").getIdPersonne(),
                    "eleve", nom_eleve_insc.getText(), prenom_eleve_insc.getText(),
                    classeDAO.returnClasse("'" + nom_classe_insc.getText() + "'", "'" + niveau_insc.getText() + "'").getIdClasse(), 0);
            //(int _idPersonne,  String _type_pers, String _nom_pers, String _prenom_pers, int _idClasse, int _idEleve)
            if (eleveDAO.create(eleve)) {
                System.out.println("ELEVE CREE");
            } else {
                System.out.println("ELEVE bug");
            }
        } //     'nom'     -->  ' "+nom+" ' 
    }

    public void inscription_fenetre() {

        this.setContentPane(panel_inscription);
        this.revalidate();
    }

    public void edit_note_fenetre() {
        this.setContentPane(container);
        this.revalidate();
    }

    public void research_eleve_note() {
        String nom_eleve = nom_eleve_note.getText();
        String prenom_eleve = prenom_eleve_note.getText();
        System.out.println(nom_eleve + " " + prenom_eleve);
        DAO<Personne> personneDAO = FactoryDAO.getPersonneDAO();
        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
        int id_eleve = Integer.parseInt(id_eleve_note.getText());
        eleveDAO.find(id_eleve);
        personneDAO.returnClasse("'" + nom_eleve_note.getText() + "'", "'" + prenom_eleve_note.getText() + "'");
        System.out.println("Eleve " + eleveDAO.find(id_eleve).getPrenom_pers() + " " + eleveDAO.find(id_eleve).getNom_pers() + " trouvé");
        this.revalidate();
    }

    public void research_eleve_bulletin() {
        String nom_eleve = nom_eleve_bulletin.getText();
        String prenom_eleve = prenom_eleve_bulletin.getText();
        System.out.println(nom_eleve + " " + prenom_eleve);
        DAO<Personne> personneDAO = FactoryDAO.getPersonneDAO();
        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();
        int id_eleve = Integer.parseInt(id_eleve_bulletin.getText());
        eleveDAO.find(id_eleve);
        personneDAO.returnClasse("'" + nom_eleve_bulletin.getText() + "'", "'" + prenom_eleve_bulletin.getText() + "'");
        System.out.println("Eleve " + eleveDAO.find(id_eleve).getPrenom_pers() + " " + eleveDAO.find(id_eleve).getNom_pers() + " trouvé");
        this.revalidate();
    }

    public void ajout_bulletin() {
        int id_eleve = Integer.parseInt(id_eleve_bulletin.getText());
        int id_trimestre = Integer.parseInt(id_trimestre_bulletin.getText());
        DAO<Bulletin> bulletinDAO = FactoryDAO.getBulletinDAO();
        String appreciation = appreciation_bulletin.getText();
        System.out.println("appreciation: " + appreciation + ", id trimestre: " + id_trimestre + ", id eleve: " + id_eleve);
        //int _idBulletin, String ag, int _idTrimestre, int _idEleve
        Bulletin bulletin = new Bulletin(1, appreciation, id_trimestre, id_eleve);
        System.out.println("appreciation: " + bulletin.getAppreciation_generale() + ", id trimestre: " + bulletin.getIdTrimestre() + ", id eleve: " + bulletin.getIdEleve());

        if (bulletinDAO.create(bulletin)) {
            System.out.println("Le bulletin a bien été ajouté");
        } else {
            System.out.println("BULLETIN BUG");
        }

    }

    public void ajouter_note() {
        int id_eleve = Integer.parseInt(id_eleve_note.getText());
        int id_bulletin = Integer.parseInt(trimestre_ajout_note.getText());
        DAO<Notes> noteDAO = FactoryDAO.getNotesDAO();
        DAO<Matiere> matiereDAO = FactoryDAO.getMatiereDAO();
        int id_matiere = matiereDAO.returnClasse("'" + matiere_ajout_note.getText() + "'", " ").getIdMatiere();
        float valeur_note = Float.parseFloat(valeur_ajout_note.getText());
        String appreciation = appreciation_note.getText();

        System.out.println("Parametre Objet JAVA (avant création): id matiere: " + id_matiere + ", valeur note: " + valeur_note + ", idEleve: " + id_eleve);
        Notes note = new Notes(1, valeur_note, appreciation, id_matiere, id_eleve, id_bulletin);
        System.out.println("Objet JAVA: idNotes" + note.getIdNote() + "id matiere: " + note.getIdMatiere() + ", valeur note: " + note.getValeurNote() + ", idEleve: " + note.getIdEleve());

        if (noteDAO.create(note)) {
            System.out.println("La note a bien été ajoutée");
        } else {
            System.out.println("NOTE BUG");
        }

    }

    public void creer_bulletin() {
        this.setContentPane(container_bulletin);
        this.revalidate();
    }

    public void associer_enseignement() {

        DAO<Enseigner> enseignerDAO = FactoryDAO.getEnseignerDAO();
        DAO<Personne> personneDAO = FactoryDAO.getPersonneDAO();
        DAO<Matiere> matiereDAO = FactoryDAO.getMatiereDAO();
        DAO<Classe> classeDAO = FactoryDAO.getClasseDAO();
        DAO<Professeur> profeseurDAO = FactoryDAO.getProfesseurDAO();

        String nom_prof, prenom_prof, matiere, nom_classe, niveau_classe;
        nom_prof = nom_ajouter_prof.getText();
        prenom_prof = prenom_ajouter_prof.getText();
        matiere = matiere_ajouter_prof.getText();
        niveau_classe = niveau_classe_ajouter_prof.getText();
        nom_classe = nom_classe_ajouter_prof.getText();

        Personne personne = new Personne(0, "professeur", nom_prof, prenom_prof);
        if (personneDAO.create(personne)) {
            
            Professeur professeur = new Professeur(personneDAO.returnClasse("'" + nom_prof + "'", "'" + prenom_prof + "'").getIdPersonne(), "professeur", nom_prof, prenom_prof, 0);

            if (profeseurDAO.create(professeur)) {
                int id_personne = personneDAO.returnClasse("'" + nom_prof + "'", "'" + prenom_prof + "'").getIdPersonne();
                int id_prof = profeseurDAO.find(id_personne).getIdProfesseur();
                
                System.out.println("id prof: "+id_prof+"id_personne"+id_personne);
                
                int id_matiere = matiereDAO.returnClasse("'" + matiere + "'", "").getIdMatiere();
                int id_classe = classeDAO.returnClasse("'" + nom_classe + "'", "'" + niveau_classe + "'").getIdClasse();
                Enseigner enseigner = new Enseigner(id_classe, id_prof, id_matiere);

                if (enseignerDAO.create(enseigner)) {
                    System.out.println("L'enseignement a bien été ajouté, "+id_classe+", "+id_prof+", "+id_matiere);
                } else {
                    System.out.println("L'enseignement BUG SA RACE");
                }
            }
        }
    }

    public void update_eleve() {
        //this.setContentPane(container_modifier);
        // this.revalidate();

        //Scanner sc = new Scanner(System.in);
        int id_pers_update = Integer.parseInt(selectionner_id_eleve.getText());
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        // rechercher l'id de la personne à modifier 
        Personne pers_id_update = persDAO.find(id_pers_update); // il cherche déjà les donners de la personne à modifier 
        System.out.println(pers_id_update.getNom_pers() + " " + pers_id_update.getPrenom_pers());

        String nom_modifie = nom_eleve.getText();
        String prenom_modifie = prenom_eleve.getText();

        if (persDAO.update(pers_id_update, nom_modifie, prenom_modifie)) {
            System.out.println("modification de la base de donnée : " + pers_id_update.getNom_pers() + " " + pers_id_update.getPrenom_pers());
        } else {
            System.out.println("l'update BUG");
        }

        // pour l'update 
        // 1. lui appler l'id de l'élève donc de la personne à modifier avec toutes ses données afficher avant de les modifier : println()
        // 2. enregistrer ces mofifications dans la base de donnée 
        // comme ca ne va mdifier que la personne il faut aussi que ca apparesse dans la table de l'élève dans la base de donnée 
    }

    public void modifier_eleve() {
        this.setContentPane(big_container_modifier);
        this.revalidate();
    }

    public void supprimer_eleve() {
        this.setContentPane(container_suppression);
        this.revalidate();
    }

    public void delete_eleve() {
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        DAO<Eleve> eleveDAO = FactoryDAO.getEleveDAO();

        // recherche l'id de l'élève à supprimer 
        System.out.println("entrer l'id d'un élève à modifier : ");
        int id_eleve_supp = Integer.parseInt(selection_id_eleve_supprime.getText());  //sc.nextInt(); 
        int id_recupere = eleveDAO.find(id_eleve_supp).getIdPersonne();
        System.out.println("Voici l'idPersonne de l'élève : " + id_recupere);

        if (eleveDAO.delete(eleveDAO.find(id_eleve_supp))) {
            persDAO.delete(persDAO.find(id_recupere));
            System.out.println("l'eleve et la personne ont ete supprimés");
        } else {
            System.out.println("Le delete BUG");
        }

    }

    public void supprimer_prof() {
        this.setContentPane(container_suppression_prof);
        this.revalidate();
    }

    public void delete_prof() {
        DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
        DAO<Professeur> professeurDAO = FactoryDAO.getProfesseurDAO();

        // recherche l'id de l'élève à supprimer 
        System.out.println("entrez l'id d'un professeur à supprimer : ");
        int id_prof_supp = Integer.parseInt(selection_id_prof_supprime.getText());  //sc.nextInt(); 
        int id_recupere = professeurDAO.find_bis(id_prof_supp).getIdPersonne();
        System.out.println("Voici l'IdPersonne du professeur : " + id_recupere);

        if (professeurDAO.delete(professeurDAO.find_bis(id_prof_supp))) {
            persDAO.delete(persDAO.find(id_recupere));
            System.out.println("le professeur et la personne ont été supprimé");
        } else {
            System.out.println("Le delete BUG");
        }

    }

    public void ajouter_prof() {
        this.setContentPane(container_ajouter_prof);
        this.revalidate();

    }

    public void back_to_menu() {
        this.setContentPane(panel_menu);
        this.revalidate();
    }

}
