/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ReadFile {
    
   
    public String[] leerConfiguracion(String archivo) {
        String[] config = new String[3];

        try {
            InputStream input = getClass().getResourceAsStream("/reader/" + archivo);
            if (input == null) {
                System.out.println("No se encontró el archivo: " + archivo);
                return null;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            for (int i = 0; i < 3; i++) {
                config[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo de configuración: " + e.getMessage());
        }

        return config;
    }
}
