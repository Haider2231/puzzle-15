/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfaz;

//import gfutria.SearchStateSpaces;
import controlador.Controlador;
import gfutria.SearchStateSpaces;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import mundo.Puzzle15;
import mundo.Solucion;

/**
 *
 * @author ASUS
 */
public class InterfazApp extends JFrame {

    private Puzzle15 puzzle;
    private PanelTablero pnlTablero;
    private PanelControls pnlControls;
    private Controlador ctrl;
    private PanelTitulo pnlTitulo;
    private PanelTextArea pnlTextArea;
    private Solucion solve;

    public InterfazApp(Controlador ctrl) {

        this.ctrl = ctrl;

        setSize(480, 680);
        setTitle("PUZZLE 15");
   
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        puzzle = new Puzzle15();
        pnlTablero = new PanelTablero(puzzle);
        pnlControls = new PanelControls(puzzle, pnlTablero, ctrl);
        pnlTitulo = new PanelTitulo();
        pnlTextArea = new PanelTextArea();
        solve = new Solucion(puzzle,ctrl);
        pnlTitulo.setBounds(110, 20, 230, 50);  
        add(pnlTitulo);
        pnlTablero.setBounds(25, 100, 410, 410);
        add(pnlTablero);
        pnlControls.setBounds(25, 500, 400, 70);
        add(pnlControls);
        pnlTextArea.setBounds(25, 560, 400, 60); 
        add(pnlTextArea);
        ctrl.conectar(puzzle, pnlTablero, pnlControls,pnlTextArea,solve);
    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new Controlador());
        frmMain.setVisible(true);

    }
}
