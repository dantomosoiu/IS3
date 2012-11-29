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

import assortedComponents.MonthCell;
import assortedComponents.MonthCellRenderer;
import assortedComponents.MonthTableModel;
import calendarCode.Appointment;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author hector
 */
public class MonthPanel extends javax.swing.JPanel {

    private CalendarEx cal;
    private CalendarDate currentDay;
    private CalendarDate startDay;
    private int mondayOffset;
    private int category;
    private MainFrame mainF;

    /**
     * Creates new form DayPanel
     */
    public MonthPanel(MainFrame mf, CalendarEx calendar, CalendarDate day) {
        initComponents();
        cal = calendar;
        currentDay = day;
        setupTable();
        mainF = mf;

        monthTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedCol = monthTable.getSelectedColumn();
                    int selectedRow = monthTable.getSelectedRow();
                    MonthCell cell = (MonthCell) monthTable.getValueAt(selectedRow, selectedCol);
                    if (cell.getDay() > 0) {
                        currentDay = new CalendarDate(cell.getDay(), currentDay.month, currentDay.year);
                        mainF.dayRepaint();
                    }
                }
            }
        });
    }

    public void setCategory(int i) {
        category = i;
    }

    private void setupTable() {
        int size = 6;
        MonthCell[][] data = new MonthCell[size][7];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = new MonthCell(0, 0);
            }
        }

        final TableModel model = new MonthTableModel(data, size);

        monthTable.setDefaultRenderer(MonthCell.class, new MonthCellRenderer());

        monthTable.setModel(
                new DefaultTableModel(data, new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}) {
                    Class[] types = new Class[]{MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class, MonthCell.class};
                    boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

                    @Override
                    public Class getColumnClass(int columnIndex) {
                        return types[columnIndex];
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit[columnIndex];
                    }
                });

        monthTable.setShowGrid(true);
    }

    public void populateTable() {
        startEndDay();
        int[] counters = new int[CalendarDate.getDaysOfMonth(startDay.month, startDay.year)];
        for (int i = 0; i < counters.length; i++) {
            List<Appointment> appointments = cal.getAppointmentsBetweenDates(CalendarDate.moveDay(i, startDay), CalendarDate.moveDay(i, startDay));
            if (category != 0) {
                List<Appointment> appointments2 = new ArrayList<Appointment>();
                for (Appointment a : appointments) {
                    if (a.category == category) {
                        appointments2.add(a);
                    }
                }
                appointments = appointments2;
            }
            counters[i] = appointments.size();
        }
        DefaultTableModel model = (DefaultTableModel) monthTable.getModel();
        if ((mondayOffset + counters.length < 36) && (model.getRowCount() == 6)) {
            model.removeRow(model.getRowCount() - 1);
        } else if (mondayOffset + counters.length > 35 && model.getRowCount() == 5) {
            model.addRow(new Object[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"});
        }

        int row = 0;
        int col;
        for (col = 0; col < mondayOffset; col++) {
            model.setValueAt(new MonthCell(0, 0), 0, col);
        }
        for (int i = 0; i < counters.length; i++) {
            model.setValueAt(new MonthCell(i + 1, counters[i]), row, col);
            col++;
            if (col > 6) {
                col = 0;
                row++;
            }
        }
        if (col != 0) {
            for (; col < 7; col++) {
                model.setValueAt(new MonthCell(0, 0), row, col);
            }
        }
        monthTable.setShowGrid(true);
    }

    public CalendarDate getCurrentDate() {
        return currentDay;
    }

    public void setCurrentDate(CalendarDate d) {
        currentDay = d;
    }

    private void startEndDay() {
        startDay = new CalendarDate(1, currentDay.month, currentDay.year);
        mondayOffset = CalendarDate.getDayNumberFromDayName(CalendarDate.getDay(startDay.day, startDay.month, startDay.year)) - 1;
        monthLabel.setText(CalendarEx.monthToString(startDay.month) + ", " + startDay.year);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        previousButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        monthLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        monthTable = new javax.swing.JTable();

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

        monthLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monthLabel.setText("Day");

        monthTable.setModel(new javax.swing.table.DefaultTableModel(
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
        monthTable.setGridColor(new java.awt.Color(4, 2, 2));
        monthTable.setMaximumSize(new java.awt.Dimension(2147483647, 390));
        monthTable.setMinimumSize(new java.awt.Dimension(105, 390));
        monthTable.setPreferredSize(new java.awt.Dimension(525, 390));
        monthTable.setRowHeight(78);
        jScrollPane1.setViewportView(monthTable);
        monthTable.setShowGrid(true);

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
                        .addComponent(monthLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
                    .addComponent(monthLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );

        monthLabel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

private void previousButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousButtonActionPerformed
    currentDay = CalendarDate.moveMonth(-1, currentDay);
    populateTable();
}//GEN-LAST:event_previousButtonActionPerformed

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    currentDay = CalendarDate.moveMonth(1, currentDay);
    populateTable();
}//GEN-LAST:event_nextButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel monthLabel;
    private javax.swing.JTable monthTable;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton previousButton;
    // End of variables declaration//GEN-END:variables
}
