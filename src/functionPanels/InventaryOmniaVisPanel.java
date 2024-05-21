package functionPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileWriter;
import java.awt.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class InventaryOmniaVisPanel extends JPanel {
    private DefaultTableModel model;
    private JTable table;
    JButton addButton = new JButton("Aggiungi riga");
    //private JTable table = new JTable(10,10);

    public InventaryOmniaVisPanel(){

        // Leggi o crea il file JSON e ottieni i dati
        //JSONArray jsonData = readOrCreateJSONFile("data.json");

        // Popola la griglia con i dati ottenuti
        //populateGrid(jsonData);



        /**
         *
         * Dati preimpostati nella prima riga della tabella
         *
         */

        Object[] columns = {"Pezzi", "ID", "Tipo", "Altezza", "Lunghezza", "Spessore", "Molle"};
        Object[][] data = {
                {"", "", "", "", "", "", ""}
        };

        // Creazione del modello della tabella
        model = new DefaultTableModel(data, columns);
        table = new JTable(model);

        // Aggiungo la tabella ad uno scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);






        /**
         *
         * Pulsante di prova per aggiungere dei fake-materassi
         *
         */

        addButton.addActionListener(e -> aggiungiRiga("prova", "prova", 1, 1, 1, false));
        add(addButton, "South");

        setVisible(true);
    }



    /**
     *
     * Metodo per aggiungere una riga alla tabella
     * @param tipo
     * @param id
     * @param altezza
     * @param lunghezza
     * @param spessore
     * @param molle
     *
     */

    public void aggiungiRiga(String id, String tipo, int altezza, int lunghezza, int spessore, boolean molle) {
        String pezzi = "PROVA";
        model.addRow(new Object[]{pezzi, id, tipo, altezza, lunghezza, spessore, molle});
    }



    /**
     *
     * Metodo che restituisce in n. di righe della table
     *
     */

    public int getNRow(){
        return model.getRowCount();
    }


    /**
     *
     * Metodo che restituisce i dati di una certa riga.
     *
     */

    public Object[] getRowData(int rowIndex){
        Object[] rowData = new Object[7];
        for(int i = 0; i < 7; i++){;
            rowData[i] = model.getValueAt(rowIndex, i);
        }
        return rowData;
    }

    /**
     *
     * Metodo che aggiorni una riga
     *
     */

    public void updateRowPezzi(Object newPezzi, int rowIndex){
        model.setValueAt(newPezzi, rowIndex, 0);
    }

    //public void set

    /*
    private JSONArray readOrCreateJSONFile(String filename) {
        JSONParser parser = new JSONParser();
        JSONArray jsonData = null;

        try {
            File file = new File(filename);
            if (file.exists()) {
                Object obj = parser.parse(new FileReader(filename));
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

    private void populateGrid(JSONArray jsonData) {
        // Ottieni il numero di righe e colonne
        int numRows = jsonData.size();
        int numCols = ((JSONObject) jsonData.getFirst()).keySet().size();

        // Crea la griglia
        String[] columnNames = new String[numCols];
        Object[][] rowData = new Object[numRows][numCols];

        // Popola i nomi delle colonne
        int colIndex = 0;
        for (Object key : ((JSONObject) jsonData.getFirst()).keySet()) {
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
        table = new JTable(rowData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }
     */
}
