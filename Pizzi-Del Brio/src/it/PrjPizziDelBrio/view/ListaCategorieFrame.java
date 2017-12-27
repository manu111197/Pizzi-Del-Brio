package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.dao.mysql.CategoriaDAO;
import it.PrjPizziDelBrio.model.Categoria;
import it.PrjPizziDelBrio.model.GestoreCatalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaCategorieFrame extends JFrame {
    private GestoreCatalogo g;
    public  ListaCategorieFrame(GestoreCatalogo g){
        super("Finestra Gestione Categorie");
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<Categoria> cat= CategoriaDAO.getInstance().findAll();
        ListaCategorieTableModel lctm=new ListaCategorieTableModel(cat);
        JTable categorie=new JTable(lctm);
         c.add(new JScrollPane(categorie),BorderLayout.CENTER);


         ListaCategorieFrame _this=this;
         JPanel sud=new JPanel(new FlowLayout());
         JButton indietro=new JButton("Indietro");
         sud.add(indietro);
         indietro.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 _this.setVisible(false);
                 new GestoreCatalogoFrame(g);

             }
         });
        JButton inserisciCategoria=new JButton("Inserisci categoria");
        sud.add(inserisciCategoria);
        inserisciCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new CategoriaSetupFrame(g);
            }
        });
        /*JButton rimuoviCategoria=new JButton("Rimuovi categoria");
        sud.add(rimuoviCategoria);
        rimuoviCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rigaselezionata = categorie.getSelectedRow();
            }
        });*/
        c.add(sud, BorderLayout.SOUTH);














        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-350 , (screenSize.height/2) - frameSize.height/2-150 );



        this.setVisible(true);
        this.setSize(750,360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
