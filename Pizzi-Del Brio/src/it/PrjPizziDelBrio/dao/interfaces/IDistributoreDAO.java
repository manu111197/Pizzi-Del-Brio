package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Distributore;

public interface IDistributoreDAO extends IBaseDAO<Distributore> {
    Distributore findById(int id);
}
