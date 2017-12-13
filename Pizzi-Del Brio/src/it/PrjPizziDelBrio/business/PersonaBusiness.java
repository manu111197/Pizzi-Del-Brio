package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.PersonaDAO;
import it.PrjPizziDelBrio.model.Persona;

public class PersonaBusiness {



    private static PersonaBusiness instance;

    public static PersonaBusiness getInstance(){
        if (instance == null)
            instance = new PersonaBusiness();
        return instance;
    }

    public Persona login(String email, byte[] password){

        Persona p = PersonaDAO.getInstance().findUsersByEmailAndPassword(email, password);
        return p;


    }
}
