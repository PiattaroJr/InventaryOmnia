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
    private JButton deleteButton = new JButton("Elimina Selezionati");

    public InventaryOmniaVisPanel(){

        setLayout(new BorderLayout());



        /**
         *
         * Dati preimpostati nella prima riga della tabella
         *
         */

        Object[] columns = {"Pezzi", "Tipo", "ID", "Altezza", "Lunghezza", "Spessore", "Molle"};
        Object[][] data = {
                {"", "", "", "", "", "", ""}
        };

        model = new DefaultTableModel(data, columns) {

            /**
             * Override del metodo isCellEditable per rendere le celle non modificabili
             *
             * @param row             the row whose value is to be queried
             * @param column          the column whose value is to be queried
             * @return
             */
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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
        southPanel.add(deleteButton);


        /**
         *
         * JPanel contenente la ricerca.
         *
         */

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel("Cerca:"));
        panel.add(searchField);
        add(panel, BorderLayout.NORTH);




        setVisible(true);
    }

    /**
     *
     * getter e tasto elimina
     *
     */

    public JButton getDeleteButton() {
        return deleteButton;
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

    public void aggiungiRiga(String id, String tipo, int altezza, int lunghezza, int spessore, String molle) {
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
    public void setDeleteButton(ActionListener action){
        this.deleteButton.addActionListener(action);
    }

}
