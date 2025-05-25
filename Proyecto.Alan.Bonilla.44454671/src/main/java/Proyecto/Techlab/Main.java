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
                4) Eliminar producto *solo para administradores*
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
        System.out.println("Esta opcion es solo para administradores");
        System.out.println("Inserte la clave de admin para tener acceso");
        int claveAdmin = 123;
        Scanner entrada = new Scanner(System.in);
        int claveUsuario;
        claveUsuario = entrada.nextInt();
        boolean encontrado = false;
        if (claveAdmin == claveUsuario){
            System.out.println("Contraseña correcta.");
            System.out.println("👾Bienvenido admin👾");
            System.out.println("Ingrese el ID del producto a eliminar");
            int idAEliminar = entrada.nextInt();
            for (Producto producto : productos){
                if (producto.getId() == idAEliminar){
                    encontrado = true;
                    System.out.println("Este es el producto que se eliminará");
                    producto.mostrarInfo();
                    System.out.println("Confirma la accion?");
                    System.out.println("""
                        1 - SI
                        2 - NO
                        """);
                    int opcionEliminar = entrada.nextInt();
                    if (opcionEliminar == 1){
                        System.out.println("Producto eliminado ❌");
                        productos.remove(producto);
                    }
                    break;
                }
            }
            if (!encontrado){
                System.out.println("No encontramos ningun producto con el id: " + idAEliminar);
            }
        }else {
            System.out.println("Contraseña incorrecta.");
            System.out.println("Usted no tiene acceso a estas opciones.");
            System.out.println("");
        }

    }

    private static void buscarProducto(ArrayList<Producto> productos) {
        System.out.println("Buscador de productos");
        Scanner entrada = new Scanner(System.in);
        String busqueda = entrada.nextLine();
        ArrayList<Producto> productosEncontrados = new ArrayList<>();
        int contadorDeProductos = 0;
        for (Producto producto : productos){
            if (producto.contieneNombre(busqueda)){
                productosEncontrados.add(producto);
                contadorDeProductos++;

            }
        }
        if (productosEncontrados.isEmpty()){
            System.out.println("No encontramos productos...");
        }else{
            System.out.println("✅Se encontraron " + contadorDeProductos + " productos✅");
            System.out.println("Los productos son los siguientes...");
            System.out.println("---------------------------");
            for (Producto producto : productosEncontrados){
                producto.mostrarInfo();
                System.out.println("----------------------");
            }
        }
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

    public static void agregarProductosDeEjemplo(ArrayList<Producto> productos) {
        productos.add(new Producto("Monitor", 300000, 20));
        productos.add(new Producto("Tarjeta gráfica", 500000, 10));
        productos.add(new Producto("Gabinete", 100000, 30));
        productos.add(new Producto("Teclado mecánico", 45000, 50));
        productos.add(new Producto("Mouse gamer", 35000, 40));
        productos.add(new Producto("Auriculares inalámbricos", 80000, 25));
        productos.add(new Producto("Notebook", 750000, 15));
        productos.add(new Producto("Tablet", 250000, 12));
        productos.add(new Producto("Smartphone", 600000, 18));
        productos.add(new Producto("Disco SSD 1TB", 120000, 22));
        productos.add(new Producto("Memoria RAM 16GB", 70000, 35));
        productos.add(new Producto("Procesador Intel i7", 180000, 10));
        productos.add(new Producto("Motherboard", 150000, 14));
        productos.add(new Producto("Fuente de poder 650W", 95000, 16));
        productos.add(new Producto("Webcam HD", 30000, 28));
        productos.add(new Producto("Impresora multifunción", 160000, 8));
        productos.add(new Producto("Parlantes Bluetooth", 55000, 32));
        productos.add(new Producto("Cámara de seguridad", 90000, 20));
        productos.add(new Producto("Router WiFi", 60000, 25));
        productos.add(new Producto("Smartwatch", 100000, 19));
    }

}
