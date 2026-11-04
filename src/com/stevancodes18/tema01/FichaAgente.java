package com.stevancodes18.tema01;

import java.util.Objects;

public class FichaAgente {
    //recibimos el alias por argumento
    public static void main(String[] args) {
       String alias=(args.length>0)?args[0]:"sin alias";

        ProcessHandle proceso = ProcessHandle.current();
        ProcessHandle.Info info = proceso.info();

        System.out.println("===Ficha Agente===");
        System.out.println("Alias: " + alias);
        System.out.println("PID: "+proceso.pid());

        //PID del padre
        proceso.parent().ifPresentOrElse(
                padre-> System.out.println("PID del padre: "+padre.pid()),
                        ()-> System.out.println("PID del padre: "+"No disponible")
        );
        //usuario
        System.out.println("Usuario: "+info.user().orElse("no disponible"));

        //instatne de inicio
        System.out.println("Inicio: "+ info.startInstant()
                .map(Objects::toString)
                .orElse("no disponible"));
    }
}
//ProcessHandle.current() → representa el proceso Java actual.
  //      proceso.pid() → identificador del proceso (PID).
    //    proceso.parent() → Optional con el proceso padre.
      //  info.user() → Optional con el usuario del proceso.
       // info.startInstant() → Optional con el Instant de arranque.
//orElse("no disponible") → manejo seguro cuando el SO no proporciona el dato.