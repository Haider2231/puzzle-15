package archivo;

import client.interfaz.PanelChat;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class HelloSocket implements Runnable {

    private ReadFile readFile;
    private PanelChat panelChat;
    private String userName;
    
    /* Constructor */
    public HelloSocket() {
        panelChat = new PanelChat();
        readFile = new ReadFile();
        readFile.leerConfiguracion("archivo1.in");
        this.userName = readFile.getConfiguracion(1);
        Thread treadListener = new Thread(this);
        treadListener.start();
    }

    /* Client:Data >> Socket >> Server */
       public void socket(String msg) {
        new Thread(() -> {
            try {
                 
                String ip = readFile.getConfiguracion(2); // Obtiene la IP
                int puertoEntrada = Integer.parseInt(readFile.getConfiguracion(3));

                Socket client = new Socket();
                client.connect(new InetSocketAddress(ip, puertoEntrada), 5000); // Timeout de 5000 ms

                DataOutputStream outBuffer = new DataOutputStream(client.getOutputStream());
                String formatMessage = userName + ": " + msg; 
                outBuffer.writeUTF(formatMessage);
                client.close();
            } catch (UnknownHostException e) {
                JOptionPane.showMessageDialog(null, "Client: socket(1) : UnknownHostException: " + e.getMessage());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Client: socket(2) : IOException: " + e.getMessage());
            }
        }).start();
    }
    @Override
    /* Client: Listen */
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
            int portListen = Integer.parseInt(readFile.getConfiguracion(4));
            serverSocket = new ServerSocket(portListen); // portListen 5050

            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
               
                String msg = userName + ": "+ inDataBuffer.readUTF();
                panelChat.addMessage(msg);
                   
                socket.close();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Client run() : IOException: " + e.getMessage());
        }
    }
}
