package Practica;

public class Product {
    String nombre;
    double precio;
    int stock;

    void descontarStock(){
        //aca va el comportamiento para descontar stock
        System.out.println("Descontando stock...");
    }

    double precioConDescuento(){
        return precio - this.precio * 0.2;
    }

    void reporteProducto(){
        System.out.println("El producto " + nombre + " vale $" + precio);
    }
}