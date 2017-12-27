package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.dao.mysql.UtenteDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Amministratore;
import it.PrjPizziDelBrio.model.Utente;

public class AmministratoreBusiness  {
    private static AmministratoreBusiness instance;

    public static AmministratoreBusiness getInstance(){
        if (instance == null)
            instance = new AmministratoreBusiness();
        return instance;
    }
    public void confermaRichiesta(String email){
        RichiestaRegistrazioneDAO.getInstance().changeStato(email,"confermata");



    }
    public void negaRichiesta(String email){
        RichiestaRegistrazioneDAO.getInstance().changeStato(email,"negata");

    }
}
