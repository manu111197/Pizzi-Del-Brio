package it.PrjPizziDelBrio.ActionListeners;

import it.PrjPizziDelBrio.model.GestoreCatalogo;
import it.PrjPizziDelBrio.view.CategoriaSetupFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoriaListener implements ActionListener {
    private CategoriaSetupFrame finestra;
    private GestoreCatalogo g;

    public CategoriaListener(CategoriaSetupFrame finestra, GestoreCatalogo g) {
        this.finestra = finestra;
        this.g=g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
