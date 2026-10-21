package com.stevancodes18.tema01;

public class Mascota {
    public static void main(String[] args) {
        if (args.length < 2){
            System.err.println("Uso: Mascota nombre, pasos");
            System.exit(1);
        }

        String nombre = args[0];
        int pasos;

        try{
            pasos=Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            System.err.println("El numero debe de ser un entero");
            System.exit(2);
            return;
        }

        long pid=ProcessHandle.current().pid();

        for (int i=0;i<=pasos;i++){
            System.out.println("PID= "+pid+ " | "+nombre+ " | paso " + i);
            try{
                Thread.sleep(100 + (int)(Math.random()*200));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }


    }
}
