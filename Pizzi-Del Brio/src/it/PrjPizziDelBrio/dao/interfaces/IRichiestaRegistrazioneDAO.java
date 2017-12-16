package it.PrjPizziDelBrio.dao.interfaces;


import it.PrjPizziDelBrio.model.RichiestaRegistrazione;



public interface IRichiestaRegistrazioneDAO extends IBaseDAO<RichiestaRegistrazione> {

    RichiestaRegistrazione findById (int id);
    RichiestaRegistrazione findByUtente(String email);



}
