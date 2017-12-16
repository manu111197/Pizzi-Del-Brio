package it.PrjPizziDelBrio.view;


import it.PrjPizziDelBrio.model.GestoreCatalogo;

import javax.swing.*;
import java.awt.*;

public class GestoreCatalogoFrame extends JFrame {
    private GestoreCatalogo g;
    public GestoreCatalogoFrame(GestoreCatalogo g){
        super("Finesta Gestore Catalogo");
        this.g=g;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-350 , (screenSize.height/2) - frameSize.height/2-150 );
        //NORTH
        JPanel nord = new JPanel();

        JLabel lblBenvenuto= new JLabel("Benvenuto gestore catalogo "+g.getNome()+"!");

        nord.add(lblBenvenuto);
        c.add(nord,BorderLayout.NORTH);

        this.setVisible(true);
        this.setSize(750,360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel sud=new JPanel();
        sud.setLayout(new FlowLayout());
        JButton btnlogout=new JButton("Logout");
        sud.add(btnlogout);
        JButton inserisciCategoria=new JButton("Inserisci categoria");
        sud.add(inserisciCategoria);

        c.add(sud, BorderLayout.SOUTH);




        //gestioneRichieste.addActionListener();
        // sud.add(gestioneRichieste);



    }
}

