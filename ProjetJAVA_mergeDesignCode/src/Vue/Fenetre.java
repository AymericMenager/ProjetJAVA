/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import DAO.DAO;
import DAO.FactoryDAO;
import Modele.Personne;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author AYMERIC
 */
public class Fenetre extends JFrame implements ActionListener {

    /*
     * Attribut privés : objets de Connexion, AWT et Swing
     * 
     */
    private final JButton backFromResearchToMenu, backFromMajToMenu, backFromInscToMaj, backFromEditNoteToMaj;

    //Attribut de la page de connexion
    private final JLabel Accueil, Identifiant, Password, nameBDD, trash, trash1, trash2, trash3;
    private final JTextField IdTexte, NomBDDTexte;
    private final JPasswordField PwTexte;
    private final JButton connect;
    private final JPanel title_panel, form_panel, p2, grid_connexion;
 
    //Attribut de la page du menu
    private final JButton rechercher_info, maj, reporting;
    private final JPanel panel_menu, grid_menu;

    //Attributs de la page de résultat de la recherche
    private final JPanel panel_result, grid_tab, grid_result, tableau_eleve;
    private final JLabel title_result, id_eleve_txt, nom_eleve_txt, prenom_eleve_txt, niveau_txt, nom_classe_txt, annee_sco_txt;

    //Attributs de la page de mise à jour
    private final JPanel panel_maj, grid_maj;
    private final JButton inscription_eleve, editer_note, creer_bulletin;

    //Attribut de la page inscription eleve
    private final JPanel panel_inscription, form_inscription, grid_inscription;
    private final JButton submit_inscription;
    private final JTextField nom_eleve_insc, prenom_eleve_insc, niveau_insc, nom_classe_insc;
    private final JLabel title_inscription, nom_eleve_champ, prenom_eleve_champ, niveau_champ, classe_champ;

    //Attribut de la page edit note
    private final JLabel title_note, nom_eleve_note_txt, prenom_eleve_note_txt, id_eleve_note_txt;
    private final JButton research_eleve_note;
    private final JTextField nom_eleve_note, prenom_eleve_note, id_eleve_note;
    private final JPanel panel_note, form_note, grid_note, validate_btn;

    //Attribut page ajout note
    private final JLabel title_ajout_note, matiere_ajout_note_txt, trimestre_ajout_note_txt, annee_sco_ajout_note_txt, valeur_ajout_note_txt;
    private final JTextField matiere_ajout_note, trimestre_ajout_note, annee_sco_ajout_note, valeur_ajout_note;
    private final JButton valider_ajout_note;
    private final JPanel panel_ajout_note, form_ajout_note, grid_ajout_note, validate_btn_note;

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

        //Page connexion
        connect = new JButton("Se Connecter");

        //Page menu
        rechercher_info = new JButton("Rechercher des informations");
        maj = new JButton("Mettre à jour les données");
        reporting = new JButton("Reporting");

        //Page mise à jour
        inscription_eleve = new JButton("Inscrire un élève");
        editer_note = new JButton("Entrer/Modifier une note");
        creer_bulletin = new JButton("Creer/Modifier le bulletin d'un élève");

        //Page inscription eleve
        submit_inscription = new JButton("Inscrire");

        //Page edit note
        research_eleve_note = new JButton("Rechercher");

        //Page ajout note
        valider_ajout_note = new JButton("Valider");
        
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
         trimestre_ajout_note_txt = new JLabel("Trimestre");
         trimestre_ajout_note_txt.setForeground(Color.WHITE);
         annee_sco_ajout_note_txt = new JLabel("Annee sco.");
         annee_sco_ajout_note_txt.setForeground(Color.WHITE);
         valeur_ajout_note_txt = new JLabel("Note/20");
         valeur_ajout_note_txt.setForeground(Color.WHITE);
         
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
        grid_menu = new JPanel(new GridLayout(3, 1));
        grid_menu.setBackground(Color.BLUE);

        //Page de resultat de la recherche
        grid_tab = new JPanel(new GridLayout(1, 6));
        panel_result = new JPanel();
        panel_result.setBackground(Color.BLUE);
        grid_result = new JPanel(new GridLayout(3, 1));
        grid_result.setBackground(Color.BLUE);
        tableau_eleve = new JPanel();

        //Page de mise à jour
        grid_maj = new JPanel(new GridLayout(3, 1));
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
        panel_note = new JPanel();
        panel_note.setBackground(Color.BLUE);
        form_note = new JPanel(new GridLayout(6, 1));
        form_note.setBackground(Color.BLUE);
        grid_note = new JPanel(new GridLayout(3, 1));
        grid_note.setBackground(Color.BLUE);
        validate_btn = new JPanel();
        validate_btn.setBackground(Color.BLUE);

        //Page ajout note
          panel_ajout_note = new JPanel();
        panel_ajout_note.setBackground(Color.BLUE);
        form_ajout_note = new JPanel(new GridLayout(2,4));
        form_ajout_note.setBackground(Color.BLUE);
        validate_btn_note = new JPanel();
        validate_btn_note.setBackground(Color.BLUE);
        grid_ajout_note = new JPanel(new GridLayout(3,1));
        grid_ajout_note.setBackground(Color.BLUE);
        
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
        panel_menu.add(grid_menu);

        //Page de recherche
        panel_result.add(backFromResearchToMenu);
        grid_result.add(title_result);
        grid_tab.add(id_eleve_txt);
        grid_tab.add(nom_eleve_txt);
        grid_tab.add(prenom_eleve_txt);
        grid_tab.add(niveau_txt);
        grid_tab.add(nom_classe_txt);
        grid_tab.add(annee_sco_txt);
        grid_result.add(grid_tab);
        panel_result.add(grid_result);

        //Page de mise à jour
        panel_maj.add(backFromMajToMenu);
        grid_maj.add(inscription_eleve);
        grid_maj.add(editer_note);
        grid_maj.add(creer_bulletin);
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
        form_ajout_note.add(matiere_ajout_note);
        form_ajout_note.add(trimestre_ajout_note);
        form_ajout_note.add(annee_sco_ajout_note);
        form_ajout_note.add(valeur_ajout_note);
        validate_btn_note.add(valider_ajout_note);
        grid_ajout_note.add(form_ajout_note);
        grid_ajout_note.add(validate_btn_note);
        panel_ajout_note.add(grid_ajout_note);
        
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

        connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                IdTexte.getText();
                PwTexte.getPassword();
                if( ("root".equals(IdTexte.getText())) && ("projet_java".equals(NomBDDTexte.getText()))){
                    menu_fenetre();
                     System.out.println("Connecté");
            }
                else{
                System.out.println("Probblème de connexion");
                }
            

            }
        });

        rechercher_info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche_fenetre();
            }
        });

        maj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maj_fenetre();

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
                back_to_menu();
            }
        });

        editer_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edit_note_fenetre();
            }
            
        });
        
         research_eleve_note.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                ajout_note_fenetre();
            }
            });
         
        valider_ajout_note.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
             back_to_menu();
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
        
        
         DAO<Personne> persDAO = FactoryDAO.getPersonneDAO();
                Personne personne = new Personne();
                System.out.println(persDAO.find(10).getPrenom_pers());
                
                
                
                for(int i=0; i<60; i++){
                    persDAO.find(i);
                    System.out.println(persDAO.find(i).getPrenom_pers());
                }
                
                
               Object[][] donnees = {  
   {"Swing", "Astral", "standard", 
      Color.red, Boolean.TRUE, "ING3"}, 
   {"Swing", "Mistral", "standard", 
      Color.yellow, Boolean.FALSE, "ING3"}, 
   {"Gin", "Oasis", "standard", 
      Color.blue, Boolean.FALSE, "ING3"},
   {"Gin", "boomerang", "compétition", 
      Color.green, Boolean.TRUE, "ING3"},
   {"Advance", "Omega", "performance", 
      Color.cyan, Boolean.TRUE, "ING3"}, 
} ;
      
String[] titreColonnes = { 
   "Id","Nom","Prenom", "Classe", "Niveau", "Annee sco."}; 
JTable jTable1 = new JTable(
      donnees, titreColonnes);

        panel_result.add(jTable1);
        this.setContentPane(panel_result);
        this.revalidate();
        
    }

    public void maj_fenetre() {
        this.setContentPane(panel_maj);
        this.revalidate();
    }

    public void inscription_fenetre() {
        this.setContentPane(panel_inscription);
        this.revalidate();
    }

    public void edit_note_fenetre() {
        this.setContentPane(panel_note);
        this.revalidate();
    }

    public void ajout_note_fenetre(){
        this.setContentPane(panel_ajout_note);
        this.revalidate();
    }
    
    public void back_to_menu() {
        this.setContentPane(panel_menu);
        this.revalidate();
    }

}
