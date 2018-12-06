package MyClasses;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectODB {

    Connection cn = null;

    public ConnectODB(String user, String pass) {
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("chargement du pilote réussi");

        } catch (ClassNotFoundException e) {
            System.out.println("Erreuur : " + e.getMessage());
        }

        try {

            cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", user, pass);
            System.out.println("chargement de base de données réussie");

        } catch (SQLException e) {
            System.out.println("Erreuur : " + e.getMessage());
        }

    }

    public Connection getCon() {
        return cn;
    }
}
