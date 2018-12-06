package AdminBD;

import MyClasses.bestLook;
import MyClasses.MySwingUtilities;
import AdminBD.Tables.CreerTable;
import AdminBD.Users.CreerUser;
import static AdminBD.strucStok.pga;
import MyClasses.ConnectODB;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jdesktop.swingx.JXHyperlink;

public class MIDAdmni extends javax.swing.JFrame {

    private JXHyperlink hynewsociete, hylogout, hyplistsociete, hyVoyageperMois, hyVilleplVisi,
            hyvoyageparmois, hyAllperSos;

    Connection cn = (new ConnectODB("System", "cy15")).getCon();
    public MIDAdmni() {
        bestLook.setBestLookAndFeelAvailable();
        setDefaultCloseOperation(1);
        initComponents();
        MySwingUtilities.setContentPane(parent_pane, new parentPaneConnect());
        createTaskPane();
        this.setTitle("Oracle DataBase Administation");
        inicialiserCompenent();
    }

    private void inicialiserCompenent() {
        tp_main.setVisible(false);
        tp_story.setVisible(false);
        tp_compta.setVisible(false);
        tp_admin.setVisible(false);
        tp_admin1.setVisible(false);
        tp_admin2.setVisible(false);
        jLabel2.setVisible(false);
        jLabel4.setVisible(false);
        MenuTable.setEnabled(false);
        MenuUser.setEnabled(false);
        jMenuItem1.setEnabled(false);
    }

    void createTaskPane() {
        // nouveau Utlisateur
        hynewsociete = new JXHyperlink(new_user_action);
        hynewsociete.setText("Nouveau Utilisateur");
        hynewsociete.setIcon(new ImageIcon(getClass().getResource("/img/utilisateur-ajout32.png")));
        tp_main.add(hynewsociete);
        // liste des Utilisateurs
        hyplistsociete = new JXHyperlink(list_user_action);
        hyplistsociete.setText("Liste des Utilisateurs");
        hyplistsociete.setIcon(new ImageIcon(getClass().getResource("/img/utilisateur-gris32.png")));
        tp_main.add(hyplistsociete);
        // liste des Utilisateurs 
        hyplistsociete = new JXHyperlink(gest_table_action);
        hyplistsociete.setText("gestion des Tables");
        hyplistsociete.setIcon(new ImageIcon(getClass().getResource("/img/table-train32.png")));
        tp_story.add(hyplistsociete);
        // gestion des profiles
        hylogout = new JXHyperlink(gest_profile_action);
        hylogout.setText("gestion des Profiles");
        hylogout.setIcon(new ImageIcon(getClass().getResource("/img/bin-ferme32.png")));
        tp_compta.add(hylogout);
        // Statistiques
        hyVoyageperMois = new JXHyperlink(gest_tablespace_action);
        hyVoyageperMois.setText("gestion des TablesSpaces");
        hyVoyageperMois.setIcon(new ImageIcon(getClass().getResource("/img/case32.png")));
        tp_admin.add(hyVoyageperMois);

        hyVilleplVisi = new JXHyperlink(strucStok_action);
        hyVilleplVisi.setText("Structure de Stockages");
        hyVilleplVisi.setIcon(new ImageIcon(getClass().getResource("/img/tableaux32.png")));
        tp_admin1.add(hyVilleplVisi);

        hyvoyageparmois = new JXHyperlink(statistiques_action);
        hyvoyageparmois.setText("Statistiques");
        hyvoyageparmois.setIcon(new ImageIcon(getClass().getResource("/img/Chart.png")));
        tp_admin2.add(hyvoyageparmois);

       

//--------------------------------------------------------------------------------------
        tp_compta.setCollapsed(true);
        tp_admin.setCollapsed(true);
        tp_admin1.setCollapsed(true);
        tp_admin2.setCollapsed(true);
    }
    /////////////////////////////////////////////////////////////////////////////////////

    public static Action connexionn = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            conexion();
        }
    };

    Action new_user_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {
            adduser();
        }
    };

    Action list_user_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {
            listuser();
        }
    };

    Action logout_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter?") == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                return;
            }

        }
    };

    Action gest_table_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {
            gestable();

        }
    };
    Action gest_profile_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            gestprofile();
        }
    };

    Action gest_tablespace_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            gesttablespaces();
        }
    };

    Action strucStok_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            structureStockage();
        }
    };

    Action statistiques_action = new AbstractAction() {

        public void actionPerformed(ActionEvent e) {

            statistiques();
        }
    };

/////////////////////////////////////////////////////////////////////////////////////////////

    public static void conexion() {
        MySwingUtilities.setContentPane(parent_pane, new session());
    }

    void adduser() {
        MySwingUtilities.setContentPane(parent_pane, new AjoutUtilisateur());
    }

    void listuser() {
        MySwingUtilities.setContentPane(parent_pane, new listeUser());
    }

    void gestable() {
        MySwingUtilities.setContentPane(parent_pane, new gestTable());
    }

    void gestprofile() {
        MySwingUtilities.setContentPane(parent_pane, new gestProfiles());
    }

    void gesttablespaces() {
        MySwingUtilities.setContentPane(parent_pane, new gestTableSpaces());
    }

    void structureStockage() {
        MySwingUtilities.setContentPane(parent_pane, new strucStok());
    }

    void statistiques() {
        MySwingUtilities.setContentPane(parent_pane, new paneau());
    }


    void enableDesableHyperLinks(boolean enableOrDesable) {
        Component[] c = this.getComponents();
        for (int i = 0; i < c.length; i++) {
            if (c[i].getClass().equals(JXHyperlink.class)) {
                c[i].setEnabled(enableOrDesable);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        mycontentpane = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        parent_pane = new javax.swing.JPanel();
        jXTaskPaneContainer1 = new org.jdesktop.swingx.JXTaskPaneContainer();
        tp_main = new org.jdesktop.swingx.JXTaskPane();
        tp_story = new org.jdesktop.swingx.JXTaskPane();
        tp_compta = new org.jdesktop.swingx.JXTaskPane();
        tp_admin = new org.jdesktop.swingx.JXTaskPane();
        tp_admin1 = new org.jdesktop.swingx.JXTaskPane();
        tp_admin2 = new org.jdesktop.swingx.JXTaskPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        MenuTable = new javax.swing.JMenu();
        Menu_CreerTable = new javax.swing.JMenuItem();
        Menu_ModifierTable = new javax.swing.JMenuItem();
        Menu_SupprimerTable = new javax.swing.JMenuItem();
        MenuUser = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setText("Utlisateur :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\CY_15\\Desktop\\Bouzaachane - Adminstration BD\\Images\\oracledb.png")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\CY_15\\Desktop\\Bouzaachane - Adminstration BD\\Images\\oracle1.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        mycontentpane.setBackground(new java.awt.Color(204, 204, 204));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        parent_pane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        parent_pane.setPreferredSize(new java.awt.Dimension(877, 516));

        javax.swing.GroupLayout parent_paneLayout = new javax.swing.GroupLayout(parent_pane);
        parent_pane.setLayout(parent_paneLayout);
        parent_paneLayout.setHorizontalGroup(
            parent_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1101, Short.MAX_VALUE)
        );
        parent_paneLayout.setVerticalGroup(
            parent_paneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );

        jXTaskPaneContainer1.setBackground(new java.awt.Color(153, 204, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setCornerSize(2);
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jXTaskPaneContainer1.setBorder(dropShadowBorder1);
        org.jdesktop.swingx.VerticalLayout verticalLayout2 = new org.jdesktop.swingx.VerticalLayout();
        verticalLayout2.setGap(14);
        jXTaskPaneContainer1.setLayout(verticalLayout2);

        tp_main.setToolTipText("");
        tp_main.setTitle("Gestion des Utilisateurs");
        jXTaskPaneContainer1.add(tp_main);

        tp_story.setTitle("Gestion des Tables");
        jXTaskPaneContainer1.add(tp_story);

        tp_compta.setToolTipText("");
        tp_compta.setTitle("Gestion des Profils");
        jXTaskPaneContainer1.add(tp_compta);

        tp_admin.setTitle("Gestion des Tablespaces");
        jXTaskPaneContainer1.add(tp_admin);

        tp_admin1.setTitle("Structures de Stockage");
        jXTaskPaneContainer1.add(tp_admin1);

        tp_admin2.setTitle("Statistiques/ Rapport");
        jXTaskPaneContainer1.add(tp_admin2);

        javax.swing.GroupLayout mycontentpaneLayout = new javax.swing.GroupLayout(mycontentpane);
        mycontentpane.setLayout(mycontentpaneLayout);
        mycontentpaneLayout.setHorizontalGroup(
            mycontentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mycontentpaneLayout.createSequentialGroup()
                .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parent_pane, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
                .addContainerGap())
        );
        mycontentpaneLayout.setVerticalGroup(
            mycontentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mycontentpaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(mycontentpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator2)
                    .addComponent(parent_pane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                    .addComponent(jXTaskPaneContainer1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mycontentpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mycontentpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel2);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Deconnecter...                     ");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(jSeparator1);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        exitMenuItem.setIcon(new javax.swing.ImageIcon("C:\\Users\\CY_15\\Desktop\\Bouzaachane - Adminstration BD\\Images\\close-cancel-20.png")); // NOI18N
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Base de données");

        MenuTable.setText("Table");

        Menu_CreerTable.setText("Créer...");
        Menu_CreerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_CreerTableActionPerformed(evt);
            }
        });
        MenuTable.add(Menu_CreerTable);

        Menu_ModifierTable.setText("Mdofier...");
        MenuTable.add(Menu_ModifierTable);

        Menu_SupprimerTable.setText("Supprimer...");
        Menu_SupprimerTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_SupprimerTableActionPerformed(evt);
            }
        });
        MenuTable.add(Menu_SupprimerTable);

        editMenu.add(MenuTable);

        MenuUser.setText("Gestion Utilisateur");
        MenuUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUserActionPerformed(evt);
            }
        });
        editMenu.add(MenuUser);
        editMenu.add(jSeparator5);

        jMenuItem1.setText("Editeur SQL");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        editMenu.add(jMenuItem1);

        menuBar.add(editMenu);

        jMenu2.setText("Sauvegarder");

        jMenuItem2.setText("Fichier de Controle");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        menuBar.add(jMenu2);

        helpMenu.setMnemonic('h');
        helpMenu.setText("?");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Manuel d'utilisation                      ");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(contentMenuItem);
        helpMenu.add(jSeparator4);

        aboutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "Est-vous sur de vouloir quitter l'application ??", "Confirmed", JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        MySwingUtilities.setContentPane(parent_pane, new parentPaneDeconnect());
        inicialiserCompenent();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
    new apropos().setVisible(true);
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
    new Aide().setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void Menu_CreerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_CreerTableActionPerformed
        CreerTable fn = new CreerTable();
        fn.setVisible(true);
    }//GEN-LAST:event_Menu_CreerTableActionPerformed

    private void Menu_SupprimerTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_SupprimerTableActionPerformed
        this.dispose();
    }//GEN-LAST:event_Menu_SupprimerTableActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
     
        try {
            String fic=JOptionPane.showInputDialog(pga, "nom du fichier backup");
            Statement stmt = cn.createStatement();
            String sql="ALTER DATABASE BACKUP CONTROLFILE TO 'C:/oraclexe/app/oracle/admin/XE/"+fic+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(pga, "Sauvegardé !");
        } catch (SQLException ex) {
            
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new DemoTableBDD().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MenuUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUserActionPerformed
       CreerUser fn = new CreerUser();
        fn.setVisible(true);
    }//GEN-LAST:event_MenuUserActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MIDAdmni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MIDAdmni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MIDAdmni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MIDAdmni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MIDAdmni().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenu MenuTable;
    public static javax.swing.JMenuItem MenuUser;
    public static javax.swing.JMenuItem Menu_CreerTable;
    public static javax.swing.JMenuItem Menu_ModifierTable;
    public static javax.swing.JMenuItem Menu_SupprimerTable;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    public static javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    public static javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private org.jdesktop.swingx.JXTaskPaneContainer jXTaskPaneContainer1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel mycontentpane;
    private javax.swing.JMenuItem openMenuItem;
    public static javax.swing.JPanel parent_pane;
    public static org.jdesktop.swingx.JXTaskPane tp_admin;
    public static org.jdesktop.swingx.JXTaskPane tp_admin1;
    public static org.jdesktop.swingx.JXTaskPane tp_admin2;
    public static org.jdesktop.swingx.JXTaskPane tp_compta;
    public static org.jdesktop.swingx.JXTaskPane tp_main;
    public static org.jdesktop.swingx.JXTaskPane tp_story;
    // End of variables declaration//GEN-END:variables

}
