package AdminBD.Users;

import static AdminBD.Users.CreerUser.listRole;
import MyClasses.ConnectODB;
import MyClasses.bestLook;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public final class CreerRole extends javax.swing.JFrame {

    DefaultListModel listModel = new DefaultListModel();
    String Suit;
    String List[] = new String[100];
    int pos = 0;

    Connection cn = (new ConnectODB("System", "cy15")).getCon();
    Statement stmt;
    ResultSet rs;

    public CreerRole() {
        bestLook.setBestLookAndFeelAvailable();
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        updatelisttabs();
        identif.setEnabled(false);
        remplirComboRole();
//        CacherTout();
//        pPrivTables.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pDescription = new javax.swing.JPanel();
        lObjet = new javax.swing.JScrollPane();
        lColonnes = new javax.swing.JList<String>();
        lbColonnes = new javax.swing.JLabel();
        cbTable = new javax.swing.JComboBox<String>();
        lbTable = new javax.swing.JLabel();
        cbTypePriv = new javax.swing.JComboBox<String>();
        lbTypePriv = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbNomRole = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tfNomRole = new javax.swing.JTextField();
        identif = new javax.swing.JTextField();
        lbNomRole1 = new javax.swing.JLabel();
        cbidentif = new javax.swing.JComboBox();
        lstroles = new javax.swing.JComboBox();
        lbNomRole2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pPrivileges = new javax.swing.JPanel();
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
        cbPVues_Titre = new javax.swing.JLabel();
        cbPVues_Select = new javax.swing.JCheckBox();
        cbPVues_Update = new javax.swing.JCheckBox();
        cbPVues_Insert = new javax.swing.JCheckBox();
        cbPVues_Constraint = new javax.swing.JCheckBox();
        cbPVues_Sous = new javax.swing.JCheckBox();
        cbPVues_Delete = new javax.swing.JCheckBox();
        pPrivSeq = new javax.swing.JPanel();
        cbPSeq_Titre = new javax.swing.JLabel();
        cbPSeq_Select = new javax.swing.JCheckBox();
        cbPSeq_Modify = new javax.swing.JCheckBox();
        pPrivProc = new javax.swing.JPanel();
        cbPProc_Titre = new javax.swing.JLabel();
        cbPProc_Manip = new javax.swing.JCheckBox();
        pPrivRep = new javax.swing.JPanel();
        cbPRep_Titre = new javax.swing.JLabel();
        cbPRep_Manip = new javax.swing.JCheckBox();
        btnAjouter = new javax.swing.JButton();
        pListPriv = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lPrivileges = new javax.swing.JList<String>();
        btnSupp = new javax.swing.JButton();
        btnAffecter = new javax.swing.JButton();
        btnAnnuler = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pDescription.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lColonnes.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Tous" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lColonnes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lColonnesValueChanged(evt);
            }
        });
        lObjet.setViewportView(lColonnes);

        lbColonnes.setText("Colonnes :");

        cbTable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        cbTable.setPreferredSize(new java.awt.Dimension(56, 22));
        cbTable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTableItemStateChanged(evt);
            }
        });
        cbTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTableActionPerformed(evt);
            }
        });

        lbTable.setText("Table :");

        cbTypePriv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Privilèges Tables", "Privilèges Vues", "Privilèges Séquences", "Privilèges Procédures", "Privilèges Répertoires" }));
        cbTypePriv.setPreferredSize(new java.awt.Dimension(56, 22));
        cbTypePriv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTypePrivActionPerformed(evt);
            }
        });

        lbTypePriv.setText("Type privilèges :");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNomRole.setText("Nom du rôle :");

        jButton1.setText("Créer Rôle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lbNomRole1.setText("Identifiant :");

        cbidentif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "sans", "avec" }));
        cbidentif.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbidentifItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbNomRole)
                            .addComponent(lbNomRole1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(identif)
                            .addComponent(tfNomRole)
                            .addComponent(cbidentif, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomRole)
                    .addComponent(lbNomRole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomRole1)
                    .addComponent(cbidentif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(identif, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(6, 6, 6))
        );

        lstroles.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "...." }));
        lstroles.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                lstrolesItemStateChanged(evt);
            }
        });

        lbNomRole2.setText("Liste des Rôles :");

        jButton2.setText("Supprimer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pDescriptionLayout = new javax.swing.GroupLayout(pDescription);
        pDescription.setLayout(pDescriptionLayout);
        pDescriptionLayout.setHorizontalGroup(
            pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDescriptionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDescriptionLayout.createSequentialGroup()
                        .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lstroles, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNomRole2)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pDescriptionLayout.createSequentialGroup()
                                .addComponent(lbColonnes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pDescriptionLayout.createSequentialGroup()
                                .addComponent(lbTable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pDescriptionLayout.createSequentialGroup()
                        .addComponent(lbTypePriv, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTypePriv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pDescriptionLayout.setVerticalGroup(
            pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pDescriptionLayout.createSequentialGroup()
                .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pDescriptionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pDescriptionLayout.createSequentialGroup()
                                .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbTable))
                                .addGap(18, 18, 18)
                                .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbColonnes))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))
                    .addGroup(pDescriptionLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lbNomRole2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lstroles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTypePriv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTypePriv)))
        );

        pPrivileges.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilèges", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        pPrivileges.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(cbPTables_Select)
                                .addGap(18, 18, 18)
                                .addComponent(cbPTables_Modify))
                            .addComponent(cbPTables_Update)))
                    .addGroup(pPrivTablesLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(cbPTables_Titre)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pPrivTablesLayout.setVerticalGroup(
            pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivTablesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPTables_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Select)
                    .addComponent(cbPTables_Modify))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Insert)
                    .addComponent(cbPTables_Delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pPrivTablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPTables_Index)
                    .addComponent(cbPTables_Constraint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbPTables_Update)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pPrivileges.add(pPrivTables, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 241, 138));

        pPrivVues.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        pPrivVues.setPreferredSize(new java.awt.Dimension(318, 111));

        cbPVues_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPVues_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPVues_Titre.setText("Privilèges Vues");

        cbPVues_Select.setText("Sélectionner");
        cbPVues_Select.setToolTipText("SELECT");

        cbPVues_Update.setText("Mise à jour");
        cbPVues_Update.setToolTipText("UPDATE");

        cbPVues_Insert.setText("Insérer ligne");
        cbPVues_Insert.setToolTipText("UPDATE");

        cbPVues_Constraint.setText("Créer contrainte");

        cbPVues_Sous.setText("Créer sous-vue");
        cbPVues_Sous.setToolTipText("UPDATE");

        cbPVues_Delete.setText("Supprimer");
        cbPVues_Delete.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivVuesLayout = new javax.swing.GroupLayout(pPrivVues);
        pPrivVues.setLayout(pPrivVuesLayout);
        pPrivVuesLayout.setHorizontalGroup(
            pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVuesLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(cbPVues_Titre)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(pPrivVuesLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPVues_Select)
                    .addComponent(cbPVues_Sous)
                    .addComponent(cbPVues_Constraint))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPVues_Delete)
                    .addComponent(cbPVues_Insert)
                    .addComponent(cbPVues_Update))
                .addGap(14, 14, 14))
        );
        pPrivVuesLayout.setVerticalGroup(
            pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivVuesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbPVues_Titre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Select)
                    .addComponent(cbPVues_Update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Insert)
                    .addComponent(cbPVues_Sous))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPrivVuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPVues_Constraint)
                    .addComponent(cbPVues_Delete))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pPrivileges.add(pPrivVues, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 241, 132));

        pPrivSeq.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        pPrivSeq.setPreferredSize(new java.awt.Dimension(318, 111));

        cbPSeq_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPSeq_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPSeq_Titre.setText("Privilèges Séquences");

        cbPSeq_Select.setText("Sélectionner");
        cbPSeq_Select.setToolTipText("SELECT");

        cbPSeq_Modify.setText("Modifier définition");
        cbPSeq_Modify.setToolTipText("UPDATE");

        javax.swing.GroupLayout pPrivSeqLayout = new javax.swing.GroupLayout(pPrivSeq);
        pPrivSeq.setLayout(pPrivSeqLayout);
        pPrivSeqLayout.setHorizontalGroup(
            pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeqLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(cbPSeq_Titre)
                .addGap(53, 53, 53))
            .addGroup(pPrivSeqLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPSeq_Modify)
                    .addComponent(cbPSeq_Select))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pPrivSeqLayout.setVerticalGroup(
            pPrivSeqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivSeqLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbPSeq_Titre)
                .addGap(18, 18, 18)
                .addComponent(cbPSeq_Select)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbPSeq_Modify)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pPrivileges.add(pPrivSeq, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 241, 134));

        pPrivProc.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        pPrivProc.setPreferredSize(new java.awt.Dimension(318, 111));

        cbPProc_Titre.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cbPProc_Titre.setForeground(new java.awt.Color(0, 51, 255));
        cbPProc_Titre.setText("Privilèges Procédures");

        cbPProc_Manip.setText("Manipuler procédure");
        cbPProc_Manip.setToolTipText("SELECT");

        javax.swing.GroupLayout pPrivProcLayout = new javax.swing.GroupLayout(pPrivProc);
        pPrivProc.setLayout(pPrivProcLayout);
        pPrivProcLayout.setHorizontalGroup(
            pPrivProcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProcLayout.createSequentialGroup()
                .addGroup(pPrivProcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivProcLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cbPProc_Titre))
                    .addGroup(pPrivProcLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(cbPProc_Manip)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pPrivProcLayout.setVerticalGroup(
            pPrivProcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivProcLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbPProc_Titre)
                .addGap(18, 18, 18)
                .addComponent(cbPProc_Manip)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pPrivileges.add(pPrivProc, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 241, 132));

        pPrivRep.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        pPrivRep.setPreferredSize(new java.awt.Dimension(318, 111));

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
                .addGroup(pPrivRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPrivRepLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(cbPRep_Titre))
                    .addGroup(pPrivRepLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(cbPRep_Manip)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        pPrivRepLayout.setVerticalGroup(
            pPrivRepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPrivRepLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cbPRep_Titre)
                .addGap(26, 26, 26)
                .addComponent(cbPRep_Manip)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pPrivileges.add(pPrivRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 28, 241, 136));

        btnAjouter.setText("Ajouter");
        btnAjouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterActionPerformed(evt);
            }
        });
        pPrivileges.add(btnAjouter, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 177, 78, 25));

        pListPriv.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Privilèges du rôle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        lPrivileges.setModel(listModel);
        lPrivileges.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lPrivilegesMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(lPrivileges);

        btnSupp.setText("Supprimer");
        btnSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pListPrivLayout = new javax.swing.GroupLayout(pListPriv);
        pListPriv.setLayout(pListPrivLayout);
        pListPrivLayout.setHorizontalGroup(
            pListPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListPrivLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(pListPrivLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(btnSupp)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pListPrivLayout.setVerticalGroup(
            pListPrivLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pListPrivLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupp, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnAffecter.setText("Affecter");
        btnAffecter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAffecterActionPerformed(evt);
            }
        });

        btnAnnuler.setText("Annuler");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pPrivileges, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pListPriv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pPrivileges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pListPriv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAffecter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void CacherTout() {
        pPrivTables.setVisible(false);
        pPrivVues.setVisible(false);
        pPrivSeq.setVisible(false);
        pPrivProc.setVisible(false);
        pPrivRep.setVisible(false);
    }

    public void NettoyerSelection() {
        cbPTables_Select.setSelected(false);
        cbPTables_Modify.setSelected(false);
        cbPTables_Update.setSelected(false);
        cbPTables_Insert.setSelected(false);
        cbPTables_Delete.setSelected(false);
        cbPTables_Index.setSelected(false);
        cbPTables_Constraint.setSelected(false);
        cbPVues_Select.setSelected(false);
        cbPVues_Update.setSelected(false);
        cbPVues_Insert.setSelected(false);
        cbPVues_Delete.setSelected(false);
        cbPVues_Sous.setSelected(false);
        cbPVues_Constraint.setSelected(false);
        cbPSeq_Select.setSelected(false);
        cbPSeq_Modify.setSelected(false);
        cbPProc_Manip.setSelected(false);
        cbPRep_Manip.setSelected(false);

    }

    private void cbTypePrivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTypePrivActionPerformed
        CacherTout();
        NettoyerSelection();

        if (cbTypePriv.getSelectedItem() == "Privilèges Tables") {
            pPrivTables.setVisible(true);
        } else if (cbTypePriv.getSelectedItem() == "Privilèges Vues") {
            pPrivVues.setVisible(true);
        } else if (cbTypePriv.getSelectedItem() == "Privilèges Séquences") {
            pPrivSeq.setVisible(true);
        } else if (cbTypePriv.getSelectedItem() == "Privilèges Procédures") {
            pPrivProc.setVisible(true);
        } else if (cbTypePriv.getSelectedItem() == "Privilèges Répertoires") {
            pPrivRep.setVisible(true);
        }

    }//GEN-LAST:event_cbTypePrivActionPerformed

    private void cbTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTableActionPerformed
        lColonnes.clearSelection();
    }//GEN-LAST:event_cbTableActionPerformed

    private void lColonnesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lColonnesValueChanged
//        if (lColonnes.getSelectedIndex() == 0) {
//            int N = lColonnes.getWidth();
//            lColonnes.setSelectionInterval(0, N);
//        }
//        lColonnes.setToolTipText(lColonnes.getSelectedValue());
    }//GEN-LAST:event_lColonnesValueChanged

    private void btnAffecterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAffecterActionPerformed
        try {
            DefaultListModel hhh = new DefaultListModel();
            String role = tfNomRole.getText();
            System.out.println(role);
            if (role.equals("")) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer le nom du role SVP");
            } else {
                hhh.addElement(role);
                listRole.setModel(hhh);
                this.hide();
            }
        } catch (Exception e) {
            System.out.println("Erreuur : " + e.getMessage());
        }
    }//GEN-LAST:event_btnAffecterActionPerformed

    private void btnAjouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterActionPerformed
        try {
            Suit = cbTable.getSelectedItem().toString();
            String nom = lstroles.getSelectedItem().toString();
            if (lstroles.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir un role dans la liste SVP");
            } else {
                if (cbTable.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Sélectionnez une table SVP!!");
                } else {

                    if (cbPTables_Select.isSelected()) {
                        listModel.addElement("- Interrogation de la table : " + Suit);
                        List[pos] = "GRANT SELECT  ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPTables_Modify.isSelected()) {
                        listModel.addElement("- Modification la définition de la table : " + Suit);
                        List[pos] = "GRANT ALTER ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPTables_Update.isSelected()) {
                        if (lColonnes.getSelectedIndex() >= 0) {
                            ArrayList<String> list = new ArrayList<String>();
                            list = (ArrayList<String>) lColonnes.getSelectedValuesList();
                            for (String s : list) {
                                System.out.println(s);
                            }
                            int nbCaseArray = list.size();
                            String rqt = null;
                            rqt = "GRANT UPDATE  ON " + Suit + " TO " + nom;
                            switch (nbCaseArray) {
                                case 1:
                                    rqt = "GRANT UPDATE (" + list.get(0) + ") ON " + Suit + " TO " + nom;
                                case 2:
                                    rqt = "GRANT UPDATE (" + list.get(0) + "," + list.get(1) + ") ON " + Suit + " TO " + nom;
                            }
                            listModel.addElement("- Mise à jour de la table : " + Suit);
                            List[pos] = rqt;
                            System.out.println(List[pos]);
                            stmt = null;
                            stmt = cn.createStatement();
                            stmt.executeUpdate(List[pos]);
                            pos++;
                        } else {
                            listModel.addElement("- Mise à jour de la table : " + Suit);
                            List[pos] = "GRANT UPDATE  ON " + Suit + " TO " + nom;
                            System.out.println(List[pos]);
                            stmt = null;
                            stmt = cn.createStatement();
                            stmt.executeUpdate(List[pos]);
                            pos++;
                        }
                    }
                    if (cbPTables_Insert.isSelected()) {
                        listModel.addElement("- Insertion des lignes dans la table : " + Suit);
                        List[pos] = "GRANT INSERT ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPTables_Delete.isSelected()) {
                        listModel.addElement("- Suppression des lignes de la table : " + Suit);
                        List[pos] = "GRANT DELETE ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPTables_Index.isSelected()) {
                        listModel.addElement("- Création un index sur la table : " + Suit);
                        List[pos] = "GRANT INDEX ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPTables_Constraint.isSelected()) {
                        listModel.addElement("- Création une constrainte sur la table : " + Suit);
                        List[pos] = "GRANT REFERENCES ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                    if (cbPVues_Select.isSelected()) {
                        listModel.addElement("- Interrogation de la vue : " + Suit);
                        List[pos] = "GRANT SELECT ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                    if (cbPVues_Update.isSelected()) {
                        if (lColonnes.getSelectedIndex() >= 0) {
                            ArrayList<String> list = new ArrayList<String>();
                            list = (ArrayList<String>) lColonnes.getSelectedValuesList();
                            for (String s : list) {
                                System.out.println(s);
                            }
                            int nbCaseArray = list.size();
                            String rqt = null;
                            rqt = "GRANT UPDATE  ON " + Suit + " TO " + nom;
                            switch (nbCaseArray) {
                                case 1:
                                    rqt = "GRANT UPDATE (" + list.get(0) + ") ON " + Suit + " TO " + nom;
                                case 2:
                                    rqt = "GRANT UPDATE (" + list.get(0) + "," + list.get(1) + ") ON " + Suit + " TO " + nom;
                            }
                            listModel.addElement("- Mise à jour de la vue : " + Suit);
                            List[pos] = rqt;
                            System.out.println(List[pos]);
                            stmt = null;
                            stmt = cn.createStatement();
                            stmt.executeUpdate(List[pos]);
                            pos++;
                        } else {
                            listModel.addElement("- Mise à jour de la vue : " + Suit);
                            List[pos] = "GRANT UPDATE  ON " + Suit + " TO " + nom;
                            System.out.println(List[pos]);
                            stmt = null;
                            stmt = cn.createStatement();
                            stmt.executeUpdate(List[pos]);
                            pos++;
                        }
                    }

                    if (cbPVues_Insert.isSelected()) {
                        listModel.addElement("- Insertion des lignes dans la vue : " + Suit);
                        List[pos] = "GRANT INSERT ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPVues_Delete.isSelected()) {
                        listModel.addElement("- Suppression des lignes de la vue : " + Suit);
                        List[pos] = "GRANT DELETE ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPVues_Sous.isSelected()) {
                        listModel.addElement("- Création une sous-vue de la vue : " + Suit);
                        List[pos] = "GRANT UNDER ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPVues_Constraint.isSelected()) {
                        listModel.addElement("- Création une contrainte sur la vue : " + Suit);
                        List[pos] = "GRANT REFERENCES ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                    if (cbPSeq_Select.isSelected()) {
                        listModel.addElement("- Interrogation de la séquence : " + Suit);
                        List[pos] = "GRANT SELECT ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }
                    if (cbPSeq_Modify.isSelected()) {
                        listModel.addElement("- Modification de la définition de la séquence : " + Suit);
                        List[pos] = "GRANT ALTER ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                    if (cbPProc_Manip.isSelected()) {
                        listModel.addElement("- Compilation, exécution d'une procédure, d'une fonction ou d'un package");
                        List[pos] = "GRANT EXECUTE ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                    if (cbPRep_Manip.isSelected()) {
                        listModel.addElement("- Utilisation d'un objet et de ses méthodes");
                        List[pos] = "GRANT EXECUTE ON " + Suit + " TO " + nom;
                        System.out.println(List[pos]);
                        stmt = null;
                        stmt = cn.createStatement();
                        stmt.executeUpdate(List[pos]);
                        pos++;
                    }

                }
            }
        } catch (Exception e) {
            System.out.println("Erreuur : " + e.getMessage());
        }
    }//GEN-LAST:event_btnAjouterActionPerformed

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed
        String S = null;

        S = lPrivileges.getSelectedValue();

        listModel.removeElement(S);
    }//GEN-LAST:event_btnSuppActionPerformed

    private void lPrivilegesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lPrivilegesMouseReleased
        lPrivileges.setToolTipText(lPrivileges.getSelectedValue());
    }//GEN-LAST:event_lPrivilegesMouseReleased

    private void cbTableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTableItemStateChanged
        updateliste();
    }//GEN-LAST:event_cbTableItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String nom = tfNomRole.getText();
            String ident = identif.getText();
            stmt = null;
            stmt = cn.createStatement();
            if (nom.equals("")) {
                JOptionPane.showMessageDialog(null, "Veuillez entre le nom du role SVP");
            } else {
                if (cbidentif.getSelectedIndex() == 0) {
                    stmt.executeUpdate("CREATE ROLE " + nom + " NOT IDENTIFIED");
                    JOptionPane.showMessageDialog(null, "le role " + nom + " est crée");
                    remplirComboRole();
                }
                if (cbidentif.getSelectedIndex() == 1) {
                    stmt.executeUpdate("CREATE ROLE " + nom + " IDENTIFIED BY " + ident);
                    JOptionPane.showMessageDialog(null, "le role " + nom + " est crée");
                    remplirComboRole();
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbidentifItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbidentifItemStateChanged
        if (cbidentif.getSelectedIndex() == 0) {
            identif.setEnabled(false);
        }
        if (cbidentif.getSelectedIndex() == 1) {
            identif.setEnabled(true);
        }
    }//GEN-LAST:event_cbidentifItemStateChanged

    private void lstrolesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_lstrolesItemStateChanged
        if (lstroles.getSelectedIndex() == 0) {
            tfNomRole.setText("");
        } else {
            tfNomRole.setText(lstroles.getSelectedItem().toString());
        }
    }//GEN-LAST:event_lstrolesItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String nom = lstroles.getSelectedItem().toString();
            stmt = null;
            stmt = cn.createStatement();
            if (lstroles.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Veuillez choisir un Rôle pour le supprimer");
            } else {
                stmt.executeUpdate("DROP ROLE " + nom);
                JOptionPane.showMessageDialog(null, "le role " + nom + " à été supprimer");
                remplirComboRole();

            }
        } catch (Exception e) {
            System.out.println("Erreuur : " + e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreerRole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAffecter;
    private javax.swing.JButton btnAjouter;
    private javax.swing.JButton btnAnnuler;
    private javax.swing.JButton btnSupp;
    private javax.swing.JCheckBox cbPProc_Manip;
    private javax.swing.JLabel cbPProc_Titre;
    private javax.swing.JCheckBox cbPRep_Manip;
    private javax.swing.JLabel cbPRep_Titre;
    private javax.swing.JCheckBox cbPSeq_Modify;
    private javax.swing.JCheckBox cbPSeq_Select;
    private javax.swing.JLabel cbPSeq_Titre;
    private javax.swing.JCheckBox cbPTables_Constraint;
    private javax.swing.JCheckBox cbPTables_Delete;
    private javax.swing.JCheckBox cbPTables_Index;
    private javax.swing.JCheckBox cbPTables_Insert;
    private javax.swing.JCheckBox cbPTables_Modify;
    private javax.swing.JCheckBox cbPTables_Select;
    private javax.swing.JLabel cbPTables_Titre;
    private javax.swing.JCheckBox cbPTables_Update;
    private javax.swing.JCheckBox cbPVues_Constraint;
    private javax.swing.JCheckBox cbPVues_Delete;
    private javax.swing.JCheckBox cbPVues_Insert;
    private javax.swing.JCheckBox cbPVues_Select;
    private javax.swing.JCheckBox cbPVues_Sous;
    private javax.swing.JLabel cbPVues_Titre;
    private javax.swing.JCheckBox cbPVues_Update;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JComboBox<String> cbTypePriv;
    private javax.swing.JComboBox cbidentif;
    private javax.swing.JTextField identif;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lColonnes;
    private javax.swing.JScrollPane lObjet;
    private javax.swing.JList<String> lPrivileges;
    private javax.swing.JLabel lbColonnes;
    private javax.swing.JLabel lbNomRole;
    private javax.swing.JLabel lbNomRole1;
    private javax.swing.JLabel lbNomRole2;
    private javax.swing.JLabel lbTable;
    private javax.swing.JLabel lbTypePriv;
    private javax.swing.JComboBox lstroles;
    private javax.swing.JPanel pDescription;
    private javax.swing.JPanel pListPriv;
    private javax.swing.JPanel pPrivProc;
    private javax.swing.JPanel pPrivRep;
    private javax.swing.JPanel pPrivSeq;
    private javax.swing.JPanel pPrivTables;
    private javax.swing.JPanel pPrivVues;
    private javax.swing.JPanel pPrivileges;
    private javax.swing.JTextField tfNomRole;
    // End of variables declaration//GEN-END:variables

    public void updatelisttabs() {

        try {

            stmt = null;
            stmt = cn.createStatement();
            rs = stmt.executeQuery("Select TABLE_NAME FROM dba_tables");

            while (rs.next()) {
                cbTable.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CreerRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateliste() {

        try {
            DefaultListModel listModel1 = new DefaultListModel();
            String table = cbTable.getSelectedItem().toString();
            stmt = null;
            stmt = cn.createStatement();
            rs = stmt.executeQuery("select COLUMN_NAME from dba_col_comments where table_name = UPPER('" + table + "')");
            while (rs.next()) {
                listModel1.addElement(rs.getString(1));
            }
            lColonnes.setModel(listModel1);
        } catch (Exception e) {
            System.out.println("Erreuuuue : " + e.getMessage());
        }
    }

    public void remplirComboRole() {

        try {
            stmt = null;
            stmt = cn.createStatement();
            rs = stmt.executeQuery("select * from dba_roles");

            while (rs.next()) {
                lstroles.addItem(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CreerRole.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
