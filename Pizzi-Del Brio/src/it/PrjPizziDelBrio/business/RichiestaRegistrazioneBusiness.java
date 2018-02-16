package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

public class RichiestaRegistrazioneBusiness {
    private static RichiestaRegistrazioneBusiness instance;

    public static RichiestaRegistrazioneBusiness getInstance(){
        if (instance == null)
            instance = new RichiestaRegistrazioneBusiness();
        return instance;
    }
    public void inserimentoRichieste(String utEmail, String ammEmail){
        if(RichiestaRegistrazioneDAO.getInstance().findByUtente(utEmail)==null|| !RichiestaRegistrazioneDAO.getInstance().findByUtente(utEmail).getStato().equals("confermata")) {
            RichiestaRegistrazioneDAO.getInstance().inserimentoRichieste(utEmail, ammEmail);
            JOptionPane.showMessageDialog(null, "Registrazione inviata.");
        }
        else JOptionPane.showMessageDialog(null,"L'utente è già registrato");
    }



    }
