/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import gfutria.SearchStateSpaces;

import interfaz.PanelControls;
import interfaz.PanelTablero;
import java.util.ArrayList;
import mundo.Puzzle15;
 
/**
 *
 * @author ASUS
 */
public class Controlador {

    private Puzzle15 puzzle;
    private PanelTablero panelTablero;
    private PanelControls panelControls;
 

    public Controlador() {
    }

    public void conectar(Puzzle15 puzzle, PanelTablero panelTablero, PanelControls panelControls) {
        this.puzzle = puzzle;
        this.panelTablero = panelTablero;
        this.panelControls = panelControls;
        
    }

    public void iniciarNuevoJuego() {
        puzzle.mezclarTablero();
        panelTablero.actualizarInterfaz();
        //     System.out.println(puzzle.state());

    }

    public void resolverPuzzle() {
        String estadoInicial = puzzle.state();
          ArrayList lst = new ArrayList();
       
        String estadoObjetivo = "1::2::3::4::5::6::7::8::9::10::11::12::13::14::15::0";

        System.out.println(estadoInicial);
       
        SearchStateSpaces sss = new SearchStateSpaces(estadoObjetivo, puzzle, 4);

        lst = sss.solve();
        int i = 0;

        while (i < lst.size()) {
            System.out.println(lst.get(i));
            i++;
        }
        System.out.println(sss.steps() );
        lst.clear();
        //resultado.append("Número de pasos: ").append(sss.steps());

        //panelControls.getTextArea().setText(resultado.toString());
    }
}
