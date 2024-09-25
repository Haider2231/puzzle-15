/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import controlador.Controlador;
import gfutria.SearchStateSpaces;
import interfaz.PanelTextArea;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Solucion {

    private Puzzle15 puzzle;
    
    private Controlador ctrl;


    public Solucion(Puzzle15 puzzle,Controlador ctrl) {
        this.puzzle = puzzle;
        this.ctrl = ctrl;
    }

    public void resolverPuzzle() {
         Thread solverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> movimientos = obtenerMovimientos();

                // Ejecutar  movimiento uno por uno
                for (String movimiento : movimientos) {
                    ejecutarMovimiento(movimiento); 
                    ctrl.actualizarTablero(); 

                    try {
                        Thread.sleep(500); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                ctrl.mostrarMensaje();
            }
        });
        solverThread.start();
    }

    public ArrayList<String> obtenerMovimientos() {
        ArrayList<String> lst = new ArrayList<>();
        String letraAsociada = "";

        String estadoObjetivo = "1::2::3::4::5::6::7::8::9::10::11::12::13::14::15::0";

        SearchStateSpaces sss = new SearchStateSpaces(estadoObjetivo, puzzle, 4);

        lst = sss.solve();

        ArrayList<String> movimientos = new ArrayList<>();

        for (Object elemento : lst) {
            letraAsociada = identificarAConNumero((String) elemento);
            if (letraAsociada != null) {
                movimientos.add(letraAsociada);
            }
        }

        lst.clear();

        return movimientos;
    }

    
    public static String identificarAConNumero(String texto) {
        String[] partes = texto.split("::|\\s+");

        for (String parte : partes) {
            switch (parte) {
                case "A1":
                    return "U";
                case "A2":
                    return "D";
                case "A3":
                    return "R";
                case "A4":
                    return "L";
            }
        }
        return null;
    }
    
     public void ejecutarMovimiento(String letraAsociada) {
        switch (letraAsociada) {
            case "U": 
                puzzle.moverArriba();
                break;
            case "D": 
                puzzle.moverAbajo();
                break;
            case "L": 
                puzzle.moverIzquierda();
                break;
            case "R": 
                puzzle.moverDerecha();
                break;
        }
    }
}
