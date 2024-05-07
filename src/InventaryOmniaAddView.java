public class InventaryOmniaAddView extends InventaryOmniaHomeView{
    public InventaryOmniaAddView()
    {
        //setSize(600,500);
        setContentPane(super.getRootPanel());
        setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.homeLabel.setText("Sei nell' \"Add View\"");
    }
}
