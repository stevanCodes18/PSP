package com.stevancodes18.tema01;

import java.util.Objects;

public class FichaAgente {
    public static void main(String[] args) {
       String alias=(args.length>0)?args[0]:"sin alias";

        ProcessHandle proceso = ProcessHandle.current();
        ProcessHandle.Info info = proceso.info();

        System.out.println("===Ficha Agente===");
        System.out.println("Alias: " + alias);
        System.out.println("PID: "+proceso.pid());

        proceso.parent().ifPresentOrElse(
                padre-> System.out.println("PID del padre: "+padre.pid()),
                        ()-> System.out.println("PID del padre: "+"No disponible")
        );

        System.out.println("Usuario: "+info.user().orElse("no disponible"));

        System.out.println("Inicio: "+ info.startInstant()
                .map(Objects::toString)
                .orElse("no disponible"));
    }
}
