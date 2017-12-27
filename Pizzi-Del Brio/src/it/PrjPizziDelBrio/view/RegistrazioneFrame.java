package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.LoginListener;
import it.PrjPizziDelBrio.ActionListeners.RegistrazioneListener;
import it.PrjPizziDelBrio.business.RichiestaRegistrazioneBusiness;
import it.PrjPizziDelBrio.business.UtenteBusiness;
import it.PrjPizziDelBrio.model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneFrame extends JFrame {

    private JTextField txtEmail = new JTextField();
    private JTextField txtPassword = new JTextField();
    private JTextField txtNome= new JTextField();
    private JTextField txtCognome = new JTextField();
    private JTextField txtIndirizzo = new JTextField();
    private JTextField txtCellulare= new JTextField();
    private Utente u;
    public RegistrazioneFrame(Utente u){
        super("Finestra registrazione");
        this.u=u;
        Container c=getContentPane();

        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-250 , (screenSize.height/2) - frameSize.height/2-100 );

        c.setLayout(new BorderLayout());




        RegistrazioneListener listener = new RegistrazioneListener(this,u);
        JPanel centro = new JPanel();
        centro.setLayout(new GridLayout(6,2));
        JLabel lblEmail = new JLabel("Email:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblNome= new JLabel("Nome:");
        JLabel lblCognome= new JLabel("Cognome:");
        JLabel lblIndirizzo=new JLabel("Indirizzo:");
        JLabel lblCellulare=new JLabel("Cellulare:");
        centro.add(lblEmail);
        centro.add(txtEmail);
        centro.add(lblPassword);
        centro.add(txtPassword);
        centro.add(lblNome);
        centro.add(txtNome);
        centro.add(lblCognome);
        centro.add(txtCognome);
        centro.add(lblIndirizzo);
        centro.add(txtIndirizzo);
        centro.add(lblCellulare);
        centro.add(txtCellulare);
        txtEmail.addActionListener(listener);
        txtPassword.addActionListener(listener);
        txtNome.addActionListener(listener);
        txtCognome.addActionListener(listener);
        txtIndirizzo.addActionListener(listener);
        txtCellulare.addActionListener(listener);




      RegistrazioneFrame _this = this;
        JPanel sud=new JPanel();
        sud.setLayout(new FlowLayout());
        JButton btnIndietro=new JButton("Indietro");
        sud.add(btnIndietro);
        btnIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new LoginFrame();


            }
        });

        JButton btnIscriviti=new JButton("Iscriviti");
        sud.add(btnIscriviti);
        btnIscriviti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                _this.setVisible(false);
                UtenteBusiness.getInstance().inserimentoUtenti(txtEmail.getText(),txtPassword.getText().getBytes(),txtNome.getText(),txtCognome.getText(),txtIndirizzo.getText(),txtCellulare.getText());
                RichiestaRegistrazioneBusiness.getInstance().inserimentoRichieste(txtEmail.getText(),"m");

                new LoginFrame();
                }
        });

        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);













        setSize(500,250);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
