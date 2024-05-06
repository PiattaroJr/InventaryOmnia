import javax.swing.*;

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
    private JPanel EastPanel;

    public InventaryOmniaHomeView(){

        setContentPane(RootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);



        setVisible(true);


    }

}
