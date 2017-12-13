package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IMetodoPagamentoDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.MetodoPagamento;

import java.util.ArrayList;
import java.util.Iterator;

public class MetodoPagamentoDAO implements IMetodoPagamentoDAO {
    //singleton desing pattern
    private static MetodoPagamentoDAO instance;

    public  static MetodoPagamentoDAO getInstance(){
        if(instance==null)
            instance=new MetodoPagamentoDAO();
        return instance;
    }

    @Override
    public MetodoPagamento findById(int id) {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Metodo_Pagamento WHERE id_CartadiCredito" + id );

        if (risultato.size() == 0) return null;

        MetodoPagamento m = new MetodoPagamento();

        String[] riga = risultato.get(0);
        m.setId(Integer.parseInt(riga[0]));
        m.setCircuito(riga[1]);
        m.setCodiceSicurezza(Integer.parseInt(riga[2]));
        m.setDatascadenza(riga[3]);
        m.setUtente(UtenteDAO.getInstance().findByEmail(riga[4]));

        return m;

}


    @Override
    public ArrayList<MetodoPagamento> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Metodo_Pagamento");

        ArrayList<MetodoPagamento> listaMetodiPagamento= new ArrayList<MetodoPagamento>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
           MetodoPagamento m = new MetodoPagamento();
            m.setId(Integer.parseInt(riga[0]));
            m.setCircuito(riga[1]);
            m.setCodiceSicurezza(Integer.parseInt(riga[2]));
            m.setDatascadenza(riga[3]);
            m.setUtente(UtenteDAO.getInstance().findByEmail(riga[4]));


            listaMetodiPagamento.add(m);

        }
        return listaMetodiPagamento;
    }
    }


