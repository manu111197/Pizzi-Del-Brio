package it.PrjPizziDelBrio.dao.mysql;


import it.PrjPizziDelBrio.dao.interfaces.ICarrelloDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Carrello;

import java.util.ArrayList;
import java.util.Iterator;

public class CarrelloDAO implements ICarrelloDAO {
    //singleton desing pattern
    private static   CarrelloDAO instance;

    public  static  CarrelloDAO getInstance(){
        if(instance==null)
            instance=new   CarrelloDAO();
        return instance;
    }

    @Override
    public Carrello findById(int id){

        ArrayList<String []> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Carrello WHERE idCarrello="+id);

        if (risultato.size()==0) return null;

        Carrello c=new Carrello();

        String[] riga= risultato.get(0);
        c.setId(Integer.parseInt(riga[0]));
        return c;

    }
    @Override
    public ArrayList<Carrello> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Carrello");

        ArrayList<Carrello> listaCarrello = new ArrayList<Carrello>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Carrello c = new Carrello();
            c.setId(Integer.parseInt(riga[0]));
            listaCarrello.add(c);

        }
        return listaCarrello;
    }
}

