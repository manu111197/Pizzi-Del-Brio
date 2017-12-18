package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.model.Amministratore;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmministratoreFrame extends JFrame {
    private Amministratore a;
    public AmministratoreFrame(Amministratore a){
        super("Finesta Amministratore");
        this.a=a;
        Container c=getContentPane();
        c.setLayout(new BorderLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-350 , (screenSize.height/2) - frameSize.height/2-150 );
        //NORTH
        JPanel nord = new JPanel();

        JLabel lblBenvenuto= new JLabel("Benvenuto amministratore "+a.getNome()+"!");

        nord.add(lblBenvenuto);
        c.add(nord,BorderLayout.NORTH);


        AmministratoreFrame _this = this;
        JPanel sud=new JPanel();
        sud.setLayout(new FlowLayout());
        JButton btnlogout=new JButton("Logout");
        sud.add(btnlogout);
        btnlogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new LoginFrame();


            }
        });
        JButton gestioneRichieste=new JButton("Gestione richieste");
        sud.add(gestioneRichieste);
        gestioneRichieste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new GestioneRichiesteFrame(a);

            }
        });





        c.add(sud, BorderLayout.SOUTH);




        this.setVisible(true);
        this.setSize(750,360);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //gestioneRichieste.addActionListener();
       // sud.add(gestioneRichieste);



    }
}
