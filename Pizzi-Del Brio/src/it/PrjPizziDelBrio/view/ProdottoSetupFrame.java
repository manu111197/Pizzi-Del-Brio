package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.ProdottoListener;
import it.PrjPizziDelBrio.business.CarrelloBusiness;
import it.PrjPizziDelBrio.business.GestoreCatalogoBusiness;
import it.PrjPizziDelBrio.model.Carrello;
import it.PrjPizziDelBrio.model.GestoreCatalogo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdottoSetupFrame extends JFrame {
    private GestoreCatalogo g;
    private JTextField txtNome= new JTextField();
    private JTextField txtDescrzione= new JTextField();
    private JTextField txtPrezzo= new JTextField();
    private JTextField txtImmagine=new JTextField();
    private JTextField txtSconto=new JTextField();

    private JTextField txtCategoria=new JTextField();
    private JTextField txtidProduttore= new JTextField();
    private JTextField txtidDistributore= new JTextField();

    public ProdottoSetupFrame(GestoreCatalogo g) {
        super("Finestra Prodotto setup");
        this.g = g;
        Container c = getContentPane();
        c.setLayout(new BorderLayout());



        ProdottoListener listener = new ProdottoListener(this, g);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(8, 2));
        JLabel lblNome = new JLabel("Nome Prodotto:");
        JLabel lblDescrizione = new JLabel("Descrizione:");
        JLabel lblPrezzo = new JLabel("Prezzo:");
        JLabel lblImmagine=new JLabel("Url immagine");
        JLabel lblSconto=new JLabel("Sconto eventuale:");
        JLabel lblCategoria=new JLabel("Categoria:");
        JLabel lblidProduttore = new JLabel("Prodottore:");
        JLabel lblidDistributore = new JLabel("Distributore:");

        centro.add(lblNome);
        centro.add(txtNome);
        centro.add(lblDescrizione);
        centro.add(txtDescrzione);
        centro.add(lblPrezzo);
        centro.add(txtPrezzo);
        centro.add(lblImmagine);
        centro.add(txtImmagine);
        centro.add(lblSconto);
        centro.add(txtSconto);
        centro.add(lblCategoria);
        centro.add(txtCategoria);
        centro.add(lblidProduttore);
        centro.add(txtidProduttore);
        centro.add(lblidDistributore);
        centro.add(txtidDistributore);
        txtNome.addActionListener(listener);
        txtDescrzione.addActionListener(listener);
        txtPrezzo.addActionListener(listener);
        txtImmagine.addActionListener(listener);
        txtSconto.addActionListener(listener);
        txtCategoria.addActionListener(listener);
        txtidProduttore.addActionListener(listener);
        txtidDistributore.addActionListener(listener);


        ProdottoSetupFrame _this=this;
        JPanel sud=new JPanel();
        sud.setLayout(new FlowLayout());
        JButton agp=new JButton("Aggiungi Prodotto");
        sud.add(agp);
        agp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                _this.setVisible(false);

               GestoreCatalogoBusiness.getInstance().inserimentoProdotti(txtNome.getText(),txtDescrzione.getText(),txtPrezzo.getText(),txtImmagine.getText(),txtSconto.getText(),txtCategoria.getText(), Integer.parseInt(txtidProduttore.getText()),Integer.parseInt(txtidDistributore.getText()));
                new ListaProdottiFrame(g);
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
        JButton visualizzaProdotti=new JButton("Visualizza Prodotti");
        sud.add(visualizzaProdotti);
        visualizzaProdotti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            _this.setVisible(false);
            new ListaProdottiFrame(g);
            }
        });
        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);






        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width / 2) - frameSize.width / 2 - 200, (screenSize.height / 2) - frameSize.height / 2 - 50);


        setSize(500, 300);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


}
