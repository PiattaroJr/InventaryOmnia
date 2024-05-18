package functionPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InventaryOmniaAddPanel extends JPanel {
    private JButton sendButton = new JButton("Invia!");
    private JSplitPane splitter;
    private JPanel leftPanel = new JPanel(new GridLayout(6,1));
    private JPanel rightPanel = new JPanel(new GridLayout(6,1));
    private Font boldFont = new Font("Arial", Font.BOLD, 25);



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

    private JTextField tipoTextField = new JTextField();
    private JTextField idTextField = new JTextField();
    private JTextField altezzaTextField = new JTextField();
    private JTextField lunghezzaTextField = new JTextField();
    private JTextField spessoreTextField = new JTextField();
    private JTextField molleTextField = new JTextField();


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

        tipoTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        idTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        altezzaTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        lunghezzaTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        spessoreTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        molleTextField.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        tipoTextField.setFont(boldFont);
        idTextField.setFont(boldFont);
        altezzaTextField.setFont(boldFont);
        lunghezzaTextField.setFont(boldFont);
        spessoreTextField.setFont(boldFont);
        molleTextField.setFont(boldFont);

        rightPanel.add(tipoTextField);
        rightPanel.add(idTextField);
        rightPanel.add(altezzaTextField);
        rightPanel.add(lunghezzaTextField);
        rightPanel.add(spessoreTextField);
        rightPanel.add(molleTextField);


        splitter = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        add(splitter, BorderLayout.CENTER);
        splitter.setDividerLocation(240);
        splitter.setDividerSize(5);


        setVisible(true);
    }

    public String getTextTipo(){
        return this.tipoTextField.getText();
    }
    public String getTextId(){
        return this.tipoTextField.getText();
    }
    public String getTextAltezza(){
        return this.tipoTextField.getText();
    }
    public String getTextLunghezza(){
        return this.tipoTextField.getText();
    }
    public String getTextSpessore(){
        return this.tipoTextField.getText();
    }
    public String getTextMolle(){
        return this.tipoTextField.getText();
    }


    public void setSendButton(ActionListener action){
        sendButton.addActionListener(action);
    }
}
