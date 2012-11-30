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
public class YearCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        YearCell feed = (YearCell) value;


        YearCell panel = feed;

        return panel;
    }
}
