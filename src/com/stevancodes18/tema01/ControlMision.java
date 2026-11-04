package com.stevancodes18.tema01;

import java.io.IOException;
import java.util.Map;
/**
 * Lanza Starship añadiendo la variable de entorno PLANETA
 * que solo estará disponible para el proceso hijo.
 */
public class ControlMision {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",System.getProperty("java.class.path"),
                "com.stevancodes18.tema01.Starship",
                "colonizacion"
        );
        // environment() → mapa de variables de entorno del hijo
        // Inicialmente es una copia del entorno del padre
        Map<String, String> entorno = pb.environment();
        // Añadimos/modificamos la variable PLANETA (solo para el hijo)
        entorno.put("Planeta","Marte");

        pb.inheritIO();
        Process hijo= pb.start();

        int codigo= hijo.waitFor();
        System.out.println("Codigo salida: "+codigo);

    }
}
//pb.environment() → obtiene el mapa de variables de entorno que recibirá el hijo.
  //      entorno.put("PLANETA", "Marte") → añade una variable que solo existe en el hijo.
    //    System.getenv("PLANETA") (en el hijo) → lee la variable de entorno.
//Si no existe, el hijo usa un valor predeterminado (Tierra).