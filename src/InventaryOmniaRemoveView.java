import javax.swing.*;
import java.awt.event.ActionListener;

public class InventaryOmniaRemoveView extends InventaryOmniaHomeView {
    private JPanel rootPanel;
    private JPanel NorthPanel;
    private JButton omniaButton;
    private JButton menuButton;
    private JPanel CenterPanel;
    private JButton homeButton;
    private JButton visualizeButton;
    private JPanel MenuPanel;
    private JButton addButton;

    public InventaryOmniaRemoveView(){
        setContentPane(this.rootPanel);
        setVisible(false);
        setSize(600, 500);
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
    public void setAddButton(ActionListener action){
        this.addButton.addActionListener(action);
    }

    @Override
    public void setRemoveButton(ActionListener action){}

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
