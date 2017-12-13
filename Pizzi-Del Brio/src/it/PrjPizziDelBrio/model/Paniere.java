package it.PrjPizziDelBrio.model;

import java.util.ArrayList;

public class Paniere {
    private String nome;
    private Carrello carrello;
    private Utente utente;
    private ArrayList<Prodotto> prodottiContenuti;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ArrayList<Prodotto> getProdottiContenuti() {
        return prodottiContenuti;
    }

    public void setProdottiContenuti(ArrayList<Prodotto> prodottiContenuti) {
        this.prodottiContenuti = prodottiContenuti;
    }
}
