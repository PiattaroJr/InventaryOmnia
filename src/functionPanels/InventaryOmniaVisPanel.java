package functionPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class InventaryOmniaVisPanel extends JPanel {
    private DefaultTableModel model;
    private JTable table;
    JButton addButton = new JButton("Aggiungi riga");
    private JButton saveButton = new JButton("Salva inventario");
    //private JTable table = new JTable(10,10);

    public InventaryOmniaVisPanel(){

        setLayout(new BorderLayout());

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
        add(scrollPane, BorderLayout.CENTER);



        /**
         *
         * Pulsante di prova per aggiungere dei fake-materassi
         *
         */

        add(saveButton, "South");

        setVisible(true);
    }


    /**
     *
     * Metodo che restituisce il model
     * @return
     *
     */

    public DefaultTableModel getModel() {
        return this.model;
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
        Integer pezzi = 1;
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

     public ArrayList<Object> getRowData(int rowIndex){
        ArrayList<Object> rowData = new ArrayList<>();
        for(int i = 0; i < 7; i++){
            rowData.add(model.getValueAt(rowIndex, i));
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



    // Method to save table data to JSON

    public void setSaveButton(ActionListener action){
        this.saveButton.addActionListener(action);
    }


}
