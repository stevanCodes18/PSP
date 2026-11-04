package com.stevancodes18.tema01;

import java.io.IOException;

public class InvocarOraculo {
    public static void main(String[] args)throws IOException,InterruptedException {
      //argumentos de ejemplo(pregunta con espacios)
        String nombre="stevan";
        String pregunta="¿que tan malo es el oraculo?";

        // ProcessBuilder configura el comando y sus argumentos
        ProcessBuilder pb=new ProcessBuilder(
                "java",
                "-cp",System.getProperty("java.class.path"),
                "com.stevancodes18.tema01.Oraculo",
                nombre,pregunta
        );

        // inheritIO() → el hijo hereda stdin/stdout/stderr del padre
        // (así vemos la salida del oráculo en la consola)
        pb.inheritIO();

        //start() crea el proceso hijo
        Process hijo=pb.start();

        // waitFor() espera a que el hijo termine y devuelve el código de salida
        int codigoSalida=hijo.waitFor();
        System.out.println("Codigo de Salida: "+ codigoSalida);
    }
}
