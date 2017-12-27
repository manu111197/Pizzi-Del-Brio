package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.RegistrazioneListener;
import it.PrjPizziDelBrio.business.AmministratoreBusiness;
import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.model.Amministratore;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;
import it.PrjPizziDelBrio.model.Utente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestioneRichiesteFrame extends JFrame {
    private Amministratore a;
    private Utente u;
    public GestioneRichiesteFrame(Amministratore a){
        super("Finestra Gestione richieste");
        //this.a=a;
        //this.u=u;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        ArrayList<RichiestaRegistrazione> r= RichiestaRegistrazioneDAO.getInstance().findAll();
        GestioneRichiesteTableModel grt=new GestioneRichiesteTableModel(r);
        JTable richieste=new JTable(grt);
        c.add(new JScrollPane(richieste),BorderLayout.CENTER);



        GestioneRichiesteFrame _this=this;
        JPanel sud = new JPanel(new FlowLayout());
        JButton confermaRichieste=new JButton("Conferma");
        sud.add(confermaRichieste);
        confermaRichieste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int column = 2;
                int row = richieste.getSelectedRow();
                String email =(String) richieste.getModel().getValueAt(row, column);

                AmministratoreBusiness.getInstance().confermaRichiesta(email);
                _this.dispose();
                new GestioneRichiesteFrame(a);

            }
        });
        JButton negaRichieste=new JButton("Nega");
        sud.add(negaRichieste);
        negaRichieste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //AmministratoreBusiness.getInstance().negaRichiesta();
                int column = 2;
                int row = richieste.getSelectedRow();
                String email =(String) richieste.getModel().getValueAt(row, column);

                AmministratoreBusiness.getInstance().negaRichiesta(email);
                _this.dispose();
                new GestioneRichiesteFrame(a);
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
