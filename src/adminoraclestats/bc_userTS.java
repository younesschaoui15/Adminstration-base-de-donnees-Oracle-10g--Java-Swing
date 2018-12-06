/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminoraclestats;


import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javax.swing.*;

/**
 *
 * @author CY_15
 */
public final class bc_userTS {
    
    JPanel panel;
    final static int W = 691;
    final static int H = 332;
    
    public JPanel getPanel() {
        return panel;
    }
    
    public bc_userTS() {

            panel = new JPanel(new BorderLayout());
            JFXPanel fxPanel = new JFXPanel();
            bc_userTS.initFX(fxPanel);
            panel.add(fxPanel);
            panel.setSize(W, H);
    }
 
    private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
 
    private static Scene createScene()
    {
        Group root = new Group();
        Scene scene = new Scene(root, javafx.scene.paint.Color.GOLDENROD);

       //************************************
        DAO BD = new DAO();
        int taille = 0;
        int[] tabNb = null;
        String[] tabTS = null;
        
        try
        {   
            String sql ="SELECT count( distinct default_tablespace ) nb FROM sys.dba_users";
            
            ResultSet rs = BD.execRequette(sql);
            while(rs.next())
            {
                taille = rs.getInt("nb");
            }

            tabNb = new int[taille];
            tabTS = new String[taille];
            
            String sql2 ="SELECT default_tablespace ts, count(*) nb " +
                            "FROM sys.dba_users GROUP BY default_tablespace";
            
            ResultSet rs1 = BD.execRequette(sql2);

            int l=0;
            while(rs1.next())
            {   
                tabTS[l] = rs1.getString("ts");
                tabNb[l] = rs1.getInt("nb");
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
        
        xAxis.setLabel("Table space");  
        yAxis.setLabel("Nombre");
        
        bc.setTitle("Nombre d'utilisateur par table space");
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Nombre d'utilisateur");
        
        for( int ii=0; ii<taille; ii++)
        {
            series1.getData().add(new XYChart.Data(tabTS[ii], tabNb[ii]));
        }

        bc.getData().add(series1);
        bc.setBarGap(1);
        bc.setCategoryGap(1);
        
       //************************************
        root.getChildren().add(bc);

        return (scene);
    }
    
}
