package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IGestoreCatalogoDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.GestoreCatalogo;

import java.util.ArrayList;
import java.util.Iterator;

public class GestoreCatalogoDAO implements IGestoreCatalogoDAO {
    //singleton desing pattern
    private static GestoreCatalogoDAO instance;

    public static GestoreCatalogoDAO getInstance() {
        if (instance == null)
            instance = new GestoreCatalogoDAO();
        return instance;
    }
    @Override
    public GestoreCatalogo findByEmail(String email) {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Gestore_Catalogo WHERE email='" + email + "';");

        if (risultato.size() == 0) return null;

        GestoreCatalogo g= new GestoreCatalogo();

        String[] riga = risultato.get(0);
        g.setEmail(riga[0]);
        g.setPassword(riga[1].getBytes());
        g.setNome(riga[2]);
        g.setCognome(riga[3]);
        g.setCellulare(riga[4]);

        return g;

    }


    @Override
    public ArrayList<GestoreCatalogo> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Gestore_Catalogo");

        ArrayList<GestoreCatalogo> listaGestoriCatalogo = new ArrayList<GestoreCatalogo>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            GestoreCatalogo g = new GestoreCatalogo();
            g.setEmail(riga[0]);
            g.setPassword(riga[1].getBytes());
            g.setNome(riga[2]);
            g.setCognome(riga[3]);
            g.setCellulare(riga[4]);
            listaGestoriCatalogo.add(g);

        }
        return listaGestoriCatalogo;

    }




}





