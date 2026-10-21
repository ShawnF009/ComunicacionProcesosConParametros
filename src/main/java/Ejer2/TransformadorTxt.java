package Ejer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TransformadorTxt {
    public static void main(String[] args) {
        BufferedReader lectorEntrada = new BufferedReader(new InputStreamReader(System.in));
        String lineaTexto;

        try {
            while ((lineaTexto = lectorEntrada.readLine()) != null) {
                if (lineaTexto.equalsIgnoreCase("fin")) {
                    break;
                }
                // Convierte la línea recibida a mayúsculas y la imprime por su salida estándar
                System.out.println(lineaTexto.toUpperCase());
            }
        } catch (IOException e) {
            System.err.println("Error en el transformador: " + e.getMessage());
        }
    }
}