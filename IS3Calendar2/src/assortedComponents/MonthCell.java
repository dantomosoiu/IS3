/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * monthCell.java
 *
 * Created on 23-Nov-2012, 16:59:12
 */
package assortedComponents;

import is3calendar2.MainFrame;
import java.awt.Color;

/**
 *
 * @author hector
 */
public class MonthCell extends javax.swing.JPanel {

    /**
     * Creates new form monthCell
     */
    public MonthCell(int i, int j) {
        initComponents();
        if (i > 0) {
            dayNum.setText(Integer.toString(i));
        } else {
            dayNum.setText("");
        }
        this.setBackground(MainFrame.emptyBusynessColor);
        if (j > 0) {
            numEvents.setText(Integer.toString(j));
        } else {
            numEvents.setText("");
        }
        if (j > MainFrame.highBusynessCount) {
            this.setBackground(MainFrame.highBusynessColor);
        }
        else if (j > MainFrame.mediumBusynessCount) {
            this.setBackground(MainFrame.mediumBusynessColor);
        }
        else if (j > MainFrame.lowBusynessCount) {
            this.setBackground(MainFrame.lowBusynessColor);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void SetDay(int i) {
        dayNum.setText(Integer.toString(i));
    }

    public void SetEvNum(int i) {
        numEvents.setText(Integer.toString(i));
    }

    public int getDay() {
        if (!dayNum.getText().equals("")) {
            return Integer.parseInt(dayNum.getText());
        } else {
            return 0;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dayNum = new javax.swing.JLabel();
        numEvents = new javax.swing.JLabel();

        dayNum.setText("1");
        dayNum.setName("dayNum"); // NOI18N

        numEvents.setFont(new java.awt.Font("Ubuntu", 1, 24));
        numEvents.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numEvents.setText("0");
        numEvents.setName("numEvents"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(numEvents, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                    .addComponent(dayNum, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dayNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numEvents, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dayNum;
    private javax.swing.JLabel numEvents;
    // End of variables declaration//GEN-END:variables
}
