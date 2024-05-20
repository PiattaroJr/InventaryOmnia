import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaRemovePanel;
import functionPanels.InventaryOmniaVisPanel;

import javax.naming.ldap.SortResponseControl;
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

    private Materasso materassoTmp;

    public Controller()
    {
        /**
         * Nel costruttore inizializzo un array contenenti i JPanel.
         * Il JPanel di avvio ovviamente è la Home.
         */

        mainView = new InventaryOmniaView();
        mainView.setCentralPanel(homePanel);



        /**
         * Materasso temporaneo
         */

        materassoTmp = new Materasso();

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
                visualizePanel.
            }
        };







        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<String> tmp = addPanel.getMaterassoData();
                materassoTmp.setTipo(tmp.get(0));
                materassoTmp.setId(tmp.get(1));
                materassoTmp.setAltezza(Integer.parseInt(tmp.get(2)));
                materassoTmp.setLunghezza(Integer.parseInt(tmp.get(3)));
                materassoTmp.setSpessore(Integer.parseInt(tmp.get(4)));
                materassoTmp.setMolle(Boolean.parseBoolean(tmp.get(5)));



                /**
                 * Selezione che controlla se il materasso esiste già
                 */

                if(true){
                    visualizePanel.aggiungiRiga();

                }

            }

            // Metodo per aggiungere una riga alla tabella
            public void aggiungiRiga() {
                model.addRow(new Object[]{"Nuovo dato", "Nuovo dato", "Nuovo dato"});
            }
        };
        addPanel.setSendButton(addNewMaterasso);







    }
}
