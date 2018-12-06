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
public final class pc_TS {
    
    JPanel panel;
    final static int W = 200;
    final static int H = 200;
    static int id;
    
    public pc_TS(int id) 
    {
        this.id = id;
        panel = new JPanel(new BorderLayout());
        JFXPanel fxPanel = new JFXPanel();
        pc_TS.initFX(fxPanel);
        panel.add(fxPanel);
        panel.setSize(W, H);
    }
    
    public JPanel getPanel() 
    {
        return panel;
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
        Scene scene = createScene(id);
        fxPanel.setScene(scene);
    }
 
    private static Scene createScene(int id) 
    {
        Group root = new Group();
        Scene scene = new Scene(root, javafx.scene.paint.Color.CORAL);
        //***********************************
        DAO BD = new DAO();
        String nom_TS = "";
        double el=-1;
        
        String sql ="SELECT a.tablespace_name ts, round ((sum(b.bytes) / a.bytes),3) * 100 el " +
                    "FROM sys.dba_data_files a, sys.dba_free_space b " +
                    "WHERE a.file_id = b.file_id " +
                    "AND a.tablespace_name = b.tablespace_name " +
                    "and a.file_id = "+id+" " +
                    "GROUP by a.tablespace_name, a.bytes " +
                    "ORDER BY 1";

        ResultSet rs = BD.execRequette(sql);
        try
        {
            while(rs.next())
            {
                nom_TS = rs.getString("ts");
                el = rs.getDouble("el");
            }
            
        }
        catch (SQLException ex) {
            System.out.println("ERREUR : "+ex.getMessage() );
        }
        finally
        {
            BD.fermerConnexion();
        }
        //************************************
        ObservableList<PieChart.Data> pieChartData = 
            FXCollections.observableArrayList(  new PieChart.Data("Espace libre ", el),
                                                new PieChart.Data("Espace occupé ",100-el) );
        
        double libre = el;
        final PieChart chart = new PieChart(pieChartData);
        chart.setPrefWidth(W);
        chart.setPrefHeight(H);
        chart.setTitle("Table space : "+nom_TS);
        final javafx.scene.control.Label caption = new javafx.scene.control.Label("");
        caption.setTextFill(javafx.scene.paint.Color.WHITE);
        caption.setStyle("-fx-font: 12 arial;");
        chart.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    (MouseEvent e) -> {
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        
                        if(data.getPieValue() == libre )
                            caption.setText(String.valueOf(data.getPieValue()) + "% Libre");
                        else
                            caption.setText(String.valueOf(data.getPieValue()) + "% Occupé");
                    });
        });

       //************************************
        root.getChildren().addAll(chart, caption);

        return (scene);
    }
    
}
