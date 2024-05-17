import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaRemovePanel;
import functionPanels.InventaryOmniaVisPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private InventaryOmniaView mainView;
    private ArrayList<JPanel> viewManager;


    /**
     * Enumerazione chiamata "WindowsList":
     * creata per facilitare il cambio di JPanel gestito dal controller
     * nel cambio delle funzionalità dell'applicazione.
     */

    public enum WindowsList {
        Home(0),
        Add(1),
        Remove(2),
        Visualize(3);

        private final int valore;
        WindowsList(int valore){
            this.valore = valore;
        }
        public int getValore(){
            return this.valore;
        }
    }

    public Controller()
    {



        /**
         * Nel costruttore inizializzo un array contenenti i JPanel.
         * Il JPanel di avvio ovviamente è la Home.
         */

        mainView = new InventaryOmniaView();
        viewManager = new ArrayList<>();

        viewManager.add(new InventaryOmniaHomePanel());
        viewManager.add(new InventaryOmniaAddPanel());
        viewManager.add(new InventaryOmniaRemovePanel());
        viewManager.add(new InventaryOmniaVisPanel());

        mainView.setCentralPanel(viewManager.get(WindowsList.Home.getValore()));

    }

    public void run(){



        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * LA VISIONE O MENO DEI
         * PULSANTI PER IL MENU.
         *
         */

        ActionListener actionMenuBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.getMenuPanel().setVisible(!mainView.getMenuPanel().isVisible());
            }
        };
        mainView.setMenuButton(actionMenuBtn);



        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * IL CAMBIO DI JPanel DA:
         * All -> {@link functionPanels.InventaryOmniaAddPanel}
         *
         */

        ActionListener actionChangeToAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setCentralPanel(viewManager.get(WindowsList.Add.getValore()));
            }
        };
        mainView.setAddButton(actionChangeToAdd);



        /**
         *
         * All -> {@link functionPanels.InventaryOmniaRemovePanel}
         *
         */

        ActionListener actionChangeToRemove = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setCentralPanel(viewManager.get(WindowsList.Remove.getValore()));
            }
        };
        mainView.setRemoveButton(actionChangeToRemove);



        /**
         *
         * All -> {@link functionPanels.InventaryOmniaVisPanel}
         *
         */

        ActionListener actionChangeToVisualize = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setCentralPanel(viewManager.get(WindowsList.Visualize.getValore()));
            }
        };
        mainView.setVisButton(actionChangeToVisualize);



        /**
         *
         * All -> {@link functionPanels.InventaryOmniaHomePanel}
         *
         */

        ActionListener actionChangeToHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.setCentralPanel(viewManager.get(WindowsList.Home.getValore()));
            }
        };
        mainView.setOmniaButton(actionChangeToHome);

        ActionListener actionAddrow = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addRow(new Object[]{"Nuovo dato", "Nuovo dato", "Nuovo dato"});
                viewManager.get(WindowsList.Visualize.getValore()).
            }
        };

    }
}
