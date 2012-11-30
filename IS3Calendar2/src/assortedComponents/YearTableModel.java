/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assortedComponents;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hector
 */
public final class YearTableModel extends AbstractTableModel {

    YearCell[][] cell;

    public YearTableModel(YearCell[][] c) {
        cell = c;
        for (int i = 0; i < this.getColumnCount(); i++) {
            for (int j = 0; j < this.getRowCount(); j++) {
                this.setValueAt(cell[j][i], j, i);
            }
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return YearCell.class;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return "";
    }

    @Override
    public int getRowCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return cell[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) {
        return false;
    }
}
