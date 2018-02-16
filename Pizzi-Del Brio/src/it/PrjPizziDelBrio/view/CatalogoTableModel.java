package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.Prodotto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CatalogoTableModel extends AbstractTableModel {
    private ArrayList<Prodotto> Prodotti;
    public CatalogoTableModel(ArrayList<Prodotto> Prodotti) { this.Prodotti=Prodotti;}

    String[] columnsNames = new String[] {"Nome","Prezzo","Categoria"};
    @Override
    public String getColumnName(int columnIndex){
        return columnsNames[columnIndex];
    }
    @Override
    public int getRowCount() {
        return Prodotti.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodotto p=Prodotti.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.getNome();
            case 1: return p.getPrezzo();
            case 2: return p.getCategoria().getNome();
            default: return null;
        }
    }
}
