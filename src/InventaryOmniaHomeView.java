import javax.swing.*;
import java.awt.*;

public class InventaryOmniaHomeView extends JFrame {
    private JPanel RootPanel;
    private JPanel NorthPanel;
    private JPanel CentralPanel;
    private JButton MenuBotton;
    private JButton omniaBotton;

    public InventaryOmniaHomeView(){
        setContentPane(RootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);

        //NorthPanel.setLayout(new BorderLayout());

        //MenuBotton.setSize(50,50);
        //getContentPane().add(MenuBotton, BorderLayout.EAST);

        //omniaBotton.setSize(50,50);
        //getContentPane().add(omniaBotton, BorderLayout.WEST);


        setVisible(true);
    }
}
