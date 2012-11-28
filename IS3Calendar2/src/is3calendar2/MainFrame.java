/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Mainframe.java
 *
 * Created on 27-Nov-2012, 21:36:58
 */
package is3calendar2;

import assortedComponents.CategoriesButtons;
import assortedComponents.HelpDialog;
import calendarCode.CalendarDate;
import calendarCode.CalendarEx;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hector
 */
public class MainFrame extends javax.swing.JFrame {

    private CalendarEx cal;
    private CalendarDate curDay;
    private JPanel currentPanel;
    private DayPanel dayPanel;
    private WeekPanel weekPanel;
    private MonthPanel monthPanel;
    private YearPanel yearPanel;
    private int category;
    public ToDoPanel toDoPanel;

    /** Creates new form Mainframe */
    public MainFrame() {
        initComponents();
        
        Toolkit kit = this.getToolkit();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
        Dimension d = kit.getScreenSize();
        int max_width = (d.width - in.left - in.right);
        int max_height = (d.height - in.top - in.bottom);
        this.setSize(Math.min(max_width, 850), Math.min(max_height, 550));//whatever size you want but smaller the insets
        this.setLocation((int) (max_width - this.getWidth()) / 2, (int) (max_height - this.getHeight() ) / 2);        
        
        category = 0;
        catButtonPanel.add(new CategoriesButtons(this));
        catButtonPanel.setLayout(new GridBagLayout());
        cal = new CalendarEx();
        File f = new File("./cal");
        if (f.exists()) cal.openCalendar("./cal");
        curDay = CalendarEx.getToday();
        todayLabel.setText(curDay.toString());

        dayPanel = new DayPanel(this, cal, curDay);
        weekPanel = new WeekPanel(this, cal, curDay);
        monthPanel = new MonthPanel(this, cal, curDay);
        yearPanel = new YearPanel(this, cal, curDay);
        toDoPanel = new ToDoPanel(this, cal);

        InternalPanel.setLayout(new java.awt.BorderLayout());

        InternalPanel.add(dayPanel);
        currentPanel = dayPanel;

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addEvent = new javax.swing.JButton();
        help = new javax.swing.JButton();
        settings = new javax.swing.JButton();
        todayLabel = new javax.swing.JLabel();
        catButtonPanel = new javax.swing.JPanel();
        InternalPanel = new javax.swing.JPanel();
        dayButton = new javax.swing.JButton();
        weekButton = new javax.swing.JButton();
        monthButton = new javax.swing.JButton();
        yearButton = new javax.swing.JButton();
        toDoButton = new javax.swing.JButton();
        todayButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 243, 243));

        addEvent.setText("Add Event");
        addEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventActionPerformed(evt);
            }
        });

        help.setText("Help");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });

        settings.setText("Settings");
        settings.setToolTipText("");

        todayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todayLabel.setText("Today's Date");

        javax.swing.GroupLayout catButtonPanelLayout = new javax.swing.GroupLayout(catButtonPanel);
        catButtonPanel.setLayout(catButtonPanelLayout);
        catButtonPanelLayout.setHorizontalGroup(
            catButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        catButtonPanelLayout.setVerticalGroup(
            catButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        InternalPanel.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout InternalPanelLayout = new javax.swing.GroupLayout(InternalPanel);
        InternalPanel.setLayout(InternalPanelLayout);
        InternalPanelLayout.setHorizontalGroup(
            InternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        InternalPanelLayout.setVerticalGroup(
            InternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 454, Short.MAX_VALUE)
        );

        dayButton.setText("Day");
        dayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayButtonActionPerformed(evt);
            }
        });

        weekButton.setText("Week");
        weekButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekButtonActionPerformed(evt);
            }
        });

        monthButton.setText("Month");
        monthButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthButtonActionPerformed(evt);
            }
        });

        yearButton.setText("Year");
        yearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearButtonActionPerformed(evt);
            }
        });

        toDoButton.setText("To-Do");
        toDoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toDoButtonActionPerformed(evt);
            }
        });

        todayButton.setText("Today");
        todayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(catButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toDoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(todayButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InternalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEvent)
                    .addComponent(help)
                    .addComponent(settings)
                    .addComponent(todayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(catButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InternalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayButton)
                    .addComponent(weekButton)
                    .addComponent(monthButton)
                    .addComponent(yearButton)
                    .addComponent(toDoButton)
                    .addComponent(todayButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventActionPerformed
    AddEventDialog addEventPanel = new AddEventDialog();
    AddEventDialog.run(cal, this);
    addEventPanel.setCal(cal);
}//GEN-LAST:event_addEventActionPerformed

public void dayRepaint() {dayButtonActionPerformed(null);}
public void monthRepaint() {monthButtonActionPerformed(null);}

private void dayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(dayPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = dayPanel;
    dayPanel.setCurrentDate(curDay);
    dayPanel.populateTable();
}//GEN-LAST:event_dayButtonActionPerformed

private void weekButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(weekPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = weekPanel;
    weekPanel.setCurrentDate(curDay);
    weekPanel.populateTable();
}//GEN-LAST:event_weekButtonActionPerformed

private void monthButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(monthPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = monthPanel;
    monthPanel.setCurrentDate(curDay);
    monthPanel.populateTable();
}//GEN-LAST:event_monthButtonActionPerformed

private void yearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(yearPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = yearPanel;
    yearPanel.setCurrentDate(curDay);
    yearPanel.populateTable();
}//GEN-LAST:event_yearButtonActionPerformed

private void todayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayButtonActionPerformed
    dayPanel.setCurrentDate(CalendarEx.getToday());
    weekPanel.setCurrentDate(CalendarEx.getToday());
    yearPanel.setCurrentDate(CalendarEx.getToday());
    monthPanel.setCurrentDate(CalendarEx.getToday());
    RefreshView();
}//GEN-LAST:event_todayButtonActionPerformed

private void toDoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(toDoPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = toDoPanel;
    toDoPanel.populateTable();
}//GEN-LAST:event_toDoButtonActionPerformed

private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
    HelpDialog.run();
}//GEN-LAST:event_helpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public void RefreshView() {
        if (currentPanel.getClass().equals(dayPanel.getClass())) {
            dayPanel.populateTable();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            weekPanel.populateTable();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            monthPanel.populateTable();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            yearPanel.populateTable();
        }
        else if (toDoPanel.getClass().equals(toDoPanel.getClass())){
        toDoPanel.populateTable();
        }
    }
    private CalendarDate getCurrentDate() {
         if (currentPanel.getClass().equals(dayPanel.getClass())) {
            return dayPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            return weekPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            return monthPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            return yearPanel.getCurrentDate();
        }
        else return curDay;
    }
    public void setCategory(int c) {
        category = c;
         if (currentPanel.getClass().equals(dayPanel.getClass())) {
            dayPanel.setCategory(c); dayPanel.populateTable();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            weekPanel.setCategory(c); weekPanel.populateTable();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            monthPanel.setCategory(c); monthPanel.populateTable();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            yearPanel.setCategory(c); yearPanel.populateTable();
        } else if (currentPanel.getClass().equals(toDoPanel.getClass())) {
            toDoPanel.setCategory(c); toDoPanel.populateTable();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel InternalPanel;
    private javax.swing.JButton addEvent;
    private javax.swing.JPanel catButtonPanel;
    private javax.swing.JButton dayButton;
    private javax.swing.JButton help;
    private javax.swing.JButton monthButton;
    private javax.swing.JButton settings;
    private javax.swing.JButton toDoButton;
    private javax.swing.JButton todayButton;
    private javax.swing.JLabel todayLabel;
    private javax.swing.JButton weekButton;
    private javax.swing.JButton yearButton;
    // End of variables declaration//GEN-END:variables
}
