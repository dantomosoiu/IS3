/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package is3calendar;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author hector
 */
public class MonthTableModel extends AbstractTableModel {
  MonthCell[][] cell;
  int size;
 
  public MonthTableModel(MonthCell[][] c, int s) {
    cell = c;
    size = s;
    for (int i=0;i<this.getColumnCount();i++) {
        for (int j=0;j<this.getRowCount();j++) {
            this.setValueAt(cell[j][i], j, i);
        }
    }
  }
 
    public Class getColumnClass(int columnIndex) { return MonthCell.class; }
    public int getColumnCount() { return 7; }
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
        }
        return "";
    }
    @Override
    public int getRowCount() { return size; }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { return cell[rowIndex][columnIndex]; }
    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) { return false; }
}
