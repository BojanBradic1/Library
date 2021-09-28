/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clan;
import model.Pisac;

/**
 *
 * @author boki
 */
public class ListaPisacaTableModel extends AbstractTableModel {

    private static final String[] columnNames = {"Ime", "Prezime"};
    private final List<Pisac> pisci;

    public ListaPisacaTableModel(List<Pisac> pisci) {
        this.pisci = pisci;
    }

    @Override
    public int getRowCount() {
        return pisci.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return pisci.get(rowIndex).getIme();
            case 1:
                return pisci.get(rowIndex).getPrezime();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
