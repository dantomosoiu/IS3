/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DayPanel.java
 *
 * Created on 27-Nov-2012, 22:28:16
 */
package is3calendar2;

import assortedComponents.ConfirmDelete;
import calendarCode.Appointment;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hector
 */
public class DayPanel extends javax.swing.JPanel {
    
    CalendarEx cal;
    CalendarDate day;
    int category;
    MainFrame mainF;
    

    /** Creates new form DayPanel */
    public DayPanel(final MainFrame mf, CalendarEx calendar, CalendarDate curDate) {
        initComponents();
        cal = calendar;
        day=curDate;
        category = 0;
        populateTable();
        mainF = mf;
        dayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = dayTable.getSelectedRow();
                    String time = dayTable.getValueAt(selectedRow, 0).toString();
                    String event = dayTable.getValueAt(selectedRow, 1).toString();
                    Appointment a = findEvent(time, event);
                    if (a != null) {
                        EditEventDialog.run(mainF, a, cal);
                    }
                }
            }
        });

        class DeleteKeyAdapter extends KeyAdapter {
        /** Handle for the KeyListener interface 
        * key control for movement */
        public void keyPressed(KeyEvent ke) {  
                int kc = ke.getKeyCode();
                if (kc == ke.VK_DELETE) {     
                    int selectedRow = dayTable.getSelectedRow();
                    String time = dayTable.getValueAt(selectedRow, 0).toString();
                    String event = dayTable.getValueAt(selectedRow, 1).toString();
                    Appointment a = findEvent(time, event);
                    if (a != null) {
                        ConfirmDelete.run(mainF, a, cal, null);
                    }
                }
            }     
        }
        dayTable.addKeyListener(new DeleteKeyAdapter());
        
    }
    
    private Appointment findEvent(String t, String eN) {
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(day, day);
        if (category != 0) { List<Appointment> appointments2 = new ArrayList<Appointment>(); for (Appointment a : appointments)if (a.category == category) appointments2.add(a); appointments = appointments2;}; 
        int hr = Integer.parseInt(t.substring(0, 2));
        int min = Integer.parseInt(t.substring(3, 5));
        for (Appointment a : appointments) if (a.start_time.min == min && a.description.equals(eN) && hr == a.start_time.hr) return a;
        return null;
    }
    
    public void setCategory(int i) {
        category = i;
    }
    
    public void populateTable(){
        dayLabel.setText(CalendarEx.getDateString(day));
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(day, day);
        if (category != 0) { List<Appointment> appointments2 = new ArrayList<Appointment>(); for (Appointment a : appointments)if (a.category == category) appointments2.add(a); appointments = appointments2;}; 
        Collections.sort(appointments);
        DefaultTableModel model = (DefaultTableModel)dayTable.getModel();
        if (appointments.size() > model.getRowCount()) while (appointments.size() > model.getRowCount()) model.addRow(new Object[]{"Time", "Event"});
        else if (appointments.size() < model.getRowCount() && model.getRowCount() > 24) while (appointments.size() < model.getRowCount() && model.getRowCount() > 24) model.removeRow(model.getRowCount()-1);
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i < appointments.size()) {
                String hr = Integer.toString(appointments.get(i).start_time.hr);
                String min = Integer.toString(appointments.get(i).start_time.min);
                if (appointments.get(i).start_time.hr < 10) hr = "0" + hr;
                if (appointments.get(i).start_time.min < 10) min = "0" + min;
                dayTable.getModel().setValueAt(hr + ":" + min, i, 0);
                dayTable.getModel().setValueAt(appointments.get(i).description, i, 1);
            }
            else {
                dayTable.getModel().setValueAt("", i, 0);
                dayTable.getModel().setValueAt("", i, 1);
            }
        }
        dayTable.setShowGrid(true);
    }
    public CalendarDate getCurrentDate() { return day; }
    public void setCurrentDate(CalendarDate d) {day = d;}

    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dayTable = new javax.swing.JTable();
        dayLabel = new javax.swing.JLabel();

        previousButton.setText("Previous");
        previousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setForeground(new java.awt.Color(254, 254, 254));

        dayTable.setBackground(new java.awt.Color(254, 254, 254));
        dayTable.setModel(new javax.swing.table.DefaultTableModel(
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
                "Time", "Event"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dayTable.setGridColor(new java.awt.Color(4, 2, 2));
        dayTable.setRowHeight(15);
        jScrollPane1.setViewportView(dayTable);
        dayTable.getColumnModel().getColumn(0).setMinWidth(50);
        dayTable.getColumnModel().getColumn(0).setPreferredWidth(75);
        dayTable.getColumnModel().getColumn(0).setMaxWidth(100);
        dayTable.setShowGrid(true);

        dayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel.setText("Day");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addGap(18, 18, 18)
                        .addComponent(dayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nextButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(dayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        dayLabel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
    day = CalendarDate.moveDay(-1, day);
    populateTable();
}//GEN-LAST:event_previousButtonActionPerformed

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    day = CalendarDate.moveDay(1, day);
    populateTable();
}//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dayLabel;
    private javax.swing.JTable dayTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables
}
