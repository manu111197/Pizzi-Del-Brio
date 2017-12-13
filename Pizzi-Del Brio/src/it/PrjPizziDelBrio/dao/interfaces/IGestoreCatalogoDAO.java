package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.GestoreCatalogo;

public interface IGestoreCatalogoDAO extends IBaseDAO<GestoreCatalogo>{
    GestoreCatalogo findByEmail(String email);
}
