/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar2;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author 1102486t
 */
public class SettingsDialog extends javax.swing.JDialog {

    /**
     * Creates new form SettingsDialog
     */
    public SettingsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        HighColor.setBackground(MainFrame.highBusynessColor);
        MediumColor.setBackground(MainFrame.mediumBusynessColor);
        LowColor.setBackground(MainFrame.lowBusynessColor);
        EmptyColor.setBackground(MainFrame.emptyBusynessColor);
        
        
        HighColorPicker.setSelectedIndex(getIndexFromColour(HighColor.getBackground()));
        MediumColorPicker.setSelectedIndex(getIndexFromColour(MediumColor.getBackground()));
        LowColorPicker.setSelectedIndex(getIndexFromColour(LowColor.getBackground()));
        EmptyColorPicker.setSelectedIndex(getIndexFromColour(EmptyColor.getBackground()));
        
        HighCountText.setText(Integer.toString(MainFrame.highBusynessCount));
        MediumCountText.setText(Integer.toString(MainFrame.mediumBusynessCount));
        LowCountText.setText(Integer.toString(MainFrame.lowBusynessCount));
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DefaultViewComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        SaveSettingsButton = new javax.swing.JButton();
        CancelSettingsButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        HighCountText = new javax.swing.JTextField();
        MediumCountText = new javax.swing.JTextField();
        LowCountText = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        HighColorPicker = new javax.swing.JComboBox();
        HighColor = new javax.swing.JTextField();
        MediumColor = new javax.swing.JTextField();
        LowColor = new javax.swing.JTextField();
        EmptyColor = new javax.swing.JTextField();
        MediumColorPicker = new javax.swing.JComboBox();
        LowColorPicker = new javax.swing.JComboBox();
        EmptyColorPicker = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(40, 0));
        setMinimumSize(new java.awt.Dimension(40, 0));

        DefaultViewComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Day", "Week", "Month", "Year", "ToDo" }));
        DefaultViewComboBox.setSelectedIndex(MainFrame.DefaultView);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Default View");

        SaveSettingsButton.setText("Save");
        SaveSettingsButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SaveSettingsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SaveSettingsButtonMouseClicked(evt);
            }
        });

        CancelSettingsButton1.setText("Cancel");
        CancelSettingsButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CancelSettingsButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelSettingsButton1MouseClicked(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Busyness Colours");

        HighCountText.setText("10");

        MediumCountText.setText("5");

        LowCountText.setText("1");

        jTextField4.setEditable(false);
        jTextField4.setText("0");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("(>=");
        jLabel3.setMaximumSize(new java.awt.Dimension(40, 0));
        jLabel3.setMinimumSize(new java.awt.Dimension(40, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("(>=");
        jLabel4.setMaximumSize(new java.awt.Dimension(40, 0));
        jLabel4.setMinimumSize(new java.awt.Dimension(40, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("(==");
        jLabel6.setMaximumSize(new java.awt.Dimension(40, 0));
        jLabel6.setMinimumSize(new java.awt.Dimension(40, 0));

        jLabel7.setText(")");

        jLabel8.setText(")");

        jLabel9.setText(")");

        jLabel10.setText(")");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("(>=");
        jLabel11.setMaximumSize(new java.awt.Dimension(40, 0));
        jLabel11.setMinimumSize(new java.awt.Dimension(40, 0));

        jLabel5.setText("High");

        jLabel12.setText("Medium");

        jLabel13.setText("Low");

        jLabel14.setText("Empty");

        HighColorPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" }));
        HighColorPicker.setSelectedIndex(getIndexFromColour(HighColor.getBackground()));
        HighColorPicker.setSelectedItem(getStringFromColour(HighColor.getBackground()));
        HighColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighColorPickerActionPerformed(evt);
            }
        });

        HighColor.setEditable(false);
        HighColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighColorActionPerformed(evt);
            }
        });

        MediumColor.setEditable(false);
        MediumColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumColorActionPerformed(evt);
            }
        });

        LowColor.setEditable(false);

        EmptyColor.setEditable(false);

        MediumColorPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" }));
        MediumColorPicker.setSelectedIndex(getIndexFromColour(MediumColor.getBackground()));
        MediumColorPicker.setSelectedItem(getStringFromColour(MediumColor.getBackground()));
        MediumColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumColorPickerActionPerformed(evt);
            }
        });

        LowColorPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" }));
        LowColorPicker.setSelectedIndex(getIndexFromColour(LowColor.getBackground()));
        LowColorPicker.setSelectedItem(getStringFromColour(LowColor.getBackground()));
        LowColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LowColorPickerActionPerformed(evt);
            }
        });

        EmptyColorPicker.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blue", "Cyan", "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" }));
        EmptyColorPicker.setSelectedIndex(getIndexFromColour(EmptyColor.getBackground()));
        EmptyColorPicker.setSelectedItem(getStringFromColour(EmptyColor.getBackground()));
        EmptyColorPicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmptyColorPickerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SaveSettingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CancelSettingsButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(MediumCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(MediumColor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(MediumColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(LowCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18)
                                                .addComponent(LowColor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(EmptyColor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(HighCountText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(HighColor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(HighColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(LowColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(EmptyColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(DefaultViewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {DefaultViewComboBox, jLabel1});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {HighCountText, LowCountText, MediumCountText, jTextField4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DefaultViewComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(3, 3, 3)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(HighCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(HighColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HighColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MediumCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12)
                    .addComponent(MediumColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MediumColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LowCountText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(LowColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LowColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(EmptyColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EmptyColorPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveSettingsButton)
                    .addComponent(CancelSettingsButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveSettingsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SaveSettingsButtonMouseClicked
        switch (DefaultViewComboBox.getSelectedIndex()) {
            case 0:
                MainFrame.DefaultView = 0;
                
                break;
            case 1:
                MainFrame.DefaultView = 1;
                
                break;
            case 2:
                MainFrame.DefaultView = 2;
                
                break;
            case 3:
                MainFrame.DefaultView = 3;
                
                break;
            case 4:
                MainFrame.DefaultView = 4;
                
                break;
            default:
                break;
        }
        
        MainFrame.lowBusynessCount = Integer.parseInt(LowCountText.getText());
        MainFrame.mediumBusynessCount = Integer.parseInt(MediumCountText.getText());
        MainFrame.highBusynessCount = Integer.parseInt(HighCountText.getText());
        
        MainFrame.lowBusynessColor = LowColor.getBackground();
        MainFrame.mediumBusynessColor = MediumColor.getBackground();
        MainFrame.highBusynessColor = HighColor.getBackground();
        MainFrame.emptyBusynessColor = EmptyColor.getBackground();
        
        
        MainFrame.saveSettings();
        try {
            this.dispose();
        } catch (Throwable ex) {
            Logger.getLogger(SettingsDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveSettingsButtonMouseClicked

    private void CancelSettingsButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelSettingsButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_CancelSettingsButton1MouseClicked

    private void EmptyColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmptyColorPickerActionPerformed
        EmptyColor.setBackground(getColorFromIndex(EmptyColorPicker.getSelectedIndex()));
    }//GEN-LAST:event_EmptyColorPickerActionPerformed

    private void HighColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighColorPickerActionPerformed
        HighColor.setBackground(getColorFromIndex(HighColorPicker.getSelectedIndex()));
    }//GEN-LAST:event_HighColorPickerActionPerformed

    private void MediumColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumColorPickerActionPerformed
        MediumColor.setBackground(getColorFromIndex(MediumColorPicker.getSelectedIndex()));
    }//GEN-LAST:event_MediumColorPickerActionPerformed

    private void LowColorPickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LowColorPickerActionPerformed
        LowColor.setBackground(getColorFromIndex(LowColorPicker.getSelectedIndex()));
    }//GEN-LAST:event_LowColorPickerActionPerformed

    private void HighColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HighColorActionPerformed

    private void MediumColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MediumColorActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void run() {
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
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SettingsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SettingsDialog dialog = new SettingsDialog(new javax.swing.JFrame(), true);
                MainFrame.SettingsDialog = dialog;
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        try {
                            this.finalize();
                        } catch (Throwable ex) {
                            Logger.getLogger(SettingsDialog.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    public static int getIndexFromColour(Color c) {

        if (c.equals(Color.BLUE)) {
            return 0;
        }

        if (c.equals(Color.CYAN)) {
            return 1;
        }
        if (c.equals(Color.DARK_GRAY)) {
            return 2;
        }
        if (c.equals(Color.GRAY)) {
            return 3;
        }
        if (c.equals(Color.GREEN)) {
            return 4;
        }
        if (c.equals(Color.LIGHT_GRAY)) {
            return 5;
        }
        if (c.equals(Color.MAGENTA)) {
            return 6;
        }
        if (c.equals(Color.ORANGE)) {
            return 7;
        }
        if (c.equals(Color.PINK)) {
            return 8;
        }
        if (c.equals(Color.RED)) {
            return 9;
        }
        if (c.equals(Color.WHITE)) {
            return 10;
        }
        if (c.equals(Color.YELLOW)) {
            return 11;
        }
        return 10;
    }

    private static String getStringFromColour(Color c) {

        if (c.equals(Color.BLUE)) {
            return "Blue";
        }

        if (c.equals(Color.CYAN)) {
            return "Cyan";
        }
        if (c.equals(Color.DARK_GRAY)) {
            return "Dark_Gray";
        }
        if (c.equals(Color.GRAY)) {
            return "Gray";
        }
        if (c.equals(Color.GREEN)) {
            return "Green";
        }
        if (c.equals(Color.LIGHT_GRAY)) {
            return "Light_Gray";
        }
        if (c.equals(Color.MAGENTA)) {
            return "Magenta";
        }
        if (c.equals(Color.ORANGE)) {
            return "Orange";
        }
        if (c.equals(Color.PINK)) {
            return "Pink";
        }
        if (c.equals(Color.RED)) {
            return "Red";
        }
        if (c.equals(Color.WHITE)) {
            return "White";
        }
        if (c.equals(Color.YELLOW)) {
            return "Yellow";
        }
        return "White";
    }

    public static Color getColorFromIndex(int i) {
        switch (i) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.CYAN;
            case 2:
                return Color.DARK_GRAY;
            case 3:
                return Color.GRAY;
            case 4:
                return Color.GREEN;
            case 5:
                return Color.LIGHT_GRAY;
            case 6:
                return Color.MAGENTA;
            case 7:
                return Color.ORANGE;
            case 8:
                return Color.PINK;
            case 9:
                return Color.RED;
            case 10:
                return Color.WHITE;
            case 11:
                return Color.YELLOW;
            default:
                return Color.WHITE;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelSettingsButton1;
    private javax.swing.JComboBox DefaultViewComboBox;
    private javax.swing.JTextField EmptyColor;
    private javax.swing.JComboBox EmptyColorPicker;
    private javax.swing.JTextField HighColor;
    private javax.swing.JComboBox HighColorPicker;
    private javax.swing.JTextField HighCountText;
    private javax.swing.JTextField LowColor;
    private javax.swing.JComboBox LowColorPicker;
    private javax.swing.JTextField LowCountText;
    private javax.swing.JTextField MediumColor;
    private javax.swing.JComboBox MediumColorPicker;
    private javax.swing.JTextField MediumCountText;
    private javax.swing.JButton SaveSettingsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
