/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

import calendarCode.CalendarEx;

/**
 *
 * @author Dan
 */
public class ToDoPanel extends javax.swing.JPanel {

    private CalendarEx cal;
    
    /**
     * Creates new form DayPanel
     */
    public ToDoPanel(CalendarEx calendar) {
        initComponents();
        
        cal = calendar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PreviousButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        ToDoLabel = new javax.swing.JLabel();

        PreviousButton.setText("Previous");

        NextButton.setText("Next");

        ToDoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ToDoLabel.setText("TO DO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PreviousButton)
                .addGap(147, 147, 147)
                .addComponent(ToDoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(NextButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {NextButton, PreviousButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PreviousButton)
                    .addComponent(NextButton)
                    .addComponent(ToDoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JLabel ToDoLabel;
    // End of variables declaration//GEN-END:variables
}
