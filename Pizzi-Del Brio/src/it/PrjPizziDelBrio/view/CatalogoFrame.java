package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.CatalogoListener;
import it.PrjPizziDelBrio.dao.mysql.ProdottoDAO;
import it.PrjPizziDelBrio.model.Carrello;
import it.PrjPizziDelBrio.model.Prodotto;
import it.PrjPizziDelBrio.model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CatalogoFrame extends JFrame {
    private Utente u;
    public CatalogoFrame(Utente u){
        super("Finestra Visione Catalogo");
        this.u=u;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<Prodotto> prod= ProdottoDAO.getInstance().findAll();
        CatalogoTableModel ctm=new CatalogoTableModel(prod);
        JTable prodotti=new JTable(ctm);
        c.add(new JScrollPane(prodotti),BorderLayout.CENTER);


        CatalogoListener listener=new CatalogoListener(this,u);
        JMenuBar bar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu move = new JMenu("Move");
        move.add(new JMenuItem("Up"));
        move.add(new JMenuItem("Down"));
        bar.add(file);
        bar.add(edit);
        edit.add(move);
        JMenuItem random = new JMenuItem("Random");
        edit.add(random);
        random.addActionListener(listener);
        random.setActionCommand("RANDOM_MENU_ITEM");

        setJMenuBar(bar);


        CatalogoFrame _this=this;
        JPanel sud=new JPanel(new FlowLayout());
        JButton paniere=new JButton("Gestione Panieri");
        sud.add(paniere);


        JButton carrello=new JButton("Carrello");
        sud.add(carrello);



        JButton info=new JButton("Visualizza Info Prodotti");
        sud.add(info);
        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column=3;
                int row=prodotti.getSelectedRow();
                

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
