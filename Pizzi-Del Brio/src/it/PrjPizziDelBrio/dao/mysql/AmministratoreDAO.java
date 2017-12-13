package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IAmministratoreDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Amministratore;



import java.util.ArrayList;
import java.util.Iterator;

public class AmministratoreDAO implements IAmministratoreDAO {
    //singleton desing pattern
    private static AmministratoreDAO instance;

    public static AmministratoreDAO getInstance() {
        if (instance == null)
            instance = new AmministratoreDAO();
        return instance;
    }

    @Override
    public Amministratore findByEmail(String email) {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Amministratore WHERE email='" + email + "';");

        if (risultato.size() == 0) return null;

       Amministratore a= new Amministratore();

        String[] riga = risultato.get(0);
        a.setEmail(riga[0]);
        a.setPassword(riga[1].getBytes());
        a.setNome(riga[2]);
        a.setCognome(riga[3]);
        a.setCellulare(riga[4]);

        return a;

    }
    @Override
    public ArrayList<Amministratore> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Amministratore");

        ArrayList<Amministratore> listaAmministratori = new ArrayList<Amministratore>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Amministratore a = new Amministratore();
            a.setEmail(riga[0]);
            a.setPassword(riga[1].getBytes());
            a.setNome(riga[2]);
            a.setCognome(riga[3]);
            a.setCellulare(riga[4]);
            listaAmministratori.add(a);

        }
        return listaAmministratori;

    }














}
