/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminBD.Users;

import static AdminBD.Users.CreerUser.listDroit;
import MyClasses.ConnectODB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;

public final class AjouterDroit extends javax.swing.JFrame {

    Connection cn = (new ConnectODB("System", "cy15")).getCon();
    Statement stmt;
    ResultSet rs;

    public AjouterDroit() {
        setBestLookAndFeelAvailable();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updatelisttabs();
        this.setResizable(false);

        ActiverMenu("Type", false);
        ActiverMenu("Objet", false);
        ActiverMenu("Objet1", false);

        ActiverPrivTables(false);
        ActiverPrivVues(false);
        ActiverPrivSeq(false);
        ActiverPrivProc(false);
        ActiverPrivRep(false);

        pPrivSys.setVisible(true);
        pPrivObjet.setVisible(false);
    }

    public static void setBestLookAndFeelAvailable() {
        String system_lf = UIManager.getSystemLookAndFeelClassName().toLowerCase();

        if (system_lf.contains("metal")) {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
            }
        } else {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pPrivObje1 = new javax.swing.JPanel();
        pPrivTables1 = new javax.swing.JPanel();
        cbPTables_Select1 = new javax.swing.JCheckBox();
        cbPTables_Modify1 = new javax.swing.JCheckBox();
        cbPTables_Insert1 = new javax.swing.JCheckBox();
        cbPTables_Titre1 = new javax.swing.JLabel();
        cbPTables_Update1 = new javax.swing.JCheckBox();
        cbPTables_Constraint1 = new javax.swing.JCheckBox();
        cbPTables_Delete1 = new javax.swing.JCheckBox();
        cbPTables_Index1 = new javax.swing.JCheckBox();
        pPrivVues1 = new javax.swing.JPanel();
        cbPVues_Select1 = new javax.swing.JCheckBox();
        cbPVues_Constraint1 = new javax.swing.JCheckBox();
        cbPVues_Update1 = new javax.swing.JCheckBox();
        cbPVues_Titre1 = new javax.swing.JLabel();
        cbPVues_Insert1 = new javax.swing.JCheckBox();
        cbPVues_Delete1 = new javax.swing.JCheckBox();
        cbPVues_Sous1 = new javax.swing.JCheckBox();
        pPrivSeq1 = new javax.swing.JPanel();
        cbPSeq_Titre1 = new javax.swing.JLabel();
        cbPSeq_Modify1 = new javax.swing.JCheckBox();
        cbPSeq_Select1 = new javax.swing.JCheckBox();
        pPrivProc1 = new javax.swing.JPanel();
        cbPProc_Manip1 = new javax.swing.JCheckBox();
        cbPProc_Titre1 = new javax.swing.JLabel();
        pPrivRep1 = new javax.swing.JPanel();
        cbPRep_Titre1 = new javax.swing.JLabel();
        cbPRep_Manip1 = new javax.swing.JCheckBox();
        pPrivSys2 = new javax.swing.JPanel();
        pPrivTables2 = new javax.swing.JPanel();
        cbPrivTables2_Titre = new javax.swing.JLabel();
        cbPrivTables2_Create = new javax.swing.JCheckBox();
        cbPrivTables2_CreateAny = new javax.swing.JCheckBox();
        cbPrivTables2_ModifyAny = new javax.swing.JCheckBox();
        cbPrivTables2_Delete = new javax.swing.JCheckBox();
        cbPrivTables2_Drop = new javax.swing.JCheckBox();
        cbPrivTables2_Insert = new javax.swing.JCheckBox();
        cbPrivTables2_Select = new javax.swing.JCheckBox();
        pPrivVues2 = new javax.swing.JPanel();
        cbPrivVues2_Titre = new javax.swing.JLabel();
        cbPrivVues2_CreateAny = new javax.swing.JCheckBox();
        cbPrivVues2_Create = new javax.swing.JCheckBox();
        cbPrivVues2_Sous = new javax.swing.JCheckBox();
        cbPrivVues2_Delete = new javax.swing.JCheckBox();
        pPrivSess2 = new javax.swing.JPanel();
        cbPrivSess2_Con = new javax.swing.JCheckBox();
        cbPrivSess2_Titre = new javax.swing.JLabel();
        pPrivProf2 = new javax.swing.JPanel();
        cbPrivProf2_Modify = new javax.swing.JCheckBox();
        cbPrivProf2_Create = new javax.swing.JCheckBox();
        cbPrivProf2_Titre = new javax.swing.JLabel();
        cbPrivProf2_Delete = new javax.swing.JCheckBox();
        pPrivRoles2 = new javax.swing.JPanel();
        cbPrivRoles2_Create = new javax.swing.JCheckBox();
        cbPrivRoles2_ModifyAny = new javax.swing.JCheckBox();
        cbPrivRoles2_Titre = new javax.swing.JLabel();
        cbPrivRoles2_Ass = new javax.swing.JCheckBox();
        cbPrivRoles2_Delete = new javax.swing.JCheckBox();
        pConteneur = new javax.swing.JPanel();
        pDroitsPour = new javax.swing.JPanel();
        lbTypeDroit = new javax.swing.JLabel();
        cbTypeDroit = new javax.swing.JComboBox<String>();
        lbTypeObjet = new javax.swing.JLabel();
        cbTypeObjet = new javax.swing.JComboBox<String>();
        cbObjet = new javax.swing.JComboBox<String>();
        lbObjet = new javax.swing.JLabel();
        cbAdminOption = new javax.swing.JCheckBox();
        lbObjet1 = new javax.swing.JLabel();
        lObjet = new javax.swing.JScrollPane();
        lObjet1 = new javax.swing.JList<String>();
        pDroits = new javax.swing.JPanel();
        pPrivObjet = new javax.swing.JPanel();
        pPrivTables = new javax.swing.JPanel();
        cbPTables_Modify = new javax.swing.JCheckBox();
        cbPTables_Select = new javax.swing.JCheckBox();
        cbPTables_Insert = new javax.swing.JCheckBox();
        cbPTables_Titre = new javax.swing.JLabel();
        cbPTables_Update = new javax.swing.JCheckBox();
        cbPTables_Constraint = new javax.swing.JCheckBox();
        cbPTables_Delete = new javax.swing.JCheckBox();
        cbPTables_Index = new javax.swing.JCheckBox();
        pPrivVues = new javax.swing.JPanel();
        cbPVues_Select = new javax.swing.JCheckBox();
        cbPVues_Constraint = new javax.swing.JCheckBox();
        cbPVues_Update = new javax.swing.JCheckBox();
        cbPVues_Titre = new javax.swing.JLabel();
        cbPVues_Insert = new javax.swing.JCheckBox();
        cbPVues_Delete = new javax.swing.JCheckBox();
        cbPVues_Sous = new javax.swing.JCheckBox();
        pPrivSeq = new javax.swing.JPanel();
        cbPSeq_Titre = new javax.swing.JLabel();
        cbPSeq_Modify = new javax.swing.JCheckBox();
        cbPSeq_Select = new javax.swing.JCheckBox();
        pPrivProc = new javax.swing.JPanel();
        cbPProc_Manip = new javax.swing.JCheckBox();
        cbPProc_Titre = new javax.swing.JLabel();
        pPrivRep = new javax.swing.JPanel();
        cbPRep_Titre = new javax.swing.JLabel();
        cbPRep_Manip = new javax.swing.JCheckBox();
        pPrivSys = new javax.swing.JPanel();
        pPrivTable = new javax.swing.JPanel();
        cbPrivTable_Titre = new javax.swing.JLabel();
        cbPrivTable_Create = new javax.swing.JCheckBox();
        cbPrivTable_CreateAny = new javax.swing.JCheckBox();
        cbPrivTable_ModifyAny = new javax.swing.JCheckBox();
        cbPrivTable_Delete = new javax.swing.JCheckBox();
        cbPrivTable_Drop = new javax.swing.JCheckBox();
        cbPrivTable_Insert = new javax.swing.JCheckBox();
        cbPrivTable_Select = new javax.swing.JCheckBox();
        cbPrivTable_modif = new javax.swing.JCheckBox();
        pPrivVue = new javax.swing.JPanel();
        cbPrivVue_Titre = new javax.swing.JLabel();
        cbPrivVue_CreateAny = new javax.swing.JCheckBox();
        cbPrivVue_Create = new javax.swing.JCheckBox();
        cbPrivVue_Sous = new javax.swing.JCheckBox();
        cbPrivVue_Delete = new javax.swing.JCheckBox();
        pPrivSess = new javax.swing.JPanel();
        cbPrivSess_Con = new javax.swing.JCheckBox();
        cbPrivSess_Titre = new javax.swing.JLabel();
        pPrivProf = new javax.swing.JPanel();
        cbPrivProf_Modify = new javax.swing.JCheckBox();
        cbPrivProf_Create = new javax.swing.JCheckBox();
        cbPrivProf_Titre = new javax.swing.JLabel();
        cbPrivProf_Delete = new javax.swing.JCheckBox();
        pPrivRoles = new javax.swing.JPanel();
        cbPrivRole_Create = new javax.swing.JCheckBox();
        cbPrivRole_ModifyAny = new javax.swing.JCheckBox();
        cbPrivRole_Titre = new javax.swing.JLabel();
        cbPrivRoles2_Ass1 = new javax.swing.JCheckBox();
        cbPrivRoles2_Delete1 = new javax.swing.JCheckBox();
        btnAffecter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        pPrivObje1.setPreferredSize(new java.awt.Dimension(347, 425));

        pPrivTables1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        cbPTables_Select1.setText("Sélectionner");
        cbPTables_Select1.setToolTipText("GRANT SELECT ON table TO user");

        cbPTables_Modify1.setText("Modifier définition");
        cbPTables_Modify1.setToolTipText("UPDATE");

        cbPTables_Insert1.setText("Insérer ligne");
        cbPTables_Insert1.setToolTipText("GRANT INSERT ON table TO user");

        cbPTables_Titre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPTables_Titre1.setForeground(new java.awt.Color(0, 51, 255));
        cbPTables_Titre1.setText("Privilèges Tables");

        cbPTables_Update1.setText("Mise à jour");
        cbPTables_Update1.setToolTipText("GRANT UPDATE ON table To USER");

        cbPTables_Constraint1.setText("Créer contrainte");

        cbPTables_Delete1.setText("Supprimer lignes");
        cbPTables_Delete1.setToolTipText("GRANT DELETE ON table TO user");

        cbPTables_Index1.setText("Créer Index");
        cbPTables_Index1.setToolTipText("GRANT INDEX ON table TO user");

        javax.swing.GroupLayout pPrivTables1Layout = new javax.swing.GroupLayout(pPrivTables1);
        pPrivTables1.setLayout(pPrivTables1Layout);
        pPrivTables1Layout.setHorizontalGroup(
            pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTables1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivTables1Layout.createSequentialGroup()
                        .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPTables_Insert1)
                            .addComponent(cbPTables_Index1))
                        .addGap(18, 18, 18)
                        .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPTables_Constraint1)
                            .addComponent(cbPTables_Delete1)))
                    .addGroup(pPrivTables1Layout.createSequentialGroup()
                        .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPTables_Titre1)
                            .addGroup(pPrivTables1Layout.createSequentialGroup()
                                .addComponent(cbPTables_Select1)
                                .addGap(18, 18, 18)
                                .addComponent(cbPTables_Modify1)))
                        .addGap(18, 18, 18)
                        .addComponent(cbPTables_Update1)))
                .addContainerGap())
        );
        pPrivTables1Layout.setVerticalGroup(
            pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTables1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPTables_Titre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Select1)
                    .addComponent(cbPTables_Modify1)
                    .addComponent(cbPTables_Update1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Insert1)
                    .addComponent(cbPTables_Delete1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTables1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Index1)
                    .addComponent(cbPTables_Constraint1))
                .addContainerGap())
        );

        pPrivVues1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPVues_Select1.setText("Sélectionner");
        cbPVues_Select1.setToolTipText("SELECT");

        cbPVues_Constraint1.setText("Créer contrainte");

        cbPVues_Update1.setText("Mise à jour");
        cbPVues_Update1.setToolTipText("UPDATE");

        cbPVues_Titre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPVues_Titre1.setForeground(new java.awt.Color(0, 51, 255));
        cbPVues_Titre1.setText("Privilèges Vues");

        cbPVues_Insert1.setText("Insérer ligne");
        cbPVues_Insert1.setToolTipText("UPDATE");

        cbPVues_Delete1.setText("Supprimer");
        cbPVues_Delete1.setToolTipText("UPDATE");

        cbPVues_Sous1.setText("Créer sous-vue");
        cbPVues_Sous1.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivVues1Layout = new javax.swing.GroupLayout(pPrivVues1);
        pPrivVues1.setLayout(pPrivVues1Layout);
        pPrivVues1Layout.setHorizontalGroup(
            pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVues1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPVues_Sous1)
                    .addGroup(pPrivVues1Layout.createSequentialGroup()
                        .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPVues_Select1)
                            .addComponent(cbPVues_Insert1))
                        .addGap(24, 24, 24)
                        .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPrivVues1Layout.createSequentialGroup()
                                .addComponent(cbPVues_Update1)
                                .addGap(50, 50, 50)
                                .addComponent(cbPVues_Delete1))
                            .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbPVues_Titre1)
                                .addComponent(cbPVues_Constraint1)))))
                .addContainerGap())
        );
        pPrivVues1Layout.setVerticalGroup(
            pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVues1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPVues_Titre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Select1)
                    .addComponent(cbPVues_Update1)
                    .addComponent(cbPVues_Delete1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivVues1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Insert1)
                    .addComponent(cbPVues_Constraint1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPVues_Sous1)
                .addContainerGap())
        );

        pPrivSeq1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPSeq_Titre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPSeq_Titre1.setForeground(new java.awt.Color(0, 51, 255));
        cbPSeq_Titre1.setText("Privilèges Séquences");

        cbPSeq_Modify1.setText("Modifier définition");
        cbPSeq_Modify1.setToolTipText("UPDATE");

        cbPSeq_Select1.setText("Sélectionner");
        cbPSeq_Select1.setToolTipText("SELECT");

        javax.swing.GroupLayout pPrivSeq1Layout = new javax.swing.GroupLayout(pPrivSeq1);
        pPrivSeq1.setLayout(pPrivSeq1Layout);
        pPrivSeq1Layout.setHorizontalGroup(
            pPrivSeq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeq1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPSeq_Select1)
                .addGap(26, 26, 26)
                .addGroup(pPrivSeq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPSeq_Titre1)
                    .addComponent(cbPSeq_Modify1))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        pPrivSeq1Layout.setVerticalGroup(
            pPrivSeq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeq1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPSeq_Titre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivSeq1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPSeq_Select1)
                    .addComponent(cbPSeq_Modify1))
                .addContainerGap())
        );

        pPrivProc1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPProc_Manip1.setText("Manipuler procédure");
        cbPProc_Manip1.setToolTipText("SELECT");

        cbPProc_Titre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPProc_Titre1.setForeground(new java.awt.Color(0, 51, 255));
        cbPProc_Titre1.setText("Privilèges Procédures");

        javax.swing.GroupLayout pPrivProc1Layout = new javax.swing.GroupLayout(pPrivProc1);
        pPrivProc1.setLayout(pPrivProc1Layout);
        pPrivProc1Layout.setHorizontalGroup(
            pPrivProc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProc1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPProc_Manip1)
                .addContainerGap(216, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivProc1Layout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addComponent(cbPProc_Titre1)
                .addGap(100, 100, 100))
        );
        pPrivProc1Layout.setVerticalGroup(
            pPrivProc1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProc1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPProc_Titre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPProc_Manip1)
                .addContainerGap())
        );

        pPrivRep1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPRep_Titre1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPRep_Titre1.setForeground(new java.awt.Color(0, 51, 255));
        cbPRep_Titre1.setText("Privilèges Répertoires");

        cbPRep_Manip1.setText("Manipuler objet");
        cbPRep_Manip1.setToolTipText("SELECT");

        javax.swing.GroupLayout pPrivRep1Layout = new javax.swing.GroupLayout(pPrivRep1);
        pPrivRep1.setLayout(pPrivRep1Layout);
        pPrivRep1Layout.setHorizontalGroup(
            pPrivRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRep1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPRep_Manip1)
                .addContainerGap(240, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivRep1Layout.createSequentialGroup()
                .addContainerGap(118, Short.MAX_VALUE)
                .addComponent(cbPRep_Titre1)
                .addGap(101, 101, 101))
        );
        pPrivRep1Layout.setVerticalGroup(
            pPrivRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRep1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPRep_Titre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPRep_Manip1)
                .addContainerGap())
        );

        javax.swing.GroupLayout pPrivObje1Layout = new javax.swing.GroupLayout(pPrivObje1);
        pPrivObje1.setLayout(pPrivObje1Layout);
        pPrivObje1Layout.setHorizontalGroup(
            pPrivObje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrivVues1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivSeq1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivTables1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivProc1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivRep1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pPrivObje1Layout.setVerticalGroup(
            pPrivObje1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivObje1Layout.createSequentialGroup()
                .addComponent(pPrivTables1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pPrivVues1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivSeq1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivProc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivRep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pPrivSys2.setPreferredSize(new java.awt.Dimension(347, 425));

        pPrivTables2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pPrivTables2.setPreferredSize(new java.awt.Dimension(347, 106));

        cbPrivTables2_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivTables2_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPrivTables2_Titre.setText("Privilèges Tables");

        cbPrivTables2_Create.setText("Créer");
        cbPrivTables2_Create.setToolTipText("CREATE TABLE");

        cbPrivTables2_CreateAny.setText("Créer n'importe");
        cbPrivTables2_CreateAny.setToolTipText("CREATE ANY TABLE");

        cbPrivTables2_ModifyAny.setText("Modifier n'importe");
        cbPrivTables2_ModifyAny.setToolTipText("ALTER ANY TABLE");

        cbPrivTables2_Delete.setText("Supprimer lignes");
        cbPrivTables2_Delete.setToolTipText("DELETE ANY TABLE");

        cbPrivTables2_Drop.setText("Supprimer tables");
        cbPrivTables2_Drop.setToolTipText("DROP ANY TABLE");

        cbPrivTables2_Insert.setText("Insérer lignes");
        cbPrivTables2_Insert.setToolTipText("INSERT ANY TABLE");

        cbPrivTables2_Select.setText("Sélectionner");
        cbPrivTables2_Select.setToolTipText("SELECT ANY TABLE");

        javax.swing.GroupLayout pPrivTables2Layout = new javax.swing.GroupLayout(pPrivTables2);
        pPrivTables2.setLayout(pPrivTables2Layout);
        pPrivTables2Layout.setHorizontalGroup(
            pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivTables2Layout.createSequentialGroup()
                .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivTables2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrivTables2_Delete)
                            .addComponent(cbPrivTables2_Create))
                        .addGap(0, 0, 0)
                        .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrivTables2_CreateAny)
                            .addComponent(cbPrivTables2_Insert)))
                    .addGroup(pPrivTables2Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(cbPrivTables2_Titre)))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivTables2_ModifyAny)
                    .addComponent(cbPrivTables2_Drop))
                .addGap(12, 12, 12))
            .addGroup(pPrivTables2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivTables2_Select)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPrivTables2Layout.setVerticalGroup(
            pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTables2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivTables2_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivTables2_Create)
                    .addComponent(cbPrivTables2_CreateAny)
                    .addComponent(cbPrivTables2_ModifyAny))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTables2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivTables2_Delete)
                    .addComponent(cbPrivTables2_Drop)
                    .addComponent(cbPrivTables2_Insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPrivTables2_Select)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrivVues2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivVues2_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivVues2_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPrivVues2_Titre.setText("Privilèges Vues");

        cbPrivVues2_CreateAny.setText("Créer n'importe");
        cbPrivVues2_CreateAny.setToolTipText("UPDATE");

        cbPrivVues2_Create.setText("Créer");
        cbPrivVues2_Create.setToolTipText("SELECT");

        cbPrivVues2_Sous.setText("Créer sous-vue");
        cbPrivVues2_Sous.setToolTipText("UPDATE");

        cbPrivVues2_Delete.setText("Supprimer");
        cbPrivVues2_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivVues2Layout = new javax.swing.GroupLayout(pPrivVues2);
        pPrivVues2.setLayout(pPrivVues2Layout);
        pPrivVues2Layout.setHorizontalGroup(
            pPrivVues2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVues2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivVues2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivVues2Layout.createSequentialGroup()
                        .addComponent(cbPrivVues2_Create)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbPrivVues2_CreateAny)
                        .addGap(39, 39, 39)
                        .addComponent(cbPrivVues2_Sous)
                        .addGap(17, 17, 17))
                    .addGroup(pPrivVues2Layout.createSequentialGroup()
                        .addComponent(cbPrivVues2_Delete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pPrivVues2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(cbPrivVues2_Titre)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pPrivVues2Layout.setVerticalGroup(
            pPrivVues2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVues2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivVues2_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVues2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivVues2_Create)
                    .addComponent(cbPrivVues2_CreateAny)
                    .addComponent(cbPrivVues2_Sous))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPrivVues2_Delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrivSess2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivSess2_Con.setText("Connexion à la Base de Données");
        cbPrivSess2_Con.setToolTipText("SELECT");

        cbPrivSess2_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivSess2_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPrivSess2_Titre.setText("Privilèges Sessions");

        javax.swing.GroupLayout pPrivSess2Layout = new javax.swing.GroupLayout(pPrivSess2);
        pPrivSess2.setLayout(pPrivSess2Layout);
        pPrivSess2Layout.setHorizontalGroup(
            pPrivSess2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSess2Layout.createSequentialGroup()
                .addGroup(pPrivSess2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivSess2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbPrivSess2_Con))
                    .addGroup(pPrivSess2Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(cbPrivSess2_Titre)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPrivSess2Layout.setVerticalGroup(
            pPrivSess2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSess2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivSess2_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPrivSess2_Con)
                .addContainerGap())
        );

        pPrivProf2.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        cbPrivProf2_Modify.setText("Modifier");
        cbPrivProf2_Modify.setToolTipText("UPDATE");

        cbPrivProf2_Create.setText("Créer");
        cbPrivProf2_Create.setToolTipText("SELECT");

        cbPrivProf2_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivProf2_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPrivProf2_Titre.setText("Privilèges Profiles");

        cbPrivProf2_Delete.setText("Supprimer");
        cbPrivProf2_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivProf2Layout = new javax.swing.GroupLayout(pPrivProf2);
        pPrivProf2.setLayout(pPrivProf2Layout);
        pPrivProf2Layout.setHorizontalGroup(
            pPrivProf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivProf2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivProf2_Create)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pPrivProf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivProf2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbPrivProf2_Modify)
                        .addGap(64, 64, 64)
                        .addComponent(cbPrivProf2_Delete))
                    .addComponent(cbPrivProf2_Titre))
                .addGap(17, 17, 17))
        );
        pPrivProf2Layout.setVerticalGroup(
            pPrivProf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProf2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivProf2_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivProf2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivProf2_Create)
                    .addComponent(cbPrivProf2_Modify)
                    .addComponent(cbPrivProf2_Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrivRoles2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivRoles2_Create.setText("Créer");
        cbPrivRoles2_Create.setToolTipText("SELECT");

        cbPrivRoles2_ModifyAny.setText("Modifier n'importe");
        cbPrivRoles2_ModifyAny.setToolTipText("UPDATE");

        cbPrivRoles2_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivRoles2_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPrivRoles2_Titre.setText("Privilèges Rôles");

        cbPrivRoles2_Ass.setText("Assigner n'importe");
        cbPrivRoles2_Ass.setToolTipText("UPDATE");

        cbPrivRoles2_Delete.setText("Supprimer n'importe");
        cbPrivRoles2_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivRoles2Layout = new javax.swing.GroupLayout(pPrivRoles2);
        pPrivRoles2.setLayout(pPrivRoles2Layout);
        pPrivRoles2Layout.setHorizontalGroup(
            pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRoles2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivRoles2_Create)
                    .addComponent(cbPrivRoles2_Ass))
                .addGap(24, 24, 24)
                .addGroup(pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivRoles2_ModifyAny)
                    .addComponent(cbPrivRoles2_Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivRoles2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbPrivRoles2_Titre)
                .addGap(124, 124, 124))
        );
        pPrivRoles2Layout.setVerticalGroup(
            pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRoles2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivRoles2_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivRoles2_Create)
                    .addComponent(cbPrivRoles2_ModifyAny))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivRoles2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivRoles2_Ass)
                    .addComponent(cbPrivRoles2_Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pPrivSys2Layout = new javax.swing.GroupLayout(pPrivSys2);
        pPrivSys2.setLayout(pPrivSys2Layout);
        pPrivSys2Layout.setHorizontalGroup(
            pPrivSys2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrivSess2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivProf2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivRoles2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivVues2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivTables2, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );
        pPrivSys2Layout.setVerticalGroup(
            pPrivSys2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSys2Layout.createSequentialGroup()
                .addComponent(pPrivTables2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivVues2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivSess2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivProf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivRoles2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pConteneur.setPreferredSize(new java.awt.Dimension(657, 530));

        pDroitsPour.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

        lbTypeDroit.setText("Type droit :");

        cbTypeDroit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Système", "Objet" }));
        cbTypeDroit.setPreferredSize(new java.awt.Dimension(56, 22));
        cbTypeDroit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeDroitActionPerformed(evt);
            }
        });

        lbTypeObjet.setText("Type d'objet :");

        cbTypeObjet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Table", "Vue", "Séquence", "Procédure", "Répertoire" }));
        cbTypeObjet.setToolTipText("");
        cbTypeObjet.setPreferredSize(new java.awt.Dimension(56, 22));
        cbTypeObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypeObjetActionPerformed(evt);
            }
        });

        cbObjet.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "..." }));
        cbObjet.setPreferredSize(new java.awt.Dimension(56, 22));
        cbObjet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbObjetItemStateChanged(evt);
            }
        });
        cbObjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbObjetActionPerformed(evt);
            }
        });

        lbObjet.setText("Table :");

        cbAdminOption.setText("Ajouter l'option d'Admin");

        lbObjet1.setText("Colonnes :");

        lObjet1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Tous" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lObjet1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lObjet1ValueChanged(evt);
            }
        });
        lObjet.setViewportView(lObjet1);

        javax.swing.GroupLayout pDroitsPourLayout = new javax.swing.GroupLayout(pDroitsPour);
        pDroitsPour.setLayout(pDroitsPourLayout);
        pDroitsPourLayout.setHorizontalGroup(
            pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDroitsPourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbAdminOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pDroitsPourLayout.createSequentialGroup()
                            .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbTypeObjet, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbObjet, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbTypeDroit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbTypeDroit, 0, 120, Short.MAX_VALUE)
                                .addComponent(cbTypeObjet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbObjet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lObjet))))
                    .addComponent(lbObjet1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pDroitsPourLayout.setVerticalGroup(
            pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDroitsPourLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTypeDroit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTypeDroit))
                .addGap(16, 16, 16)
                .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTypeObjet)
                    .addComponent(cbTypeObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbObjet)
                    .addComponent(cbObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pDroitsPourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbObjet1)
                    .addComponent(lObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(cbAdminOption)
                .addContainerGap())
        );

        pDroits.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Droits", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        pDroits.setPreferredSize(new java.awt.Dimension(347, 397));

        pPrivObjet.setPreferredSize(new java.awt.Dimension(347, 425));

        pPrivTables.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        pPrivTables.setPreferredSize(new java.awt.Dimension(318, 111));

        cbPTables_Modify.setText("Modifier définition");
        cbPTables_Modify.setToolTipText("UPDATE");

        cbPTables_Select.setText("Sélectionner");
        cbPTables_Select.setToolTipText("GRANT SELECT ON table TO user");

        cbPTables_Insert.setText("Insérer ligne");
        cbPTables_Insert.setToolTipText("GRANT INSERT ON table TO user");

        cbPTables_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPTables_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPTables_Titre.setText("Privilèges Tables");

        cbPTables_Update.setText("Mise à jour");
        cbPTables_Update.setToolTipText("GRANT UPDATE ON table To USER");

        cbPTables_Constraint.setText("Créer contrainte");

        cbPTables_Delete.setText("Supprimer lignes");
        cbPTables_Delete.setToolTipText("GRANT DELETE ON table TO user");

        cbPTables_Index.setText("Créer Index");
        cbPTables_Index.setToolTipText("GRANT INDEX ON table TO user");

        javax.swing.GroupLayout pPrivTablesLayout = new javax.swing.GroupLayout(pPrivTables);
        pPrivTables.setLayout(pPrivTablesLayout);
        pPrivTablesLayout.setHorizontalGroup(
            pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivTablesLayout.createSequentialGroup()
                        .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPTables_Insert)
                            .addComponent(cbPTables_Index))
                        .addGap(18, 18, 18)
                        .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPTables_Constraint)
                            .addComponent(cbPTables_Delete)))
                    .addGroup(pPrivTablesLayout.createSequentialGroup()
                        .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbPTables_Titre)
                            .addGroup(pPrivTablesLayout.createSequentialGroup()
                                .addComponent(cbPTables_Select)
                                .addGap(18, 18, 18)
                                .addComponent(cbPTables_Modify)))
                        .addGap(18, 18, 18)
                        .addComponent(cbPTables_Update)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pPrivTablesLayout.setVerticalGroup(
            pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPTables_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Select)
                    .addComponent(cbPTables_Modify)
                    .addComponent(cbPTables_Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Insert)
                    .addComponent(cbPTables_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Index)
                    .addComponent(cbPTables_Constraint))
                .addContainerGap())
        );

        pPrivVues.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPVues_Select.setText("Sélectionner");
        cbPVues_Select.setToolTipText("SELECT");

        cbPVues_Constraint.setText("Créer contrainte");

        cbPVues_Update.setText("Mise à jour");
        cbPVues_Update.setToolTipText("UPDATE");

        cbPVues_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPVues_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPVues_Titre.setText("Privilèges Vues");

        cbPVues_Insert.setText("Insérer ligne");
        cbPVues_Insert.setToolTipText("UPDATE");

        cbPVues_Delete.setText("Supprimer");
        cbPVues_Delete.setToolTipText("UPDATE");

        cbPVues_Sous.setText("Créer sous-vue");
        cbPVues_Sous.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivVuesLayout = new javax.swing.GroupLayout(pPrivVues);
        pPrivVues.setLayout(pPrivVuesLayout);
        pPrivVuesLayout.setHorizontalGroup(
            pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPVues_Sous)
                    .addGroup(pPrivVuesLayout.createSequentialGroup()
                        .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPVues_Select)
                            .addComponent(cbPVues_Insert))
                        .addGap(24, 24, 24)
                        .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pPrivVuesLayout.createSequentialGroup()
                                .addComponent(cbPVues_Update)
                                .addGap(50, 50, 50)
                                .addComponent(cbPVues_Delete))
                            .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbPVues_Titre)
                                .addComponent(cbPVues_Constraint)))))
                .addContainerGap())
        );
        pPrivVuesLayout.setVerticalGroup(
            pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVuesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPVues_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Select)
                    .addComponent(cbPVues_Update)
                    .addComponent(cbPVues_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Insert)
                    .addComponent(cbPVues_Constraint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPVues_Sous)
                .addContainerGap())
        );

        pPrivSeq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPSeq_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPSeq_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPSeq_Titre.setText("Privilèges Séquences");

        cbPSeq_Modify.setText("Modifier définition");
        cbPSeq_Modify.setToolTipText("UPDATE");

        cbPSeq_Select.setText("Sélectionner");
        cbPSeq_Select.setToolTipText("SELECT");

        javax.swing.GroupLayout pPrivSeqLayout = new javax.swing.GroupLayout(pPrivSeq);
        pPrivSeq.setLayout(pPrivSeqLayout);
        pPrivSeqLayout.setHorizontalGroup(
            pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPSeq_Select)
                .addGap(26, 26, 26)
                .addGroup(pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPSeq_Titre)
                    .addComponent(cbPSeq_Modify))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPrivSeqLayout.setVerticalGroup(
            pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeqLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPSeq_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPSeq_Select)
                    .addComponent(cbPSeq_Modify))
                .addContainerGap())
        );

        pPrivProc.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPProc_Manip.setText("Manipuler procédure");
        cbPProc_Manip.setToolTipText("SELECT");

        cbPProc_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPProc_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPProc_Titre.setText("Privilèges Procédures");

        javax.swing.GroupLayout pPrivProcLayout = new javax.swing.GroupLayout(pPrivProc);
        pPrivProc.setLayout(pPrivProcLayout);
        pPrivProcLayout.setHorizontalGroup(
            pPrivProcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPProc_Manip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivProcLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbPProc_Titre)
                .addGap(100, 100, 100))
        );
        pPrivProcLayout.setVerticalGroup(
            pPrivProcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProcLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPProc_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPProc_Manip)
                .addContainerGap())
        );

        pPrivRep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPRep_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPRep_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPRep_Titre.setText("Privilèges Répertoires");

        cbPRep_Manip.setText("Manipuler objet");
        cbPRep_Manip.setToolTipText("SELECT");

        javax.swing.GroupLayout pPrivRepLayout = new javax.swing.GroupLayout(pPrivRep);
        pPrivRep.setLayout(pPrivRepLayout);
        pPrivRepLayout.setHorizontalGroup(
            pPrivRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRepLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPRep_Manip)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivRepLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbPRep_Titre)
                .addGap(101, 101, 101))
        );
        pPrivRepLayout.setVerticalGroup(
            pPrivRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRepLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPRep_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPRep_Manip)
                .addContainerGap())
        );

        javax.swing.GroupLayout pPrivObjetLayout = new javax.swing.GroupLayout(pPrivObjet);
        pPrivObjet.setLayout(pPrivObjetLayout);
        pPrivObjetLayout.setHorizontalGroup(
            pPrivObjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrivVues, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivSeq, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivProc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivRep, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivTables, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pPrivObjetLayout.setVerticalGroup(
            pPrivObjetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivObjetLayout.createSequentialGroup()
                .addComponent(pPrivTables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(pPrivVues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivSeq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivProc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivRep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pPrivSys.setPreferredSize(new java.awt.Dimension(347, 425));

        pPrivTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pPrivTable.setPreferredSize(new java.awt.Dimension(347, 111));
        pPrivTable.setRequestFocusEnabled(false);

        cbPrivTable_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivTable_Titre.setForeground(new java.awt.Color(0, 102, 0));
        cbPrivTable_Titre.setText("Privilèges Tables");

        cbPrivTable_Create.setText("Créer");
        cbPrivTable_Create.setToolTipText("CREATE TABLE");

        cbPrivTable_CreateAny.setText("Créer n'importe");
        cbPrivTable_CreateAny.setToolTipText("CREATE ANY TABLE");

        cbPrivTable_ModifyAny.setText("Modifier n'importe");
        cbPrivTable_ModifyAny.setToolTipText("ALTER ANY TABLE");

        cbPrivTable_Delete.setText("Supprimer lignes");
        cbPrivTable_Delete.setToolTipText("DELETE ANY TABLE");

        cbPrivTable_Drop.setText("Supprimer tables");
        cbPrivTable_Drop.setToolTipText("DROP ANY TABLE");

        cbPrivTable_Insert.setText("Insérer lignes");
        cbPrivTable_Insert.setToolTipText("INSERT ANY TABLE");

        cbPrivTable_Select.setText("Sélectionner");
        cbPrivTable_Select.setToolTipText("SELECT ANY TABLE");

        cbPrivTable_modif.setText("modifier lignes");
        cbPrivTable_modif.setToolTipText("SELECT ANY TABLE");

        javax.swing.GroupLayout pPrivTableLayout = new javax.swing.GroupLayout(pPrivTable);
        pPrivTable.setLayout(pPrivTableLayout);
        pPrivTableLayout.setHorizontalGroup(
            pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivTable_Delete)
                    .addComponent(cbPrivTable_Create))
                .addGap(0, 0, 0)
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivTable_CreateAny)
                    .addComponent(cbPrivTable_Insert))
                .addGap(0, 14, Short.MAX_VALUE)
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPrivTable_ModifyAny)
                    .addComponent(cbPrivTable_Drop))
                .addGap(12, 12, 12))
            .addGroup(pPrivTableLayout.createSequentialGroup()
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivTableLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbPrivTable_Select)
                        .addGap(18, 18, 18)
                        .addComponent(cbPrivTable_modif))
                    .addGroup(pPrivTableLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(cbPrivTable_Titre)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        pPrivTableLayout.setVerticalGroup(
            pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTableLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivTable_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivTable_Create)
                    .addComponent(cbPrivTable_CreateAny)
                    .addComponent(cbPrivTable_ModifyAny))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivTable_Delete)
                    .addComponent(cbPrivTable_Drop)
                    .addComponent(cbPrivTable_Insert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivTable_Select)
                    .addComponent(cbPrivTable_modif))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pPrivVue.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivVue_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivVue_Titre.setForeground(new java.awt.Color(0, 102, 0));
        cbPrivVue_Titre.setText("Privilèges Vues");

        cbPrivVue_CreateAny.setText("Créer n'importe");
        cbPrivVue_CreateAny.setToolTipText("UPDATE");

        cbPrivVue_Create.setText("Créer");
        cbPrivVue_Create.setToolTipText("SELECT");

        cbPrivVue_Sous.setText("Créer sous-vue");
        cbPrivVue_Sous.setToolTipText("UPDATE");

        cbPrivVue_Delete.setText("Supprimer");
        cbPrivVue_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivVueLayout = new javax.swing.GroupLayout(pPrivVue);
        pPrivVue.setLayout(pPrivVueLayout);
        pPrivVueLayout.setHorizontalGroup(
            pPrivVueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVueLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPrivVueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivVueLayout.createSequentialGroup()
                        .addComponent(cbPrivVue_Create)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(cbPrivVue_CreateAny)
                        .addGap(39, 39, 39)
                        .addComponent(cbPrivVue_Sous)
                        .addGap(17, 17, 17))
                    .addGroup(pPrivVueLayout.createSequentialGroup()
                        .addComponent(cbPrivVue_Delete)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pPrivVueLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(cbPrivVue_Titre)
                .addGap(0, 138, Short.MAX_VALUE))
        );
        pPrivVueLayout.setVerticalGroup(
            pPrivVueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivVue_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivVue_Create)
                    .addComponent(cbPrivVue_CreateAny)
                    .addComponent(cbPrivVue_Sous))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPrivVue_Delete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrivSess.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivSess_Con.setText("Connexion à la Base de Données");
        cbPrivSess_Con.setToolTipText("SELECT");

        cbPrivSess_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivSess_Titre.setForeground(new java.awt.Color(0, 102, 0));
        cbPrivSess_Titre.setText("Privilèges Sessions");

        javax.swing.GroupLayout pPrivSessLayout = new javax.swing.GroupLayout(pPrivSess);
        pPrivSess.setLayout(pPrivSessLayout);
        pPrivSessLayout.setHorizontalGroup(
            pPrivSessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSessLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivSess_Con)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivSessLayout.createSequentialGroup()
                .addContainerGap(120, Short.MAX_VALUE)
                .addComponent(cbPrivSess_Titre)
                .addGap(113, 113, 113))
        );
        pPrivSessLayout.setVerticalGroup(
            pPrivSessLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSessLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivSess_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPrivSess_Con)
                .addContainerGap())
        );

        pPrivProf.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        cbPrivProf_Modify.setText("Modifier");
        cbPrivProf_Modify.setToolTipText("UPDATE");

        cbPrivProf_Create.setText("Créer");
        cbPrivProf_Create.setToolTipText("SELECT");

        cbPrivProf_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivProf_Titre.setForeground(new java.awt.Color(0, 102, 0));
        cbPrivProf_Titre.setText("Privilèges Profiles");

        cbPrivProf_Delete.setText("Supprimer");
        cbPrivProf_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivProfLayout = new javax.swing.GroupLayout(pPrivProf);
        pPrivProf.setLayout(pPrivProfLayout);
        pPrivProfLayout.setHorizontalGroup(
            pPrivProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPrivProfLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivProf_Create)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(cbPrivProf_Modify)
                .addGap(64, 64, 64)
                .addComponent(cbPrivProf_Delete)
                .addGap(17, 17, 17))
            .addGroup(pPrivProfLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(cbPrivProf_Titre)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        pPrivProfLayout.setVerticalGroup(
            pPrivProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProfLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPrivProf_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivProfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivProf_Create)
                    .addComponent(cbPrivProf_Modify)
                    .addComponent(cbPrivProf_Delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pPrivRoles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbPrivRole_Create.setText("Créer");
        cbPrivRole_Create.setToolTipText("SELECT");

        cbPrivRole_ModifyAny.setText("Modifier n'importe");
        cbPrivRole_ModifyAny.setToolTipText("UPDATE");

        cbPrivRole_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPrivRole_Titre.setForeground(new java.awt.Color(0, 102, 0));
        cbPrivRole_Titre.setText("Privilèges Rôles");

        cbPrivRoles2_Ass1.setText("Assigner n'importe");
        cbPrivRoles2_Ass1.setToolTipText("UPDATE");

        cbPrivRoles2_Delete1.setText("Supprimer n'importe");
        cbPrivRoles2_Delete1.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivRolesLayout = new javax.swing.GroupLayout(pPrivRoles);
        pPrivRoles.setLayout(pPrivRolesLayout);
        pPrivRolesLayout.setHorizontalGroup(
            pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRolesLayout.createSequentialGroup()
                .addGroup(pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivRolesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrivRole_Create)
                            .addComponent(cbPrivRoles2_Ass1))
                        .addGap(24, 24, 24)
                        .addGroup(pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPrivRole_ModifyAny)
                            .addComponent(cbPrivRoles2_Delete1)))
                    .addGroup(pPrivRolesLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(cbPrivRole_Titre)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        pPrivRolesLayout.setVerticalGroup(
            pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRolesLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(cbPrivRole_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivRole_Create)
                    .addComponent(cbPrivRole_ModifyAny))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivRolesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPrivRoles2_Ass1)
                    .addComponent(cbPrivRoles2_Delete1))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pPrivSysLayout = new javax.swing.GroupLayout(pPrivSys);
        pPrivSys.setLayout(pPrivSysLayout);
        pPrivSysLayout.setHorizontalGroup(
            pPrivSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pPrivSess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivRoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivVue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pPrivTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pPrivSysLayout.setVerticalGroup(
            pPrivSysLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSysLayout.createSequentialGroup()
                .addComponent(pPrivTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivVue, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivSess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pPrivRoles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pDroitsLayout = new javax.swing.GroupLayout(pDroits);
        pDroits.setLayout(pDroitsLayout);
        pDroitsLayout.setHorizontalGroup(
            pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 347, Short.MAX_VALUE)
            .addGroup(pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDroitsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPrivSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDroitsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPrivObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pDroitsLayout.setVerticalGroup(
            pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
            .addGroup(pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDroitsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPrivSys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(pDroitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pDroitsLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pPrivObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        btnAffecter.setText("Affecter");
        btnAffecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAffecterActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pConteneurLayout.createSequentialGroup()
                        .addComponent(btnAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pConteneurLayout.createSequentialGroup()
                        .addComponent(pDroitsPour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pDroits, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pConteneurLayout.setVerticalGroup(
            pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConteneurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDroits, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pDroitsPour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pConteneurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pConteneur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pConteneur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void ActiverMenu(String S, boolean B) {
        if (S.equals("Type")) {
            lbTypeObjet.setVisible(B);
            cbTypeObjet.setVisible(B);
        } else if (S.equals("Objet")) {
            lbObjet.setVisible(B);
            cbObjet.setVisible(B);
        } else if (S.equals("Objet1")) {
            lbObjet1.setVisible(B);
            lObjet1.setVisible(B);
            lObjet.setVisible(B);
        } else if (S.equals("Objet11")) {
            lbObjet1.setEnabled(B);
            lObjet1.setEnabled(B);
            lObjet.setEnabled(B);
        }
    }

    public void ActiverPrivTables(boolean B) {
        cbPTables_Select.setSelected(false);
        cbPTables_Modify.setSelected(false);
        cbPTables_Update.setSelected(false);
        cbPTables_Insert.setSelected(false);
        cbPTables_Delete.setSelected(false);
        cbPTables_Index.setSelected(false);
        cbPTables_Constraint.setSelected(false);

        cbPTables_Titre.setEnabled(B);
        cbPTables_Select.setEnabled(B);
        cbPTables_Modify.setEnabled(B);
        cbPTables_Update.setEnabled(B);
        cbPTables_Insert.setEnabled(B);
        cbPTables_Delete.setEnabled(B);
        cbPTables_Index.setEnabled(B);
        cbPTables_Constraint.setEnabled(B);
    }

    public void ActiverPrivVues(boolean B) {
        cbPVues_Select.setSelected(false);
        cbPVues_Update.setSelected(false);
        cbPVues_Insert.setSelected(false);
        cbPVues_Delete.setSelected(false);
        cbPVues_Sous.setSelected(false);
        cbPVues_Constraint.setSelected(false);

        cbPVues_Titre.setEnabled(B);
        cbPVues_Select.setEnabled(B);
        cbPVues_Update.setEnabled(B);
        cbPVues_Insert.setEnabled(B);
        cbPVues_Delete.setEnabled(B);
        cbPVues_Sous.setEnabled(B);
        cbPVues_Constraint.setEnabled(B);
    }

    public void ActiverPrivSeq(boolean B) {
        cbPSeq_Select.setSelected(false);
        cbPSeq_Modify.setSelected(false);

        cbPSeq_Titre.setEnabled(B);
        cbPSeq_Select.setEnabled(B);
        cbPSeq_Modify.setEnabled(B);
    }

    public void ActiverPrivProc(boolean B) {
        cbPProc_Manip.setSelected(false);

        cbPProc_Titre.setEnabled(B);
        cbPProc_Manip.setEnabled(B);
    }

    public void ActiverPrivRep(boolean B) {
        cbPRep_Manip.setSelected(false);

        cbPRep_Titre.setEnabled(B);
        cbPRep_Manip.setEnabled(B);
    }


    private void cbTypeDroitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeDroitActionPerformed
        if (cbTypeDroit.getSelectedItem() == "Objet") {
            pPrivObjet.setVisible(true);
            pPrivSys.setVisible(false);

            ActiverMenu("Type", true);
            ActiverMenu("Objet", false);
            ActiverMenu("Objet1", false);
            ActiverMenu("Objet11", false);
            lbObjet.setText("Objet :");
        } else if (cbTypeDroit.getSelectedItem() == "Système") {
            pPrivObjet.setVisible(false);
            pPrivSys.setVisible(true);

            ActiverMenu("Type", false);
            ActiverMenu("Objet", false);
            ActiverMenu("Objet1", false);
            ActiverMenu("Objet11", false);
        }

        lObjet1.clearSelection();
    }//GEN-LAST:event_cbTypeDroitActionPerformed

    private void cbTypeObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypeObjetActionPerformed
        if (cbTypeObjet.getSelectedItem() == "Table") {
            ActiverPrivTables(true);
            ActiverPrivVues(false);
            ActiverPrivSeq(false);
            ActiverPrivProc(false);
            ActiverPrivRep(false);
            ActiverMenu("Objet11", true);
        } else if (cbTypeObjet.getSelectedItem() == "Vue") {
            ActiverPrivTables(false);
            ActiverPrivVues(true);
            ActiverPrivSeq(false);
            ActiverPrivProc(false);
            ActiverPrivRep(false);
            ActiverMenu("Objet11", true);
        } else if (cbTypeObjet.getSelectedItem() == "Séquence") {
            ActiverPrivTables(false);
            ActiverPrivVues(false);
            ActiverPrivSeq(true);
            ActiverPrivProc(false);
            ActiverPrivRep(false);
            ActiverMenu("Objet11", false);
        } else if (cbTypeObjet.getSelectedItem() == "Procédure") {
            ActiverPrivTables(false);
            ActiverPrivVues(false);
            ActiverPrivSeq(false);
            ActiverPrivProc(true);
            ActiverPrivRep(false);
            ActiverMenu("Objet11", false);
        } else if (cbTypeObjet.getSelectedItem() == "Répertoire") {
            ActiverPrivTables(false);
            ActiverPrivVues(false);
            ActiverPrivSeq(false);
            ActiverPrivProc(false);
            ActiverPrivRep(true);
            ActiverMenu("Objet11", false);
        }

        if (cbTypeObjet.getSelectedItem() == "Répertoire") {
            lbObjet.setText("Répertoire :");
        } else {
            lbObjet.setText("Table :");
        }

        ActiverMenu("Objet", true);
        ActiverMenu("Objet1", true);

        lObjet1.clearSelection();
    }//GEN-LAST:event_cbTypeObjetActionPerformed


    private void lObjet1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lObjet1ValueChanged
        if (lObjet1.getSelectedIndex() == 0) {
            int N = lObjet1.getWidth();
            lObjet1.setSelectionInterval(0, N);
        }
    }//GEN-LAST:event_lObjet1ValueChanged

    private void btnAffecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAffecterActionPerformed
        String priv = null;
        DefaultListModel listModel1 = new DefaultListModel();
        
            //pour les tables
            if (cbPrivTable_Create.isSelected()) {
                priv = "CREATE TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_CreateAny.isSelected()) {
                priv = "CREATE ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_ModifyAny.isSelected()) {
                priv = "ALTER ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_Delete.isSelected()) {
                priv = "DELETE ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_Insert.isSelected()) {
                priv = "INSERT ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_Drop.isSelected()) {
                priv = "DROP ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_Select.isSelected()) {
                priv = "SELECT ANY TABLE";
                listModel1.addElement(priv);
            }
            if (cbPrivTable_modif.isSelected()) {
                priv = "UPDATE ANY TABLE";
                listModel1.addElement(priv);
            }

            //pour les vues
            if (cbPrivVue_Create.isSelected()) {
                priv = "CREATE VIEW";
                listModel1.addElement(priv);
            }
            if (cbPrivVue_CreateAny.isSelected()) {
                priv = "CREATE ANY VIEW";
                listModel1.addElement(priv);
            }
            if (cbPrivVue_Sous.isSelected()) {
                priv = "UNDER ANY VIEW";
                listModel1.addElement(priv);
            }
            if (cbPrivVue_Delete.isSelected()) {
                priv = "DROP ANY VIEW";
                listModel1.addElement(priv);
            }

            //pour les sessions
            if (cbPrivSess_Con.isSelected()) {
                priv = "CREATE SESSION";
                listModel1.addElement(priv);
            }

            // pour les profiles
            if (cbPrivProf_Create.isSelected()) {
                priv = "CREATE PROFILE";
                listModel1.addElement(priv);
            }
            if (cbPrivProf_Modify.isSelected()) {
                priv = "ALTER PROFILE";
                listModel1.addElement(priv);
            }
            if (cbPrivProf_Delete.isSelected()) {
                priv = "DROP PROFILE";
                listModel1.addElement(priv);
            }

            //pour les roles
            if (cbPrivRole_Create.isSelected()) {
                priv = "CREATE ROLE";
                listModel1.addElement(priv);
            }
            if (cbPrivRole_ModifyAny.isSelected()) {
                priv = "ALTER ANY ROLE";
                listModel1.addElement(priv);
            }
            if (cbPrivRoles2_Ass1.isSelected()) {
                priv = "GRANT ANY ROLE";
                listModel1.addElement(priv);
            }
            if (cbPrivRoles2_Delete1.isSelected()) {
                priv = "DROP ANY ROLE";
                listModel1.addElement(priv);
            }
       
            //pour les tables
            if (cbPTables_Select.isSelected()) {
                priv = "SELECT";
                listModel1.addElement(priv);
            }
            if (cbPTables_Modify.isSelected()) {
                priv = "ALTER";
                listModel1.addElement(priv);
            }
            if (cbPTables_Update.isSelected()) {
                priv = "UPDATE";
                listModel1.addElement(priv);
            }
            if (cbPTables_Insert.isSelected()) {
                priv = "INSERT";
                listModel1.addElement(priv);
            }
            if (cbPTables_Delete.isSelected()) {
                priv = "DELETE";
                listModel1.addElement(priv);
            }
            if (cbPTables_Index.isSelected()) {
                priv = "INDEX";
                listModel1.addElement(priv);
            }
            if (cbPTables_Constraint.isSelected()) {
                priv = "REFERENCES";
                listModel1.addElement(priv);
            }

            //pour les vues
            if (cbPVues_Select.isSelected()) {
                priv = "SELECT";
                listModel1.addElement(priv);
            }
            if (cbPVues_Update.isSelected()) {
                priv = "UPDATE";
                listModel1.addElement(priv);
            }
            if (cbPVues_Delete.isSelected()) {
                priv = "DELETE";
                listModel1.addElement(priv);
            }
            if (cbPVues_Insert.isSelected()) {
                priv = "INSERT";
                listModel1.addElement(priv);
            }
            if (cbPVues_Constraint.isSelected()) {
                priv = "REFERENCES";
                listModel1.addElement(priv);
            }
            if (cbPVues_Sous.isSelected()) {
                priv = "UNDER";
                listModel1.addElement(priv);
            }

            //pour les séquences
            if (cbPSeq_Select.isSelected()) {
                priv = "SELECT";
                listModel1.addElement(priv);
            }
            if (cbPSeq_Modify.isSelected()) {
                priv = "ALTER";
                listModel1.addElement(priv);
            }

            // pour les procédures
            if (cbPProc_Manip.isSelected()) {
                priv = "EXECUTE";
                listModel1.addElement(priv);
            }

            //pour les répertoires
            if (cbPRep_Manip.isSelected()) {
                priv = "EXECUTE";
                listModel1.addElement(priv);
            }
        
        listDroit.setModel(listModel1);
        
        this.hide();
    }//GEN-LAST:event_btnAffecterActionPerformed

    private void cbObjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbObjetActionPerformed
        lObjet1.clearSelection();
    }//GEN-LAST:event_cbObjetActionPerformed

    private void btnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnnulerActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnAnnulerActionPerformed

    private void cbObjetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbObjetItemStateChanged
        updateliste();
    }//GEN-LAST:event_cbObjetItemStateChanged

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
            java.util.logging.Logger.getLogger(AjouterDroit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouterDroit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouterDroit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouterDroit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AjouterDroit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAffecter;
    private javax.swing.JButton btnAnnuler;
    public static javax.swing.JCheckBox cbAdminOption;
    private javax.swing.JComboBox<String> cbObjet;
    private javax.swing.JCheckBox cbPProc_Manip;
    private javax.swing.JCheckBox cbPProc_Manip1;
    private javax.swing.JLabel cbPProc_Titre;
    private javax.swing.JLabel cbPProc_Titre1;
    private javax.swing.JCheckBox cbPRep_Manip;
    private javax.swing.JCheckBox cbPRep_Manip1;
    private javax.swing.JLabel cbPRep_Titre;
    private javax.swing.JLabel cbPRep_Titre1;
    private javax.swing.JCheckBox cbPSeq_Modify;
    private javax.swing.JCheckBox cbPSeq_Modify1;
    private javax.swing.JCheckBox cbPSeq_Select;
    private javax.swing.JCheckBox cbPSeq_Select1;
    private javax.swing.JLabel cbPSeq_Titre;
    private javax.swing.JLabel cbPSeq_Titre1;
    private javax.swing.JCheckBox cbPTables_Constraint;
    private javax.swing.JCheckBox cbPTables_Constraint1;
    private javax.swing.JCheckBox cbPTables_Delete;
    private javax.swing.JCheckBox cbPTables_Delete1;
    private javax.swing.JCheckBox cbPTables_Index;
    private javax.swing.JCheckBox cbPTables_Index1;
    private javax.swing.JCheckBox cbPTables_Insert;
    private javax.swing.JCheckBox cbPTables_Insert1;
    private javax.swing.JCheckBox cbPTables_Modify;
    private javax.swing.JCheckBox cbPTables_Modify1;
    private javax.swing.JCheckBox cbPTables_Select;
    private javax.swing.JCheckBox cbPTables_Select1;
    private javax.swing.JLabel cbPTables_Titre;
    private javax.swing.JLabel cbPTables_Titre1;
    private javax.swing.JCheckBox cbPTables_Update;
    private javax.swing.JCheckBox cbPTables_Update1;
    private javax.swing.JCheckBox cbPVues_Constraint;
    private javax.swing.JCheckBox cbPVues_Constraint1;
    private javax.swing.JCheckBox cbPVues_Delete;
    private javax.swing.JCheckBox cbPVues_Delete1;
    private javax.swing.JCheckBox cbPVues_Insert;
    private javax.swing.JCheckBox cbPVues_Insert1;
    private javax.swing.JCheckBox cbPVues_Select;
    private javax.swing.JCheckBox cbPVues_Select1;
    private javax.swing.JCheckBox cbPVues_Sous;
    private javax.swing.JCheckBox cbPVues_Sous1;
    private javax.swing.JLabel cbPVues_Titre;
    private javax.swing.JLabel cbPVues_Titre1;
    private javax.swing.JCheckBox cbPVues_Update;
    private javax.swing.JCheckBox cbPVues_Update1;
    private javax.swing.JCheckBox cbPrivProf2_Create;
    private javax.swing.JCheckBox cbPrivProf2_Delete;
    private javax.swing.JCheckBox cbPrivProf2_Modify;
    private javax.swing.JLabel cbPrivProf2_Titre;
    private javax.swing.JCheckBox cbPrivProf_Create;
    private javax.swing.JCheckBox cbPrivProf_Delete;
    private javax.swing.JCheckBox cbPrivProf_Modify;
    private javax.swing.JLabel cbPrivProf_Titre;
    private javax.swing.JCheckBox cbPrivRole_Create;
    private javax.swing.JCheckBox cbPrivRole_ModifyAny;
    private javax.swing.JLabel cbPrivRole_Titre;
    private javax.swing.JCheckBox cbPrivRoles2_Ass;
    private javax.swing.JCheckBox cbPrivRoles2_Ass1;
    private javax.swing.JCheckBox cbPrivRoles2_Create;
    private javax.swing.JCheckBox cbPrivRoles2_Delete;
    private javax.swing.JCheckBox cbPrivRoles2_Delete1;
    private javax.swing.JCheckBox cbPrivRoles2_ModifyAny;
    private javax.swing.JLabel cbPrivRoles2_Titre;
    private javax.swing.JCheckBox cbPrivSess2_Con;
    private javax.swing.JLabel cbPrivSess2_Titre;
    private javax.swing.JCheckBox cbPrivSess_Con;
    private javax.swing.JLabel cbPrivSess_Titre;
    private javax.swing.JCheckBox cbPrivTable_Create;
    private javax.swing.JCheckBox cbPrivTable_CreateAny;
    private javax.swing.JCheckBox cbPrivTable_Delete;
    private javax.swing.JCheckBox cbPrivTable_Drop;
    private javax.swing.JCheckBox cbPrivTable_Insert;
    private javax.swing.JCheckBox cbPrivTable_ModifyAny;
    private javax.swing.JCheckBox cbPrivTable_Select;
    private javax.swing.JLabel cbPrivTable_Titre;
    private javax.swing.JCheckBox cbPrivTable_modif;
    private javax.swing.JCheckBox cbPrivTables2_Create;
    private javax.swing.JCheckBox cbPrivTables2_CreateAny;
    private javax.swing.JCheckBox cbPrivTables2_Delete;
    private javax.swing.JCheckBox cbPrivTables2_Drop;
    private javax.swing.JCheckBox cbPrivTables2_Insert;
    private javax.swing.JCheckBox cbPrivTables2_ModifyAny;
    private javax.swing.JCheckBox cbPrivTables2_Select;
    private javax.swing.JLabel cbPrivTables2_Titre;
    private javax.swing.JCheckBox cbPrivVue_Create;
    private javax.swing.JCheckBox cbPrivVue_CreateAny;
    private javax.swing.JCheckBox cbPrivVue_Delete;
    private javax.swing.JCheckBox cbPrivVue_Sous;
    private javax.swing.JLabel cbPrivVue_Titre;
    private javax.swing.JCheckBox cbPrivVues2_Create;
    private javax.swing.JCheckBox cbPrivVues2_CreateAny;
    private javax.swing.JCheckBox cbPrivVues2_Delete;
    private javax.swing.JCheckBox cbPrivVues2_Sous;
    private javax.swing.JLabel cbPrivVues2_Titre;
    private javax.swing.JComboBox<String> cbTypeDroit;
    private javax.swing.JComboBox<String> cbTypeObjet;
    private javax.swing.JScrollPane lObjet;
    private javax.swing.JList<String> lObjet1;
    private javax.swing.JLabel lbObjet;
    private javax.swing.JLabel lbObjet1;
    private javax.swing.JLabel lbTypeDroit;
    private javax.swing.JLabel lbTypeObjet;
    private javax.swing.JPanel pConteneur;
    private javax.swing.JPanel pDroits;
    private javax.swing.JPanel pDroitsPour;
    private javax.swing.JPanel pPrivObje1;
    private javax.swing.JPanel pPrivObjet;
    private javax.swing.JPanel pPrivProc;
    private javax.swing.JPanel pPrivProc1;
    private javax.swing.JPanel pPrivProf;
    private javax.swing.JPanel pPrivProf2;
    private javax.swing.JPanel pPrivRep;
    private javax.swing.JPanel pPrivRep1;
    private javax.swing.JPanel pPrivRoles;
    private javax.swing.JPanel pPrivRoles2;
    private javax.swing.JPanel pPrivSeq;
    private javax.swing.JPanel pPrivSeq1;
    private javax.swing.JPanel pPrivSess;
    private javax.swing.JPanel pPrivSess2;
    private javax.swing.JPanel pPrivSys;
    private javax.swing.JPanel pPrivSys2;
    private javax.swing.JPanel pPrivTable;
    private javax.swing.JPanel pPrivTables;
    private javax.swing.JPanel pPrivTables1;
    private javax.swing.JPanel pPrivTables2;
    private javax.swing.JPanel pPrivVue;
    private javax.swing.JPanel pPrivVues;
    private javax.swing.JPanel pPrivVues1;
    private javax.swing.JPanel pPrivVues2;
    // End of variables declaration//GEN-END:variables

    public void updatelisttabs() {

        try {

            stmt = null;
            stmt = cn.createStatement();
            rs = stmt.executeQuery("Select TABLE_NAME FROM dba_tables");

            while (rs.next()) {
                cbObjet.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CreerRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateliste() {

        try {
            DefaultListModel listModel1 = new DefaultListModel();
            String table = cbObjet.getSelectedItem().toString();
            stmt = null;
            stmt = cn.createStatement();
            rs = stmt.executeQuery("select COLUMN_NAME from dba_col_comments where table_name = UPPER('" + table + "')");
            while (rs.next()) {
                listModel1.addElement(rs.getString(1));
            }
            lObjet1.setModel(listModel1);
        } catch (Exception e) {
            System.out.println("Erreuuuue : " + e.getMessage());
        }
    }

}
