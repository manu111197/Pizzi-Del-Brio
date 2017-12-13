package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.MetodoPagamento;

public interface IMetodoPagamentoDAO extends IBaseDAO<MetodoPagamento> {
    MetodoPagamento findById(int id);
}
