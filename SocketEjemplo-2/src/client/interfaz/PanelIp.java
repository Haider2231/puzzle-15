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
public class PanelIp extends JPanel {

    private JTextField textFieldIP;
    private JLabel labelIP;

    public PanelIp() {
        setLayout(null);
        labelIP = new JLabel("IP:");
        textFieldIP = new JTextField(15);
        textFieldIP.setEditable(false);

        labelIP.setBounds(10, 10, 30, 20);
        textFieldIP.setBounds(50, 10, 120, 20);
        add(labelIP);
        add(textFieldIP);
    }

    public void setIP(String ip) {
        textFieldIP.setText(ip);
    }

   

}
