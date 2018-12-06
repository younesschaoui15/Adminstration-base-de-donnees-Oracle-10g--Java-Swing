/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MyClasses;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author bashizip
 */
public class MySwingUtilities {

    public MySwingUtilities() {
    }

    public static void setContentPane(JPanel parent, JPanel target) {
        parent.removeAll();
        parent.repaint();
        parent.revalidate();
        parent.setLayout(new BorderLayout());
        
        parent.add(target, BorderLayout.CENTER);
        parent.repaint();
        parent.revalidate();
    }

    public static int showConfirmDialog(String message){
        return JOptionPane.showConfirmDialog(null, message, "Confirmation", JOptionPane.YES_NO_OPTION);
    }

    public static void showMessageDialog(String message){
       JOptionPane.showMessageDialog(null, message);
    }
}
