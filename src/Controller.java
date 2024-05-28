import com.google.gson.*;
import com.sun.management.GarbageCollectionNotificationInfo;
import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaRemovePanel;
import functionPanels.InventaryOmniaVisPanel;
import org.json.simple.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

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
                mainView.repaint();
                mainView.revalidate();
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
                mainView.repaint();
                mainView.revalidate();
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
                mainView.repaint();
                mainView.revalidate();
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
                mainView.repaint();
                mainView.revalidate();
            }
        };
        mainView.setOmniaButton(actionChangeToHome);






        /**
         * ActionListener per l'aggiunta di Materassi
         */

        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int nRow;
                String tmpId, tmpTipo;
                Integer nPezziContainer, tmpAltezza, tmpLunghezza, tmpSpessore, tmpPezzi;
                Boolean isEqual = false, tmpMolle;
                ArrayList<Object> tmpDataObject;
                Materasso tmpRow;
                ArrayList<String> tmp = addPanel.getMaterassoData();
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

                nRow = visualizePanel.getNRow();
                System.out.println(nRow);

                for(int i = 1; i < nRow && !isEqual; i++){
                    tmpDataObject = visualizePanel.getRowData(i);
                    tmpPezzi = (Integer) tmpDataObject.get(0);
                    tmpId = (String) tmpDataObject.get(1);
                    tmpTipo = (String) tmpDataObject.get(2);
                    tmpAltezza = (Integer) tmpDataObject.get(3);
                    tmpLunghezza = (Integer) tmpDataObject.get(4);
                    tmpSpessore = (Integer) tmpDataObject.get(5);
                    tmpMolle = (Boolean) tmpDataObject.get(6);
                    tmpRow = new Materasso(tmpId, tmpTipo, tmpAltezza, tmpLunghezza, tmpSpessore, tmpMolle);

                    System.out.println(tmpRow);

                    if(toAddMaterasso.equals(tmpRow)){
                        isEqual = true;
                        nPezziContainer = tmpPezzi + 1;
                        visualizePanel.updateRowPezzi((Object) nPezziContainer, i);
                    }
                }

                if(!isEqual){
                    visualizePanel.aggiungiRiga(toAddMaterasso.getId(), toAddMaterasso.getTipo(), toAddMaterasso.getAltezza(), toAddMaterasso.getLunghezza(), toAddMaterasso.getSpessore(), toAddMaterasso.hasMolle());

                }

            }
        };
        addPanel.setSendButton(addNewMaterasso);



        /**
         *
         *  ActionListener per il saveButton.
         *
         *  FUNZIONANTE
         *
         */

        ActionListener saveButtonAction = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = visualizePanel.getModel();
                saveTableDataToJSON(model, "data.json");
            }

            public void saveTableDataToJSON(DefaultTableModel model, String filename) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonArray jsonArray = new JsonArray();

                for (int i = 0; i < model.getRowCount(); i++) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.add("Pezzi", new JsonPrimitive(model.getValueAt(i, 0).toString()));
                    jsonObject.add("ID", new JsonPrimitive(model.getValueAt(i, 1).toString()));
                    jsonObject.add("Tipo", new JsonPrimitive(model.getValueAt(i, 2).toString()));
                    jsonObject.add("Altezza", new JsonPrimitive(model.getValueAt(i, 3).toString()));
                    jsonObject.add("Lunghezza", new JsonPrimitive(model.getValueAt(i, 4).toString()));
                    jsonObject.add("Spessore", new JsonPrimitive(model.getValueAt(i, 5).toString()));
                    jsonObject.add("Molle", new JsonPrimitive(model.getValueAt(i, 6).toString()));
                    jsonArray.add(jsonObject);
                }

                try (FileWriter file = new FileWriter(filename)) {
                    gson.toJson(jsonArray, file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        visualizePanel.setSaveButton(saveButtonAction);



        /**
         *
         * ActionListener per caricare i dati salvati
         *
         * NON FUNZIONANTE
         *
         */

        ActionListener caricaButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONArray materassiJSON = readOrCreateJSONFile("data.json");
                JScrollPane loadedTable = populateGrid(materassiJSON);
                visualizePanel.setTableContainer(loadedTable);
                visualizePanel.repaint();
                visualizePanel.revalidate();
            }

            private JSONArray readOrCreateJSONFile(String filename) {
                JSONParser parser = new JSONParser();
                JSONArray jsonData = null;

                try {
                    File file = new File(filename);
                    if (file.exists()) {
                        Object obj = parser.parse(new FileReader(filename));
                        System.out.println(obj);
                        jsonData = (JSONArray) obj;
                    } else {
                        // Crea il file e inizializza con un array vuoto
                        FileWriter fileWriter = new FileWriter(filename);
                        fileWriter.write("[]");
                        fileWriter.close();
                        jsonData = new JSONArray();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return jsonData;
            }

            private JScrollPane populateGrid(JSONArray jsonData) {
                // Ottieni il numero di righe e colonne
                int numRows = jsonData.size();
                int numCols = ((JSONObject) jsonData.get(0)).keySet().size();

                // Crea la griglia
                String[] columnNames = new String[numCols];
                Object[][] rowData = new Object[numRows][numCols];

                // Popola i nomi delle colonne
                int colIndex = 0;
                for (Object key : ((JSONObject) jsonData.get(0)).keySet()) {
                    columnNames[colIndex++] = (String) key;
                }

                // Popola i dati delle righe
                for (int i = 0; i < numRows; i++) {
                    JSONObject row = (JSONObject) jsonData.get(i);
                    int j = 0;
                    for (Object key : row.keySet()) {
                        rowData[i][j++] = row.get(key);
                    }
                }

                // Crea la tabella e aggiungila al panel
                JTable table = new JTable(rowData, columnNames);
                JScrollPane scrollPane = new JScrollPane(table);
                return scrollPane;
            }
        };
        visualizePanel.setCaricaButton(caricaButtonListener);

    }
}
