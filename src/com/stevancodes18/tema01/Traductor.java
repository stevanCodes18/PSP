package com.stevancodes18.tema01;
import java.io.*;
import java.nio.charset.StandardCharsets;
public class Traductor {

    /**
     * Lanza el Robot, le envía al menos tres mensajes por su stdin,
     * cierra el flujo y lee todas las respuestas.
     */
        public static void main(String[] args) throws IOException, InterruptedException {
            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "-cp", System.getProperty("java.class.path"),
                    "com.germangascon.tema01.Robot"
            );

            // No usamos inheritIO porque queremos controlar los flujos nosotros
            Process robot = pb.start();

            // Escribimos en la entrada estándar del hijo (getOutputStream)
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(robot.getOutputStream(), StandardCharsets.UTF_8))) {

                writer.write("Hola robot");
                writer.newLine();
                writer.write("¿Cómo estás?");
                writer.newLine();
                writer.write("Traduce este mensaje");
                writer.newLine();
                writer.flush();          // forzamos el envío
                // Al cerrar el writer se cierra el flujo → el hijo recibe EOF
            }

            // Leemos la salida estándar del hijo (getInputStream)
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(robot.getInputStream(), StandardCharsets.UTF_8))) {

                String respuesta;
                while ((respuesta = reader.readLine()) != null) {
                    System.out.println("Respuesta del robot: " + respuesta);
                }
            }

            int codigo = robot.waitFor();
            System.out.println("Código de salida del robot: " + codigo);
        }
    }

