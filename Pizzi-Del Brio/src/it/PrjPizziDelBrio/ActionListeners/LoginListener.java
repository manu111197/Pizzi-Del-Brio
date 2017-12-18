package it.PrjPizziDelBrio.ActionListeners;

import it.PrjPizziDelBrio.business.PersonaBusiness;

import it.PrjPizziDelBrio.business.UtenteBusiness;
import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.model.Amministratore;
import it.PrjPizziDelBrio.model.GestoreCatalogo;
import it.PrjPizziDelBrio.model.Persona;

import it.PrjPizziDelBrio.model.Utente;
import it.PrjPizziDelBrio.view.AmministratoreFrame;
import it.PrjPizziDelBrio.view.GestoreCatalogoFrame;
import it.PrjPizziDelBrio.view.LoginFrame;
import it.PrjPizziDelBrio.view.RegistrazioneFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginListener implements ActionListener {

    private LoginFrame finestra;

    public LoginListener(LoginFrame finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Evento catturato!");

        if("RANDOM_MENU_ITEM".equals(e.getActionCommand())) {
            JOptionPane.showMessageDialog(null,"Hai premuto la voce di menu random");
        }
        if(e.getSource() instanceof JButton
                || e.getSource() instanceof JTextField
                || e.getSource() instanceof  JPasswordField) {

            //String username = "mario.rossi";
            //byte[] password = "Passw0rd1".getBytes();

            String email = finestra.getTxtEmail().getText();
            byte[] password = new String(finestra.getTxtPassword().getPassword()).getBytes();

            Persona p = PersonaBusiness.getInstance().login(email, password);


                if (p != null) {
                    System.out.println("LOGIN OK!");
                    if (p instanceof Utente ) {

                        //apriremo la view dell'utente
                        //finestra.setVisible(false);
                        Utente u = (Utente) p;
                        if(UtenteBusiness.getInstance().isRegistrato(u)) {
                            System.out.println("Benvenuto utente " + u.getNome() + " " + u.getCognome() + "!");
                            JOptionPane.showMessageDialog(null, "Benvenuto utente " + u.getNome() + " " + u.getCognome() + "!");
                        }else
                            JOptionPane.showMessageDialog(null, "Utente non registrato");


                    } else if (p instanceof Amministratore) {
                        //apriremo la view dell'amministratore
                        //finestra.setVisible(false);
                        Amministratore a = (Amministratore) p;
                        System.out.println("Benvenuto amministratore " + a.getNome() + " " + a.getCognome() + "!");
                //        JOptionPane.showMessageDialog(null,"Benvenuto amministratore " + a.getNome() + " " + a.getCognome() + "!");
                        finestra.setVisible(false);
                        new AmministratoreFrame(a);


                    } else if (p instanceof GestoreCatalogo) {
                        //apriremo la view del gestore catalogo
                        //finestra.setVisible(false);
                        GestoreCatalogo g = (GestoreCatalogo) p;
                        System.out.println("Benvenuto gestore catalogo " + g.getNome() + " " + g.getCognome() + "!");
                        //JOptionPane.showMessageDialog(null,"Benvenuto gestore catalogo " + g.getNome() + " " + g.getCognome() + "!");
                        finestra.setVisible(false);
                        new GestoreCatalogoFrame(g);
                    }


                }else {
                    System.out.println("Il login non è andato a buon fine..");
                }

            }

        }
    }

