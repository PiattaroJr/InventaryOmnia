package functionPanels;

import javax.swing.*;
import java.awt.*;

public class InventaryOmniaRemovePanel extends JPanel {
    private JButton removeButton = new JButton("Rimuovi!");
    public InventaryOmniaRemovePanel(){

        removeButton.setBackground(Color.black);
        setVisible(true);
        add(removeButton);


    }
}
