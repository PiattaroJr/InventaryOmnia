import javax.swing.*;
import java.awt.event.ActionListener;

public class InventaryOmniaAddView extends InventaryOmniaHomeView {
    private JButton omniaButton;
    private JButton menuButton;
    private JButton homeButton;
    private JButton visualizeButton;
    private JPanel rootPanel;
    private JPanel NorthPanel;
    private JPanel CentralPanel;
    private JPanel MenuPanel;
    private JButton removeButton;

    public InventaryOmniaAddView()
    {
        setContentPane(this.rootPanel);
        setVisible(false);
        setSize(600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public JPanel getMenuPanel() {
        return this.MenuPanel;
    }
    @Override
    public void setMenuButtonListener(ActionListener action) {
        this.menuButton.addActionListener(action);
    }

    @Override
    public void setAddButton(ActionListener action) {}
    @Override
    public void setRemoveButton(ActionListener action){
        this.removeButton.addActionListener(action);
    }
    @Override
    public void setVisualizeButton(ActionListener action){
        this.visualizeButton.addActionListener(action);
    }

    @Override
    public void setHomeButton(ActionListener action) {
        this.homeButton.addActionListener(action);
    }

    @Override
    public void setOmniaButton(ActionListener action) {
        this.omniaButton.addActionListener(action);
    }
}
