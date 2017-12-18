package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;

public class RichiestaRegistrazioneBusiness {
    private static RichiestaRegistrazioneBusiness instance;

    public static RichiestaRegistrazioneBusiness getInstance(){
        if (instance == null)
            instance = new RichiestaRegistrazioneBusiness();
        return instance;
    }
    public void inserimentoRichieste(String utEmail, String ammEmail){
         RichiestaRegistrazioneDAO.getInstance().inserimentoRichieste(utEmail,ammEmail);

    }



    }
