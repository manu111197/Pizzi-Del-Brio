package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.RichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.dao.mysql.UtenteDAO;
import it.PrjPizziDelBrio.model.Persona;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;
import it.PrjPizziDelBrio.model.Utente;

public class UtenteBusiness {
    private static UtenteBusiness instance;

    public static UtenteBusiness getInstance(){
        if (instance == null)
            instance = new UtenteBusiness();
        return instance;
    }

    public boolean isRegistrato(Utente u){

        try {
            //RichiestaRegistrazione a =RichiestaRegistrazioneDAO.getInstance().findByUtente(u.getEmail());
            return RichiestaRegistrazioneDAO.getInstance().findByUtente(u.getEmail()).getStato().equals("confermata");
        } catch (NullPointerException e){
            return false;
        }

    }
    public void inserimentoUtenti(String email,byte[] password,String nome,String cognome,String indirizzo,String cellulare){

        if(UtenteDAO.getInstance().findByEmail(email)==null)
        UtenteDAO.getInstance().inserimentoUtenti(email,password,nome,cognome,indirizzo,cellulare);

    }

}
