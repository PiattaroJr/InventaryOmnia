package functionPanels;

import javax.swing.*;
import java.awt.*;

public class InventaryOmniaAddPanel extends JPanel {
    private JButton sendButton = new JButton("Invia!");
    public InventaryOmniaAddPanel(){

        sendButton.setBackground(Color.black);
        add(sendButton);
        setVisible(true);
    }
}
