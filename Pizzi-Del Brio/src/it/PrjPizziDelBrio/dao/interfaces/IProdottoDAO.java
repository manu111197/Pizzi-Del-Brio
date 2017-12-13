package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Prodotto;

public interface IProdottoDAO extends IBaseDAO<Prodotto>{
    Prodotto findByNome(String nome);
}
