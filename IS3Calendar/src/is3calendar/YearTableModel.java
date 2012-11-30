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
public class YearTableModel extends AbstractTableModel {
  YearCell[][] cell;
 
  public YearTableModel(YearCell[][] c) {
    cell = c;
    for (int i=0;i<this.getColumnCount();i++) {
        for (int j=0;j<this.getRowCount();j++) {
            this.setValueAt(cell[j][i], j, i);
        }
    }
  }
 
    public Class getColumnClass(int columnIndex) { return YearCell.class; }
    public int getColumnCount() { return 4; }
    public String getColumnName(int columnIndex) { return "";}
    @Override
    public int getRowCount() { return 3; }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) { return cell[rowIndex][columnIndex]; }
    @Override
    public boolean isCellEditable(int columnIndex, int rowIndex) { return false; }
}
