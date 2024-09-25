/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ASUS
 */
public class PanelTextArea extends JPanel {

    private JTextArea textArea;

    public PanelTextArea() {
        textArea = new JTextArea();
        textArea.setBounds(50, 200, 200, 300);
        textArea.setEditable(false);
        add(textArea);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
