package functionPanels;

import javax.swing.*;
import java.awt.*;

public class InventaryOmniaHomePanel extends JPanel {
    private JLabel homeLabel = new JLabel("Benvenuto in InventaryOmnia!");
    public InventaryOmniaHomePanel(){

        homeLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        add(homeLabel);
        setVisible(true);
    }
}
