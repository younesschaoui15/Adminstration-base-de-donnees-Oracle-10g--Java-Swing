package adminoraclestats;

import java.sql.SQLException;
import javafx.application.Platform;
import javafx.embed.swing.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.paint.Color;
import javax.swing.*;
 
public final class bc_shemas extends JFrame
{
      
    public JFXPanel fxPanel;
    public JFrame frame;
    public static int annee;

// les villes les plus visitées
// PARAMETRES : annee
    public bc_shemas(int an)
    {   
        this.annee = an;
        initAndShowGUI();
    }
    
    public void initAndShowGUI() 
    {
        // This method is invoked on Swing thread
        frame = new JFrame("Statistique");
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
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }

    private static Scene createScene() 
    {
        Group root = new Group();
        Scene scene = new Scene(root, Color.THISTLE);

       //************************************
        DAO bd = new DAO();
        int an = annee;
        
        String[] mois ={"Janvier","Fevrier","Mars","Avril","Mai","Juan","Juillet",
                        "Aôut","Septembre","Octobre","Novembre","Decembre"};
        int[] m = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        String[] ville = {"","","","","","","","","","","",""};
        int[] valeur = {0,0,0,0,0,0,0,0,0,0,0,0};
        
        for( int j=0; j<12; j++)
        {
            try 
            {
                String Sql_1 = "SELECT destination, COUNT(idVoyage) as 'nb' from tab_voyage " +
                        "WHERE dhmDepart >= '"+an+"-"+m[j]+"-00' and dhmDepart <= '"+an+"-"+m[j]+"-28'" +
                        "GROUP BY destination Order BY nb DESC " +
                        "LIMIT 0 , 1";
                bd.setResultat(bd.getStm().executeQuery(Sql_1));
                while(bd.getResultat().next())
                {
                    valeur[j]= bd.getResultat().getInt("nb");
                    ville[j] = bd.getResultat().getString("destination");
                }
                
            } 
            catch (SQLException ex) 
            {
                System.out.println("Probleme dans stat "+ex.getMessage());
            }
                
        }
        
        for( int j=0; j<12; j++)
        {
            System.out.println(m[j]+", "+ville[j]+", "+valeur[j]);
        }
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc = new BarChart<>(xAxis,yAxis);
        bc.setPrefWidth(750);
        bc.setPrefHeight(550);
        
        xAxis.setLabel("Mois");  
        yAxis.setLabel("Visites");
        
        bc.setTitle("Les villes les plus visitées en "+an);
        
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Nombre de visites par mois"); 
        
        for( int ii=0; ii<12; ii++)
        {
            series1.getData().add(new XYChart.Data(m[ii]+"\n"+ville[ii], valeur[ii]));
        }

        bc.getData().add(series1);
        bc.setBarGap(1);
        bc.setCategoryGap(1);
        
       //************************************
        root.getChildren().add(bc);

        return (scene);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new  bc_shemas(2016);
            }
        });
    }
}