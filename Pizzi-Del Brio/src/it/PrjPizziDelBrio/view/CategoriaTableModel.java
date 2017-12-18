package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.Categoria;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CategoriaTableModel extends AbstractTableModel {

    private ArrayList<Categoria> Categoria;
    public CategoriaTableModel(ArrayList<Categoria> Categoria) {

        this.Categoria=Categoria;}

    String[] columnsNames = new String[] {"Nome"};

    @Override
    public String getColumnName(int columnIndex){
        return columnsNames[columnIndex];
    }
    @Override
    public int getRowCount() {return Categoria.size(); }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria c=Categoria.get(rowIndex);
        switch(columnIndex) {
            case 0: return c.getNome();
            default: return null;
        }
    }
    //JScrollPane jsp = new JScrollPane();
}



