/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Clan;
import model.IznajmljenaKnjiga;
import model.Knjiga;
import model.Pisac;

/**
 *
 * @author boki
 */
public class IznajmljeneKnjigeTableModel extends AbstractTableModel {

    private static final String[] columnNames = {"Naslov knjige", "Ime clana", "Prezime clana", "Autor", "Zanr"};
    private final List<IznajmljenaKnjiga> knjige;

    public IznajmljeneKnjigeTableModel(List<IznajmljenaKnjiga> knjige) {
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
        Knjiga knjiga = knjige.get(rowIndex).getKnjiga();
        Pisac pisac = knjiga.getPisac();
        Clan clan = knjige.get(rowIndex).getClan();
        switch (columnIndex) {
            case 0:
                return knjiga.getNaslov();
            case 1:
                return clan.getIme();
            case 2:
                return clan.getPrezime();
            case 3:
                return pisac.getIme() + " " + pisac.getPrezime();
            case 4:
                return knjiga.getKategorija().getNaziv();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public IznajmljenaKnjiga vratiSelektovanuKnjigu(int index) {
        return knjige.get(index);
    }
}
