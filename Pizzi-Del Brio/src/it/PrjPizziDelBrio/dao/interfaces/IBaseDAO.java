package it.PrjPizziDelBrio.dao.interfaces;

import java.util.ArrayList;

public interface IBaseDAO<T> {
    ArrayList<T> findAll();
}
