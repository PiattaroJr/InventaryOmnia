import javax.swing.*;
import java.awt.*;

public class InventaryOmniaView extends JFrame {
    private JPanel rootPanel = new JPanel(new BorderLayout());
    private JPanel northPanel = new JPanel(new BorderLayout());
    private JButton omniaButton;
    private JButton menuButton;
    private JPanel centralPanel = new JPanel(new BorderLayout());
    private JPanel menuPanel = new JPanel(new BorderLayout());
    private JButton addButton;
    private JButton removeButton;
    private JButton visButton;


    public InventaryOmniaView() throws HeadlessException {
        getContentPane().setLayout(new BorderLayout());
        //getContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);     //centra il frame nello schermo

        add(rootPanel);

        northPanel.setBackground(Color.black);
        rootPanel.add(northPanel, BorderLayout.NORTH);


        omniaButton = new JButton("omnia");
        omniaButton.setEnabled(true);
        northPanel.add(omniaButton, BorderLayout.WEST);

        menuButton = new JButton("menu");
        omniaButton.setEnabled(true);
        northPanel.add(menuButton, BorderLayout.EAST);

        menuPanel.setBackground(Color.black);

        addButton = new JButton("Aggiungi materassi");
        addButton.setEnabled(true);

        removeButton = new JButton("Rimuovi materassi");
        removeButton.setEnabled(true);

        visButton = new JButton("Visualizza i materassi");
        visButton.setEnabled(true);

        menuPanel.add(addButton, BorderLayout.NORTH);
        menuPanel.add(removeButton, BorderLayout.CENTER);
        menuPanel.add(visButton, BorderLayout.SOUTH);

        menuPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        menuPanel.setAlignmentY(Component.TOP_ALIGNMENT);




        centralPanel.add(menuPanel, BorderLayout.EAST);

        //centralPanel.add();

        rootPanel.add(centralPanel, BorderLayout.CENTER);

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
