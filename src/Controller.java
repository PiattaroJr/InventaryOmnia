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
    private InventaryOmniaHomePanel homePanel = new InventaryOmniaHomePanel();
    private InventaryOmniaAddPanel addPanel = new InventaryOmniaAddPanel();
    private InventaryOmniaRemovePanel removePanel = new InventaryOmniaRemovePanel();
    private InventaryOmniaVisPanel visualizePanel = new InventaryOmniaVisPanel();

    public Controller()
    {
        /**
         * Nel costruttore inizializzo un array contenenti i JPanel.
         * Il JPanel di avvio ovviamente è la Home.
         */

        mainView = new InventaryOmniaView();
        mainView.setCentralPanel(homePanel);

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
                mainView.setCentralPanel(addPanel);
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
                mainView.setCentralPanel(removePanel);
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
                mainView.setCentralPanel(visualizePanel);
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
                mainView.setCentralPanel(homePanel);
            }
        };
        mainView.setOmniaButton(actionChangeToHome);



        /**
         *
         * ActionListener per aggiungere righe alla VisPanel
         *
         */

        ActionListener actionAddrow = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addRow(new Object[]{"Nuovo dato", "Nuovo dato", "Nuovo dato"});
                //viewManager.get(WindowsList.Visualize.getValore()).
            }
        };



        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isValid = true;
                System.out.println(addPanel.isSelectedMolle());


            }
        };
        addPanel.setSendButton(addNewMaterasso);






    }
}
