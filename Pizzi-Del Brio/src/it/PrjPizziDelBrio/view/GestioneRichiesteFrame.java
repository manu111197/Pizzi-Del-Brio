package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.model.Amministratore;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GestioneRichiesteFrame extends JFrame {
    private Amministratore a;
    public GestioneRichiesteFrame(Amministratore a){
        super("Finestra Gestione richieste");
        this.a=a;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<RichiestaRegistrazione> r= RichiestaRegistrazioneDAO.getInstance().findAll();
        GestioneRichiesteTableModel grt=new GestioneRichiesteTableModel(r);
        JTable richieste=new JTable(grt);
        c.add(new JScrollPane(richieste),BorderLayout.CENTER);







        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-350 , (screenSize.height/2) - frameSize.height/2-150 );








        this.setVisible(true);
        this.setSize(750,360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
