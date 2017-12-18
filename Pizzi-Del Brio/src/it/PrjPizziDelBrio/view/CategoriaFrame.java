package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.dao.mysql.CategoriaDAO;
import it.PrjPizziDelBrio.model.Categoria;
import it.PrjPizziDelBrio.model.GestoreCatalogo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CategoriaFrame extends JFrame {
    private GestoreCatalogo g;
    public CategoriaFrame(GestoreCatalogo g){
        super("Categoria setup");
        this.g=g;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<Categoria> cat= CategoriaDAO.getInstance().findAll();
        CategoriaTableModel ctm=new CategoriaTableModel(cat);
        JTable categoria=new JTable(ctm);
        c.add(new JScrollPane(categoria),BorderLayout.CENTER);



    }

}
