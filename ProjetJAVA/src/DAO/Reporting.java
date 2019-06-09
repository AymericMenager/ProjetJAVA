/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leogerardin
 */
public class Reporting {
    protected Connection connect = null; 
    
    
    public Reporting(Connection _connect){
        connect = _connect ; 
    }
    
    public void report() {
        
        int tot1=0;int tot2=0;int tot3=0;int tot4=0;
        int tot5=0;int tot8=0;int tot17=0;int tot61=0;
        try {
            ResultSet resultat1 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total1 FROM eleve WHERE IdClasse = 1");
            ResultSet resultat2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total2 FROM eleve WHERE IdClasse = 2");
            ResultSet resultat3 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total3 FROM eleve WHERE IdClasse = 3");
            ResultSet resultat4 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total4 FROM eleve WHERE IdClasse = 4");
            ResultSet resultat5 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total5 FROM eleve WHERE IdClasse = 5");
            ResultSet resultat8 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total8 FROM eleve WHERE IdClasse = 8");
            ResultSet resultat17 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total17 FROM eleve WHERE IdClasse = 17");
            ResultSet resultat61 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total61 FROM eleve WHERE IdClasse = 61");

            if (resultat1.first()) tot1=resultat1.getInt("total1");
            else tot1=0;
            if (resultat2.first()) tot2=resultat2.getInt("total2");
            else tot2=0;
            if (resultat3.first()) tot3=resultat3.getInt("total3");
            else tot3=0;
            if (resultat4.first()) tot4=resultat4.getInt("total4");
            else tot4=0;
            if (resultat5.first()) tot5=resultat5.getInt("total5");
            else tot5=0;
            if (resultat8.first()) tot8=resultat8.getInt("total8");
            else tot8=0;
            if (resultat17.first()) tot17=resultat17.getInt("total17");
            else tot17=0;
            if (resultat61.first()) tot61=resultat61.getInt("total61");
            else tot61=0;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("td"+tot61);
      /*DefaultPieDataset dataset1 = new DefaultPieDataset( );
      dataset1.setValue("TD08", tot1 );
      dataset1.setValue("TD01", tot2 );
      dataset1.setValue("TD04", tot3);
      dataset1.setValue("TD02", tot4);
      dataset1.setValue("TD03", tot5);
      dataset1.setValue("TD10", tot8);
      dataset1.setValue("TD05", tot17);
      dataset1.setValue("TD07", tot61);

      JFreeChart chart = ChartFactory.createPieChart(
         "Part d'eleves par TD",   // chart title
         dataset1,          // data
         true,             // include legend
         true,
         false);
         
      int width = 640;   /* Width of the image */
      //int height = 480;  /* Height of the image */ 
     // File pieChart = new File( "PieChart.jpeg" ); 
      //ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
      
      try {
            ResultSet resultat1 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total1 FROM classe WHERE Niveau = 'ING1'");
            ResultSet resultat2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total2 FROM classe WHERE Niveau = 'ING2'");
            ResultSet resultat3 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total3 FROM classe WHERE Niveau = 'ING3'");
            ResultSet resultat4 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total4 FROM classe WHERE Niveau = 'ING4'");
            ResultSet resultat5 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT COUNT(*) As total5 FROM classe WHERE Niveau = 'ING5'");
           

            if (resultat1.first()) tot1=resultat1.getInt("total1");
            else tot1=0;
            if (resultat2.first()) tot2=resultat2.getInt("total2");
            else tot2=0;
            if (resultat3.first()) tot3=resultat3.getInt("total3");
            else tot3=0;
            if (resultat4.first()) tot4=resultat4.getInt("total4");
            else tot4=0;
            if (resultat5.first()) tot5=resultat5.getInt("total5");
            else tot5=0;
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("prom"+tot4);
      /*DefaultPieDataset dataset2 = new DefaultPieDataset( );
      dataset2.setValue("ING1", tot1 );
      dataset2.setValue("ING2", tot2 );
      dataset2.setValue("ING3", tot3);
      dataset2.setValue("ING4", tot4);
      dataset2.setValue("ING5", tot5);

      JFreeChart chart = ChartFactory.createPieChart(
         "Part d'eleves par promotion",   // chart title
         dataset2,          // data
         true,             // include legend
         true,
         false);
         
      int width = 640;   /* Width of the image */
      //int height = 480;  /* Height of the image */ 
      //File pieChart = new File( "PieChart.jpeg" ); 
      //ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
      
      
      try {
            ResultSet resultat1 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT AVG(Valeur_note) As total1 FROM note WHERE IdMatiere = 1");
            ResultSet resultat2 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT AVG(Valeur_note) As total2 FROM note WHERE IdMatiere = 2");
            ResultSet resultat3 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT AVG(Valeur_note) As total3 FROM note WHERE IdMatiere = 3");
            ResultSet resultat4 = this.connect.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT AVG(Valeur_note) As total4 FROM note WHERE IdMatiere = 4");
            

            if (resultat1.first()) tot1=resultat1.getInt("total1");
            else tot1=0;
            if (resultat2.first()) tot2=resultat2.getInt("total2");
            else tot2=0;
            if (resultat3.first()) tot3=resultat3.getInt("total3");
            else tot3=0;
            if (resultat4.first()) tot4=resultat4.getInt("total4");
            else tot4=0;
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("moymat"+tot3);
      /*DefaultPieDataset dataset2 = new DefaultPieDataset( );
      dataset2.setValue("Mathematiques", tot1 );
      dataset2.setValue("Informatique", tot2 );
      dataset2.setValue("Physique", tot3);
      dataset2.setValue("Electronique", tot4);

      JFreeChart chart = ChartFactory.createPieChart(
         "Note moyenne par Matieres",   // chart title
         dataset2,          // data
         true,             // include legend
         true,
         false);
         
      int width = 640;   /* Width of the image */
      //int height = 480;  /* Height of the image */ 
     // File pieChart = new File( "PieChart.jpeg" ); 
      //ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
      
    }
 
    
}