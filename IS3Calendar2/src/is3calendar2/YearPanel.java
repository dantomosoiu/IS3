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

import assortedComponents.YearCell;
import assortedComponents.YearCellRenderer;
import assortedComponents.YearTableModel;
import calendarCode.Appointment;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hector
 */
public class YearPanel extends javax.swing.JPanel {
    
    
    private CalendarEx cal;
    private int year;
    private CalendarDate currentDay;
    private int category;
    MainFrame mainF;

    /** Creates new form DayPanel */
    public YearPanel(MainFrame mf, CalendarEx calendar, CalendarDate curDay) {
        initComponents();
        cal = calendar;
        currentDay = curDay;
        mainF = mf;
        setupTable();
        
        yearTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedCol = yearTable.getSelectedColumn();
                    int selectedRow = yearTable.getSelectedRow();
                    currentDay = new CalendarDate(currentDay.day, 4*selectedRow+selectedCol+1, currentDay.year);
                    mainF.monthRepaint();
                }
            }
        });
    }
    
    
    public void setCategory(int i) {
        category = i;
    }
    
    
    private void setupTable() {
        YearCell[][] data = new YearCell[3][4];
        for (int i = 0; i < 3; i++) for (int j = 0; j < 4; j++) data[i][j] = new YearCell(new int[42],new int[42]);
        
        final YearTableModel model = new YearTableModel(data);
   
        yearTable.setDefaultRenderer(YearCell.class, new YearCellRenderer());
        
        yearTable.setModel(
            new DefaultTableModel(data, new String [] {"", "", "", ""}) {
            Class[] types = new Class[] {YearCell.class, YearCell.class, YearCell.class, YearCell.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false};
            @Override
            public Class getColumnClass(int columnIndex){ return types [columnIndex];}
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit [columnIndex];}
        });
        
        yearTable.setShowGrid(true);
    }
    
    public void populateTable(){
        year = currentDay.year;
        yearLabel.setText(Integer.toString(year));
        
        DefaultTableModel model = (DefaultTableModel)yearTable.getModel();
        
        //int[][] counters = new int[12][31]
        for (int j = 0; j < 12; j++) {
            int[] numbers = new int[42];
            int[] busy = new int[42];
            int i;
            int offset = getOffset(j+1);
            for (i=0;i<offset;i++) {busy[i] = 0; numbers[i] = 0; }
            if (i!=0) i -= 1;
            for (; i < CalendarDate.getDaysOfMonth(j+1, year)+offset; i++) {List<Appointment> appointments = cal.getAppointmentsBetweenDates(new CalendarDate(i-offset+1, j+1, year), new CalendarDate(i-offset+1, j+1, year));if (category != 0) { List<Appointment> appointments2 = new ArrayList<Appointment>(); for (Appointment a : appointments)if (a.category == category) appointments2.add(a); appointments = appointments2;}; busy[i] = appointments.size(); numbers[i] = i-offset+1;}
            for (;i<42;i++) {busy[i] = 0; numbers[i] = 0; }
            
            model.setValueAt(new YearCell(busy, numbers), j/4, j%4);
        }
        yearTable.setShowGrid(true);
    }
    
    public CalendarDate getCurrentDate() { return currentDay; }
    public void setCurrentDate(CalendarDate d) {currentDay = d;}

    public int getOffset(int month){
        return CalendarDate.getDayNumberFromDayName(CalendarDate.getDay(1, month, currentDay.year))-1;
    }
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
        yearLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        yearTable = new javax.swing.JTable();

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

        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel.setText("Year");

        yearTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        yearTable.setGridColor(new java.awt.Color(4, 2, 2));
        yearTable.setRowHeight(135);
        jScrollPane1.setViewportView(yearTable);
        yearTable.setShowGrid(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(nextButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nextButton, previousButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousButton)
                    .addComponent(nextButton)
                    .addComponent(yearLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addContainerGap())
        );

        yearLabel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
    year -=1;
    currentDay = new CalendarDate(currentDay.day, currentDay.month, currentDay.year-1);
    populateTable();
}//GEN-LAST:event_previousButtonActionPerformed

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    year +=1;
    currentDay = new CalendarDate(currentDay.day, currentDay.month, currentDay.year+1);
    populateTable();
}//GEN-LAST:event_nextButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    private javax.swing.JLabel yearLabel;
    private javax.swing.JTable yearTable;
    // End of variables declaration//GEN-END:variables
}
