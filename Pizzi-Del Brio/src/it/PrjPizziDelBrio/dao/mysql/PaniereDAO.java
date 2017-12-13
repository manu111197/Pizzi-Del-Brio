package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IPaniereDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Paniere;
import it.PrjPizziDelBrio.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;

public class PaniereDAO implements IPaniereDAO {
    //singleton desing pattern
    private static PaniereDAO instance;

    public  static PaniereDAO getInstance(){
        if(instance==null)
            instance=new PaniereDAO();
        return instance;
    }




    @Override
    public Paniere findByNome(String nome) {
        ArrayList<String []> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Paniere WHERE nome='"+nome+"';");

        if (risultato.size()==0) return null;

        Paniere p=new Paniere();

        String[] riga= risultato.get(0);
        p.setNome(riga[0]);
        p.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[1])));
        p.setUtente(UtenteDAO.getInstance().findByEmail(riga[2]));

        ArrayList<Prodotto> prodottiContenuti = new ArrayList<Prodotto>();

        ArrayList<String[]> risultato2 =  DbConnection.getInstance().eseguiQuery("SELECT nome, descrizione, prezzo, Carrello_idCarrello, Categoria_nome, Produttore_idProduttore, Distributore_idDistributore " +
                "FROM paniere_has_prodotto as Pan " +
                "JOIN  prodotto as P " +
                "on  Pan.Prodotto_nome = P.nome " +
                "WHERE Pan.Paniere_nome=" +nome);

        if(risultato2.size() != 0) {
            Iterator<String[]> i = risultato2.iterator();
            while(i.hasNext()) {
                String[] riga2 = i.next();

                Prodotto p2=new Prodotto();

                p2.setNome(riga2[0]);
                p2.setDescrizione(riga2[1]);
                p2.setPrezzo(riga2[2]);
                p2.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga2[3])));
                p2.setCategoria(CategoriaDAO.getInstance().findByNome(riga2[4]));
                p2.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga2[5])));
                p2.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga2[6])));
                prodottiContenuti.add(p2);
            }
        }
        p.setProdottiContenuti(prodottiContenuti);


        return p;


    }

    @Override
    public ArrayList<Paniere> findAll() {
        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Paniere");

        ArrayList<Paniere> listaPanieri = new ArrayList<Paniere>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Paniere p= new Paniere();
            p.setNome(riga[0]);
            p.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[1])));
            p.setUtente(UtenteDAO.getInstance().findByEmail(riga[2]));

            ArrayList<Prodotto> prodottiContenuti = new ArrayList<Prodotto>();

            ArrayList<String[]> risultato2 =  DbConnection.getInstance().eseguiQuery("SELECT nome, descrizione, prezzo, Carrello_idCarrello, Categoria_nome, Produttore_idProduttore, Distributore_idDistributore " +
                    "FROM paniere_has_prodotto as Pan " +
                    "JOIN  prodotto as P " +
                    "on  Pan.Prodotto_nome = P.nome " +
                    "WHERE Pan.Paniere_nome=" +riga[0]);

            if(risultato2.size() != 0) {
                Iterator<String[]> j = risultato2.iterator();
                while(j.hasNext()) {
                    String[] riga2 = j.next();

                    Prodotto p2=new Prodotto();

                    p2.setNome(riga2[0]);
                    p2.setDescrizione(riga2[1]);
                    p2.setPrezzo(riga2[2]);
                    p2.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga2[3])));
                    p2.setCategoria(CategoriaDAO.getInstance().findByNome(riga2[4]));
                    p2.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga2[5])));
                    p2.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga2[6])));
                    prodottiContenuti.add(p2);
                }
            }
            p.setProdottiContenuti(prodottiContenuti);


            listaPanieri.add(p);

        }
        return listaPanieri;

    }
    }



