/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.interfaz;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class PanelNick extends JPanel {

    private JTextField textFieldNick;
    private JLabel labelNick;

    public PanelNick() {

        setLayout(null);

        labelNick = new JLabel("Nick:");
        textFieldNick = new JTextField(15);
        textFieldNick.setEditable(false);
        
        labelNick.setBounds(200, 10, 30, 20);
        textFieldNick.setBounds(250, 10, 120, 20);
        
        add(labelNick);
        add(textFieldNick);

    }

  
    public void setNick(String nick) {
        textFieldNick.setText(nick);
    }

  

}
