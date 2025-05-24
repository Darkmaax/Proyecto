package Practica;

public class Main {
    public static void main(String[] args) {
        Product teclado = new Product();
        teclado.nombre = "Teclado Redragon";
        teclado.precio = 20000;
        teclado.stock = 20;

        teclado.reporteProducto();
        double precio = teclado.precioConDescuento();
        System.out.println("Precio con descuento" + precio);


        Product mouse = new Product();
        mouse.nombre = "Mouse Redragon";
        mouse.precio = 10000;
        mouse.stock = 20;

        mouse.reporteProducto();
        System.out.println("Precio con descuento" + precio);


    }
}
