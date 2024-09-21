/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author asus
 */
public class PanelChat extends JPanel {

    private JTextArea textAreaChat;
    private   JScrollPane scrollPaneChat ;
    public PanelChat() {
        setLayout(null);

        textAreaChat = new JTextArea(15, 30);
        textAreaChat.setEditable(false);

         scrollPaneChat = new JScrollPane(textAreaChat);
        
          scrollPaneChat.setBounds(10, 10, 350, 200);
        
        add(scrollPaneChat);
    }

    public void addMessage(String message) {
        textAreaChat.append(message + "\n");
    }
}
