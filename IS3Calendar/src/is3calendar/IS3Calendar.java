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

public class IS3Calendar {

    MainFrame mainFrame;
    CalendarEx cal;

    public IS3Calendar() {
        cal = new CalendarEx();
        cal.openCalendar("./cal");
        mainFrame = new MainFrame(cal);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IS3Calendar calendar = new IS3Calendar();
        calendar.mainFrame.setVisible(true);


    }
}
