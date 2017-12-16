package it.PrjPizziDelBrio.view;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;


public class MyTableModel extends AbstractTableModel {

    private ArrayList<MyTableRow> model;

    public MyTableModel(ArrayList<MyTableRow> model) {
        this.model = model;
    }

    @Override
    public int getRowCount() {
        return model.size();
    }

    @Override
    public int getColumnCount() {
        return MyTableRow.class.getFields().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0) return model.get(rowIndex).id;
        if(columnIndex==1) return model.get(rowIndex).nome;
        return model.get(rowIndex).ok;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if(columnIndex==0) model.get(rowIndex).id = Integer.valueOf(value.toString());
        if(columnIndex==1) model.get(rowIndex).nome = value.toString();
        if(columnIndex==2) model.get(rowIndex).ok = Boolean.valueOf(value.toString());
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col!=0;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        if(columnIndex == 0) return Integer.class;
        if(columnIndex == 1) return String.class;
        if(columnIndex == 2) return Boolean.class;
        return String.class;
    }

    public class MyTableRow {
        public int id;
        public String nome;
        public boolean ok;

        public MyTableRow(int id, String nome, boolean ok) {
            this.id = id;
            this.nome = nome;
            this.ok = ok;
        }
    }
}
