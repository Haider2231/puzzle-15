/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import controlador.Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import mundo.Puzzle15;

/**
 *
 * @author ASUS
 */
public class PanelControls extends JPanel implements ActionListener {

    private Puzzle15 puzzle;
    private PanelTablero panelTablero;

    private JButton btnNewGame;
    private JButton btnSolve;
    private Controlador ctrl;

    public PanelControls(Puzzle15 puzzle, PanelTablero panelTablero, Controlador ctrl) {
        this.puzzle = puzzle;
        this.ctrl = ctrl;
        this.panelTablero = panelTablero;

        setLayout(null);
        btnNewGame = new JButton("New Game");
        btnNewGame.addActionListener(this);
        btnNewGame.setBounds(50, 20, 100, 35);
        add(btnNewGame);

        btnSolve = new JButton("Solve");
        btnSolve.addActionListener(this);
        btnSolve.setBounds(300, 20, 100, 35);
        add(btnSolve);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New Game")) {
            ctrl.iniciarNuevoJuego();
        } else if (e.getActionCommand().equals("Solve")) {
            ctrl.solve();
        }

    }

}
