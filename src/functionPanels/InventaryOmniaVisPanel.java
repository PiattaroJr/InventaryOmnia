package functionPanels;

import javax.swing.*;
import java.awt.*;

public class InventaryOmniaVisPanel extends JPanel {
    private JButton visButton = new JButton("Visualizza!");

    public InventaryOmniaVisPanel(){
        setVisible(true);
        add(visButton);
        visButton.setBackground(Color.black);
    }
}
