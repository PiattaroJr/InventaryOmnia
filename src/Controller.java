import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {

    private int indexActualView = 0;
    private ArrayList<InventaryOmniaHomeView> viewManager;

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
        viewManager = new ArrayList<>();
        viewManager.add(new InventaryOmniaHomeView());
        viewManager.add(new InventaryOmniaAddView());
        viewManager.add(new InventaryOmniaRemoveView());
        viewManager.add(new InventaryOmniaVisualizeView());

    }

    public void run(){

        /**
         * TENTATIVO DI PROVA PER IL MENUBOTTON:
         *
         * TEST PER PROVARE CHE IL BOTTONE MENU
         * ATTIVI E DISATTIVI IL MENU CHE CONTIENE
         * I PULSANTI PER AGGIUNGERE, RIMUOVERE
         * E VISUALIZZARE MATERASSI.
         *
         */


        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * LA VISIONE O MENO DEI
         * PULSANTI PER IL MENU
         *
         */

        ActionListener actionMenuBtn = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel tmp = viewManager.get(indexActualView).getMenuPanel();
                tmp.setVisible(!tmp.isVisible());
            }
        };
        for (InventaryOmniaHomeView v : viewManager) {
            v.setMenuButtonListener(actionMenuBtn);
        }

        /**
         *
         * ACTIONLISTENER CHE GESTISCE
         * IL CAMBIO DI FINESTRA DA:
         * All -> {@link InventaryOmniaAddView}
         *
         */

        ActionListener actionChangeToAdd = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.get(indexActualView).setVisible(false);
                viewManager.get(WindowsList.Add.getValore()).setVisible(true);
                indexActualView = WindowsList.Add.getValore();
            }
        };
        for(InventaryOmniaHomeView v : viewManager){
            v.setAddButton(actionChangeToAdd);
        }

        /**
         * All -> {@link InventaryOmniaRemoveView}
         */
        ActionListener actionChangeToRemove = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.get(indexActualView).setVisible(false);
                viewManager.get(WindowsList.Remove.getValore()).setVisible(true);
                indexActualView = WindowsList.Remove.getValore();
            }
        };
        for(InventaryOmniaHomeView v : viewManager){
            v.setRemoveButton(actionChangeToRemove);
        }

        /**
         * All -> {@link InventaryOmniaVisualizeView}
         */

        ActionListener actionChangeToVisualize = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.get(indexActualView).setVisible(false);
                viewManager.get(WindowsList.Visualize.getValore()).setVisible(true);
                indexActualView = WindowsList.Visualize.getValore();
            }
        };
        for(InventaryOmniaHomeView v : viewManager){
            v.setVisualizeButton(actionChangeToVisualize);
        }

        /**
         * All -> {@link InventaryOmniaHomeView}
         */

        ActionListener actionChangeToHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.get(indexActualView).setVisible(false);
                viewManager.get(WindowsList.Home.getValore()).setVisible(true);
                indexActualView = WindowsList.Home.getValore();
            }
        };
        for(InventaryOmniaHomeView v : viewManager){
            v.setHomeButton(actionChangeToHome);
            v.setOmniaButton(actionChangeToHome);
        }
    }
}
