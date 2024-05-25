import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

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



    /**
     * Creazione del JPanel che cambierà per ogni pagina:
     */

    private JPanel functionsPanel = new JPanel();


    public InventaryOmniaView() {



        /**
         * Setting di default
         */

        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);
        setVisible(true);



        /**
         * Aggiunta del rootPanel
         */

        add(rootPanel);



        /**
         * Aggiunta del northPanel con bc nero
         */

        northPanel.setBackground(Color.black);
        rootPanel.add(northPanel, BorderLayout.NORTH);



        /**
         * Aggiunta dei due pulsanti nel northPanel,
         * settando il colore e varie impostazioni
         * come l'aggiunta della immagine ai pulsanti
         */

        omniaButton = new JButton(new ImageIcon(getClass().getResource("Img/omnia.png")));
        omniaButton.setEnabled(true);
        omniaButton.setBackground(Color.black);
        omniaButton.setBorderPainted(false);
        omniaButton.setFocusPainted(false);
        northPanel.add(omniaButton, BorderLayout.WEST);

        menuButton = new JButton(new ImageIcon(getClass().getResource("Img/Menu_4_lines.jpeg")));
        menuButton.setEnabled(true);
        menuButton.setBackground(Color.black);
        menuButton.setBorderPainted(false);
        menuButton.setFocusPainted(false);
        northPanel.add(menuButton, BorderLayout.EAST);



        /**
         * Aggiunta dei pulsanti di "Aggiunta", "Rimozione" e "Visualizzazione"
         * dei materassi all'interno di un JPanel chiamato "buttonsPanel".
         * Questo poi aggiunto al JPanel chiamato "menuPanel".
         */

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
        buttonsPanel.setForeground(Color.blue);

        menuPanel.add(buttonsPanel, BorderLayout.NORTH);

        centralPanel.add(menuPanel, BorderLayout.EAST);

        rootPanel.add(centralPanel, BorderLayout.CENTER);



        /**
         * Aggiunta del "functionPanel" di default.
         */

        centralPanel.add(functionsPanel, BorderLayout.CENTER);

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

    public void setMenuButton(ActionListener action) {
        menuButton.addActionListener(action);
    }

    public JPanel getCentralPanel() {
        return centralPanel;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public void setMenuPanel(JPanel menuPanel) {
        this.menuPanel = menuPanel;
    }



    /**
     * Metodi utili al {@link Controller} per gestire i listeners.
     *
     * Ogni pulsante dovrà effettuare un'operazione, questi metodi
     * permettono loro di prendere un ActionListener inviato dal Controller.
     */

    public void setAddButton(ActionListener action){
        addButton.addActionListener(action);
    }
    public void setRemoveButton(ActionListener action){
        removeButton.addActionListener(action);
    }
    public void setVisButton(ActionListener action){
        visButton.addActionListener(action);
    }
    public void setOmniaButton(ActionListener action){
        omniaButton.addActionListener(action);
    }



    /**
     * Metodo che serve al {@link Controller} per gestire
     * i JPanel di ogni finestra.
     *
     * @param centralPanelToChange
     */

    public void setCentralPanel(JPanel centralPanelToChange) {

        centralPanel.remove(functionsPanel);
        this.functionsPanel = centralPanelToChange;
        centralPanel.add(functionsPanel, BorderLayout.CENTER);

    }
}
