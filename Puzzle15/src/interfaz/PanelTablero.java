/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import mundo.Puzzle15;

/**
 *
 * @author ASUS
 */
public class PanelTablero extends JPanel {

    private Puzzle15 puzzle;
    private JButton[][] botones;

    public PanelTablero(Puzzle15 puzzle) {
        this.puzzle = puzzle;
        this.botones = new JButton[4][4];
        setLayout(new GridLayout(4, 4, 5, 5));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                botones[i][j] = new JButton(String.valueOf(puzzle.getTablero()[i][j]));
                botones[i][j].setPreferredSize(new Dimension(100, 100));
                botones[i][j].addActionListener(new BotonListener(i, j));
                botones[i][j].setBackground(Color.LIGHT_GRAY);

                botones[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                botones[i][j].setBorder(new RoundedBorder(25));
                botones[i][j].setFocusPainted(false);  
                botones[i][j].setContentAreaFilled(false);  
                botones[i][j].setOpaque(true);

                add(botones[i][j]);
                if (puzzle.getTablero()[i][j] == 0) {
                    botones[i][j].setText("");
                    botones[i][j].setEnabled(false);
                }
            }
        }
    }

    // ActionListener para los botones del tablero
    private class BotonListener implements ActionListener {

        private int fila;
        private int columna;

        public BotonListener(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int filaVacia = puzzle.getFilaVacia();
            int columnaVacia = puzzle.getColumnaVacia();

            if (fila == filaVacia && columna == columnaVacia - 1) {
                puzzle.moverIzquierda();
            } else if (fila == filaVacia && columna == columnaVacia + 1) {
                puzzle.moverDerecha();
            } else if (columna == columnaVacia && fila == filaVacia - 1) {
                puzzle.moverArriba();
            } else if (columna == columnaVacia && fila == filaVacia + 1) {
                puzzle.moverAbajo();
            }
            actualizarInterfaz();
        }

    }

    private class RoundedBorder implements Border {

        private int radius;

        public RoundedBorder(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

         @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.BLACK);  // Color del borde
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2d.dispose();
        }

    }

    // Actualiza el texto de los botones en el tablero
    public void actualizarInterfaz() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (puzzle.getTablero()[i][j] == 0) {
                    botones[i][j].setText("");
                    botones[i][j].setEnabled(false); 
                } else {

                    botones[i][j].setText(String.valueOf(puzzle.getTablero()[i][j]));
                    botones[i][j].setEnabled(true); 
                }
            }
        }
    }
}
