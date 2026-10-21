package com.stevancodes18.tema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Hipodromo {
    public static void main(String[] args) throws InterruptedException, IOException {
        String[][] mascotas={
                {"Rocky","8"},
                {"Chispitas","6"},
                {"Luna","9"}
        };


        List<Process> hijo=new ArrayList<>();
        String classpath=System.getProperty("java.class.path");

        //lanzamos las tres mascotas
        for (String[] mascota:mascotas) {
            ProcessBuilder pb=new ProcessBuilder(
                    "java",
                    "-cp",classpath,
                    "com.stevancodes18.tema01.Mascota",
                    mascota[0],mascota[1]
            );
            pb.inheritIO();
            Process p= pb.start();
            hijo.add(p);
            System.out.println("Lanzada de mascotas: "+ mascota[0]+" (PID hijo=  "+p.pid()+")");
        }

        int llegadas=0;
        while (llegadas<hijo.size()) {
            for (int i=0;i<hijo.size();i++) {
                Process p=hijo.get(i);
                if (p != null && !p.isAlive()) {
                    int codigo= p.exitValue();
                    System.out.println("--- Llegada #" + (llegadas+1) + " | PID hijo= " + p.pid() +"| Codigo de Salida= " + codigo );
                    hijo.set(i,null);
                    llegadas++;
                }
            }
            //espera para no saturar cpu
            TimeUnit.MILLISECONDS.sleep(50);
        }
        System.out.println("Carrera Finalizada");

    }
}
