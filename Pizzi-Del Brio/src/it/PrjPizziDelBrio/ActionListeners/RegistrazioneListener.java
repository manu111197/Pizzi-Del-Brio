package it.PrjPizziDelBrio.ActionListeners;

import it.PrjPizziDelBrio.model.Utente;
import it.PrjPizziDelBrio.view.RegistrazioneFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrazioneListener implements ActionListener {
    private RegistrazioneFrame finestra;
    private Utente u;

    public RegistrazioneListener(RegistrazioneFrame finestra) {
        this.finestra = finestra;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

      new RegistrazioneFrame(u);
    }
}
