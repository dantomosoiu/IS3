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
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hector
 */
public final class ToDoPanel extends javax.swing.JPanel {

    CalendarEx cal;
    CalendarDate day;
    int category;
    MainFrame mainF;

    /**
     * Creates new form DayPanel
     */
    public ToDoPanel(MainFrame mf, CalendarEx calendar) {
        initComponents();
        cal = calendar;
        day = CalendarEx.getToday();
        category = 0;
        populateTable();
        mainF = mf;


        toDoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int selectedRow = toDoTable.getSelectedRow();
                    String date = toDoTable.getValueAt(selectedRow, 0).toString();
                    String time = toDoTable.getValueAt(selectedRow, 1).toString();
                    String event = toDoTable.getValueAt(selectedRow, 2).toString();
                    Appointment a = findEvent(date, time, event);
                    if (a != null) {
                        EditEventDialog edit = new EditEventDialog();
                        EditEventDialog.run(mainF, a, cal);
                        edit.setApp(a, cal);
                    }
                }
            }
        });


        class DeleteKeyAdapter extends KeyAdapter {

            /**
             * Handle for the KeyListener interface key control for movement
             */
            @Override
            public void keyPressed(KeyEvent ke) {
                int kc = ke.getKeyCode();
                if (kc == KeyEvent.VK_DELETE) {
                    int selectedRow = toDoTable.getSelectedRow();
                    String date = toDoTable.getValueAt(selectedRow, 0).toString();
                    String time = toDoTable.getValueAt(selectedRow, 1).toString();
                    String event = toDoTable.getValueAt(selectedRow, 2).toString();
                    Appointment a = findEvent(date, time, event);
                    if (a != null) {
                        ConfirmDelete.run(mainF, a, cal, null);
                    }
                }
            }
        }
        toDoTable.addKeyListener(new DeleteKeyAdapter());
        toDoTable.getTableHeader().setPreferredSize(new Dimension(toDoTable.getTableHeader().getHeight(), 33));

    }

    private Appointment findEvent(String d, String t, String eN) {
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(day, CalendarDate.moveMonth(12, day));
        if (category != 0) {
            List<Appointment> appointments2 = new ArrayList<Appointment>();
            for (Appointment a : appointments) {
                if (a.category == category) {
                    appointments2.add(a);
                }
            }
            appointments = appointments2;
        }
        int evHr = Integer.parseInt(t.substring(0, 2));
        int evDay = Integer.parseInt(d.substring(0, 2));
        int evMonth = Integer.parseInt(d.substring(3, 5));
        int evYear = Integer.parseInt(d.substring(6, 10));
        for (Appointment a : appointments) {
            if (a.date.year == evYear && a.date.month == evMonth && a.date.day == evDay && a.description.equals(eN) && evHr == a.start_time.hr) {
                return a;
            }
        }
        return null;
    }

    public void setCategory(int i) {
        category = i;
    }

    public void populateTable() {
        //dayLabel.setText(CalendarEx.getDateString(day));
        List<Appointment> appointments = cal.getAppointmentsBetweenDates(day, CalendarDate.moveMonth(12, day));
        if (category != 0) {
            List<Appointment> appointments2 = new ArrayList<Appointment>();
            for (Appointment a : appointments) {
                if (a.category == category) {
                    appointments2.add(a);
                }
            }
            appointments = appointments2;
        }
        Collections.sort(appointments);
        DefaultTableModel model = (DefaultTableModel) toDoTable.getModel();
        if (appointments.size() > model.getRowCount()) {
            while (appointments.size() > model.getRowCount() && appointments.size() < 50) {
                model.addRow(new Object[]{"Time", "Event"});
            }
        } else if (appointments.size() < model.getRowCount() && model.getRowCount() > 24) {
            while (appointments.size() < model.getRowCount() && model.getRowCount() > 24) {
                model.removeRow(model.getRowCount() - 1);
            }
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            if (i < appointments.size()) {
                String hr = Integer.toString(appointments.get(i).start_time.hr);
                String min = Integer.toString(appointments.get(i).start_time.min);
                if (appointments.get(i).start_time.hr < 10) {
                    hr = "0" + hr;
                }
                if (appointments.get(i).start_time.min < 10) {
                    min = "0" + min;
                }
                toDoTable.getModel().setValueAt(appointments.get(i).date.toString(), i, 0);
                toDoTable.getModel().setValueAt(hr + ":" + min, i, 1);
                toDoTable.getModel().setValueAt(appointments.get(i).description, i, 2);
            } else {
                toDoTable.getModel().setValueAt("", i, 0);
                toDoTable.getModel().setValueAt("", i, 1);
                toDoTable.getModel().setValueAt("", i, 2);
            }
        }
        toDoTable.setShowGrid(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        toDoTable = new javax.swing.JTable();
        dayLabel = new javax.swing.JLabel();

        jScrollPane1.setForeground(new java.awt.Color(254, 254, 254));

        toDoTable.setBackground(new java.awt.Color(254, 254, 254));
        toDoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Time", "Event"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        toDoTable.setGridColor(new java.awt.Color(4, 2, 2));
        jScrollPane1.setViewportView(toDoTable);
        toDoTable.getColumnModel().getColumn(0).setMinWidth(50);
        toDoTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        toDoTable.getColumnModel().getColumn(0).setMaxWidth(125);
        toDoTable.getColumnModel().getColumn(1).setMinWidth(50);
        toDoTable.getColumnModel().getColumn(1).setPreferredWidth(75);
        toDoTable.getColumnModel().getColumn(1).setMaxWidth(100);
        toDoTable.setShowGrid(true);

        dayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dayLabel.setText("Upcoming Events");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addComponent(dayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(dayLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        dayLabel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dayLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable toDoTable;
    // End of variables declaration//GEN-END:variables
}
