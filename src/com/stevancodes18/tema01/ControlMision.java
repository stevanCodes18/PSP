package com.stevancodes18.tema01;

import java.io.IOException;
import java.util.Map;

public class ControlMision {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(
                "java",
                "-cp",System.getProperty("java.class.path"),
                "com.stevancodes18.tema01.Starship",
                "colonizacion"
        );

        Map<String, String> entorno = pb.environment();
        entorno.put("Planeta","Marte");

        pb.inheritIO();
        Process hijo= pb.start();

        int codigo= hijo.waitFor();
        System.out.println("Codigo salida: "+codigo);

    }
}
