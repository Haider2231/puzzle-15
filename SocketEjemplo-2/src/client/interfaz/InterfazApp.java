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

        setTitle("Personal Chat");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        
      
       readFile = new ReadFile();

    
        // Instanciar los paneles
        panelIp = new PanelIp();
        panelNick = new PanelNick();
        panelChat = new PanelChat();
        panelMsg = new PanelMsg(ctrl);

        panelIp.setBounds(10, 10, 180, 40);
        panelNick.setBounds(10, 10, 380, 40);
        panelChat.setBounds(10, 60, 380, 250);
        panelMsg.setBounds(10, 300, 380, 50);

        add(panelIp);
        add(panelNick);
        add(panelChat);
        add(panelMsg);

        ctrl.conectar(readFile, panelIp, panelNick);
        ctrl.cargarConfiguracion();
        
    }

    public static void main(String[] args) {
        InterfazApp frmMain = new InterfazApp(new Controlador());
        frmMain.setVisible(true);
    }
}
