/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

import calendarCode.Appointment;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.util.List;
import java.util.Calendar;
import java.util.Collections;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dan
 */
public final class DayPanel extends javax.swing.JPanel {

    private CalendarEx cal;
    private CalendarDate day;
    
    /**
     * Creates new form DayPanel
     */
    public DayPanel(CalendarEx calendar) {
        initComponents();
        cal = calendar;
        day = new CalendarDate(CalendarEx.getCurrentDay(), CalendarEx.getCurrentMonth(), CalendarEx.getCurrentYear());
        ListAppointMents();
        DayLabel.setText(CalendarEx.getDateString(day));
    }
    
    public void RefreshView(){
        ListAppointMents();
        DayLabel.setText(CalendarEx.getDateString(day));
    }
    
    public void ListAppointMents(){
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(day, day);
        Collections.sort(appointments);
        String data[][] = new String[24][2];
        for (int i = 0; i < appointments.size(); i++) {
            String hr = Integer.toString(appointments.get(i).start_time.hr);
            String min = Integer.toString(appointments.get(i).start_time.min);
            if (appointments.get(i).start_time.hr < 10) hr = "0" + hr;
            if (appointments.get(i).start_time.min < 10) min = "0" + min;
            jTable1.getModel().setValueAt(hr + ":" + min, i, 0);
            jTable1.getModel().setValueAt(appointments.get(i).description, i, 1);
        }
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
        DayLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");

        DayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DayLabel.setText("Day, Date");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "time", "null"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(4, 2, 2));
        jTable1.setRowHeight(15);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(80);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PreviousButton)
                        .addGap(147, 147, 147)
                        .addComponent(DayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                        .addComponent(NextButton)))
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
                    .addComponent(DayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousButtonActionPerformed
        day = CalendarDate.moveWeek(-1, day);
        RefreshView();
    }//GEN-LAST:event_PreviousButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DayLabel;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
