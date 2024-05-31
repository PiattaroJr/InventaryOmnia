import functionPanels.InventaryOmniaAddPanel;
import functionPanels.InventaryOmniaHomePanel;
import functionPanels.InventaryOmniaVisPanel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InventaryOmniaView mainView = new InventaryOmniaView();;
                InventaryOmniaHomePanel homePanel = new InventaryOmniaHomePanel();
                InventaryOmniaAddPanel addPanel = new InventaryOmniaAddPanel();
                InventaryOmniaVisPanel visualizePanel = new InventaryOmniaVisPanel();
                Materasso materassoModel = new Materasso();

                Controller c = new Controller(homePanel, visualizePanel, addPanel, mainView, materassoModel);
                c.run();


            }
        });
    }
}