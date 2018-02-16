package it.PrjPizziDelBrio.dao.mysql;

import it.PrjPizziDelBrio.dao.interfaces.IProdottoDAO;
import it.PrjPizziDelBrio.dbInterface.DbConnection;
import it.PrjPizziDelBrio.model.Prodotto;

import java.util.ArrayList;
import java.util.Iterator;

public class ProdottoDAO implements IProdottoDAO {
    //singleton desing pattern
    private static ProdottoDAO instance;

    public static ProdottoDAO getInstance() {
        if (instance == null)
            instance = new ProdottoDAO();
        return instance;
    }

    @Override
    public Prodotto findByNome(String nome) {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM Prodotto WHERE nome=" + nome);

        if (risultato.size() == 0) return null;

        Prodotto p = new Prodotto();

        String[] riga = risultato.get(0);
        p.setNome(riga[0]);
        p.setDescrizione(riga[1]);
        p.setPrezzo(riga[2]);
        p.setImmagine(riga[3]);
        p.setSconto(riga[4]);
//            p.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[5])));
        p.setCategoria(CategoriaDAO.getInstance().findByNome(riga[6]));
        p.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga[7])));
        p.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga[8])));

        ArrayList<Prodotto> prodottiContenuti = new ArrayList<Prodotto>();

        ArrayList<String[]> risultato2 = DbConnection.getInstance().eseguiQuery("SELECT nome, descrizione, prezzo, Carrello_idCarrello, Categoria_nome, Produttore_idProduttore, Distributore_idDistributore " +
                "FROM prodotto_has_prodotto as PC" +
                "JOIN  prodotto as P " +
                "on  PC.Prodotto_Contenuto = P.nome " +
                "WHERE PC.Prodotto_Composto=" + nome);

        if (risultato2.size() != 0) {
            Iterator<String[]> i = risultato2.iterator();
            while (i.hasNext()) {
                String[] riga2 = i.next();

                Prodotto p2 = new Prodotto();

                p2.setNome(riga[0]);
                p2.setDescrizione(riga[1]);
                p2.setPrezzo(riga[2]);
                p2.setImmagine(riga[3]);
                p2.setSconto(riga[4]);
//            p2.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[5])));
                p2.setCategoria(CategoriaDAO.getInstance().findByNome(riga[6]));
                p2.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga[7])));
                p2.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga[8])));

                prodottiContenuti.add(p2);
            }
        }
        p.setProdottiContenuti(prodottiContenuti);

        return p;

    }

    @Override
    public ArrayList<Prodotto> findAll() {

        ArrayList<String[]> risultato = DbConnection.getInstance().eseguiQuery("SELECT * FROM prodotto");

        ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();

        Iterator<String[]> i = risultato.iterator();

        while (i.hasNext()) {
            String[] riga = i.next();
            Prodotto p = new Prodotto();
            p.setNome(riga[0]);
            p.setDescrizione(riga[1]);
            p.setPrezzo(riga[2]);
            p.setImmagine(riga[3]);
            p.setSconto(riga[4]);
//            p.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga[5])));
            p.setCategoria(CategoriaDAO.getInstance().findByNome(riga[6]));
            p.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga[7])));
            p.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga[8])));

            ArrayList<Prodotto> prodottiContenuti = new ArrayList<Prodotto>();

            ArrayList<String[]> risultato2 = DbConnection.getInstance().eseguiQuery("SELECT nome, descrizione, prezzo,Immagine,`Sconto eventuale`, Carrello_idCarrello, Categoria_nome, Produttore_idProduttore, Distributore_idDistributore " +
                    "FROM prodotto_has_prodotto as PC " +
                    "JOIN  prodotto as P " +
                    "on  PC.Prodotto_Contenuto = P.nome " +
                    "WHERE PC.Prodotto_Composto='" + riga[0]+"';");

            if (risultato2.size() != 0) {
                Iterator<String[]> j = risultato2.iterator();
                while (j.hasNext()) {
                    String[] riga2 = j.next();

                    Prodotto p2 = new Prodotto();

                    p2.setNome(riga2[0]);
                    p2.setDescrizione(riga2[1]);
                    p2.setPrezzo(riga2[2]);
                    p2.setImmagine(riga2[3]);
                    p2.setSconto(riga2[4]);
//            p2.setCarrello(CarrelloDAO.getInstance().findById(Integer.parseInt(riga2[5])));
                    p2.setCategoria(CategoriaDAO.getInstance().findByNome(riga2[6]));
                    p2.setProduttore(ProduttoreDAO.getInstance().findById(Integer.parseInt(riga2[7])));
                    p2.setDistributore(DistributoreDAO.getInstance().findById(Integer.parseInt(riga2[8])));

                    prodottiContenuti.add(p2);
                }
            }

            p.setProdottiContenuti(prodottiContenuti);


            listaProdotti.add(p);

        }

        return listaProdotti;

    }

    public void insertProdotti(String nome, String descrizione, String prezzo,String Immagine,String Sconto,String categoria, int idprod, int iddist) {

        DbConnection.getInstance().eseguiAggiornamento("INSERT INTO prodotto (nome,descrizione,prezzo,Immagine,`Sconto eventuale`,Categoria_nome,Produttore_idProduttore,Distributore_idDistributore) " +
                "VALUES  ('"+ nome +"','"+ descrizione +"','"+ Float.parseFloat(prezzo) +"','"+Immagine+"','"+Float.parseFloat(Sconto)+"','"+ categoria +"',"+ idprod +","+ iddist +");");
    }
   public void deleteProdotti(String nome){
        DbConnection.getInstance().eseguiAggiornamento("DELETE FROM prodotto WHERE nome='"+nome+"';");
   }

    public void deleteCategoria(String nome){
        DbConnection.getInstance().eseguiAggiornamento("DELETE FROM categoria WHERE nome='"+nome+"';");
    }

}




