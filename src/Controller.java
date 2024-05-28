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
         *
         * ActionListener per l'aggiunta di Materassi
         *
         */

        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int nRow;
                String tmpId, tmpTipo;
                Number nPezziContainer, tmpAltezza, tmpLunghezza, tmpSpessore, tmpPezzi;
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

                    System.out.println(tmpDataObject);

                    tmpPezzi = (Number) tmpDataObject.get(0);
                    tmpId = (String) tmpDataObject.get(1);
                    tmpTipo = (String) tmpDataObject.get(2);
                    tmpAltezza = (Number) tmpDataObject.get(3);
                    tmpLunghezza = (Number) tmpDataObject.get(4);
                    tmpSpessore = (Number) tmpDataObject.get(5);
                    tmpMolle = (Boolean) tmpDataObject.get(6);

                    tmpRow = new Materasso(tmpId, tmpTipo, tmpAltezza.intValue(), tmpLunghezza.intValue(), tmpSpessore.intValue(), tmpMolle);

                    System.out.println(tmpRow);

                    if(toAddMaterasso.equals(tmpRow)){
                        isEqual = true;
                        nPezziContainer = tmpPezzi.intValue() + 1;
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
                JsonObject firstRow = new JsonObject();

                //prima riga
                firstRow.addProperty("Pezzi", "");
                firstRow.addProperty("Tipo", "");
                firstRow.addProperty("ID","");
                firstRow.addProperty("Altezza","");
                firstRow.addProperty("Lunghezza", "");
                firstRow.addProperty("Spessore", "");
                firstRow.addProperty("Molle", "");
                jsonArray.add(firstRow);

                for (int i = 1; i < model.getRowCount(); i++) {
                    JsonObject jsonObject = new JsonObject();

                    jsonObject.addProperty("Pezzi", (Number) model.getValueAt(i,0));
                    jsonObject.addProperty("Tipo", (String) model.getValueAt(i, 1));
                    jsonObject.addProperty("ID", (String) model.getValueAt(i, 2));
                    jsonObject.addProperty("Altezza", (Number) model.getValueAt(i, 3));
                    jsonObject.addProperty("Lunghezza", (Number) model.getValueAt(i, 4));
                    jsonObject.addProperty("Spessore", (Number) model.getValueAt(i, 5));
                    jsonObject.addProperty("Molle", (Boolean) model.getValueAt(i, 6));
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
         * FUNZIONANTE
         *
         */

        ActionListener caricaButtonListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) visualizePanel.getModel();
                model.setRowCount(0); // Cancella tutte le righe esistenti

                JsonArray materassiJSON = readOrCreateJSONFile("data.json");
                populateGrid(model, materassiJSON);

                visualizePanel.repaint();
                visualizePanel.revalidate();
            }

            public JsonArray readOrCreateJSONFile(String filename) {
                JsonArray jsonData = null;
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                try {
                    File file = new File(filename);
                    if (file.exists()) {
                        jsonData = gson.fromJson(new FileReader(filename), JsonArray.class);
                    } else {
                        FileWriter fileWriter = new FileWriter(filename);
                        gson.toJson(new JsonArray(), fileWriter);
                        fileWriter.close();
                        jsonData = new JsonArray();
                    }
                } catch (JsonIOException | JsonSyntaxException | IOException e) {
                    e.printStackTrace();
                }

                return jsonData;
            }

            public void populateGrid(DefaultTableModel model, JsonArray jsonData) {
                for (JsonElement element : jsonData) {
                    JsonObject row = element.getAsJsonObject();
                    Object[] rowData = new Object[model.getColumnCount()];
                    for (int i = 0; i < model.getColumnCount(); i++) {
                        String columnName = model.getColumnName(i);
                        JsonElement value = row.get(columnName);
                        if (value != null) {
                            if (value.isJsonPrimitive()) {
                                JsonPrimitive primitive = value.getAsJsonPrimitive();
                                if (primitive.isNumber()) {
                                    rowData[i] = primitive.getAsNumber();
                                } else if (primitive.isString()) {
                                    rowData[i] = primitive.getAsString();
                                } else if (primitive.isBoolean()) {
                                    rowData[i] = primitive.getAsBoolean();
                                }
                            }
                        }
                    }
                    model.addRow(rowData);
                }
            }
        };
        visualizePanel.setCaricaButton(caricaButtonListener);

    }
}
