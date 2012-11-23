/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

import calendarCode.Appointment;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.util.Collections;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Dan
 */
public class MonthPanel extends javax.swing.JPanel {

    private CalendarEx cal;
    private CalendarDate startDay;
    private CalendarDate endDay;
    private int mondayOffset;

    /**
     * Creates new form DayPanel
     */
    public MonthPanel(CalendarEx calendar) {
        initComponents();
        cal = calendar;
        startEndDay(CalendarEx.getCurrentDay(), CalendarEx.getCurrentMonth(), CalendarEx.getCurrentYear());
        SetOffset();
        ListAppointMents();
    }

    public void SetOffset(){
        switch (CalendarDate.getDayNumberFromDayName(CalendarDate.getDay(startDay.day, startDay.month, startDay.year))) {
            case 1:
                mondayOffset = 1;
                break;
            case 2:
                mondayOffset = 2;
                break;
            case 3:
                mondayOffset = 3;
                break;
            case 4:
                mondayOffset = 4;
                break;
            case 5:
                mondayOffset = 5;
                break;
            case 6:
                mondayOffset = 6;
                break;
            case 7:
                mondayOffset = 7;
                break;
            default:
                break;
        }
    }
    
    public void RefreshView() {
        SetOffset();
        ListAppointMents();
    }

    public void ListAppointMents() {
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(startDay, endDay);
        Collections.sort(appointments);
        
        
        int size = 6;
        if (mondayOffset < 5) {
            jTable1.setSize(7, 5);
            size = 5;
        }
        else {
            jTable1.setSize(7, 6);
            size = 6;
        }
        
        int[] counters = new int[CalendarDate.getDaysOfMonth(startDay.month, startDay.year)];
        for (int i = 0; i < counters.length; i++) {
            for (Appointment a : appointments) {
                if (a.date.day == startDay.day + i) {
                    counters[i]++;
                }
            }
        }
        MonthLabel.setText(CalendarEx.monthToString(startDay.month) + ", " + startDay.year);
        MonthCell[][] data = new MonthCell[size][7];
        int row = 0;
        int col = mondayOffset;
        if(col > 6){
                col = 0;
            }
        for (int i = 0; i < counters.length; i++) {
            data[row][col] = new MonthCell(i+1, counters[i]);
            col++;
            if(col > 6){
                col = 0;
                row++;
            }
        }
        
        final TableModel model = new MonthTableModel(data, size);
   
        JTable table = new JTable(model);
        jTable1.setDefaultRenderer(MonthCell.class, new MonthCellRenderer());
        
        jTable1.setModel(
            new DefaultTableModel(data, new String [] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
            Class[] types = new Class[] {MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class};
            boolean[] canEdit = new boolean[] {false, false, false, false, false, false, false};
            @Override
            public Class getColumnClass(int columnIndex){ return types [columnIndex];}
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex){ return canEdit [columnIndex];}
        });
        
        

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
        MonthLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        PreviousButton.setText("Previous");
        PreviousButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousButtonActionPerformed(evt);
            }
        });

        NextButton.setText("Next");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        MonthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MonthLabel.setText("MONTH (,YEAR?)");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(4, 2, 2));
        jTable1.setRowHeight(60);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PreviousButton)
                        .addGap(18, 18, 18)
                        .addComponent(MonthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(MonthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        CalendarDate day = CalendarDate.moveMonth(1, startDay);
        startEndDay(day.day, day.month, day.year);
        RefreshView();
}//GEN-LAST:event_NextButtonActionPerformed

    private void PreviousButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CalendarDate day = CalendarDate.moveMonth(-1, startDay);
        startEndDay(day.day, day.month, day.year);
        RefreshView();
    }
    
                                                  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel MonthLabel;
    private javax.swing.JButton NextButton;
    private javax.swing.JButton PreviousButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void startEndDay(int day, int month, int year) {
        startDay = new CalendarDate(1, month, year);
        endDay = new CalendarDate(CalendarDate.getDaysOfMonth(month, year), month, year);
    }
}
