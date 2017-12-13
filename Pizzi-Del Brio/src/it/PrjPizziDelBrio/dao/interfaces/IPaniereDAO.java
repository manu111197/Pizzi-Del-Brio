package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Paniere;

public interface IPaniereDAO extends IBaseDAO<Paniere> {

    Paniere findByNome(String nome);
    //Paniere findByEmail(String email);
}
