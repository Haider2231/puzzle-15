package client.controlador;

import client.interfaz.PanelIp;
import client.interfaz.PanelNick;
import archivo.HelloSocket;
import archivo.ReadFile;

public class Controlador {
    // Atributos

    // Relaciones 	
    private HelloSocket helloSocket;
    private ReadFile readFile;
    private PanelIp panelIP;
    private PanelNick panelNick;

    // Constructor	
    public Controlador() {
         helloSocket = new HelloSocket();
    
    }

    // Recibe las referencias de los objetos a controlar en la interfaz	
    public void conectar(ReadFile readFile, PanelIp panelIP, PanelNick panelNick) {
        this.readFile = readFile;
        this.panelIP = panelIP;
        this.panelNick = panelNick;

    }

    // --------------------------------------------------------------	
    // Implementacion de los requerimientos de usuario.	
    // --------------------------------------------------------------
    public void socket(String msg) {
        helloSocket.socket(msg);
    }

    public void cargarConfiguracion() {
        readFile.leerConfiguracion("archivo1.in");
        panelIP.setIP(readFile.getConfiguracion(2));
        panelNick.setNick(readFile.getConfiguracion(0));
    }

}
