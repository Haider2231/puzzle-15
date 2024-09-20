
package client.mundo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
