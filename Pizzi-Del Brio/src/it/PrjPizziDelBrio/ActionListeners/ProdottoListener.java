package it.PrjPizziDelBrio.ActionListeners;

import it.PrjPizziDelBrio.model.GestoreCatalogo;
import it.PrjPizziDelBrio.view.CategoriaSetupFrame;
import it.PrjPizziDelBrio.view.ProdottoSetupFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProdottoListener implements ActionListener {
    private ProdottoSetupFrame finestra;
    private GestoreCatalogo g;

    public ProdottoListener(ProdottoSetupFrame finestra, GestoreCatalogo g) {
        this.finestra = finestra;
        this.g=g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

