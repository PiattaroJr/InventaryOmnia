import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    public Controller()
    {

    }

    public void run(){

        /**
         * TENTATIVO DI PROVA PER IL MENUBOTTON:
         *
         * TEST PER PROVARE CHE IL BOTTONE MENU
         * ATTIVI E DISATTIVI IL MENU CHE CONTIENE
         * I PULSANTI PER AGGIUNGERE, RIMUOVERE
         * E VISUALIZZARE MATERASSI.
         */

        InventaryOmniaHomeView homeView = new InventaryOmniaHomeView();
        InventaryOmniaAddView addView = new InventaryOmniaAddView();

        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * LA VISIONE O MENO DEI
         * PULSANTI PER IL MENU
         *
         */

        ActionListener actionMenuBtnHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeView.getMenuPanel().setVisible(!homeView.getMenuPanel().isVisible());
                homeView.repaint();
                homeView.revalidate();
            }
        };
        homeView.setMenuBotton(actionMenuBtnHome);

        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * IL CAMBIO DI FINESTRA DA:
         * {@link InventaryOmniaHomeView} A:
         * {@link InventaryOmniaAddView}
         *
         */

        ActionListener actionChangeToAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addView.setVisible(true);
                homeView.setVisible(false);
            }
        };
        homeView.setAddButton(actionChangeToAdd);
    }
}
