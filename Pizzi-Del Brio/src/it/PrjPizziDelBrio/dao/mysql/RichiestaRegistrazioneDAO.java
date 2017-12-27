package it.PrjPizziDelBrio.dao.mysql;


import it.PrjPizziDelBrio.dao.interfaces.IRichiestaRegistrazioneDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.RichiestaRegistrazione;



import java.util.ArrayList;
import java.util.Iterator;


public class RichiestaRegistrazioneDAO implements IRichiestaRegistrazioneDAO {
    //singleton desing pattern
    private static RichiestaRegistrazioneDAO instance;

    public  static RichiestaRegistrazioneDAO getInstance(){
        if(instance==null)
            instance=new RichiestaRegistrazioneDAO();
        return instance;
    }


    @Override
    public RichiestaRegistrazione findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Richiesta_registrazione WHERE idRichiesta_registazione" + id );

        if (risultato.size() == 0) return null;

        RichiestaRegistrazione r = new RichiestaRegistrazione();

        String[] riga = risultato.get(0);
        r.setId(Integer.parseInt(riga[0]));
        r.setStato(riga[1]);
        r.setUtente(UtenteDAO.getInstance().findByEmail(riga[2]));
        r.setAmministratore(AmministratoreDAO.getInstance().findByEmail(riga[3]));

        return r;

    }

    @Override
    public RichiestaRegistrazione findByUtente(String email) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM richiesta_registrazione WHERE Utente_email ='" + email + "';" );

        if (risultato.size() == 0) return null;

        RichiestaRegistrazione r = new RichiestaRegistrazione();

        String[] riga = risultato.get(0);
        r.setId(Integer.parseInt(riga[0]));
        r.setStato(riga[1]);
        r.setUtente(UtenteDAO.getInstance().findByEmail(riga[2]));
        r.setAmministratore(AmministratoreDAO.getInstance().findByEmail(riga[3]));

        return r;    }


    @Override
    public ArrayList<RichiestaRegistrazione> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Richiesta_registrazione");

        ArrayList<RichiestaRegistrazione> listaRichiestaRegistrazioni = new ArrayList<RichiestaRegistrazione>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            RichiestaRegistrazione r = new RichiestaRegistrazione();
            r.setId(Integer.parseInt(riga[0]));
            r.setStato(riga[1]);
            r.setUtente(UtenteDAO.getInstance().findByEmail(riga[2]));
            r.setAmministratore(AmministratoreDAO.getInstance().findByEmail(riga[3]));

            listaRichiestaRegistrazioni.add(r);

        }
        return listaRichiestaRegistrazioni;
    }
     public void inserimentoRichieste(String utEmail, String ammEmail){

        DbConnection.getInstance().eseguiAggiornamento("INSERT INTO richiesta_registrazione (stato_registrazione,Utente_email,Amministratore_email) " +
                "VALUES ('Pending','"+utEmail+"','"+ammEmail+"');");

    }


   public void changeStato(String email,String stato){

       DbConnection.getInstance().eseguiAggiornamento("UPDATE richiesta_registrazione SET stato_registrazione = '"+stato+"' WHERE Utente_email='"+email+"';");
   }

}






