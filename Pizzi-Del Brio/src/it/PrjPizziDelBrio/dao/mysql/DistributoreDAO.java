package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IDistributoreDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Distributore;

import java.util.ArrayList;
import java.util.Iterator;

public class DistributoreDAO implements IDistributoreDAO {
    //singleton desing pattern
    private static DistributoreDAO instance;

    public  static DistributoreDAO getInstance(){
        if(instance==null)
            instance=new DistributoreDAO();
        return instance;
    }
    @Override
    public Distributore findById(int id){

        ArrayList<String []> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Distributore WHERE idDistributore="+id);

        if (risultato.size()==0) return null;

        Distributore d=new Distributore();

        String[] riga= risultato.get(0);
        d.setId(Integer.parseInt(riga[0]));
        d.setNome(riga[1]);
        d.setCognome(riga[2]);
        d.setDescrizione(riga[3]);
        return d;

    }

    @Override
    public ArrayList<Distributore> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Distributore");

        ArrayList<Distributore> listaDistributori = new ArrayList<Distributore>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Distributore d = new Distributore();
            d.setId(Integer.parseInt(riga[0]));
            d.setNome(riga[1]);
            d.setCognome(riga[2]);
            d.setDescrizione(riga[3]);

            listaDistributori.add(d);

        }

        return listaDistributori;
    }
}
