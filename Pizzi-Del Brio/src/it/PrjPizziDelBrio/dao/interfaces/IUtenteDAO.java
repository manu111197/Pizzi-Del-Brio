package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Utente;

public interface IUtenteDAO extends IBaseDAO<Utente>{
    Utente findByEmail(String email);

}
