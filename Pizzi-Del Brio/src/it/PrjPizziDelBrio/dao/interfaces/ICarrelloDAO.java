package it.PrjPizziDelBrio.dao.interfaces;


import it.PrjPizziDelBrio.model.Carrello;

public interface ICarrelloDAO extends IBaseDAO<Carrello> {
    Carrello findById(int id);
}
