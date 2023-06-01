/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelLomba extends AbstractTableModel {
    List<Lomba> p;
    
    public ModelLomba(List<Lomba> p ) {
        this.p = p;
    }
    @Override
    public int getRowCount() {
        return p.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col) {
            case 0: return "Judul";
            case 1: return "Alur";
            case 2: return "Orisinalitas";
            case 3: return "PemilihanKata";
            case 4: return "Nilai";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col) {
            case 0: return p.get(row).getjudul();
            case 1: return p.get(row).getalur();
            case 2: return p.get(row).getoriginalitas();
            case 3: return p.get(row).getpemilihankata();
            case 4: return p.get(row).getnilai();
            default: return null;
        }
    }
    
}
