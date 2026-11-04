package com.stevancodes18.tema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
/**Lanza tres mascotas como procesos hijos y anuncia las llegadas
  sin asumir el orden de finalización.
   **/
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
            pb.inheritIO(); // vemos la salida de cada mascota
            Process p= pb.start();
            hijo.add(p);
            System.out.println("Lanzada de mascotas: "+ mascota[0]+" (PID hijo=  "+p.pid()+")");
        }

        // Esperamos a que termine cualquiera y luego el resto
        // (no usamos waitFor() en un bucle fijo de orden)
        int llegadas=0;
        while (llegadas<hijo.size()) {
            for (int i=0;i<hijo.size();i++) {
                Process p=hijo.get(i);
                if (p != null && !p.isAlive()) {
                    int codigo= p.exitValue();
                    System.out.println("--- Llegada #" + (llegadas+1) + " | PID hijo= " + p.pid() +"| Codigo de Salida= " + codigo );
                    hijo.set(i,null); // marcamos como procesada
                    llegadas++;
                }
            }
            //espera para no saturar cpu
            TimeUnit.MILLISECONDS.sleep(50);
        }
        System.out.println("Carrera Finalizada");

    }
}
//ProcessBuilder + start() → crea cada proceso hijo (mascota).
  //      pb.inheritIO() → la salida de las mascotas se ve en la consola del padre.
    //    p.pid() → PID del hijo.
      //  p.isAlive() / p.exitValue() → detectamos cuándo ha terminado y su código.
//No se asume orden: se comprueba continuamente qué hijo ha finalizado primero.