package it.PrjPizziDelBrio.model;

import it.PrjPizziDelBrio.dao.mysql.MetodoPagamentoDAO;



public class MetodoPagamento extends MetodoPagamentoDAO {
    private int id;
    private String circuito;
    private int codiceSicurezza;
    private String datascadenza;
    private Utente utente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public int getCodiceSicurezza() {
        return codiceSicurezza;
    }

    public void setCodiceSicurezza(int codiceSicurezza) {
        this.codiceSicurezza = codiceSicurezza;
    }

    public String getDatascadenza() {
        return datascadenza;
    }

    public void setDatascadenza(String datascadenza) {
        this.datascadenza = datascadenza;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

}
