package archivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author ASUS
 */
public class ReadFile {

    private String[] config;

    public ReadFile() {
        this.config = new String[5];
    }

    public void leerConfiguracion(String archivo) {

        try {
            InputStream input = getClass().getResourceAsStream("/archivo/" + archivo);
            if (input == null) {
                System.out.println("No se encontró el archivo: " + archivo);
                return;
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            for (int i = 0; i < 5; i++) {
                config[i] = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo de configuración: " + e.getMessage());
        }

    }

    public String getConfiguracion(int index) {
        return config[index];

    }

  
}
