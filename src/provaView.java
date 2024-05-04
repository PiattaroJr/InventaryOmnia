import javax.swing.*;
import java.awt.*;

public class provaView extends JFrame {
    private JPanel rootPanel;
    private JButton button1;
    private JTextField textField1;
    private JPasswordField passwordPasswordField;
    private JLabel log;


    public provaView() {
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,500);
        setVisible(true);
    }
}

