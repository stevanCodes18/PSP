public class Saludo {
    public  static void main(String[] args) {
        System.out.println("hola desde Saludo");
        String nombre= System.getenv("Nombre");
        String apellidos= System.getenv("Apellidos");
        System.out.println("Nombre: "+nombre);
        System.out.println("Apellidos: "+apellidos);
    }
}
