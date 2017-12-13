package it.PrjPizziDelBrio.dao.mysql;


import it.PrjPizziDelBrio.dao.interfaces.ICategoriaDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Categoria;

import java.util.ArrayList;
import java.util.Iterator;

public class CategoriaDAO implements ICategoriaDAO {
    //singleton desing pattern
    private static  CategoriaDAO instance;

    public  static  CategoriaDAO getInstance(){
        if(instance==null)
            instance=new  CategoriaDAO();
        return instance;
    }

    @Override
    public Categoria findByNome(String nome){

        ArrayList<String []> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Categoria WHERE nome="+nome);

        if (risultato.size()==0) return null;

        Categoria c=new Categoria();

        String[] riga= risultato.get(0);
        c.setNome(riga[0]);

        return c;

    }
    @Override
    public ArrayList<Categoria> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Categoria");

        ArrayList<Categoria> listaCategorie = new ArrayList<Categoria>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Categoria c = new Categoria();
            c.setNome(riga[0]);
            listaCategorie.add(c);

        }
        return listaCategorie;


    }


    }