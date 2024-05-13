import javax.swing.*;
import java.awt.event.ActionListener;

public class InventaryOmniaHomeView extends JFrame {
    private JPanel RootPanel;
    private JPanel NorthPanel;
    private JPanel CentralPanel;
    private JButton menuButton;
    private JButton omniaButton;
    private JButton addButton;
    private JButton removeButton;
    private JButton visualizeButton;
    private JPanel MenuPanel;
    private JLabel homeLabel;
    private JPanel EastPanel;

    public InventaryOmniaHomeView(){

        setContentPane(this.RootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);



        setVisible(true);
    }


    /**
     * AGGIUNTA DI METODI PER
     * IL CONTROLLER:
     *
     * Guarda {@link Controller}
     */

    public void setMenuButtonListener(ActionListener action)
    {
        this.menuButton.addActionListener(action);
    }

    public JPanel getMenuPanel() {
        return this.MenuPanel;
    }

    public void setAddButton(ActionListener action){
        this.addButton.addActionListener(action);
    }
    public void setRemoveButton(ActionListener action){
        this.removeButton.addActionListener(action);
    }
    public void setVisualizeButton(ActionListener action){
        this.visualizeButton.addActionListener(action);
    }

    public void setHomeButton(ActionListener action) {}

    public void setOmniaButton(ActionListener action) {
        this.omniaButton.addActionListener(action);
    }
}
