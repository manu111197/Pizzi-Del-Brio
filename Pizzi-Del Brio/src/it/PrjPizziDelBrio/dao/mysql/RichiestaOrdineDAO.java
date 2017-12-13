package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IRichiestaOrdineDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.RichiestaOrdine;

import java.util.ArrayList;
import java.util.Iterator;

public class RichiestaOrdineDAO implements IRichiestaOrdineDAO {
    //singleton desing pattern
    private static RichiestaOrdineDAO instance;

    public  static RichiestaOrdineDAO getInstance(){
        if(instance==null)
            instance=new RichiestaOrdineDAO();
        return instance;
    }

    @Override
    public RichiestaOrdine findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Richiesta_Ordine WHERE idRichiesta_Ordine" + id);

        if (risultato.size() == 0) return null;

        RichiestaOrdine r = new RichiestaOrdine();

        String[] riga = risultato.get(0);
        r.setId(Integer.parseInt(riga[0]));
        r.setStato(riga[1]);
        r.setAmministratore(AmministratoreDAO.getInstance().findByEmail(riga[2]));
        r.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[3])));
        r.setMetodoPagamento(MetodoPagamentoDAO.getInstance().findById(Integer.parseInt(riga[4])));
        r.setUtente(UtenteDAO.getInstance().findByEmail(riga[5]));
        return r;

    }
    @Override
    public ArrayList<RichiestaOrdine> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Richiesta_Ordine");

        ArrayList<RichiestaOrdine> listaRichiestaOrdini = new ArrayList<RichiestaOrdine>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            RichiestaOrdine r = new RichiestaOrdine();
            r.setId(Integer.parseInt(riga[0]));
            r.setStato(riga[1]);
            r.setAmministratore(AmministratoreDAO.getInstance().findByEmail(riga[2]));
            r.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[3])));
            r.setMetodoPagamento(MetodoPagamentoDAO.getInstance().findById(Integer.parseInt(riga[4])));
            r.setUtente(UtenteDAO.getInstance().findByEmail(riga[5]));

            listaRichiestaOrdini.add(r);

        }
        return listaRichiestaOrdini;
    }
}