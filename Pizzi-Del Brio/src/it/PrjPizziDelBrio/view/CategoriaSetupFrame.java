package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.CategoriaListener;
import it.PrjPizziDelBrio.business.GestoreCatalogoBusiness;
import it.PrjPizziDelBrio.dao.mysql.GestoreCatalogoDAO;
import it.PrjPizziDelBrio.model.GestoreCatalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaSetupFrame extends JFrame {
    private GestoreCatalogo g;
    private JTextField txtNome= new JTextField();
    public CategoriaSetupFrame(GestoreCatalogo g) {
        super("Finestra Categoria setup");
        this.g = g;
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width / 2) - frameSize.width / 2 - 200, (screenSize.height / 2) - frameSize.height / 2 - 50);


        CategoriaListener listener = new CategoriaListener(this, g);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(1, 2));
        JLabel lblNome = new JLabel("Nome Categoria:");
        centro.add(lblNome);
        centro.add(txtNome);
        txtNome.addActionListener(listener);


        CategoriaSetupFrame _this=this;
        JPanel sud=new JPanel();
        sud.setLayout(new FlowLayout());
        JButton agc=new JButton("Aggiungi Categoria");
        sud.add(agc);
        agc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                _this.setVisible(false);
                GestoreCatalogoBusiness.getInstance().inserimentoCategorie(txtNome.getText(),g.getEmail());
                new ListaCategorieFrame(g);
            }
        });

        JButton annulla=new JButton("Annulla");
        sud.add(annulla);
        annulla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new ListaCategorieFrame(g);
            }
        });
        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);








        setSize(400, 100);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
