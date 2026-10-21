package com.stevancodes18.tema01;

public class FichaAgente {
    public static void main(String[] args) {
        ProcessHandle proceso = ProcessHandle.current();
        ProcessHandle.Info info = proceso.info();

        System.out.println("PID: "+ proceso.pid());
        System.out.println("Esta activo: "+ proceso.isAlive());

        String comando = info.command().orElse("No disponible");
        String usuario= info.user().orElse("No disponible");


        String inicio= info.startInstant().map(Object::toString).orElse("No disponible");

        System.out.println("Ejecutable: "+ comando);
        System.out.println("Usuario: "+ usuario);
        System.out.println("Inicio: "+ inicio);

        proceso.parent().ifPresentOrElse(
                padre -> System.out.println(
                        "PID del padre:" + padre.pid()
                ),
                ()-> System.out.println("Proceso padre no disponible")
        );

    }
}
