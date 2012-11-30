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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JPanel;

/**
 *
 * @author hector
 */
public final class MainFrame extends javax.swing.JFrame {

    public static MainFrame mf;
    private CalendarEx cal; //Calendar Item
    private CalendarDate curDay; //Represents the day being viewed by the user
    private JPanel currentPanel; //A holder for the different views
    private DayPanel dayPanel; // The Day View
    private WeekPanel weekPanel; // The Week View
    private MonthPanel monthPanel; // The Month View
    private YearPanel yearPanel; // The Year View
    private BusynessGraph busynessGraph; //i wonder what view this is
    private int category; // integer representation of selected category
    public ToDoPanel toDoPanel; // The To-Do View
    //Settings
    public static int DefaultView = 0;
    public static int lowBusynessCount = 1;
    public static int mediumBusynessCount = 2;
    public static int highBusynessCount = 3;
    public static Color emptyBusynessColor = Color.RED;
    public static Color lowBusynessColor = Color.BLUE;
    public static Color mediumBusynessColor = Color.CYAN;
    public static Color highBusynessColor = Color.LIGHT_GRAY;
    public static SettingsDialog SettingsDialog;

    /**
     * Creates new form Mainframe
     */
    public MainFrame() {
        initComponents(); //Generates code for items created in Design View
        parseSettingsFile();


        //Finds the size of the screen and item. Uses this to calculate how to position the frame in the center of the screen.
        Toolkit kit = this.getToolkit();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        Insets in = kit.getScreenInsets(gs[0].getDefaultConfiguration());
        Dimension d = kit.getScreenSize();
        int max_width = (d.width - in.left - in.right);
        int max_height = (d.height - in.top - in.bottom);
        this.setSize(Math.min(max_width, 850), Math.min(max_height, 550));//whatever size you want but smaller the insets
        this.setLocation((int) (max_width - this.getWidth()) / 2, (int) (max_height - this.getHeight()) / 2);

        category = 0;//Sets the catergory to all
        catButtonPanel.add(new CategoriesButtons(this));//Adds category buttons. Having their own panel would make it easier to implement User added categoried in future
        catButtonPanel.setLayout(new GridBagLayout());//uses a layout that will centralise the buttons
        cal = new CalendarEx();//creates a new calendar
        File f = new File("./cal");//if a calendar file is present
        if (f.exists()) {
            cal.openCalendar("./cal");//loads it
        }
        curDay = CalendarEx.getToday();//starts the program showing today
        todayLabel.setText("Today is " + CalendarDate.getDay(curDay.day, curDay.month, curDay.year) + ", " + curDay.toString());//sets the label at the top of the frame

        dayPanel = new DayPanel(this, cal, curDay);//creates a new Day Panel
        weekPanel = new WeekPanel(this, cal, curDay);//creates a new Week Panel
        monthPanel = new MonthPanel(this, cal, curDay);//creates a new Month Panel
        yearPanel = new YearPanel(this, cal, curDay);//creates a new Year Panel
        toDoPanel = new ToDoPanel(this, cal);//creates a new ToDo Panel
        busynessGraph = new BusynessGraph(this, cal, curDay);

        InternalPanel.setLayout(new java.awt.BorderLayout());

        switch (DefaultView) {
            case 0:
                InternalPanel.add(dayPanel);
                currentPanel = dayPanel;
                break;
            case 1:
                InternalPanel.add(weekPanel);
                currentPanel = weekPanel;
                break;
            case 2:
                InternalPanel.add(monthPanel);
                currentPanel = monthPanel;
                break;
            case 3:
                InternalPanel.add(yearPanel);
                currentPanel = yearPanel;
                break;
            case 4:
                InternalPanel.add(toDoPanel);
                currentPanel = toDoPanel;
                break;
        }

        mf = this;
        
        RefreshView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
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
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        BusynessButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(243, 243, 243));
        setMaximumSize(new java.awt.Dimension(2147483647, 615));
        setMinimumSize(new java.awt.Dimension(0, 615));
        setPreferredSize(new java.awt.Dimension(845, 615));
        setResizable(false);

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
        settings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingsMouseClicked(evt);
            }
        });

        todayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        todayLabel.setText("Today's Date");

        javax.swing.GroupLayout catButtonPanelLayout = new javax.swing.GroupLayout(catButtonPanel);
        catButtonPanel.setLayout(catButtonPanelLayout);
        catButtonPanelLayout.setHorizontalGroup(
            catButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
            .addGap(0, 0, Short.MAX_VALUE)
        );
        InternalPanelLayout.setVerticalGroup(
            InternalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
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

        toDoButton.setText("Upcoming Events");
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

        BusynessButton.setText("Busyness");
        BusynessButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusynessButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(addEvent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(todayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(settings)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(help))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(catButtonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BusynessButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(todayButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(InternalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addEvent, help, settings});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dayButton, monthButton, todayButton, weekButton, yearButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addEvent)
                            .addComponent(help)
                            .addComponent(settings)
                            .addComponent(todayLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(todayButton)
                    .addComponent(BusynessButton))
                .addGap(18, 18, 18))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addEvent, help, settings});

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void addEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventActionPerformed
    //When the Add Event Button Is Pushed, opens the add event dialogue
    AddEventDialog.run(cal, this);
}//GEN-LAST:event_addEventActionPerformed

//Public methods to allow the views to change view
    public void dayRepaint() {
        dayButtonActionPerformed(null);
    }

    public void monthRepaint() {
        monthButtonActionPerformed(null);
    }

    private void parseSettingsFile() {
        try {
            BufferedReader settingsReader = new BufferedReader(new FileReader("settings.txt"));
            while (true) {
                String line = settingsReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.startsWith("DefaultView")) {
                    DefaultView = Integer.parseInt(line.replace("DefaultView=", ""));
                }
                if (line.startsWith("lowBusynessCount")) {
                    lowBusynessCount = Integer.parseInt(line.replace("lowBusynessCount=", ""));
                }
                if (line.startsWith("mediumBusynessCount")) {
                    mediumBusynessCount = Integer.parseInt(line.replace("mediumBusynessCount=", ""));
                }
                if (line.startsWith("highBusynessCount")) {
                    highBusynessCount = Integer.parseInt(line.replace("highBusynessCount=", ""));
                }
                if (line.startsWith("emptyBusynessColor")) {
                    emptyBusynessColor = SettingsDialog.getColorFromIndex(Integer.parseInt(line.replace("emptyBusynessColor=", "")));
                }
                if (line.startsWith("lowBusynessColor")) {
                    lowBusynessColor = SettingsDialog.getColorFromIndex(Integer.parseInt(line.replace("lowBusynessColor=", "")));
                }
                if (line.startsWith("mediumBusynessColor")) {
                    mediumBusynessColor = SettingsDialog.getColorFromIndex(Integer.parseInt(line.replace("mediumBusynessColor=", "")));
                }
                if (line.startsWith("highBusynessColor")) {
                    highBusynessColor = SettingsDialog.getColorFromIndex(Integer.parseInt(line.replace("highBusynessColor=", "")));
                }
            }

        } catch (Exception e) {
        }
    }

    public static void saveSettings() {
        try {
            BufferedWriter settingsWriter = new BufferedWriter(new FileWriter("settings.txt"));
            settingsWriter.write("DefaultView=" + DefaultView + "\n");
            settingsWriter.write("lowBusynessCount=" + lowBusynessCount + "\n");
            settingsWriter.write("mediumBusynessCount=" + mediumBusynessCount + "\n");
            settingsWriter.write("highBusynessCount=" + highBusynessCount + "\n");
            settingsWriter.write("emptyBusynessColor=" + SettingsDialog.getIndexFromColour(emptyBusynessColor) + "\n");
            settingsWriter.write("lowBusynessColor=" + SettingsDialog.getIndexFromColour(lowBusynessColor) + "\n");
            settingsWriter.write("mediumBusynessColor=" + SettingsDialog.getIndexFromColour(mediumBusynessColor) + "\n");
            settingsWriter.write("highBusynessColor=" + SettingsDialog.getIndexFromColour(highBusynessColor) + "\n");


            settingsWriter.close();
        } catch (Exception e) {
        }
    }

//sets the day panel as current, and makes sure its table is up to date
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

//sets the week panel as current, and makes sure its table is up to date
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

//sets the month panel as current, and makes sure its table is up to date
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

//sets the year panel as current, and makes sure its table is up to date
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

//sets the view day to today
private void todayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todayButtonActionPerformed
    dayPanel.setCurrentDate(CalendarEx.getToday());
    weekPanel.setCurrentDate(CalendarEx.getToday());
    yearPanel.setCurrentDate(CalendarEx.getToday());
    monthPanel.setCurrentDate(CalendarEx.getToday());
    RefreshView();
}//GEN-LAST:event_todayButtonActionPerformed

//sets the todo panel as current, and makes sure its table is up to date
private void toDoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toDoButtonActionPerformed
    curDay = getCurrentDate();
    InternalPanel.remove(currentPanel);
    InternalPanel.add(toDoPanel);
    InternalPanel.revalidate();
    InternalPanel.repaint();
    currentPanel = toDoPanel;
    toDoPanel.populateTable();
}//GEN-LAST:event_toDoButtonActionPerformed

//Launches the help dialogue
private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
    HelpDialog.run();
}//GEN-LAST:event_helpActionPerformed

    private void settingsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingsMouseClicked
        SettingsDialog.run();
    }//GEN-LAST:event_settingsMouseClicked

    private void BusynessButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusynessButtonActionPerformed
        curDay = getCurrentDate();
        InternalPanel.remove(currentPanel);
        InternalPanel.add(busynessGraph);
        InternalPanel.revalidate();
        InternalPanel.repaint();
        currentPanel = busynessGraph;
    }//GEN-LAST:event_BusynessButtonActionPerformed

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

    //checks which panel is current, and refreshes its table
    public void RefreshView() {
        busynessGraph.resetData(cal);
        
        if (currentPanel.getClass().equals(dayPanel.getClass())) {
            dayPanel.populateTable();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            weekPanel.populateTable();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            monthPanel.populateTable();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            yearPanel.populateTable();
        } else if (currentPanel.getClass().equals(toDoPanel.getClass())) {
            toDoPanel.populateTable();
        } else if (currentPanel.getClass().equals(busynessGraph.getClass())){
            //busynessGraph = new BusynessGraph(this, cal, curDay);
            busynessGraph.repaint();
        }
    }
    //returns the current Date from the current panel

    private CalendarDate getCurrentDate() {
        if (currentPanel.getClass().equals(dayPanel.getClass())) {
            return dayPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            return weekPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            return monthPanel.getCurrentDate();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            return yearPanel.getCurrentDate();
        } else {
            return curDay;
        }
    }
    //sets the category in the panels

    public void setCategory(int c) {
        category = c;
        toDoPanel.setCategory(c);
        dayPanel.setCategory(c);
        weekPanel.setCategory(c);
        yearPanel.setCategory(c);
        monthPanel.setCategory(c);
        busynessGraph.setCategory(c);
        if (currentPanel.getClass().equals(dayPanel.getClass())) {
            dayPanel.populateTable();
        } else if (currentPanel.getClass().equals(weekPanel.getClass())) {
            weekPanel.populateTable();
        } else if (currentPanel.getClass().equals(monthPanel.getClass())) {
            monthPanel.populateTable();
        } else if (currentPanel.getClass().equals(yearPanel.getClass())) {
            yearPanel.populateTable();
        } else if (currentPanel.getClass().equals(toDoPanel.getClass())) {
            toDoPanel.populateTable();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BusynessButton;
    private javax.swing.JPanel InternalPanel;
    private javax.swing.JButton addEvent;
    private javax.swing.JPanel catButtonPanel;
    private javax.swing.JButton dayButton;
    private javax.swing.Box.Filler filler2;
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
