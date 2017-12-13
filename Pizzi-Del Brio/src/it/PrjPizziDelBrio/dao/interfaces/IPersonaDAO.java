package it.PrjPizziDelBrio.dao.interfaces;

import it.PrjPizziDelBrio.model.Persona;

import java.util.ArrayList;

public interface IPersonaDAO extends IBaseDAO {

 Persona findUsersByEmailAndPassword(String email, byte[] password);



}
