package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.RichiestaRegistrazione;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class GestioneRichiesteTableModel extends AbstractTableModel {
    private ArrayList<RichiestaRegistrazione> RichiestaRegistrazioni;
    public GestioneRichiesteTableModel(ArrayList<RichiestaRegistrazione> RichiestaRegistrazioni) {

        this.RichiestaRegistrazioni=RichiestaRegistrazioni;}
        private JPanel jpC = new JPanel();
        private JPanel jpE = new JPanel();
        String[] columnsNames = new String[] { "ID Richiesta", "Stato Registrazione", "Utente email", "Amministratore email"};

        @Override
        public String getColumnName(int columnIndex){
            return columnsNames[columnIndex];
        }
        @Override
        public int getRowCount() {return RichiestaRegistrazioni.size(); }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RichiestaRegistrazione r=RichiestaRegistrazioni.get(rowIndex);
            switch(columnIndex) {
                case 0: return r.getId();
                case 1: return r.getStato();
                case 2: return r.getUtente().getEmail();
                case 3: return r.getAmministratore().getEmail();
                default: return null;
            }
        }
        //JScrollPane jsp = new JScrollPane();
    }
