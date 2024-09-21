package client.interfaz;

import archivo.HelloSocket;
import client.controlador.Controlador;
import archivo.ReadFile;
import javax.swing.JFrame;

public class InterfazApp extends JFrame {

    /* Relaciones */
    // private Controlador ctrl;
    private PanelNick panelNick;
    private PanelChat panelChat;
    private PanelMsg panelMsg;
    private PanelIp panelIp;
    private Controlador ctrl;
    private ReadFile readFile;
    private HelloSocket helloSocket;

    public InterfazApp(Controlador ctrl) {
        this.ctrl = ctrl;
        this.readFile = new ReadFile();
        //     ctrl.socket("Client: Hello server...");
        setTitle("Personal Chat");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        // Instanciar los paneles
        panelChat = new PanelChat();
        helloSocket = new HelloSocket(panelChat);
        panelIp = new PanelIp();
        panelNick = new PanelNick();
        panelChat = new PanelChat();
        panelMsg = new PanelMsg(helloSocket);

        panelIp.setBounds(10, 10, 180, 40);
        panelNick.setBounds(10, 10, 380, 40);
        panelChat.setBounds(10, 60, 380, 250);
        panelMsg.setBounds(10, 300, 380, 50);

        add(panelIp);
        add(panelNick);
        add(panelChat);
        add(panelMsg);

        ctrl.conectar(readFile, panelIp, panelNick,helloSocket);
        ctrl.cargarConfiguracion();

    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new Controlador());
        frmMain.setVisible(true);
    }
}
