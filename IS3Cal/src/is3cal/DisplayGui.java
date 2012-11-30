/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3cal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author 1007414g
 */
public class DisplayGui {
    private JPanel contentPane;
    private Dayview DayView;
    
    

    private void displayGUI()
    {
        JFrame frame = new JFrame("IS3Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        DayView = new Dayview(contentPane);
        contentPane.add(DayView, "Day View");
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new DisplayGui().displayGUI();
            }
        });
    }
}
