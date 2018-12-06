package AdminBD.Users;

import static AdminBD.Users.AjouterDroit.cbAdminOption;
import MyClasses.ConnectODB;
import MyClasses.bestLook;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public final class CreerUser extends javax.swing.JFrame {

    Connection cn = (new ConnectODB("System", "cy15")).getCon();

    public CreerUser() {
        bestLook.setBestLookAndFeelAvailable();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        remplirCombot();
        updatecomboprof();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pConteneur = new javax.swing.JPanel();
        tpUser = new javax.swing.JTabbedPane();
        pGeneral = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPassword = new javax.swing.JPasswordField();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtxtnom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tempTablespace = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        NatureMotPasse = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        quota = new javax.swing.JTextField();
        pDroits = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listDroit = new javax.swing.JList<String>();
        btnCreerDroit = new javax.swing.JButton();
        btnSuppDroit = new javax.swing.JButton();
        pRoles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listRole = new javax.swing.JList<String>();
        btnAjouterRole = new javax.swing.JButton();
        btnSuppRole = new javax.swing.JButton();
        btnOK = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SYSTEM", "SYSAUX", "USERS", "TEMP" }));

        jLabel13.setText("Quota :");

        jLabel6.setText("Default tablespace :");

        jLabel1.setText("Username :");

        jLabel2.setText("Password :");

        jLabel9.setText("Profile :");

        tempTablespace.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "TEMP" }));

        jLabel8.setText("Account  :");

        NatureMotPasse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "EXPIRE" }));

        jLabel14.setText("Tomporary tablespace :");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Déverrouillé", "Verrouillé" }));

        jLabel7.setText("Password :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, 162, Short.MAX_VALUE)
                            .addComponent(quota, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jtxtnom)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tempTablespace, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NatureMotPasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtnom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempTablespace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NatureMotPasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pGeneralLayout = new javax.swing.GroupLayout(pGeneral);
        pGeneral.setLayout(pGeneralLayout);
        pGeneralLayout.setHorizontalGroup(
            pGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pGeneralLayout.setVerticalGroup(
            pGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpUser.addTab("Généralités", pGeneral);

        listDroit.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "<Tous>" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listDroit);

        btnCreerDroit.setText("Créer");
        btnCreerDroit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreerDroitActionPerformed(evt);
            }
        });

        btnSuppDroit.setText("Supprimer");
        btnSuppDroit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppDroitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDroitsLayout = new javax.swing.GroupLayout(pDroits);
        pDroits.setLayout(pDroitsLayout);
        pDroitsLayout.setHorizontalGroup(
            pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDroitsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreerDroit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuppDroit, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        pDroitsLayout.setVerticalGroup(
            pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDroitsLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btnCreerDroit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuppDroit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pDroitsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
        );

        tpUser.addTab("Droits", pDroits);

        jScrollPane2.setViewportView(listRole);

        btnAjouterRole.setText("Ajouter");
        btnAjouterRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterRoleActionPerformed(evt);
            }
        });

        btnSuppRole.setText("Supprimer");

        javax.swing.GroupLayout pRolesLayout = new javax.swing.GroupLayout(pRoles);
        pRoles.setLayout(pRolesLayout);
        pRolesLayout.setHorizontalGroup(
            pRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(pRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAjouterRole, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSuppRole, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        pRolesLayout.setVerticalGroup(
            pRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRolesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(pRolesLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(btnAjouterRole, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuppRole, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tpUser.addTab("Rôles", pRoles);

        btnOK.setText("Ajouter");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnAnnuler.setText("Annuler");
        btnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pConteneurLayout = new javax.swing.GroupLayout(pConteneur);
        pConteneur.setLayout(pConteneurLayout);
        pConteneurLayout.setHorizontalGroup(
            pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConteneurLayout.createSequentialGroup()
                .addGroup(pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConteneurLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tpUser))
                    .addGroup(pConteneurLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pConteneurLayout.setVerticalGroup(
            pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConteneurLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpUser, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK)
                    .addComponent(btnAnnuler))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConteneur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConteneur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void btnCreerDroitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreerDroitActionPerformed
        AjouterDroit fen = new AjouterDroit();

        fen.setVisible(true);

    }//GEN-LAST:event_btnCreerDroitActionPerformed

    private void btnAjouterRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterRoleActionPerformed
        CreerRole fen = new CreerRole();

        fen.setVisible(true);
    }//GEN-LAST:event_btnAjouterRoleActionPerformed

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        String nom, mdp, tablSpace, quot, tmpTableSpace, natureAccount, natureMdp;

        nom = jtxtnom.getText();
        mdp = jPassword.getText();
        tablSpace = jComboBox1.getSelectedItem().toString();
        quot = quota.getText();
        tmpTableSpace = tempTablespace.getSelectedItem().toString();
        natureMdp = NatureMotPasse.getSelectedItem().toString();
        natureAccount = jComboBox3.getSelectedItem().toString();
        ArrayList<String> listNonVide = new ArrayList<String>();
        ArrayList<String> listData = new ArrayList<String>();
        int nombreChamps = 0;
        if (!tablSpace.equals("None")) {
            listData.add(tablSpace);
            listNonVide.add("DEFAULT TABLESPACE ");
            nombreChamps++;
            if (!quot.equals("")) {
                try {
                    listData.add(quot + "M ON " + tablSpace);
                    listNonVide.add("QUOTA");
                    nombreChamps++;
                } catch (Exception e) {
                    System.out.println("verifier ce qque vous avez saisir !! ");
                }
            }
        }
        // verifier que la valeur saisi dans QUOTA est un nombre
        if (!tmpTableSpace.equals("None")) {
            listData.add(tmpTableSpace);
            nombreChamps++;
            listNonVide.add("TEMPORARY TABLESPACE");
            // verifier que la valeur saisi dans QUOTA est un nombre

        }

        if (!natureMdp.equals("None")) {
            listData.add(natureMdp);
            listNonVide.add("PASSWORD");
            nombreChamps++;
        }

        if (natureAccount.equals("Déverrouillé")) {
            listData.add("UNLOCK");
            listNonVide.add("ACCOUNT");
            nombreChamps++;
        } else {
            listData.add("LOCK");
            listNonVide.add("ACCOUNT");
            nombreChamps++;
        }

        // etablir  la connexion !! et la création des users
        try {
            if (!nom.equals("") || !mdp.equals("")) {
                String str = null;

                switch (nombreChamps) {
                    case 1:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;
                    case 2:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + listNonVide.get(1) + " " + listData.get(1)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;
                    case 3:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + listNonVide.get(1) + " " + listData.get(1)
                                + "\n " + listNonVide.get(2) + " " + listData.get(2)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;
                    case 4:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + listNonVide.get(1) + " " + listData.get(1)
                                + "\n " + listNonVide.get(2) + " " + listData.get(2)
                                + "\n " + listNonVide.get(4) + " " + listData.get(3)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;

                    case 5:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + listNonVide.get(1) + " " + listData.get(1)
                                + "\n " + listNonVide.get(2) + " " + listData.get(2)
                                + "\n " + listNonVide.get(3) + " " + listData.get(3)
                                + "\n " + listNonVide.get(4) + " " + listData.get(4)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;
                    case 6:
                        str = "CREATE USER " + nom + " IDENTIFIED BY " + mdp + ""
                                + "\n " + listNonVide.get(0) + " " + listData.get(0)
                                + "\n " + listNonVide.get(1) + " " + listData.get(1)
                                + "\n " + listNonVide.get(2) + " " + listData.get(2)
                                + "\n " + listNonVide.get(3) + " " + listData.get(3)
                                + "\n " + listNonVide.get(4) + " " + listData.get(4)
                                + "\n " + listNonVide.get(5) + " " + listData.get(5)
                                + "\n " + "PROFILE " + jComboBox2.getSelectedItem().toString();
                        break;
                }

                System.out.println(str);

                try {
                    Statement st = cn.createStatement();
                    st.executeUpdate(str);

                    if (listDroit.getSelectedIndex() >= 0) {
                        Statement st1 = cn.createStatement();
                        if (cbAdminOption.isSelected()) {
                            String priva = "GRANT " + privilc(listDroit) + " TO " + jtxtnom.getText() + " WITH ADMIN OPTION";
                            System.out.println(priva);
                            st1.executeUpdate(priva);
                        } else {
                            String priva1 = "GRANT " + privilc(listDroit) + " TO " + jtxtnom.getText();
                            System.out.println(priva1);
                            st1.executeUpdate(priva1);
                        }
                    }
                    if (listRole.getSelectedIndex() >= 0) {
                        Statement st2 = cn.createStatement();
                        String priva = "GRANT " + privilc(listRole) + " TO " + jtxtnom.getText();
                        System.out.println(priva);
                        st2.executeUpdate(priva);
                    }
                    JOptionPane.showMessageDialog(this, "L'utlisateur " + jtxtnom.getText() + " ajouté avec succés", "Succés", WIDTH);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {

            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnSuppDroitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppDroitActionPerformed
        DefaultListModel listModell = new <String>DefaultListModel();
        if (listDroit.isSelectionEmpty()) {
            System.out.println("la liste est empty");
        } else {
            if (listDroit.getSelectedIndex() < 0) {
                JOptionPane.showMessageDialog(this, "Sélectionnez une des Données à Supprimer !!\nClik OK à Continuer!!", "Erreur !!", JOptionPane.WARNING_MESSAGE);
            } else {
                listModell.addElement(listDroit);
                String lista = listDroit.getSelectedValue();

                listModell.addElement(lista);
                listModell.removeAllElements();
                listDroit.setModel(listModell);
//                System.out.println("Suprimé!!");
            }
        }
    }//GEN-LAST:event_btnSuppDroitActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CreerUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreerUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreerUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreerUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreerUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox NatureMotPasse;
    private javax.swing.JButton btnAjouterRole;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnCreerDroit;
    private javax.swing.JButton btnOK;
    private javax.swing.JButton btnSuppDroit;
    private javax.swing.JButton btnSuppRole;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtxtnom;
    public static javax.swing.JList<String> listDroit;
    public static javax.swing.JList<String> listRole;
    private javax.swing.JPanel pConteneur;
    private javax.swing.JPanel pDroits;
    private javax.swing.JPanel pGeneral;
    private javax.swing.JPanel pRoles;
    private javax.swing.JTextField quota;
    private javax.swing.JComboBox tempTablespace;
    private javax.swing.JTabbedPane tpUser;
    // End of variables declaration//GEN-END:variables

    public void updatecomboprof() {
        jComboBox2.removeAllItems();
        try {

            DefaultListModel listModel = new <String>DefaultListModel();
            Statement stmt = null;

            stmt = cn.createStatement();

            ResultSet rs = stmt.executeQuery("Select DISTINCT PROFILE FROM dba_profiles ");
            while (rs.next()) {
                jComboBox2.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void remplirCombot() {
        jComboBox1.removeAllItems();
        try {

            Statement stmt = null;
            stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select tablespace_name from dba_tablespaces");

            while (rs.next()) {
                jComboBox1.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public String privilc(JList l) {
        String s = "";

        ArrayList<String> df = (ArrayList<String>) l.getSelectedValuesList();
        int nb = df.size();
        int i = 0;
        for (Iterator it = df.iterator(); it.hasNext();) {
            i++;
            if (nb == i) {
                s = s + it.next();
            } else {
                s = s + it.next() + ", ";
            }

        }

        return s;
    }

}
