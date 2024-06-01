package functionPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class InventaryOmniaAddPanel extends JPanel {
    private JButton sendButton = new JButton("Invia!");
    private JSplitPane splitter;
    private JPanel leftPanel = new JPanel(new GridLayout(6,1));
    private JPanel rightPanel = new JPanel(new GridLayout(6,1));
    private Font boldFont = new Font("Arial", Font.BOLD, 25);
    private ArrayList<String> dataMateTmp = new ArrayList<>();

    /**
     *
     * Lista dei tipi di materassi
     */

    private String[] mattressTypes = { "Memory Foam", "Lattice", "Artico", "Ibrido", "Ad aria", "Ignifugo", "Aloe" };

    /**
     * Attributi per i label:
     */

    private JLabel tipoLabel = new JLabel("  Tipo: ");
    private JLabel idLabel = new JLabel("  Id: ");
    private JLabel altezzaLabel = new JLabel("  Altezza: ");
    private JLabel lunghezzaLabel = new JLabel("  Lunghezza: ");
    private JLabel spessoreLabel = new JLabel("  Spessore: ");
    private JLabel molleLabel = new JLabel("  Molle: ");



    /**
     * Attributi per i textField
     */

    //private  tipoTextField = new JTextField();
    JComboBox<String> mattressComboBox = new JComboBox<>(mattressTypes);
    private JTextField idTextField = new JTextField();
    private JTextField altezzaTextField = new JTextField();
    private JTextField lunghezzaTextField = new JTextField();
    private JTextField spessoreTextField = new JTextField();
    private JCheckBox molleCheckBox = new JCheckBox();



    public InventaryOmniaAddPanel(){

        this.setLayout(new BorderLayout());

        sendButton.setBackground(Color.black);
        add(sendButton, BorderLayout.SOUTH);



        /**
         * Configurazione del leftPanel
         * (a sinistra del JSplitPane)
         */

        tipoLabel.setFont(boldFont);
        idLabel.setFont(boldFont);
        altezzaLabel.setFont(boldFont);
        lunghezzaLabel.setFont(boldFont);
        spessoreLabel.setFont(boldFont);
        molleLabel.setFont(boldFont);

        leftPanel.add(tipoLabel);
        leftPanel.add(idLabel);
        leftPanel.add(altezzaLabel);
        leftPanel.add(lunghezzaLabel);
        leftPanel.add(spessoreLabel);
        leftPanel.add(molleLabel);



        /**
        * Configurazione del rightPanel
        * (a destra del JSplitPane)
        */

        mattressComboBox.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        idTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        altezzaTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        lunghezzaTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        spessoreTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        mattressComboBox.setFont(boldFont);
        idTextField.setFont(boldFont);
        altezzaTextField.setFont(boldFont);
        lunghezzaTextField.setFont(boldFont);
        spessoreTextField.setFont(boldFont);

        rightPanel.add(mattressComboBox);
        rightPanel.add(idTextField);
        rightPanel.add(altezzaTextField);
        rightPanel.add(lunghezzaTextField);
        rightPanel.add(spessoreTextField);
        rightPanel.add(molleCheckBox);



        splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        add(splitter, BorderLayout.CENTER);
        splitter.setDividerLocation(240);
        splitter.setDividerSize(5);



        mattressComboBox.setSelectedIndex(0); // Imposta il valore di default


        setVisible(true);
    }


    public JComboBox<String> getMattressComboBox() {
        return mattressComboBox;
    }

    public void setMattressComboBox(JComboBox<String> mattressComboBox) {
        this.mattressComboBox = mattressComboBox;
    }

    public String getTextId(){
        return this.idTextField.getText();
    }
    public String getTextAltezza(){
        return this.altezzaTextField.getText();
    }
    public String getTextLunghezza(){
        return this.lunghezzaTextField.getText();
    }
    public String getTextSpessore(){
        return this.spessoreTextField.getText();
    }
    public boolean isSelectedMolle(){
        return this.molleCheckBox.isSelected();
    }
    public void setSendButton(ActionListener action){
        sendButton.addActionListener(action);
    }



    /**
     * Metodo che invia i dati del materasso al Controller.
     * @return
     */

    public ArrayList<String> getMaterassoData(){
        dataMateTmp.clear();
        dataMateTmp.add((String) this.getMattressComboBox().getSelectedItem());
        dataMateTmp.add(getTextId());
        dataMateTmp.add(getTextAltezza());
        dataMateTmp.add(getTextLunghezza());
        dataMateTmp.add(getTextSpessore());
        if(isSelectedMolle())
            dataMateTmp.add("true");
        else
            dataMateTmp.add("false");

        return dataMateTmp;
    }


    public JButton getSendButton() {
        return sendButton;
    }



    /**
     * Metodo per applicare il pretesto ad un textField.
     * @param f
     * @param s
     */

    public void applyShadow(JTextField f, String s)
    {
        f.setText(s);
        f.setForeground(Color.gray);
        f.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(f.getText().equals(s)) {
                    f.setText("");
                    f.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(f.getText().isEmpty()) {
                    f.setText(s);
                    f.setForeground(Color.gray);
                }
            }
        });
    }

    public void showErrorDialog(String error){
        JOptionPane.showMessageDialog(this, error);
    }


    public void clearText(){
        this.idTextField.setText("");
        this.altezzaTextField.setText("");
        this.lunghezzaTextField.setText("");
        this.spessoreTextField.setText("");
        this.molleCheckBox.setSelected(false);



        /**
         *
         *
         * Applichiamo qui il placeHolder nei textField.
         *
         */

        this.applyShadow(idTextField, "Inserisci qui l'ID");
        this.applyShadow(altezzaTextField, "in cm...");
        this.applyShadow(lunghezzaTextField, "in cm...");
        this.applyShadow(spessoreTextField, "in cm...");

    }
}
