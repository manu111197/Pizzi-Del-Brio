package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IPersonaDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Amministratore;
import it.PrjPizziDelBrio.model.GestoreCatalogo;
import it.PrjPizziDelBrio.model.Persona;
import it.PrjPizziDelBrio.model.Utente;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonaDAO implements IPersonaDAO {
    private static PersonaDAO instance;

    public static PersonaDAO getInstance(){
        if (instance == null)
            instance = new PersonaDAO();
        return instance;
    }


    @Override
    public ArrayList<Object> findAll() {
        ArrayList<String[]> risultatoUtenti = DbConnection.getInstance().eseguiQuery("SELECT * FROM Utente");
        ArrayList<String[]> risultatoAmministratori = DbConnection.getInstance().eseguiQuery("SELECT * FROM Amministratore");
        ArrayList<String[]> risultatoGestori = DbConnection.getInstance().eseguiQuery("SELECT * FROM Gestore_Catalogo");

        ArrayList<Object> listaPersone = new ArrayList<Object>();

        Iterator<String[]> i = risultatoUtenti.iterator();
        Iterator<String[]> j = risultatoAmministratori.iterator();
        Iterator<String[]> k = risultatoGestori.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Utente u = new Utente();
            u.setEmail(riga[0]);
            u.setPassword(riga[1].getBytes());
            u.setNome(riga[2]);
            u.setCognome(riga[3]);
            u.setIndirizzo(riga[4]);
            u.setCellulare(riga[5]);
            listaPersone.add(u);
        }
        while(j.hasNext()){
            String[] riga=j.next();
            Amministratore a = new Amministratore();
            a.setEmail(riga[0]);
            a.setPassword(riga[1].getBytes());
            a.setNome(riga[2]);
            a.setCognome(riga[3]);
            a.setCellulare(riga[4]);
            listaPersone.add(a);
        }
        while (k.hasNext()){

            String[] riga= k.next();

            GestoreCatalogo g = new GestoreCatalogo();
            g.setEmail(riga[0]);
            g.setPassword(riga[1].getBytes());
            g.setNome(riga[2]);
            g.setCognome(riga[3]);
            g.setCellulare(riga[4]);
            listaPersone.add(g);
        }
        return listaPersone;
    }

    @Override
    public Persona findUsersByEmailAndPassword(String email, byte[] password) {
        ArrayList<String[]> risultatoUtenti = DbConnection.getInstance().eseguiQuery("SELECT * FROM Utente WHERE email ='" + email + "' AND password = '" + new String(password) + "';");
        ArrayList<String[]> risultatoAmministratori = DbConnection.getInstance().eseguiQuery("SELECT * FROM Amministratore WHERE email ='" + email + "' AND password = '" + new String(password) + "';");
        ArrayList<String[]> risultatoGestori = DbConnection.getInstance().eseguiQuery("SELECT * FROM Gestore_Catalogo WHERE email ='" + email + "' AND password = '" + new String(password) + "';");

        Persona p = null;

        if (risultatoUtenti.size() != 0) {
            String[] utente = risultatoUtenti.get(0);
            String mail = utente[0];
            //vediamo se è un utente
            Utente u = UtenteDAO.getInstance().findByEmail(mail);

            if (u != null) {
                p = u;
            }
        }
         else if(risultatoAmministratori.size()!=0) {

            String[] amministratore = risultatoAmministratori.get(0);
            String mail = amministratore[0];
            //vediamo se è un amministratore
            Amministratore a = AmministratoreDAO.getInstance().findByEmail(mail);

            if (a != null) {
                p = a;
            }

        }
        else if (risultatoGestori.size()!=0){

            String[] gestore = risultatoGestori.get(0);
            String mail = gestore[0];
            //vediamo se è un gestore
            GestoreCatalogo g = GestoreCatalogoDAO.getInstance().findByEmail(mail);

            if (g != null) {
                p = g;
            }

        }

        return p;

    }
}
