package server.mundo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;
import client.mundo.ReadFile;

public class HelloSocket implements Runnable {

    private ReadFile readFile;
    private static String[] config;

    /* Constructor */
    public HelloSocket() {
        readFile = new ReadFile();
        config = readFile.leerConfiguracion("archivo2.in");
        Thread treadListener = new Thread(this);
        treadListener.start();
    }

    /* Server:Data >> Socket >> Client */
    public static void socket(String msg) {
        try {

            String ip = config[0]; 
            int puertoEntrada = Integer.parseInt(config[1]);

            Socket server = new Socket(ip, puertoEntrada); // portSend 5050
            DataOutputStream outBuffer = new DataOutputStream(server.getOutputStream());
            outBuffer.writeUTF(msg);
            server.close();
        } catch (UnknownHostException e) {
            JOptionPane.showMessageDialog(null, "Server : socket() : UnknownHostException: " + e.getMessage());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Server : socket() : IOException: " + e.getMessage());
        }
    }

    @Override
    /* Server: Listen */
    public void run() {
        ServerSocket serverSocket;
        Socket socket;
        DataInputStream inDataBuffer;

        try {
             int puertoListen = Integer.parseInt(config[2]);
            serverSocket = new ServerSocket(puertoListen); // portListen 5000

            while (true) {
                socket = serverSocket.accept();
                inDataBuffer = new DataInputStream(socket.getInputStream());
                String msg = inDataBuffer.readUTF();
                System.out.println(msg);
                response("Server: Welcome to the world client/server...");
                socket.close();
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Server : run (): IOException: " + e.getMessage());
        }
    }

    public static void response(String msg) {
        socket(msg);
    }

}
