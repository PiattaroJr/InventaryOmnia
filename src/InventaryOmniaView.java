import javax.swing.*;
import java.awt.*;

public class InventaryOmniaView extends JFrame {
    private JPanel rootPanel = new JPanel(new BorderLayout());
    private JPanel northPanel = new JPanel(new BorderLayout());
    private JButton omniaButton;
    //private ImageIcon omniaImage = new ImageIcon("");

    private JButton menuButton;
    private JPanel centralPanel = new JPanel(new BorderLayout());
    private JPanel menuPanel = new JPanel(new BorderLayout());
    private JButton addButton;
    private JButton removeButton;
    private JButton visButton;


    public InventaryOmniaView() throws HeadlessException {
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);     //centra il frame nello schermo

        add(rootPanel);

        northPanel.setBackground(Color.black);
        rootPanel.add(northPanel, BorderLayout.NORTH);


        omniaButton = new JButton(new ImageIcon("/Users/piattarojr/Public/Codici/IdeaProject/Lavori/InventaryOmnia/src/Img/omnia.png"));
        //omniaButton.setIcon(omniaImage);
        omniaButton.setEnabled(true);
        omniaButton.setBackground(Color.black);
        omniaButton.setBorderPainted(false);
        omniaButton.setFocusPainted(false);
        northPanel.add(omniaButton, BorderLayout.WEST);

        menuButton = new JButton(new ImageIcon("/Users/piattarojr/Public/Codici/IdeaProject/Lavori/InventaryOmnia/src/Img/Menu_4_lines.jpeg"));
        menuButton.setEnabled(true);
        menuButton.setBackground(Color.black);
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        northPanel.add(menuButton, BorderLayout.EAST);

        menuPanel.setBackground(Color.white);


        addButton = new JButton("Aggiungi materassi");
        addButton.setEnabled(true);


        removeButton = new JButton("Rimuovi materassi");
        removeButton.setEnabled(true);


        visButton = new JButton("Visualizza i materassi");
        visButton.setEnabled(true);


        JPanel buttonsPanel = new JPanel(new GridLayout(3, 1));
        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);
        buttonsPanel.add(visButton);
        buttonsPanel.setBackground(Color.blue);

        menuPanel.add(buttonsPanel, BorderLayout.NORTH);

        centralPanel.add(menuPanel, BorderLayout.EAST);

        rootPanel.add(centralPanel, BorderLayout.CENTER);


        menuPanel.setVisible(true);

        setVisible(true);

    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public void setRootPanel(JPanel rootPanel) {
        this.rootPanel = rootPanel;
    }

    public JPanel getNorthPanel() {
        return northPanel;
    }

    public void setNorthPanel(JPanel northPanel) {
        this.northPanel = northPanel;
    }

    public JButton getOmniaButton() {
        return omniaButton;
    }

    public void setOmniaButton(JButton omniaButton) {
        this.omniaButton = omniaButton;
    }

    public JButton getMenuButton() {
        return menuButton;
    }

    public void setMenuButton(JButton menuButton) {
        this.menuButton = menuButton;
    }

    public JPanel getCentralPanel() {
        return centralPanel;
    }

    public void setCentralPanel(JPanel centralPanelTmp) {
        centralPanel.add(centralPanelTmp, BorderLayout.CENTER);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }
}
