package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IIndicazioneConsegnaDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.IndicazioneConsegna;

import java.util.ArrayList;
import java.util.Iterator;

public class IndicazioneConsegnaDAO implements IIndicazioneConsegnaDAO {
    //singleton desing pattern
    private static IndicazioneConsegnaDAO instance;

    public  static IndicazioneConsegnaDAO getInstance(){
        if(instance==null)
            instance=new IndicazioneConsegnaDAO();
        return instance;
    }


    @Override
    public IndicazioneConsegna findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM IndicazioneConsegna WHERE idIndicazioneConsegna" + id );

        if (risultato.size() == 0) return null;

      IndicazioneConsegna i = new IndicazioneConsegna();

        String[] riga = risultato.get(0);
        i.setId(Integer.parseInt(riga[0]));
        i.setIndirizzo(riga[1]);
        i.setNominativo(riga[2]);
        i.setUtente(UtenteDAO.getInstance().findByEmail(riga[3]));

        return i;


    }

    @Override
    public ArrayList<IndicazioneConsegna> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM IndicazioneConsegna");

        ArrayList<IndicazioneConsegna> listaIndicazioniConsegna= new ArrayList<IndicazioneConsegna>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            IndicazioneConsegna c = new IndicazioneConsegna();
            c.setId(Integer.parseInt(riga[0]));
            c.setIndirizzo(riga[1]);
            c.setNominativo(riga[2]);
            c.setUtente(UtenteDAO.getInstance().findByEmail(riga[3]));


            listaIndicazioniConsegna.add(c);

        }
   return listaIndicazioniConsegna;
    }
}

