package it.PrjPizziDelBrio.ActionListeners;

import it.PrjPizziDelBrio.model.Utente;
import it.PrjPizziDelBrio.view.CatalogoFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogoListener implements ActionListener {
   private Utente u;
   private CatalogoFrame finestra;
    public CatalogoListener(CatalogoFrame finestra, Utente u) {
        this.finestra = finestra;
        this.u=u;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
