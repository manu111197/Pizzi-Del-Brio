package it.PrjPizziDelBrio.business;

import it.PrjPizziDelBrio.dao.mysql.CarrelloDAO;

public class CarrelloBusiness {
    private static CarrelloBusiness instance;

    public static CarrelloBusiness getInstance(){
        if (instance == null)
            instance = new CarrelloBusiness();
        return instance;
    }

    public void inserimentoCarrello(String utemail){
        CarrelloDAO.getInstance().insertCarrello(utemail);
    }

}
