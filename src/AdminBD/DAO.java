package AdminBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author CY_15
 */
public final class DAO {

private Connection con;
private  Statement stm;
private  ResultSet resultat;

public DAO() 
{
    ouvrirConnexion();
//    this.stm =  this.con.createStatement();
}

public Connection getCon() {
        return con;
    }

    public Statement getStm() {
        return stm;
    }

    public ResultSet getResultat() {
        return resultat;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public void setResultat(ResultSet resultat) {
        this.resultat = resultat;
    }

public void ouvrirConnexion()
{
    try 
    {                  
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
//        Class.forName("com.mysql.jdbc.Driver");
        
//        String BD="jdbc:mysql://localhost:3306/bdd_gestiongareroutiere";
//        String US="root";
//        String MP="";
                                                
        this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "cy15");
//        this.con = DriverManager.getConnection(BD, US, MP);
        System.out.println("Connexion ouverte avec succes.");
    } 
    catch (ClassNotFoundException | SQLException ex)
    {
       JOptionPane.showMessageDialog(null, "Problème dans le chargement du pilote");
       System.out.println("Erreur dans l'overture de la connextion : "+ex.getMessage());
    }
}

public void fermerConnexion()
{   
    try 
    {
//        this.stm.close();
        this.con.close();
        System.out.println("Connexion fermée avec succes.");
    } 
    catch (SQLException ex)      
    {
        System.out.println("Erreur dans la fermeture de la connexion :  "+ex.getMessage());
    }
}

public ResultSet execRequette(String sql)
{
    stm = null;
    ResultSet rs = null;
        
    try 
    {    
        ouvrirConnexion();
        stm = con.createStatement();
        rs = stm.executeQuery(sql);
    } 
    catch (SQLException ex) {
        System.out.println("Problème dans \"execRequette()\" "+ex.getMessage());
    }    
//    finally
//    {
//        try 
//        {
//            stat.close();
//        } catch (SQLException ex) 
//        {
//            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        fermerConnexion();
//    }

    return rs;    
}

public void lancerRequette(String sql)
{   
    stm = null;
    try 
    {   
        ouvrirConnexion();
        stm = con.createStatement();
        stm.executeUpdate(sql);
    } 
    catch (Exception ex)
    {
//       JOptionPane.showMessageDialog(null, "Problème dans la création du statement ");
       System.out.println("Problème dans la création du statement "+ex.getMessage());
    }
    finally
    {
        try 
        {
            stm.close();
        } catch (SQLException ex) 
        {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fermerConnexion();
    }
}
  
           
}

//        BD.resultat = BD.stm.executeQuery(SQLidVoyageSelectionne);
//    
//        while(BD.resultat.next())
//        {
//            idV= BD.resultat.getInt("idVoyage");
//        }
//        BD.fermerConnexion();

//        BD.stm.executeUpdate(SQLajoutVoyageur);
//        BD.fermerConnexion();

 
