/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.interfaz;

import archivo.HelloSocket;
import client.controlador.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class PanelMsg extends JPanel implements ActionListener {

    private JTextField textFieldEnviar;
    private JButton buttonSend;
    private Controlador ctrl;

    public PanelMsg(Controlador ctrl) {
        this.ctrl = ctrl;
        setLayout(null);

        textFieldEnviar = new JTextField(25);
        buttonSend = new JButton("enviar");
        buttonSend.addActionListener(this);

        textFieldEnviar.setBounds(10, 10, 250, 30);
        buttonSend.setBounds(270, 10, 90, 30);

        add(textFieldEnviar);
        add(buttonSend);
    }

    public String getMessage() {
        return textFieldEnviar.getText();
    }

    public void clearMessage() {
        textFieldEnviar.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("enviar")) {
            String message = getMessage();
            System.out.println(message);
            ctrl.socket(message);
            clearMessage();
        }
    }

}
