package it.PrjPizziDelBrio.model;

public class Categoria {
    private String nome;
    private GestoreCatalogo gestoreCatalogo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GestoreCatalogo getGestoreCatalogo() {
        return gestoreCatalogo;
    }

    public void setGestoreCatalogo(GestoreCatalogo gestoreCatalogo) {
        this.gestoreCatalogo = gestoreCatalogo;
    }
}
