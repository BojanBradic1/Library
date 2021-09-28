/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clan;
import model.Knjiga;

/**
 *
 * @author boki
 */
public class PregledKnjigaTableModel extends AbstractTableModel {

    private static final String[] columnNames = {"Naziv", "Ime Pisca", "Prezime Pisca", "Zanr"};
    private final List<Knjiga> knjige;

    public PregledKnjigaTableModel(List<Knjiga> knjige) {
        this.knjige = knjige;
    }

    @Override
    public int getRowCount() {
        return knjige.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return knjige.get(rowIndex).getNaslov();
            case 1:
                return knjige.get(rowIndex).getPisac().getIme();
            case 2:
                return knjige.get(rowIndex).getPisac().getPrezime();
            case 3:
                return knjige.get(rowIndex).getKategorija().getNaziv();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public Knjiga vratiKnjiguPodIndexom(int index){
        return this.knjige.get(index);
    }
}
