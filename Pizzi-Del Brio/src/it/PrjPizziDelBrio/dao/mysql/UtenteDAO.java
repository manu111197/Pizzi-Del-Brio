package it.PrjPizziDelBrio.dao.mysql;


import it.PrjPizziDelBrio.dao.interfaces.IUtenteDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Utente;

import java.util.ArrayList;
import java.util.Iterator;

public class UtenteDAO implements IUtenteDAO {
    //singleton desing pattern
    private static UtenteDAO instance;

    public static UtenteDAO getInstance() {
        if (instance == null)
            instance = new UtenteDAO();
        return instance;
    }

    @Override
    public Utente findByEmail(String email) {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Utente WHERE email='" + email + "';");

        if (risultato.size() == 0) return null;

        Utente u = new Utente();

        String[] riga = risultato.get(0);
        u.setEmail(riga[0]);
        u.setPassword(riga[1].getBytes());
        u.setNome(riga[2]);
        u.setCognome(riga[3]);
        u.setIndirizzo(riga[4]);
        u.setCellulare(riga[5]);

        return u;

    }

    @Override
    public ArrayList<Utente> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Utente");

        ArrayList<Utente> listaUtenti = new ArrayList<Utente>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Utente u = new Utente();
            u.setEmail(riga[0]);
            u.setPassword(riga[1].getBytes());
            u.setNome(riga[2]);
            u.setCognome(riga[3]);
            u.setIndirizzo(riga[4]);
            u.setCellulare(riga[5]);
            listaUtenti.add(u);

        }
        return listaUtenti;

    }
    public void inserimentoUtenti(String email,byte[] password,String nome,String cognome,String indirizzo,String cellulare){
        DbConnection.getInstance().eseguiAggiornamento("INSERT INTO Utente (email,password,nome,cognome,indirizzo,numero_telefono) " +
                "VALUES ('"+email+"','"+new String(password)+"','"+nome+"','"+cognome+"','"+indirizzo+"','"+cellulare+"');");


    }


}
