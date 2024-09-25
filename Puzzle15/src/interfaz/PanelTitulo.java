/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ASUS
 */
public class PanelTitulo extends JPanel {

    private JLabel titulo;

    public PanelTitulo() {
        setLayout(null);
        setBackground(Color.WHITE);
        titulo = new JLabel("Puzzle 15");
        titulo.setFont(new Font("Serif", Font.BOLD, 20));
        titulo.setForeground(Color.BLACK);
        titulo.setBounds(70, 10, 90, 20);
        add(titulo);

    }

}
