/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assortedComponents;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hector
 */
public class MonthCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        MonthCell feed = (MonthCell) value;


        MonthCell panel = feed;

        return panel;
    }
}
