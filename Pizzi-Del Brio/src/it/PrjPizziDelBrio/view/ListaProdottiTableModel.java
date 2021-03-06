package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.Prodotto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ListaProdottiTableModel extends AbstractTableModel {
    private ArrayList<Prodotto> Prodotti;
    public ListaProdottiTableModel(ArrayList<Prodotto> Prodotti) { this.Prodotti=Prodotti;}

    String[] columnsNames = new String[] {"Nome","Descrizione","Prezzo","Url Immagine","Sconto","Categoria","Id Distributore","Id Produttore"};
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
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prodotto p=Prodotti.get(rowIndex);
        switch(columnIndex) {
            case 0: return p.getNome();
            case 1: return p.getDescrizione();
            case 2: return "€"+p.getPrezzo();
            case 3: return p.getImmagine();
            case 4: return p.getSconto()+"%";
            case 5: return p.getCategoria().getNome();
            case 6: return p.getDistributore().getId();
            case 7: return p.getProduttore().getId();
            default: return null;
        }
    }
}
