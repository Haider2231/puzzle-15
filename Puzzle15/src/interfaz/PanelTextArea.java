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
        setLayout(null);
        textArea = new JTextArea();
       textArea.setBounds(10, 10, 400, 40); 
        textArea.setEditable(false);
        add(textArea);

    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
