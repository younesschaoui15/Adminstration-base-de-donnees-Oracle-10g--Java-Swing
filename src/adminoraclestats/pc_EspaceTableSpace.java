package adminoraclestats;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.JFrame;

public final class pc_EspaceTableSpace extends JFrame
{
      
    public JFXPanel fxPanel;
    public JFrame frame;
    static int id;

    public pc_EspaceTableSpace(int id)
    {   this.id = id;
         initAndShowGUI();
         
    }
    
    public void initAndShowGUI() 
    {
        // This method is invoked on Swing thread
        frame = new JFrame("Statistiques");
        fxPanel = new JFXPanel();

        Platform.runLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                initFX(fxPanel);
            }
        });
        
        frame.add(fxPanel);
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    private static void initFX(JFXPanel fxPanel) 
    {
    // This method is invoked on JavaFX thread
        int x = id;
        Scene scene = createScene(x);
        fxPanel.removeAll();
        fxPanel.repaint();
        fxPanel.setScene(scene);
    }

    private static Scene createScene(int id) 
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.CORAL);
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

        final PieChart chart = new PieChart(pieChartData);
        chart.setPrefWidth(550);
        chart.setPrefHeight(450);
        chart.setTitle("Table space : "+nom_TS);
        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 20 arial;");
        chart.getData().stream().forEach((data) -> {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    (MouseEvent e) -> {
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        caption.setText(String.valueOf(data.getPieValue()) + "%");
                    });
        });

       //************************************
        root.getChildren().addAll(chart, caption);

        return (scene);
    }
    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new  pc_EspaceTableSpace(4);
//            }
//        });
//    }
}