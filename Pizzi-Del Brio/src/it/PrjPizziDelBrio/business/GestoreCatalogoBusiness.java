package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.CategoriaDAO;
import it.PrjPizziDelBrio.dao.mysql.ProdottoDAO;

import javax.swing.*;

public class GestoreCatalogoBusiness  {
    private static GestoreCatalogoBusiness instance;

        public static GestoreCatalogoBusiness getInstance(){
            if (instance == null)
                instance = new GestoreCatalogoBusiness();
            return instance;
        }

    public void inserimentoCategorie(String nomecategoria,String gctemail){
        CategoriaDAO.getInstance().insertCategoria(nomecategoria,gctemail);
        //JOptionPane.showMessageDialog(null, "Categoria aggiunta.");
    }
    public void inserimentoProdotti(String nome,String descrizione,String prezzo,String Immagine,String Sconto ,String categoria ,int iprod,int idist){
        ProdottoDAO.getInstance().insertProdotti(nome,descrizione,prezzo,Immagine,Sconto,categoria,iprod,idist);

        }
    public void rimuoviProdotti(String nome){
        ProdottoDAO.getInstance().deleteProdotti(nome);
    }
    public void rimuoviCategorie(String nome){
        ProdottoDAO.getInstance().deleteCategoria(nome);
    }
}



