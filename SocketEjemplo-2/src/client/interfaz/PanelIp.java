package client.interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelIp extends JPanel {

    private JTextField txtFielIP;
    private JLabel lblIP;

    public PanelIp() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(new Color(255, 255, 255, 240)); // Fondo neumórfico

        lblIP = new JLabel("IP:");
        txtFielIP = new JTextField(15);
        txtFielIP.setEditable(false);
        txtFielIP.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0, 50), 1),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        add(lblIP);
        add(txtFielIP);
    }

    public void setIP(String ip) {
        txtFielIP.setText(ip);
    }
}

