/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminoraclestats;


import static adminoraclestats.bc_shemas.annee;
import java.awt.*;
import static java.awt.Color.WHITE;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javax.swing.*;

/**
 *
 * @author CY_15
 */
public final class bc_Schema {
    
    JPanel panel;
    final static int W = 520;
    final static int H = 429;
    
    public JPanel getPanel() {
        return panel;
    }
    
    public bc_Schema() {

            panel = new JPanel(new BorderLayout());
            JFXPanel fxPanel = new JFXPanel();
            bc_Schema.initFX(fxPanel);
            panel.add(fxPanel);
            panel.setSize(W, H);
    }
 
//	public static void initAndShowGUI(JFXPanel fxPanel) {
 
//		Platform.runLater(new Runnable() {
//			@Override
//			public void run() {
//				initFX(fxPanel);
//			}
//		});
//	}
 
    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
 
    private static Scene createScene()
    {
        Group root = new Group();
        Scene scene = new Scene(root, javafx.scene.paint.Color.AQUA);

       //************************************
        DAO BD = new DAO();
        int taille = 0;
        double[] tabTaille = null;
        String[] tabSchema = null;
        
        try
        {   
            String sql ="SELECT count(distinct OWNER) nb FROM DBA_EXTENTS  ";
            
            ResultSet rs = BD.execRequette(sql);
            while(rs.next())
            {
                taille = rs.getInt("nb");
            }

            tabTaille = new double[taille];
            tabSchema = new String[taille];
            
            String sql2 ="SELECT OWNER , " +
                        "Sum(BYTES) / 1024 / 1024 AS Taille " +
                        "FROM DBA_EXTENTS " +
                        "GROUP BY OWNER " +
                        "ORDER by 1";
            
            ResultSet rs1 = BD.execRequette(sql2);

            int l=0;
            while(rs1.next())
            {   
                tabSchema[l] = rs1.getString("OWNER");
                tabTaille[l] = rs1.getDouble("Taille");
                l++;
            }

            BD.fermerConnexion();
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERREUR : "+ex.getMessage());
        }
        
        //**************************************************************************
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
        bc.setPrefWidth(W);
        bc.setPrefHeight(H);
        
        xAxis.setLabel("Schéma");  
        yAxis.setLabel("Taille");
        
        bc.setTitle("Les schémas de la base de données");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Tailles des schémas en (Mo)");
        
        for( int ii=0; ii<taille; ii++)
        {
            series1.getData().add(new XYChart.Data(tabSchema[ii], tabTaille[ii]));
        }

        bc.getData().add(series1);
        bc.setBarGap(1);
        bc.setCategoryGap(1);
        
       //************************************
        root.getChildren().add(bc);

        return (scene);
    }
    
}
