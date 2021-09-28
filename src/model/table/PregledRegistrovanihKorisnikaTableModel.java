/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clan;

/**
 *
 * @author boki
 */
public class PregledRegistrovanihKorisnikaTableModel extends AbstractTableModel {

    private static final String[] columnNames = {"Ime", "Prezime", "Nadimak"};
    private final List<Clan> clanovi;

    public PregledRegistrovanihKorisnikaTableModel(List<Clan> clanovi) {
        this.clanovi = clanovi;
    }

    @Override
    public int getRowCount() {
        return clanovi.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return clanovi.get(rowIndex).getIme();
            case 1:
                return clanovi.get(rowIndex).getPrezime();
            case 2:
                return clanovi.get(rowIndex).getNadimak();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

}
