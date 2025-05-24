package Proyecto.Techlab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        agregarProductosDeEjemplo(productos);

        Scanner entrada = new Scanner(System.in);
        int opcionUsuario;

        System.out.println(" 😁 Bienvenidos a TiendaMia 😁");

        do {
            System.out.println("""
            Para continuar elija una opcion
            Opciones:
                1) Agregar producto
                2) Listar productos
                3) Buscar/actualizar producto
                4) Eliminar producto
                5) Crear producto
                6) Listar pedidos
                7) Salir

                """);

            opcionUsuario = entrada. nextInt();

            switch (opcionUsuario){
                case 1 -> agregarProducto(productos);
                case 2 -> listarProductos(productos);
                case 3 -> buscarProducto(productos);
                case 4 -> eliminarProducto(productos);
                case 5 -> System.out.println("Crear productos");
                case 6 -> System.out.println("Listar pedidos");
                case 7 -> System.out.println("Gracias por usar la app");
                default -> System.out.println("Opcion incorrecta, Elija una opcion");
            }
        }while (opcionUsuario != 7);
    }

    private static void eliminarProducto(ArrayList<Producto> productos) {
        System.out.println("Eliminar producto");
    }

    private static void buscarProducto(ArrayList<Producto> productos) {
        System.out.println("Buscar/Actualizar producto");
    }

    private static void listarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()){
            System.out.println("No hay productos");
        }else {
            for (Producto producto : productos){
                System.out.println("---------------");
                producto.mostrarInfo();
                System.out.println("---------------");
            }
        }
    }

    public static void agregarProducto(ArrayList<Producto> productos) {
        Scanner entrada = new Scanner(System.in);
        int opcionDeUsuario;
        System.out.println("Menu para agregar productos");
        do {

            System.out.println("Seguro que quiere agregar productos?");
            System.out.println("""
                    1) Si
                    2) Volver al menu
                    """);
            opcionDeUsuario = entrada. nextInt();

            switch (opcionDeUsuario){
                case 1->{
                    Scanner entrada1 = new Scanner(System.in);
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = entrada1.nextLine();
                    System.out.printf("Ingrese el precio de %s", nombre);
                    System.out.println("");
                    double precio = entrada1.nextDouble();
                    System.out.printf("Ingrese el stock de %s", nombre);
                    System.out.println("");
                    int stock = entrada1.nextInt();
                    Producto producto = new Producto(nombre, precio, stock);

                    productos.add(producto);

                    System.out.println("Producto agregado correctamente ✅");
                }
                case 2-> System.out.println("Volvemos al menu");
                }

            }while(opcionDeUsuario != 2);
    }

    public static void agregarProductosDeEjemplo(ArrayList<Producto> productos){
        Producto producto1 = new Producto("Monitor", 300000, 20);
        Producto producto2 = new Producto("Tarjeta grafica", 500000, 10);
        Producto producto3 = new Producto("Gabinete", 100000, 30);
        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
    }
}
