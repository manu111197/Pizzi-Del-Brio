package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IProduttoreDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Produttore;

import java.util.ArrayList;
import java.util.Iterator;

public class ProduttoreDAO implements IProduttoreDAO {
    //singleton desing pattern
    private static ProduttoreDAO instance;

    public static ProduttoreDAO getInstance() {
        if (instance == null)
            instance = new ProduttoreDAO();
        return instance;
    }

    @Override
    public Produttore findById(int id) {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Produttore WHERE idProduttore=" + id);

        if (risultato.size() == 0) return null;

        Produttore p = new Produttore();

        String[] riga = risultato.get(0);
        p.setId(Integer.parseInt(riga[0]));
        p.setNome(riga[1]);
        p.setCognome(riga[2]);
        p.setDescrzione(riga[3]);
        return p;

    }


    @Override
    public ArrayList<Produttore> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Produttore");

        ArrayList<Produttore> listaProduttori = new ArrayList<Produttore>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Produttore p = new Produttore();
            p.setId(Integer.parseInt(riga[0]));
            p.setNome(riga[1]);
            p.setCognome(riga[2]);
            p.setDescrzione(riga[3]);

            listaProduttori.add(p);

        }

        return listaProduttori;

    }
}
