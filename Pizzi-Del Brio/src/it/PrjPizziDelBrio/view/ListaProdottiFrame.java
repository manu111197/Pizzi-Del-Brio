package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.business.GestoreCatalogoBusiness;
import it.PrjPizziDelBrio.dao.mysql.ProdottoDAO;
import it.PrjPizziDelBrio.model.GestoreCatalogo;
import it.PrjPizziDelBrio.model.Prodotto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaProdottiFrame extends JFrame{
    private GestoreCatalogo g;
    public  ListaProdottiFrame(GestoreCatalogo g){
        super("Finestra Gestione Prodotti");
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<Prodotto> prod= ProdottoDAO.getInstance().findAll();
        ListaProdottiTableModel lptm=new ListaProdottiTableModel(prod);
        JTable prodotti=new JTable(lptm);
        c.add(new JScrollPane(prodotti),BorderLayout.CENTER);


        ListaProdottiFrame _this=this;
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
        JButton inserisciProdotto=new JButton("Inserisci prodotto");
        sud.add(inserisciProdotto);
        inserisciProdotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new ProdottoSetupFrame(g);
            }
        });

        JButton rimuoviProdotto=new JButton("Rimuovi prodotto");
        sud.add(rimuoviProdotto);
       rimuoviProdotto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column = 0;
                int row = prodotti.getSelectedRow();
                String nome =(String) prodotti.getModel().getValueAt(row, column);
                GestoreCatalogoBusiness.getInstance().rimuoviProdotti(nome);
                _this.setVisible(false);
                new ListaProdottiFrame(g);

            }
        });
        c.add(sud, BorderLayout.SOUTH);














        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-350 , (screenSize.height/2) - frameSize.height/2-150 );



        this.setVisible(true);
        this.setSize(750,360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}


