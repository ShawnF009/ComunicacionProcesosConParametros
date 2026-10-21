package Ejer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TransformadorTxt {

    public static void main(String[] args) {
        try {
            // El proceso hijo lee de su entrada estándar
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String linea;
            // Lee líneas hasta que el flujo de entrada se cierre
            while ((linea = br.readLine()) != null) {
                // Transforma a mayúsculas y escribe en la salida estándar
                System.out.println(linea.toUpperCase());
                // Hacemos flush para asegurar que el padre lo reciba inmediatamente
                System.out.flush();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}