package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.RichiestaOrdine;

public interface IRichiestaOrdineDAO extends IBaseDAO<RichiestaOrdine> {
    RichiestaOrdine findById(int id);
}
