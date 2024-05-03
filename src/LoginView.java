import javax.swing.*;
import java.awt.*;


public class LoginView {
    private JFrame finestraLogin;
    private JLabel etichettaLogin;
    private JTextField textUsername;
    private JPasswordField passwordField;
    private JButton invioButton;



    public LoginView(){
        finestraLogin = new JFrame("Login");
        finestraLogin.getContentPane().setLayout(new BorderLayout());
        finestraLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestraLogin.setSize(600,500);
        finestraLogin.setLocationRelativeTo(null);
        //finestraLogin.setContentPane(rootPanel);

        etichettaLogin = new JLabel("Effettua il login");
        etichettaLogin.setHorizontalAlignment(SwingConstants.CENTER);
        etichettaLogin.setFont(new Font(etichettaLogin.getFont().getName(), Font.BOLD, 48));
        finestraLogin.getContentPane().add(etichettaLogin, BorderLayout.NORTH);

        textUsername = new JTextField();
        textUsername.setHorizontalAlignment(SwingConstants.CENTER);
        finestraLogin.getContentPane().add(textUsername,BorderLayout.NORTH);



        finestraLogin.setVisible(true);
    }

}
