package functionPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class InventaryOmniaVisPanel extends JPanel {
    private DefaultTableModel model;
    private JPanel southPanel = new JPanel(new FlowLayout());
    private JTable table;
    JButton addButton = new JButton("Aggiungi riga");
    private JButton saveButton = new JButton("Salva inventario");
    private JButton caricaButton = new JButton("Carica inventario");
    private JScrollPane tableContainer;
    private JTextField searchField  = new JTextField(30);

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

        Object[] columns = {"Pezzi", "Tipo", "ID", "Altezza", "Lunghezza", "Spessore", "Molle"};
        Object[][] data = {
                {"", "", "", "", "", "", ""}
        };

        // Creazione del modello della tabella
        model = new DefaultTableModel(data, columns);
        table = new JTable(model);

        // Aggiungo la tabella ad uno scroll pane
        tableContainer = new JScrollPane(table);
        add(tableContainer, BorderLayout.CENTER);



        /**
         *
         * JPanel contenente i pulsanti.
         *
         */

        add(southPanel, "South");
        southPanel.add(saveButton);
        southPanel.add(caricaButton);


        /**
         *
         * JPanel contenente la ricerca.
         */


        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Cerca:"));
        panel.add(searchField);
        add(panel, BorderLayout.NORTH);




        setVisible(true);
    }


    /**
     *
     * getter della table e della searchfield
     * @return
     *
     */
    public JTable getTable() {
        return table;
    }

    public JTextField getSearchField() {
        return searchField;
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
     * Metodo che setta il nuovo JScrollPane per la table.
     * @param newPane
     */

    public void setTableContainer(JScrollPane newPane){
        this.remove(tableContainer);
        this.tableContainer = newPane;
        add(tableContainer, BorderLayout.CENTER);
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
            System.out.println(model.getValueAt(rowIndex,i).getClass());
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

    /**
     * metodi per gestire i listener dei pulsanti.
     * @param action
     */

    public void setSaveButton(ActionListener action){
        this.saveButton.addActionListener(action);
    }
    public void setCaricaButton(ActionListener action){
        this.caricaButton.addActionListener(action);
    }

}
