import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                /**
                * MODIFICA EFFETTUATA PER IL TESTING,
                * GUARDA {@link Controller}
                 */

                //Controller c = new Controller();
                //c.run();

                InventaryOmniaView view = new InventaryOmniaView();

            }
        });
    }
}