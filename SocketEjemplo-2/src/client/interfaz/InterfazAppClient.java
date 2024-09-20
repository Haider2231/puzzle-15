package client.interfaz;

import client.controlador.Controlador;
import javax.swing.JFrame;

public class InterfazAppClient extends JFrame {

    /* Relaciones */
    private Controlador ctrl;

    public InterfazAppClient(Controlador ctrl) {
        this.ctrl = ctrl;
        ctrl.socket("Client: Hello server...");
    }

    public static void main(String[] args) {
        new InterfazAppClient(new Controlador());
    }
}
