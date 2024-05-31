import com.google.gson.*;
import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaVisPanel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    private InventaryOmniaView mainView;
    private InventaryOmniaHomePanel homePanel;
    private InventaryOmniaAddPanel addPanel;
    private InventaryOmniaVisPanel visualizePanel;
    private Materasso materassoModel;

    public Controller(InventaryOmniaHomePanel homePanel, InventaryOmniaVisPanel visPanel, InventaryOmniaAddPanel addPanel, InventaryOmniaView mainView, Materasso materassoModel)
    {
        this.homePanel = homePanel;
        this.visualizePanel = visPanel;
        this.addPanel = addPanel;
        this.materassoModel = materassoModel;
        this.mainView = mainView;


        /**
         *
         * Il JPanel di avvio ovviamente è la Home.
         *
         */

        mainView.setCentralPanel(homePanel);



        /**
         *
         * Materasso temporaneo
         *
         */

        materassoModel = new Materasso();

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
        mainView.setHomeButton(actionChangeToHome);



        /**
         *
         * ActionListener per l'aggiunta di Materassi
         *
         */

        ActionListener addNewMaterasso = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String error = "[!] Error: ";
                int countErrors = 0;

                int nRow;
                String tmpId, tmpTipo;
                Number nPezziContainer, tmpAltezza, tmpLunghezza, tmpSpessore, tmpPezzi;
                Boolean isEqual = false, tmpMolle;
                ArrayList<Object> tmpDataObject;
                Materasso tmpRow;
                ArrayList<String> tmp = addPanel.getMaterassoData();

                if(tmp.get(1).equals("")){
                    error += "Il campo Id è vuoto!\n";
                    countErrors++;
                }

                if(!tmp.get(2).matches("[0-9]+")){
                    error += "Il campo Altezza è vuoto o ha caratteri alfabetici!\n";
                    countErrors++;
                }

                if(!tmp.get(3).matches("[0-9]+")){
                    error += "Il campo Lunghezza è vuoto o ha caratteri alfabetici!\n";
                    countErrors++;
                }

                if(!tmp.get(4).matches("[0-9]+")){
                    error += "Il campo Spessore è vuoto o ha caratteri alfabetici!\n";
                    countErrors++;
                }

                if(countErrors == 0){
                    materassoModel.setId(tmp.get(0));
                    materassoModel.setTipo(tmp.get(1));
                    materassoModel.setAltezza(Integer.parseInt(tmp.get(2)));
                    materassoModel.setLunghezza(Integer.parseInt(tmp.get(3)));
                    materassoModel.setSpessore(Integer.parseInt(tmp.get(4)));
                    materassoModel.setMolle(Boolean.parseBoolean(tmp.get(5)));



                    /**
                     *
                     * Selezione che controlla se il materasso esiste già
                     *
                     */

                    nRow = visualizePanel.getNRow();

                    for(int i = 1; i < nRow && !isEqual; i++){
                        tmpDataObject = visualizePanel.getRowData(i);

                        tmpPezzi = (Number) tmpDataObject.get(0);
                        tmpId = (String) tmpDataObject.get(1);
                        tmpTipo = (String) tmpDataObject.get(2);
                        tmpAltezza = (Number) tmpDataObject.get(3);
                        tmpLunghezza = (Number) tmpDataObject.get(4);
                        tmpSpessore = (Number) tmpDataObject.get(5);
                        tmpMolle = (Boolean) tmpDataObject.get(6);

                        tmpRow = new Materasso(tmpId, tmpTipo, tmpAltezza.intValue(), tmpLunghezza.intValue(), tmpSpessore.intValue(), tmpMolle);

                        if(materassoModel.equals(tmpRow)){
                            isEqual = true;
                            nPezziContainer = tmpPezzi.intValue() + 1;
                            visualizePanel.updateRowPezzi((Object) nPezziContainer, i);
                        }
                    }

                    if(!isEqual){
                        visualizePanel.aggiungiRiga(materassoModel.getId(), materassoModel.getTipo(), materassoModel.getAltezza(), materassoModel.getLunghezza(), materassoModel.getSpessore(), materassoModel.hasMolle());

                    }
                }
                else{
                    addPanel.showErrorDialog(error);
                }
            }
        };
        addPanel.setSendButton(addNewMaterasso);



        /**
         *
         *  ActionListener per il saveButton.
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


        /**
         *
         * Implementazione della ricerca
         *
         */


        TableRowSorter<TableModel> sorter = new TableRowSorter<>(visualizePanel.getModel());
        visualizePanel.getTable().setRowSorter(sorter);

        visualizePanel.getSearchField().getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }

            private void filterTable() {
                String text = visualizePanel.getSearchField().getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
        });



        /**
         *
         * tasto elimina
         *
         */

        ActionListener deleteButton = new ActionListener() {
            ArrayList<Object> tmp;
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRows();
            }

            private void deleteSelectedRows() {
                int[] selectedRows = visualizePanel.getTable().getSelectedRows();
                if (selectedRows.length == 0) {
                    JOptionPane.showMessageDialog(visualizePanel, "Seleziona almeno una riga da eliminare.", "Nessuna selezione", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(visualizePanel, "Sei sicuro di voler eliminare i prodotti selezionati?", "Conferma Eliminazione", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    deleteRows(selectedRows);
                }
            }

            public void deleteRows(int[] rows) {
                for (int i = rows.length - 1; i >= 0; i--) {
                        visualizePanel.getModel().removeRow(rows[i]);
                    }
                }
            };
        visualizePanel.setDeleteButton(deleteButton);



        /**
         *
         * Metodi che gestiscono l'uscita dal programma
         * dal HomeView
         *
         */
        ActionListener quitListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirm = JOptionPane.showConfirmDialog(homePanel, "Sei sicuro di voler uscire dal programma?", "Conferma Uscita", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        };
        homePanel.setQuitButton(quitListener);
    }
}
