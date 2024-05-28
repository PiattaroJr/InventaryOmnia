package functionPanels;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventaryOmniaRemovePanel extends JPanel {
    private JButton removeButton = new JButton("Rimuovi!");
    private JButton deleteButton = new JButton("Elimina Selezionati");
    private JTextField removeById = new JTextField();
    private InventaryOmniaVisPanel table = new InventaryOmniaVisPanel();

    public InventaryOmniaRemovePanel() {

        setLayout(new BorderLayout());

        add(table, BorderLayout.CENTER);


    }

    public InventaryOmniaVisPanel getTable() {
        return table;
    }

    public void setTable(InventaryOmniaVisPanel table) {
        this.table = table;
    }

}