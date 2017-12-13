package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Categoria;

public interface ICategoriaDAO extends IBaseDAO<Categoria> {
    Categoria findByNome(String nome);
}
