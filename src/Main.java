
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            // commento da Andrea
            // commento da giovanni
            public void run() {
                //LoginView view = new LoginView();
                provaView provaView = new provaView();
            }
        });
    }
}