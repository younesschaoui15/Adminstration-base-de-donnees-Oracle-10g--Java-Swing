/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminBD;

import MyClasses.bestLook;
import java.awt.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * A basic JFC based application.
 */
public class DemoTableBDD extends JFrame {

    public DemoTableBDD() {
        bestLook.setBestLookAndFeelAvailable();
        setTitle("Console SQL");
        setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        this.setResizable(false);
        //this.setLocationRelativeTo(null);
        setSize(570, 519);
        //setVisible(false);
        JPanel1.setLayout(new GridBagLayout());
        getContentPane().add("Center", JPanel1);
        JPanel1.setBounds(0, 0, 570, 519);
        JScrollPane1.setOpaque(true);
        JPanel1.add(JScrollPane1, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.BOTH, new Insets(12, 12, 0, 10), 295, 147));
        JScrollPane1.setBounds(12, 44, 548, 184);
        txtSQL.setText("Entrer votre code sql ici ...");
        txtSQL.setSelectionColor(new java.awt.Color(204, 204, 255));
        txtSQL.setSelectedTextColor(java.awt.Color.black);
        txtSQL.setCaretColor(java.awt.Color.black);
        txtSQL.setDisabledTextColor(new java.awt.Color(153, 153, 153));

        JScrollPane1.getViewport().add(txtSQL);
        txtSQL.setBounds(0, 0, 545, 181);
        JScrollPane2.setOpaque(true);
        JPanel1.add(JScrollPane2, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.BOTH, new Insets(8, 12, 19, 10), 95, -192));
        JScrollPane2.setBounds(12, 274, 548, 226);
        JTable1.setSelectionBackground(new java.awt.Color(204, 204, 255));
        JTable1.setSelectionForeground(java.awt.Color.black);
        JTable1.setGridColor(new java.awt.Color(153, 153, 153));
        JScrollPane2.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 545, 223);

        JPanel3.setLayout(new GridLayout(1, 4, 1, 1));
//        JPanel3.setLayout(new FlowLayout());

        JPanel1.add(JPanel3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.NONE, new Insets(10, 12, 0, 0), 184, 3));
        JPanel3.setBounds(12, 238, 543, 28);
        boutonConnection.setText("Connection");
        boutonConnection.setActionCommand("Action 1");
        JPanel3.add(boutonConnection);
        boutonConnection.setBounds(0, 0, 174, 28);
        boutonSQL.setText("Executer SQL");
        boutonSQL.setActionCommand("Action 2");
        JPanel3.add(boutonSQL);
        boutonSQL.setBounds(184, 0, 174, 28);
        boutonInfo.setText("Get Info Table");
        boutonInfo.setActionCommand("Action 3");
        JPanel3.add(boutonInfo);

        boutonInfo.setBounds(368, 0, 174, 28);

        JPanel3.add(boutonExport);
        boutonExport.setText("Export ASCII");

        JPanel4.setLayout(new GridBagLayout());
        JPanel1.add(JPanel4, new GridBagConstraints(0, 0, 2, 1, 1.0, 0.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.HORIZONTAL, new Insets(7, 12, 0, 10), 0, 0));
        JPanel4.setBounds(12, 7, 548, 25);
        txtConnection.setText("Veuillez entrer le nom de la table SVP : ");
        JPanel4.add(txtConnection, new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.NONE, new Insets(0, 1, 0, 0), 60, 4));

        txtTable.setText(" ");
        txtTable.setSelectionColor(new java.awt.Color(204, 204, 255));
        txtTable.setSelectedTextColor(java.awt.Color.black);
        txtTable.setCaretColor(java.awt.Color.black);
        txtTable.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        JPanel4.add(txtTable, new GridBagConstraints(2, 0, 1, 4, 1.0, 1.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.BOTH, new Insets(0, 5, 1, 0), 128, 5));
        txtTable.setBounds(279, 0, 170, 24);

        cmbBoxBDD.setModel(stringComboBoxModel2);
        JPanel4.add(cmbBoxBDD, new GridBagConstraints(3, 0, 1, 2, 0.0, 0.0, java.awt.GridBagConstraints.CENTER, java.awt.GridBagConstraints.NONE, new Insets(2, 4, 0, 5), 15, -4));
        cmbBoxBDD.setBounds(453, 2, 90, 20);

        {
            String[] tempString = new String[1];
            tempString[0] = "Oracle Database";
            stringComboBoxModel2.setItems(tempString);
        }
        cmbBoxBDD.setSelectedIndex(0);

        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
        boutonSQL.addActionListener(lSymAction);
        boutonConnection.addActionListener(lSymAction);
        boutonInfo.addActionListener(lSymAction);
        boutonExport.addActionListener(lSymAction);
        initcolors();
        pack();
    }

    public DemoTableBDD(String sTitle) {
        this();
        setTitle(sTitle);
    }

    void boutonExport_actionPerformed(java.awt.event.ActionEvent event) {

        String table = this.txtTable.getText();
        if (table == null) {
            return;
        }

        java.awt.FileDialog saveFileDialog = new java.awt.FileDialog(this);
        saveFileDialog.setMode(FileDialog.SAVE);
        saveFileDialog.setTitle("Export d'une table");
        String rep = new String(".\\");
        File f = new File(rep);
        f.mkdirs(); // crer le repertoire si necessaire 
        saveFileDialog.setDirectory(f.getPath());
        saveFileDialog.setVisible(true);
        String s = saveFileDialog.getFile();
        String d = saveFileDialog.getDirectory();
        if (s != null) {
            if (s.indexOf(".") < 0) {
                s = s + "txt";
            }
            // ecrire un fichier darchive de filtre avec le filtre courrant les filtre a jour
            //DataUtil.exportFichierAscii( d+s, currentTable, tblChamp.getSelectedRows(), ";" );
            exportLineInAsciiFile(d + s, connection, table, null, ";");
        }
    }

    /**
     * export ds un fichier des lignes d une table d'une bdd la 1ere ligne
     * comportera les noms la 2ime comportera les types si pas de condition
     * where toute la table est exporter si pas de sep le sep par defo est
     * utilisé on ajoute a la fin de la 1ere ligne le sep(et toute les otres
     * ;o))
     */
    public void exportLineInAsciiFile(String nomFichier, Connection connec, String nomTable, String where, String separator) {
        String sql = "";
        try {
            String sep = (separator == null) ? ";" : separator; // par defo on pren ";" comme separator
            BufferedWriter data = new BufferedWriter(new FileWriter(nomFichier));
            Statement stm = connec.createStatement();
            sql = "SELECT * FROM " + nomTable; //
            if (where != null && where.trim().length() > 0) {
                sql += " WHERE " + where;
            }
//System.out.println( " SQL = " + sql );
            ResultSet rs = stm.executeQuery(sql);
            ResultSetMetaData mdt = rs.getMetaData();
            String ligne = "";
            // preparer les 2 irer ligne du fichier export 
            // ki comporteron les nom mdes colonnes et les types des colonnes
            int nbrCols = mdt.getColumnCount();
            // 1ere ligne
            for (int i = 1; i <= nbrCols; i++) {
                ligne += mdt.getColumnName(i) + sep;
            }
            data.write(ligne);
            data.newLine(); //ecri la ligne et passe a la suivante ...
            ligne = "";
            // 2eme ligne
            for (int i = 1; i <= nbrCols; i++) {
                ligne += mdt.getColumnTypeName(i) + sep;
            }
            data.write(ligne);
            data.newLine(); //ecri la ligne et passe a la suivante ...
            ligne = "";
            while (rs.next()) {
                ligne = "";
                for (int i = 1; i <= nbrCols; i++) {
                    ligne += rs.getString(i) + sep;
                }
                data.write(ligne);
                data.newLine(); //ecri la ligne et passe a la suivante ...
            }
            data.close();
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println("Erreur ds saveObject : " + e);
            System.out.println("sql : " + sql);
        }
    }

    JPanel JPanel1 = new JPanel();
    JScrollPane JScrollPane1 = new JScrollPane();
    JTextArea txtSQL = new JTextArea();
    JScrollPane JScrollPane2 = new JScrollPane();
    JTable JTable1 = new JTable();
    JPanel JPanel3 = new JPanel();
    JButton boutonConnection = new JButton();
    JButton boutonSQL = new JButton();
    JButton boutonInfo = new JButton();
    JButton boutonExport = new JButton();
    JPanel JPanel4 = new JPanel();
    JLabel txtConnection = new JLabel();
    JTextField txtTable = new JTextField();
    JComboBox JComboBox1 = new JComboBox();
    JComboBox cmbBoxBDD = new JComboBox();
    StringComboBoxModel stringComboBoxModel1 = new StringComboBoxModel();
    StringComboBoxModel stringComboBoxModel2 = new StringComboBoxModel();

    void exitApplication() {
        try {
            // Beep
            Toolkit.getDefaultToolkit().beep();
            // Show a confirmation dialog
            int reply = JOptionPane.showConfirmDialog(this,
                    "Voulez-vous vraiment quitter?",
                    "Console SQL - Quitter",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            // If the confirmation was affirmative, handle exiting.
            if (reply == JOptionPane.YES_OPTION) {
                this.hide();
            }
        } catch (Exception e) {
        }
    }

    class SymWindow extends java.awt.event.WindowAdapter {

        public void windowClosing(java.awt.event.WindowEvent event) {
            Object object = event.getSource();
            if (object == DemoTableBDD.this) {
                TestBDD_windowClosing(event);
            }
        }
    }

    void TestBDD_windowClosing(java.awt.event.WindowEvent event) {
        TestBDD_windowClosing_Interaction1(event);
    }

    void TestBDD_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
        try {
            if (connection != null) {
                connection.close();
            }
            this.exitApplication();
        } catch (Exception e) {
        }
    }

    class SymAction implements java.awt.event.ActionListener {

        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == boutonSQL) {
                boutonSQL_actionPerformed(event);
            } else if (object == boutonConnection) {
                boutonConnection_actionPerformed(event);
            } else if (object == boutonInfo) {
                boutonInfo_actionPerformed(event);
            } else if (object == boutonExport) {
                boutonExport_actionPerformed(event);
            }
        }
    }

    void boutonSQL_actionPerformed(java.awt.event.ActionEvent event) {
        String sql = "";
        // executer le sql de la fenetre 
        try {
            if (connection == null) {
                return;
            }
            Statement stm = connection.createStatement();
            String query = this.txtSQL.getText().replace('%', '`');

            String queryMaj = query.toUpperCase();
            sql = query;
            // si c une query de type select 
            if ((queryMaj.trim().startsWith("SELECT"))
                    || (queryMaj.trim().startsWith("DESCRIBE"))
                    || (queryMaj.trim().startsWith("SHOW"))) {
                JTable1.removeAll();
                ResultSet rs = stm.executeQuery(sql);
                ResultSetMetaData mdt = rs.getMetaData();
                int num = mdt.getColumnCount();
                DefaultTableModel df = new DefaultTableModel() {   // la ossi c juste pour faire un exemple
                    public boolean isCellEditable(int row, int col) {
                        if ((row >> 1) << 1 == row) {
                            return true;
                        }
                        return false;
                    }
                };
                // preferer addColumn() a linit ds le constructeur car le nom est mieu Fired
                for (int i = 0; i < num; i++) {
                    df.addColumn(mdt.getColumnName(i + 1));
                }
                JTable1.setModel(df);

                TableCellRenderer tbcH = createDemoHeaderRenderer();
                for (int i = 0; i < num; i++) {
                    TableColumn tc = JTable1.getTableHeader().getColumnModel().getColumn(i);
                    //tc.setHeaderValue( mdt.getColumnName( i + 1 ) );
                    //if ( (int)((i+1)/2) == (int)((i)/2) )
                    //if ( (i>>1)<<1 == i )
//                    JTable1.getColumnModel().getColumn()
                    tc.setHeaderRenderer(tbcH);
                    tc.setCellRenderer(new LudoDemoCellRenderer());
                    
                }
                int line = 0;
                while (rs.next()) {
                    Vector v = new Vector(10);
                    for (int col = 0; col < num; col++) {
                        v.addElement(rs.getString(col + 1));
                    }
                    df.addRow(v);
                    line++;
                }
                 JOptionPane.showMessageDialog(null, "SQL est executé correctement");
                System.out.println("\n nombre d enreg lu = " + line);
                rs.close();
            } else // si c une query de type update
            {
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "SQL est exécuté correctement");
                // ici fodrai afficher le conterendu
            }
            stm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "\nError execute sql : " + e);
        }
    }

    Connection connection = null;

    /**
     * effectu la connection a la base choisi
     *
     */
    void boutonConnection_actionPerformed(java.awt.event.ActionEvent event) {
        try {
            String base = this.txtConnection.getText();
//	        if ( base.length() > 0 )
            {
                if (connection != null) {
                    connection.close();
                }

                // connection a une base Oracle par jdbc
                String url = "jdbc:oracle:thin:@localhost:1521:XE"; // evidement cette base n est ppas valide
                Class.forName("oracle.jdbc.driver.OracleDriver");
                connection = DriverManager.getConnection(url, "System", "cy15");

                DatabaseMetaData mdt = connection.getMetaData();
                JOptionPane.showMessageDialog(null, " connectiuon effectuer a  :  " + mdt.getURL());

            }
        } catch (Exception e) {
            System.out.println("Error Connection : " + e);
        }
    }

    /**
     * Affiche les info d une table
     */
    void boutonInfo_actionPerformed(java.awt.event.ActionEvent event) {
        String sql = "";
        try {
            JTable1.removeAll();
            String nomTable = this.txtTable.getText();
            String bddt = cmbBoxBDD.getSelectedItem().toString();
            if (bddt.compareTo("MySQL") == 0) {
                nomTable = "`" + nomTable + "`";
            }

            Statement stm = connection.createStatement();

            sql = "SELECT count(*) FROM " + nomTable;
            ResultSet rs = stm.executeQuery(sql);
            int taille = 0;
            if (rs.next()) {
                taille = rs.getInt(1);
            }
            rs.close();
            //sql = "SHOW COLUMNS FROM " + nomTable;
            sql = "SELECT * FROM " + nomTable;
            rs = stm.executeQuery(sql);
            ResultSetMetaData mdt = rs.getMetaData();

            int num = mdt.getColumnCount();
            StringTokenizer headers = new StringTokenizer("Nom,Type,Type num,Precision,Echelle,Nullable ;o)", ",");
            DefaultTableModel df = new DefaultTableModel(0, headers.countTokens() + 1);
            JTable1.setModel(df);
            TableCellRenderer tbcH = createDemoHeaderRenderer();
            int i = 0;
            while (headers.hasMoreTokens()) {
                TableColumn tc = JTable1.getColumnModel().getColumn(i++);
                tc.setHeaderValue(headers.nextToken());
                tc.setHeaderRenderer(tbcH);
                tc.setCellRenderer(new LudoDemoCellRenderer());
            }
            TableColumn tc = JTable1.getTableHeader().getColumnModel().getColumn(i);
            tc.setHeaderValue("Taille");
            tc.setHeaderRenderer(tbcH);
            // on met pas ce cellrendere pour exemple
//            tc.setCellRenderer( new LudoDemoCellRenderer() );

            String s = "";
            for (int col = 1; col <= num; col++) {
                Vector v = new Vector(10);
                s = mdt.getColumnName(col);
                v.addElement(s);
                s = mdt.getColumnTypeName(col);
                v.addElement(s);
                s = new String("" + mdt.getColumnType(col));
                v.addElement(s);
                s = new String("" + mdt.getPrecision(col));
                v.addElement(s);
                s = new String("" + mdt.getScale(col));
                v.addElement(s);
                s = new String("" + mdt.isNullable(col));
                v.addElement(s);
                s = new String("" + taille);
                v.addElement(s);
                df.addRow(v);
            }

            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println("Error Connection : " + e);
            System.out.println("sql : " + sql);
        }
    }

    Color foreColor = new Color(0, 0, 50);
    Hashtable couleur = new Hashtable(10);

    public void initcolors() {   // c juste pour montrer un exemple de coloriage de header ds le rendere
        couleur.put("Nom", Color.red);
        couleur.put("Type", Color.orange);
        couleur.put("Type num", Color.blue);
        couleur.put("Precision", Color.cyan);
        couleur.put("Echelle", Color.green);
        couleur.put("Nullable ;o)", Color.magenta);
        couleur.put("Taille", Color.pink);
    }

    //Color defoBack = new Color( 220, 220, 220 );
    Color defoBack = new Color(194, 194, 194);

    private TableCellRenderer createDemoHeaderRenderer() {
        DefaultTableCellRenderer label = new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                setText((value == null) ? "" : value.toString());
                if (table != null) {
                    JTableHeader header = table.getTableHeader();
                    if (header != null) {
//	                        String nom = value.toString();
                        Color back = (Color) couleur.get(getText()); // recherche une couleur pour cette colonne
                        setForeground(foreColor);
                        setBackground((back == null) ? defoBack : back);
                        setFont(header.getFont());
                    }
                }
                setBorder(UIManager.getBorder("TableHeader.cellBorder"));
                return this;
            }
        };
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    // desinne une colonne comme un header
    class LudoDemoCellRenderer extends JLabel
            implements TableCellRenderer {

        boolean isBordered = true;
        Color selectedForeground = null;
        Color selectedBackground = null;
        Color unselectedForegroundAlt = null; //Color.magenta;
        Color unselectedBackgroundAlt = new Color(200, 200, 200);
        Color unselectedForeground = null;
        Color unselectedBackground = null;

        public LudoDemoCellRenderer() {
            super();
            setOpaque(true); //pour ke le background soi fai( mai bon sa ser a rien  ;o) ).
        }

        public Component getTableCellRendererComponent(
                JTable table, Object val,
                boolean isSelected, boolean hasFocus,
                int row, int column) {
            //setText( (String)table.getValueAt( row, column ) );
            setAlignmentX(CENTER_ALIGNMENT);

            // sassure du style de la font 
            Font f = getFont();
            if (isSelected) {
                setFont(new Font(f.getName(), Font.PLAIN | Font.ITALIC, f.getSize())); // otement c bold par defo
                // gestion des couleur de selection
                super.setForeground((selectedForeground != null) ? selectedForeground : table.getSelectionForeground());
                super.setBackground((selectedBackground != null) ? selectedBackground : table.getSelectionBackground());
            } else {
                setFont(new Font(f.getName(), Font.PLAIN, f.getSize())); // otement c bold par defo
                if (((column) >> 1) << 1 == column - (row - ((row >> 1) << 1))) {
                    super.setForeground((unselectedForegroundAlt != null) ? unselectedForegroundAlt : table.getForeground());
                    super.setBackground((unselectedBackgroundAlt != null) ? unselectedBackgroundAlt : table.getBackground());
                } else {
                    super.setForeground((unselectedForeground != null) ? unselectedForeground : table.getForeground());
                    super.setBackground((unselectedBackground != null) ? unselectedBackground : table.getBackground());
                }
            }
            setText((String) val);
            return this;
        }
    }

    public class StringComboBoxModel
            extends StringListModel
            implements Serializable,
            ComboBoxModel {

        protected String selectedItem;

        public void setSelectedItem(Object item) {
            selectedItem = (String) item;
            fireContentsChanged(this, -1, -1);
        }

        public Object getSelectedItem() {
            return selectedItem;
        }
    }

    public class StringListModel
            extends AbstractListModel
            implements Serializable {

        protected Vector delegate = new Vector();

        public String[] getItems() {
            return (String[]) toArray();
        }

        public void setItems(String[] items) {
            Vector newDelegate = new Vector(items.length);

            for (int i = 0; i < items.length; i++) {
                newDelegate.addElement(items[i]);
            }

            int oldSize = delegate.size();
            int newSize = items.length;

            delegate = newDelegate;

            if (oldSize > newSize) {
                fireIntervalRemoved(this, newSize, oldSize - 1);
            } else if (oldSize < newSize) {
                fireIntervalAdded(this, oldSize, newSize - 1);
            }

            fireContentsChanged(this, -1, -1);
        }

        public int getSize() {
            return delegate.size();
        }

        public Object getElementAt(int index) {
            return delegate.elementAt(index);
        }

        public void copyInto(Object anArray[]) {
            delegate.copyInto(anArray);
        }

        public void trimToSize() {
            delegate.trimToSize();
        }

        public void ensureCapacity(int minCapacity) {
            delegate.ensureCapacity(minCapacity);
        }

        public void setSize(int newSize) {
            int oldSize = delegate.size();
            delegate.setSize(newSize);
            if (oldSize > newSize) {
                fireIntervalRemoved(this, newSize, oldSize - 1);
            } else if (oldSize < newSize) {
                fireIntervalAdded(this, oldSize, newSize - 1);
            }
        }

        public int capacity() {
            return delegate.capacity();
        }

        public int size() {
            return delegate.size();
        }

        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        public Enumeration elements() {
            return delegate.elements();
        }

        public boolean contains(Object elem) {
            return delegate.contains(elem);
        }

        public int indexOf(Object elem) {
            return delegate.indexOf(elem);
        }

        public int indexOf(Object elem, int index) {
            return delegate.indexOf(elem, index);
        }

        public int lastIndexOf(Object elem) {
            return delegate.lastIndexOf(elem);
        }

        public int lastIndexOf(Object elem, int index) {
            return delegate.lastIndexOf(elem, index);
        }

        public Object elementAt(int index) {
            return delegate.elementAt(index);
        }

        public Object firstElement() {
            return delegate.firstElement();
        }

        public Object lastElement() {
            return delegate.lastElement();
        }

        public void setElementAt(Object obj, int index) {
            delegate.setElementAt(obj, index);
            fireContentsChanged(this, index, index);
        }

        public void removeElementAt(int index) {
            delegate.removeElementAt(index);
            fireIntervalRemoved(this, index, index);
        }

        public void insertElementAt(Object obj, int index) {
            delegate.insertElementAt(obj, index);
            fireIntervalAdded(this, index, index);
        }

        public void addElement(Object obj) {
            int index = delegate.size();
            delegate.addElement(obj);
            fireIntervalAdded(this, index, index);
        }

        public boolean removeElement(Object obj) {
            int index = indexOf(obj);
            boolean rv = delegate.removeElement(obj);
            if (index > 0) {
                fireIntervalRemoved(this, index, index);
            }
            return rv;
        }

        public void removeAllElements() {
            int index1 = delegate.size() - 1;
            delegate.removeAllElements();
            if (index1 >= 0) {
                fireIntervalRemoved(this, 0, index1);
            }
        }

        public String toString() {
            return delegate.toString();
        }

        public Object[] toArray() {
            String[] rv = new String[delegate.size()];
            delegate.copyInto(rv);
            return rv;
        }

        public Object get(int index) {
            return delegate.elementAt(index);
        }

        public Object set(int index, Object element) {
            Object rv = delegate.elementAt(index);
            delegate.setElementAt(element, index);
            fireContentsChanged(this, index, index);
            return rv;
        }

        public void add(int index, Object element) {
            delegate.insertElementAt(element, index);
            fireIntervalAdded(this, index, index);
        }

        public Object remove(int index) {
            Object rv = delegate.elementAt(index);
            delegate.removeElementAt(index);
            fireIntervalRemoved(this, index, index);
            return rv;
        }

        public void clear() {
            int index1 = delegate.size() - 1;
            delegate.removeAllElements();
            if (index1 >= 0) {
                fireIntervalRemoved(this, 0, index1);
            }
        }

        public void removeRange(int fromIndex, int toIndex) {
            for (int i = toIndex; i >= fromIndex; i--) {
                delegate.removeElementAt(i);
            }
            fireIntervalRemoved(this, fromIndex, toIndex);
        }
    }
}
