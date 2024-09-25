
package client.interfaz;

import client.controlador.Controlador;
import javax.swing.*;
import java.awt.*;

public class PanelChat extends JPanel {

    private JTextArea txtArena;

    public PanelChat() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255, 240)); // Fondo neumórfico

        txtArena = new JTextArea();
        txtArena.setEditable(false);
        txtArena.setFont(new Font("Arial", Font.PLAIN, 14));
        txtArena.setLineWrap(true);
        txtArena.setWrapStyleWord(true);
        txtArena.setOpaque(false);
        txtArena.setMargin(new Insets(10, 10, 10, 10));

        JScrollPane scrlChat = new JScrollPane(txtArena);
        scrlChat.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        
        add(scrlChat, BorderLayout.CENTER);
    }

    public void addMessage(String message) {
        txtArena.append(message + "\n");
    }
}
