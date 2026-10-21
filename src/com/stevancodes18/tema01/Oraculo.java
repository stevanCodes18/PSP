package com.stevancodes18.tema01;

import java.io.IOException;
import java.util.List;

public class Oraculo {
    private static final String[] Excusas={
            "El destino aun no ha decidido",
            "El universo necesita mas cafe",
            "El oraculo esta de vaciones vuelva mañana",
            "La respuesta esta en el viento... o en google",
            "Consulta de nuevo despues de la siesta"
    };
    public static void main(String[] args) {
     if (args.length < 2){
         System.err.println("Uso: Oraculo nombre pregunta");
         System.exit(1);
     }

     String nombre=args[0];
     //unir los argumentos por si la pregunta tiene espacios
     StringBuilder pregunta = new StringBuilder();
     for (int i = 1; i < args.length; i++){
         if(i > 1) pregunta.append(" ");
         pregunta.append(args[i]);
     }

     int indice= pregunta.length() % Excusas.length;
     String respuesta=Excusas[indice];

        System.out.println("Hola"+nombre+" el oraculo responde:");
        System.out.println("-> " + respuesta);
    }
}
