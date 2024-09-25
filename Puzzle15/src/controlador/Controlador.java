/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import gfutria.SearchStateSpaces;

import interfaz.PanelControls;
import interfaz.PanelTablero;
import interfaz.PanelTextArea;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import mundo.Puzzle15;
import mundo.Solucion;

/**
 *
 * @author ASUS
 */
public class Controlador {

    private Puzzle15 puzzle;
    private PanelTablero panelTablero;
    private PanelControls panelControls;
    private PanelTextArea panelTextArea;
    private Solucion solve;

    public Controlador() {
    }

    public void conectar(Puzzle15 puzzle, PanelTablero panelTablero, PanelControls panelControls, PanelTextArea panelTextArea, Solucion solve) {
        this.puzzle = puzzle;
        this.panelTablero = panelTablero;
        this.panelControls = panelControls;
        this.panelTextArea = panelTextArea;
        this.solve = solve;
    }

    public void iniciarNuevoJuego() {
        puzzle.mezclarTablero();
        panelTablero.actualizarInterfaz();
    }
    
    // Actualizar el tablero después de cada movimiento
    public void actualizarTablero() {
        panelTablero.actualizarInterfaz();
    }

    // Mostrar mensaje en la interfaz
    public void mostrarMensaje() {
       JOptionPane.showMessageDialog(null, "Se ha resuelto el puzzle.");
    }

    public void solve() {
      solve.resolverPuzzle();
    }
    
    
}
