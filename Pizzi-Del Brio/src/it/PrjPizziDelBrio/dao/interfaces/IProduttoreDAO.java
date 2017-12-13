package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Produttore;

public interface IProduttoreDAO extends IBaseDAO<Produttore> {
    Produttore findById(int id);
}
