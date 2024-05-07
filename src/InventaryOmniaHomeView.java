import javax.swing.*;
import java.awt.event.ActionListener;

public class InventaryOmniaHomeView extends JFrame {
    private JPanel RootPanel;
    private JPanel NorthPanel;
    private JPanel CentralPanel;
    private JButton MenuBotton;
    private JButton omniaBotton;
    private JButton addButton;
    private JButton removeButton;
    private JButton visualButton;
    private JPanel MenuPanel;
    protected JLabel homeLabel;
    private JPanel EastPanel;

    public InventaryOmniaHomeView(){

        setContentPane(RootPanel);
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

    public void setMenuBotton(ActionListener action)
    {
        this.MenuBotton.addActionListener(action);
    }

    public JButton getMenuBotton(){
        return this.MenuBotton;
    }

    public JPanel getMenuPanel() {
        return this.MenuPanel;
    }

    public JPanel getRootPanel(){return this.RootPanel;}
    public void setAddButton(ActionListener action){
        this.addButton.addActionListener(action);
    }
}
