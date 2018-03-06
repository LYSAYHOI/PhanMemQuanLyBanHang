/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BLL.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minhh
 */
public class ItemsManagement extends javax.swing.JFrame {

    String filename;
    byte[] saveClickImage = new byte[2048];

    public ItemsManagement() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ItemsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemsManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        Load_Form();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Load_Form() {
        this.txtID.setEnabled(false);

        //Pour to jTable
        PourDataItemsOnTable model = new PourDataItemsOnTable((DefaultTableModel) table.getModel());
        table.setModel(model.defaultmodel());
        //Pour to jComboBox
        PourDataOnComboBox combobox = new PourDataOnComboBox("1"); //1 la comboBox NPP
        jComboBoxDis.setModel(combobox.defaultcomboBox());
        PourDataOnComboBox combobox1 = new PourDataOnComboBox("3"); //3 la comboBox LoaiHang
        jComboBoxType.setModel(combobox1.defaultcomboBox());
        //jComboBoxType.setEditable(true); jComboBoxDis.setEditable(true);
        // jComboBoxType.setSelectedItem("");jComboBoxDis.setSelectedItem("");
        // jComboBoxType.setEditable(false); jComboBoxDis.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        buttonGroupSearch = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel(){
            ImageIcon icon = new ImageIcon("src/Presentation/Resources/16.png");
            public void paintComponent(Graphics g){
                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jTextFieldSearch = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtQuanlity = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jComboBoxDis = new javax.swing.JComboBox();
        jComboBoxType = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtPrice1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jRadioItemName = new javax.swing.JRadioButton();
        jRadioID = new javax.swing.JRadioButton();
        jRadioPrice = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jRadioBrand = new javax.swing.JRadioButton();
        jRadioType = new javax.swing.JRadioButton();
        imagebutton = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jlabelImage = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1366, 765));

        table.setAutoCreateRowSorter(true);
        table.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NameItem", "TypeItems", "Manufacturer", "Retail Price", "Import Price", "Quanlity", "Figure", "Image"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class, java.lang.Byte.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        table.setFillsViewportHeight(true);
        table.setFocusCycleRoot(true);
        table.setFocusTraversalPolicyProvider(true);
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setInheritsPopupMenu(true);
        table.setName(""); // NOI18N
        table.setSelectionBackground(new java.awt.Color(204, 204, 255));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ClickTableItem(evt);
            }
        });
        jScrollPane2.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(8).setMinWidth(0);
            table.getColumnModel().getColumn(8).setPreferredWidth(0);
            table.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        jTextFieldSearch.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldSearch.setText("Search");
        jTextFieldSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextFieldSearch.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClickFieldSearch(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        txtID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtPrice.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtQuanlity.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txtArea.setOpaque(false);
        jScrollPane1.setViewportView(txtArea);

        jComboBoxDis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Catalogy");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("NameItem");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Retail Price");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Quanlity");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Distributor");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Specification");

        txtPrice1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Import Price");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxDis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtQuanlity)
                            .addComponent(txtPrice)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1))
                            .addComponent(txtPrice1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxType, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtQuanlity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxDis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(0, 102, 102));
        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 62)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("            Items Management");
        jLabel1.setToolTipText("");

        jRadioItemName.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSearch.add(jRadioItemName);
        jRadioItemName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioItemName.setForeground(new java.awt.Color(255, 255, 255));
        jRadioItemName.setSelected(true);
        jRadioItemName.setText("ItemName");

        jRadioID.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSearch.add(jRadioID);
        jRadioID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioID.setForeground(new java.awt.Color(255, 255, 255));
        jRadioID.setText("ItemID");

        jRadioPrice.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSearch.add(jRadioPrice);
        jRadioPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioPrice.setForeground(new java.awt.Color(255, 255, 255));
        jRadioPrice.setText("Price");

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/ok-mark.png"))); // NOI18N
        jLabel2.setText("SAVE");
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel2MouseMoved(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SaveItems(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 0));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/refreshingưhite.png"))); // NOI18N
        jLabel4.setText("ReLoad");
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel4MouseMoved(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ReLoad(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/icons8-Search-30.png"))); // NOI18N
        jLabel7.setText("Search");
        jLabel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel7MouseMoved(evt);
            }
        });
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel7MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SearchButton(evt);
            }
        });

        jRadioBrand.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSearch.add(jRadioBrand);
        jRadioBrand.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioBrand.setForeground(new java.awt.Color(255, 255, 255));
        jRadioBrand.setText("Distributor");

        jRadioType.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroupSearch.add(jRadioType);
        jRadioType.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jRadioType.setForeground(new java.awt.Color(255, 255, 255));
        jRadioType.setText("Type");

        imagebutton.setBackground(new java.awt.Color(255, 255, 0));
        imagebutton.setForeground(new java.awt.Color(255, 255, 255));
        imagebutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/upanh1.1.png"))); // NOI18N
        imagebutton.setText("IMAGE");
        imagebutton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imagebuttonMouseMoved(evt);
            }
        });
        imagebutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imagebuttonMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImageButton(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/back.png"))); // NOI18N
        jLabel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel3MouseMoved(evt);
            }
        });
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/user.png"))); // NOI18N
        jLabel15.setText("Admin");
        jLabel15.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel15MouseMoved(evt);
            }
        });
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        jlabelImage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlabelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelImage.setText("No Image");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(imagebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioID)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioItemName)
                        .addGap(28, 28, 28)
                        .addComponent(jRadioType, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jRadioBrand))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addComponent(jlabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 783, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jlabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioItemName)
                                    .addComponent(jRadioPrice)
                                    .addComponent(jRadioID)
                                    .addComponent(jRadioBrand)
                                    .addComponent(jRadioType))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagebutton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReLoad(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReLoad
        reload();
        txtID.setText("");
        txtName.setText("");
        txtPrice.setText(""); txtPrice1.setText("");
        txtQuanlity.setText("");
        txtArea.setText("");
        jlabelImage.setIcon(null);
        filename = null;
        saveClickImage = null; //reload valueables contain  filename and saveClickImage
    }//GEN-LAST:event_ReLoad

    private void SaveItems(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveItems
        String IDHang, TenHang, Giabanle, SoLuong, ThongSoKyThuat, IDLoaiHang, IDNPP,gianhap;
        byte[] Image = new byte[2048];
        IDHang = txtID.getText();
        TenHang = txtName.getText();
        if (TenHang.length() == 0) {
            JOptionPane.showMessageDialog(null, "The NULL Name Item is not created ", "ERROR", 1);
            return;
        }
        Giabanle = txtPrice.getText();
        gianhap= txtPrice1.getText();
        if (Giabanle.length() == 0 || gianhap.length()==0 ) {
            JOptionPane.showMessageDialog(null, "Price is not NULL", "ERROR", 1);
            return;
        }
        SoLuong = txtQuanlity.getText();
        if (SoLuong.length() == 0) {
            SoLuong = "0";
        }
        ThongSoKyThuat = txtArea.getText();
        if (ThongSoKyThuat.length() == 0) {
            JOptionPane.showMessageDialog(null, "Write something for item discription", "ERROR", 1);
            return;
        }
        IDLoaiHang = ((ClassComboBox) jComboBoxType.getSelectedItem()).getIDLoaiHang();
        IDNPP = ((ClassComboBox) jComboBoxDis.getSelectedItem()).getIDLoaiHang();

        if (filename != null) { //Case insert with filename
            try {
                Image = ConvertToByte(filename);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "There are some error in save Image", "Error", 2);
            }
        }
        //Case Insert without id
        if (IDHang.length() == 0) {
            InsertNewItems insert = new InsertNewItems(TenHang, ThongSoKyThuat, IDNPP, IDLoaiHang, Giabanle, SoLuong, Image,gianhap);
            int a = insert.CallProcedure_ToInsert();
            if (a != -1) {
                txtID.setText("NUM" + a);
                JOptionPane.showMessageDialog(null, "Successful. ", "Notification", 1);
            }

        } else//Case Update
        {
            if (saveClickImage != null && filename == null) {
                Image = saveClickImage;   //case modify info but no modify image
            }
            ModifyItems modify = new ModifyItems(IDHang, TenHang, ThongSoKyThuat, IDNPP, IDLoaiHang, Giabanle, SoLuong, Image,gianhap);
            if (modify.CallProcedure_ToModify() != -1) {
                JOptionPane.showMessageDialog(null, "Successful. ", "Notification", 1);
            }
        }
        reload();
    }//GEN-LAST:event_SaveItems

    private void ClickTableItem(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClickTableItem
        int row = this.table.getSelectedRow();//lấy dòng hiện tại
        txtID.setText((this.table.getModel().getValueAt(row, 0)).toString());//lấy giá trị
        txtName.setText((this.table.getModel().getValueAt(row, 1)).toString());
        txtPrice.setText((this.table.getModel().getValueAt(row, 4)).toString());
        txtPrice1.setText((this.table.getModel().getValueAt(row, 5)).toString());
        txtQuanlity.setText((this.table.getModel().getValueAt(row, 6)).toString());
        txtArea.setText((this.table.getModel().getValueAt(row, 7)).toString());
        setSelectedValue(jComboBoxType, this.table.getValueAt(row, 2).toString());
        setSelectedValue(jComboBoxDis, this.table.getValueAt(row, 3).toString());
        if (this.table.getModel().getValueAt(row, 8) != null) {
            jlabelImage.setIcon(ResizeIconImage(null, (byte[]) this.table.getModel().getValueAt(row, 8)));
            saveClickImage = (byte[]) this.table.getModel().getValueAt(row, 8);
        } else {
            jlabelImage.setIcon(null);
        }
    }//GEN-LAST:event_ClickTableItem

    private void ImageButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImageButton
        filename = null;

        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "png");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();//Trả lại tập tin được chọn.
        filename = file.getAbsolutePath();
        jlabelImage.setIcon(ResizeIconImage(filename, null));
    }//GEN-LAST:event_ImageButton

    private void ClickFieldSearch(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClickFieldSearch
        jTextFieldSearch.setText("");
    }//GEN-LAST:event_ClickFieldSearch

    private void SearchButton(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButton
        String textsearch, columsearch = "";
        textsearch = jTextFieldSearch.getText();
        if (jRadioID.isSelected() == true) {
            columsearch = "IDHang";
        }
        if (jRadioItemName.isSelected() == true) {
            columsearch = "TenHang";
        }
        if (jRadioType.isSelected() == true) {
            columsearch = "TenLoaiHang";
        }
        if (jRadioPrice.isSelected() == true) {
            columsearch = "Giabanle";
        }
        if (jRadioBrand.isSelected() == true) {
            columsearch = "TenNPP";
        }
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        SearchItems model = new SearchItems((DefaultTableModel) table.getModel(), textsearch, columsearch);
        table.setModel(model.Find());
    }//GEN-LAST:event_SearchButton

    private void jLabel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseMoved
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/refreshingblue_1.png")));
    }//GEN-LAST:event_jLabel4MouseMoved

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/refreshingưhite.png")));
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/ok-mark.png")));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseMoved
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/ok-markss.png")));
    }//GEN-LAST:event_jLabel2MouseMoved

    private void imagebuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagebuttonMouseExited
        imagebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/upanh1.1.png")));
    }//GEN-LAST:event_imagebuttonMouseExited

    private void imagebuttonMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagebuttonMouseMoved
        imagebutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/upanh1_1.png")));
    }//GEN-LAST:event_imagebuttonMouseMoved

    private void jLabel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseExited
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/icons8-Search-30.png")));
    }//GEN-LAST:event_jLabel7MouseExited

    private void jLabel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseMoved
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/search.png")));
    }//GEN-LAST:event_jLabel7MouseMoved

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/back.png")));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseMoved
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/back1.png")));
    }//GEN-LAST:event_jLabel3MouseMoved

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        new AdminHomepage()
                .setInfo(info);
        this.dispose();
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel15MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseMoved
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/user (2).png")));
    }//GEN-LAST:event_jLabel15MouseMoved

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentation/Resources/user.png")));
    }//GEN-LAST:event_jLabel15MouseExited
    //Method to set value event Click for data from table to comboBox
    public static void setSelectedValue(JComboBox comboBox, String TenLoaiHang) {
        ClassComboBox item;
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            item = (ClassComboBox) comboBox.getItemAt(i);
            if (item.getTenLoaiHang().equalsIgnoreCase(TenLoaiHang)) {
                comboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    private byte[] ConvertToByte(String filename) throws FileNotFoundException {
        byte[] bytehinh = null;
        File image = new File(filename);
        FileInputStream fis = new FileInputStream(image); //read image file -> byte
        ByteArrayOutputStream s = new ByteArrayOutputStream();//
        byte[] bytearray = new byte[2048]; //bo nho noi du lieu duoc luu tru
        try {
            for (int readnum; (readnum = fis.read(bytearray)) != -1;) {
                s.write(bytearray, 0, readnum);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khong chuyen byte , kiểm tra lại dữ liệu nhập", "Error", 2);
        }
        bytehinh = s.toByteArray();
        return bytehinh;
    }
    //Hinh (Xu ly anh len label)

    private ImageIcon ResizeIconImage(String Imgpath, byte[] picture) {
        ImageIcon myImage = null;
        if (Imgpath != null) {
            myImage = new ImageIcon(Imgpath);
        } else {
            myImage = new ImageIcon(picture);
        }
        Image img1 = myImage.getImage();
        Image img2 = img1.getScaledInstance(jlabelImage.getWidth(), jlabelImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }

    private void reload() {
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);
        Load_Form();

    }
    private ClassLoginInfo info;

    public void setInfo(ClassLoginInfo info) {
        this.info = info;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroupSearch;
    private javax.swing.JLabel imagebutton;
    private javax.swing.JComboBox jComboBoxDis;
    private javax.swing.JComboBox jComboBoxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioBrand;
    private javax.swing.JRadioButton jRadioID;
    private javax.swing.JRadioButton jRadioItemName;
    private javax.swing.JRadioButton jRadioPrice;
    private javax.swing.JRadioButton jRadioType;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel jlabelImage;
    private javax.swing.JTable table;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPrice1;
    private javax.swing.JTextField txtQuanlity;
    // End of variables declaration//GEN-END:variables
}
