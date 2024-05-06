
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // andrea
                //LoginView view = new LoginView();
                //provaView provaView = new provaView();
                InventaryOmniaHomeView homeView = new InventaryOmniaHomeView();
            }
        });
    }
}