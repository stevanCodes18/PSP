package com.stevancodes18.tema01;

public class Starship {
    public static void main(String[] args){
        String planeta=System.getenv("Planeta");
        if (planeta==null || planeta.isBlank()){
            planeta="Tierra";
        }
        String mision=(args.length>0)?args[0]:"exploracion";

        System.out.println("===Starship===");
        System.out.println("Planeta destino: "+planeta);
        System.out.println("Mision: "+mision);
        System.out.println("Mensaje   Despegando hacia: "+ planeta +" para la mision de "+ mision);
    }
}
