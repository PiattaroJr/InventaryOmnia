package functionPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InventaryOmniaHomePanel extends JPanel {
    private JLabel homeLabel = new JLabel("Benvenuto in InventaryOmnia!", SwingConstants.CENTER);
    private JButton quitButton = new JButton("Esci");
    public InventaryOmniaHomePanel(){
        this.setLayout(new BorderLayout());

        homeLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        //quitButton.setBackground(Color.red);
        quitButton.setForeground(Color.red);
        quitButton.setFont(new Font("Arial", Font.PLAIN, 24));

        add(homeLabel, BorderLayout.CENTER);
        add(quitButton, BorderLayout.PAGE_END);
        setVisible(true);
    }

    public void setQuitButton(ActionListener action){
        this.quitButton.addActionListener(action);
    }
}
