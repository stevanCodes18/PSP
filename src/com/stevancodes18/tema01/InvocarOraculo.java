package com.stevancodes18.tema01;

import java.io.IOException;

public class InvocarOraculo {
    public static void main(String[] args)throws IOException,InterruptedException {
      //argumentos de ejemplo
        String nombre="stevan";
        String pregunta="¿?";

        ProcessBuilder pb=new ProcessBuilder(
                "java",
                "-cp",System.getProperty("java.class.path"),
                "com.stevancodes18.tema01.Oraculo",
                nombre,pregunta
        );
        pb.inheritIO();

        Process hijo=pb.start();

        int codigoSalida=hijo.waitFor();
        System.out.println("Codigo de Salida: "+ codigoSalida);
    }
}
