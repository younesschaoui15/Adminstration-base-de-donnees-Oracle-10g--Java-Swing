/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminBD;

import javax.swing.JFrame;

/**
 *
 * @author CY_15
 */
public class main {
    public static void main(String[] args) {
        JFrame f = new JFrame("main");
        f.setVisible(true);
        f.setSize(1103, 540);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(3);
        
        f.getContentPane().add(new paneau());
    }
}
