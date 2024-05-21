import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaRemovePanel;
import functionPanels.InventaryOmniaVisPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controller {
    private InventaryOmniaView mainView;
    private InventaryOmniaHomePanel homePanel = new InventaryOmniaHomePanel();
    private InventaryOmniaAddPanel addPanel = new InventaryOmniaAddPanel();
    private InventaryOmniaRemovePanel removePanel = new InventaryOmniaRemovePanel();
    private InventaryOmniaVisPanel visualizePanel = new InventaryOmniaVisPanel();

    private Materasso toAddMaterasso;

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

        toAddMaterasso = new Materasso();

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
/*
        ActionListener actionAddrow = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addRow(new Object[]{"Nuovo dato", "Nuovo dato", "Nuovo dato"});
                //viewManager.get(WindowsList.Visualize.getValore()).
                visualizePanel.
            }
        };

*/





        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int nRow;
                Object objContainer;
                Integer nPezziContainer;
                Boolean isEqual = false;
                Object[] tmpDataObject;
                Materasso tmpRow;
                ArrayList<String> tmp = addPanel.getMaterassoData();
                System.out.println(tmp);
                toAddMaterasso.setId(tmp.get(0));
                toAddMaterasso.setTipo(tmp.get(1));
                toAddMaterasso.setAltezza(Integer.parseInt(tmp.get(2)));
                toAddMaterasso.setLunghezza(Integer.parseInt(tmp.get(3)));
                toAddMaterasso.setSpessore(Integer.parseInt(tmp.get(4)));
                toAddMaterasso.setMolle(Boolean.parseBoolean(tmp.get(5)));



                /**
                 *
                 * Selezione che controlla se il materasso esiste già
                 *
                 */
/*
                nRow = visualizePanel.getNRow();

                for(int i = 0; i < nRow && !isEqual; i++){
                    tmpDataObject = visualizePanel.getRowData(i);
                    tmpRow = new Materasso((String) tmpDataObject[1], (String) tmpDataObject[2], Integer.parseInt((String) tmpDataObject[3]), Integer.parseInt((String) tmpDataObject[4]), Integer.parseInt((String)tmpDataObject[5]), Boolean.parseBoolean((String)tmpDataObject[6]));


                    if(toAddMaterasso.equals(tmpRow)){
                        isEqual = true;
                        nPezziContainer = (Integer) tmpDataObject[0] + 1;
                        visualizePanel.updateRowPezzi((Object) nPezziContainer, i);
                    }
                }
*/
                if(!isEqual){
                    visualizePanel.aggiungiRiga(toAddMaterasso.getId(), toAddMaterasso.getTipo(), toAddMaterasso.getAltezza(), toAddMaterasso.getLunghezza(), toAddMaterasso.getSpessore(), toAddMaterasso.hasMolle());

                }

            }
        };
        addPanel.setSendButton(addNewMaterasso);







    }
}
