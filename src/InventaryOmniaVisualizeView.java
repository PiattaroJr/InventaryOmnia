import javax.swing.*;
import java.awt.event.ActionListener;

public class InventaryOmniaVisualizeView extends InventaryOmniaHomeView {
    private JButton omniaButton;
    private JButton menuButton;
    private JPanel NorthPanel;
    private JPanel rootPanel;
    private JPanel CentralPanel;
    private JButton homeButton;
    private JPanel MenuPanel;
    private JButton addButton;
    private JButton removeButton;

    public InventaryOmniaVisualizeView() {
        setContentPane(this.rootPanel);
        setVisible(false);
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public JPanel getMenuPanel() {
        return MenuPanel;
    }

    @Override
    public void setMenuButtonListener(ActionListener action) {
        this.menuButton.addActionListener(action);
    }

    @Override
    public void setAddButton(ActionListener action){
        this.addButton.addActionListener(action);
    }
    @Override
    public void setRemoveButton(ActionListener action){
        this.removeButton.addActionListener(action);
    }
    @Override
    public void setVisualizeButton(ActionListener action){}

    @Override
    public void setHomeButton(ActionListener action) {
        this.homeButton.addActionListener(action);
    }

    @Override
    public void setOmniaButton(ActionListener action) {
        this.omniaButton.addActionListener(action);
    }
}
