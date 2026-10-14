import java.io.IOException;

public class Padre {
    public static void main(String[] args) {
        int codigoSalida = -1;
        String nombrePaquete = Padre.class.getPackageName();
        try {
            String classpath = System.getProperty("java.class.path");
            ProcessBuilder constructor = new ProcessBuilder(
                    "java",
                    "-cp", classpath,
                    "Saludo"
            );

             /*
            String valorPATH = System.getenv("PATH");
            System.out.println("Valor PATH: " + valorPATH);
            */
            /*
            Map<String, String> entorno = System.getenv();
            for (Map.Entry<String, String> entrada : entorno.entrySet()) {
                System.out.printf("%s = %s%n", entrada.getKey(), entrada.getValue()
                );
            }
             */


            constructor.inheritIO();
            Process proceso = constructor.start();
            codigoSalida = proceso.waitFor();

        } catch (IOException ioe) {
            System.err.println("Error al abrir el proceso: " + ioe.getMessage());
        } catch (InterruptedException ignored) { }

        System.out.println("Fin del programa con código de salida " + codigoSalida);
    }
}
