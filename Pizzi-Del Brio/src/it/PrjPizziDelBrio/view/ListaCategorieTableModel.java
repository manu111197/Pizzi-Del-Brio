package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.Categoria;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ListaCategorieTableModel extends AbstractTableModel {

    private ArrayList<Categoria> Categorie;
    public ListaCategorieTableModel(ArrayList<Categoria> Categorie) { this.Categorie=Categorie;}

    String[] columnsNames = new String[] {"Categoria","Gestore Catalogo"};

    @Override
    public String getColumnName(int columnIndex){
        return columnsNames[columnIndex];
    }
    @Override
    public int getRowCount() {return Categorie.size(); }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria c=Categorie.get(rowIndex);
        switch(columnIndex) {
            case 0: return c.getNome();
            case 1:return c.getGestoreCatalogo().getEmail();
            default: return null;
        }

    }
   // JScrollPane jsp = new JScrollPane();
}



