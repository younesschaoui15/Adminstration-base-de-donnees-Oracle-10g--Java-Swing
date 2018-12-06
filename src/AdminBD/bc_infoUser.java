package AdminBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Platform;
import javafx.embed.swing.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javax.swing.*;
 
public final class bc_infoUser extends JFrame
{
      
    public JFXPanel fxPanel;
    public JFrame frame;
    protected static String utilisateur;
// nombre de ... par Societe
    
    public bc_infoUser(String user)
    {   
        utilisateur = user;
        initAndShowGUI();
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
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
        frame.setSize(800, 600);
    }

    private static void initFX(JFXPanel fxPanel) 
    {
    // This method is invoked on JavaFX thread
        Scene scene = createScene(utilisateur);
        fxPanel.setScene(scene);
    }

    private static Scene createScene(String user) 
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.LIGHTBLUE);

       //************************************
        DAO BD = new DAO();
        
//        int nbTable = 0;
//        int nbVue = 0;
//        int nbFonc = 0;
//        int nbPro = 0;
        int i = 0;
        int[] resAll = new int[6];
        String[] ob = {"FUNCTION", "INDEX", "PROCEDURE", "SEQUENCE", "TABLE", "VIEW"};
        Object[][] obj = new Object[6][2];
        
        for(int k=0; k<obj.length; k++)
        {
            obj[k][0] = ob[k];
            obj[k][1] = 0;
            
//            System.out.print(obj[k][0]+", "+obj[k][1]);
        }
        
        
        try
        {
            String sql = "SELECT OBJECT_TYPE, count(OBJECT_TYPE) nb from dba_objects where owner like '"+user+"' " +
                        "and OBJECT_TYPE in ('FUNCTION', 'INDEX', 'PROCEDURE', 'SEQUENCE', 'TABLE', 'VIEW') " +
                        "group by OBJECT_TYPE order by 1";
            
            ResultSet rs = BD.execRequette(sql);
            
            while(rs.next())
            {   
                while( !obj[i][0].toString().equals(rs.getString("OBJECT_TYPE")) )
                    i++;
                
                obj[i][1] = rs.getInt("nb");                
            }
            BD.fermerConnexion();
        } 
        catch (SQLException ex) 
        {
            System.out.println("ERREUR : "+ex.getMessage());
        }
        
    //**************************************************************
        
        //defining the axes
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Objets");
        yAxis.setLabel("Nombre");
        
        //creating the chart
        final BarChart<String,Number> barChart = new BarChart<>(xAxis,yAxis);
                
        barChart.setTitle(" Les objets de ( "+user+" )");
        barChart.setPrefWidth(750);
        barChart.setPrefHeight(550);
        //defining a series
        XYChart.Series fonctions = new XYChart.Series();
        fonctions.setName("Fonctions");
        XYChart.Series index = new XYChart.Series();
        index.setName("Index");
        XYChart.Series procedures = new XYChart.Series();
        procedures.setName("Procedures");
        XYChart.Series sequences = new XYChart.Series();
        sequences.setName("Sequences");
        XYChart.Series tables = new XYChart.Series();
        tables.setName("Tables");
        XYChart.Series vues = new XYChart.Series();
        vues.setName("Vues");
        
        //populating the series with data
        
        fonctions.getData().add(new XYChart.Data("", obj[0][1]));
        index.getData().add(new XYChart.Data("", obj[1][1]));
        procedures.getData().add(new XYChart.Data("", obj[2][1]));
        sequences.getData().add(new XYChart.Data("", obj[3][1]));
        tables.getData().add(new XYChart.Data("", obj[4][1]));
        vues.getData().add(new XYChart.Data("", obj[5][1]));
        
        barChart.getData().addAll(fonctions, index, procedures, vues, sequences, tables);
//        barChart.setBarGap(0.1);
//        barChart.setCategoryGap(6);
       //************************************
        root.getChildren().add(barChart);

        return (scene);
    }
    
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new  bc_infoUser("SYS");
//            }
//        });
//    }
}