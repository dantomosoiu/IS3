/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

/**
 *
 * @author Dan
 */
public class IS3Calendar {

    MainFrame mainFrame;

    public IS3Calendar() {
        mainFrame = new MainFrame();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        IS3Calendar calendar = new IS3Calendar();
        calendar.mainFrame.setVisible(true);


    }
}
