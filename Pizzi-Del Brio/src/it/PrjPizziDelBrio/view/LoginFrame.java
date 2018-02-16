package it.PrjPizziDelBrio.view;

import it.PrjPizziDelBrio.ActionListeners.LoginListener;
import it.PrjPizziDelBrio.model.Utente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private JTextField txtEmail = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();
    private Utente u;


    public LoginFrame() {
        super("Finestra Login");
        Container c = getContentPane();



        Dimension screenSize = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = this.getSize ();
        this.setLocation ((screenSize.width/2) - frameSize.width/2-250 , (screenSize.height/2) - frameSize.height/2-100 );
        /*
        c.add(new JLabel("Buona lezione"));
        c.add(new JButton(("Cliccami")));
        */

        //c.setLayout(new FlowLayout());

        /*
        c.setLayout(new GridLayout(4,4));
        for(int i=0;i<10;i++)
            c.add(new JButton(String.valueOf(i)));
        */

        /*
        c.setLayout(new BorderLayout());
        c.add(new JLabel("Buona lezione"), BorderLayout.NORTH);
        c.add(new JButton(("Cliccami")), BorderLayout.SOUTH);
        c.add(new JTextField(), BorderLayout.CENTER);
        c.add(new JPasswordField(), BorderLayout.CENTER);
        */

        c.setLayout(new BorderLayout());

        LoginListener listener = new LoginListener(this);

        JPanel centro = new JPanel();
            centro.setLayout(new GridLayout(2,2));
            JLabel lblEmail = new JLabel("Email:");
            JLabel lblPassword = new JLabel("Password:");
            centro.add(lblEmail);
            centro.add(txtEmail);
            centro.add(lblPassword);
            centro.add(txtPassword);
            txtEmail.addActionListener(listener);
            txtPassword.addActionListener(listener);

        JPanel sud = new JPanel();
            sud.setLayout(new FlowLayout());
            sud.add(new JLabel("Benvenuto!"));
            JButton btnLogin = new JButton(("LOGIN"));
            btnLogin.addActionListener(listener);
            sud.add(btnLogin);

        c.add(centro, BorderLayout.CENTER);
        c.add(sud, BorderLayout.SOUTH);

        /*JMenuBar bar = new JMenuBar();
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

        setJMenuBar(bar);*/


        LoginFrame _this= this;
        JButton registrazione= new JButton("Registrati");
        sud.add(registrazione);
        registrazione.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _this.setVisible(false);
                new RegistrazioneFrame(u);
            }
        });


        setSize(500,130);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }


}
