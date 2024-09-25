/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

import gfutria.Logic;
import java.util.Random;

/**
 *
 * @author ASUS
 */
public class Puzzle15 extends Logic {

    private int[][] tablero;
    private int filaVacia, columnaVacia;

    public int[][] getTablero() {
        return tablero;
    }

    public void setTablero(int[][] tablero) {
        this.tablero = tablero;
    }

    public int getFilaVacia() {
        return filaVacia;
    }

    public void setFilaVacia(int filaVacia) {
        this.filaVacia = filaVacia;
    }

    public int getColumnaVacia() {
        return columnaVacia;
    }

    public void setColumnaVacia(int columnaVacia) {
        this.columnaVacia = columnaVacia;
    }

    public Puzzle15(int[][] tablero, int filaVacia, int columnaVacia) {
        this.tablero = tablero;
        this.filaVacia = filaVacia;
        this.columnaVacia = columnaVacia;
    }

    public Puzzle15() {
        tablero = new int[4][4];
        inicializarTablero();
        mezclarTablero();
    }
    private void inicializarTablero() {
        int valor = 1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (valor == 16) {
                    tablero[i][j] = 0;
                    filaVacia = i;
                    columnaVacia = j;
                } else {
                    tablero[i][j] = valor;
                }
                valor++;
            }
        }
    }

    public void moverArriba() {
        if (filaVacia > 0) {
            intercambiar(filaVacia, columnaVacia, filaVacia - 1, columnaVacia);
            filaVacia--;
        }
   }

    public void moverAbajo() {
        if (filaVacia < 3) {
            intercambiar(filaVacia, columnaVacia, filaVacia + 1, columnaVacia);
            filaVacia++;
        }
    }

    public void moverIzquierda() {
        if (columnaVacia > 0) {
            intercambiar(filaVacia, columnaVacia, filaVacia, columnaVacia - 1);
            columnaVacia--;
        }

    }

    public void moverDerecha() {
        if (columnaVacia < 3) {
            intercambiar(filaVacia, columnaVacia, filaVacia, columnaVacia + 1);
            columnaVacia++;
        }
    }

    private void intercambiar(int fila1, int col1, int fila2, int col2) {
        int temp = tablero[fila1][col1];
        tablero[fila1][col1] = tablero[fila2][col2];
        tablero[fila2][col2] = temp;
    }

    public void mezclarTablero() {
        Random rand = new Random();
        for (int i = 0; i < 70; i++) {
            int movimiento = rand.nextInt(4);
            switch (movimiento) {
                case 0:
                    moverArriba();
                    break;
                case 1:
                    moverAbajo();
                    break;
                case 2:
                    moverIzquierda();
                    break;
                case 3:
                    moverDerecha();
                    break;
            }
        }
    }

    @Override
    public Logic cloneObject(Logic logic) {
        Puzzle15 objPuzzle15 = (Puzzle15) logic;
        Puzzle15 puzzleClone = new Puzzle15();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                puzzleClone.tablero[i][j] = objPuzzle15.tablero[i][j];
            }
        }
        puzzleClone.setFilaVacia(objPuzzle15.getFilaVacia());
        puzzleClone.setColumnaVacia(objPuzzle15.getColumnaVacia());
        return puzzleClone;
    }

 @Override
public String state() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            sb.append(tablero[i][j]);
            if (j < 3) {
                sb.append("::");
            }
        }
        if (i < 3) {
            sb.append("::");
        }
    }
    return sb.toString();
}

    @Override
    public void action(int i) {

        switch (i) {
            case 1:
                moverArriba();
                break;
            case 2:
                moverAbajo();
                break;
            case 3:
                moverDerecha();
                break;
            case 4:
                moverIzquierda();
                break;

        }
    }

}
