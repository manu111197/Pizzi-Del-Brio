package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Amministratore;

public interface IAmministratoreDAO extends IBaseDAO<Amministratore>{
    Amministratore findByEmail(String email);

}
