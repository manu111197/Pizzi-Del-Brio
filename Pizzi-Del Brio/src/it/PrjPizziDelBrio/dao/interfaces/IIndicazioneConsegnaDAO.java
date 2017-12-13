package it.PrjPizziDelBrio.dao.interfaces;


import it.PrjPizziDelBrio.model.IndicazioneConsegna;

public interface IIndicazioneConsegnaDAO extends IBaseDAO<IndicazioneConsegna>{
    IndicazioneConsegna findById(int id);
}
