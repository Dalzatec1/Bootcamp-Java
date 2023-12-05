/**
 * Necesitamos una aplicación para una tienda mediante la que queremos almacenar
 * los distintos productos que venderemos y el precio que tendrán.
 * Y se quiere que tenga las funciones básicas, introducir un elemento,
 * modificar su precio, eliminar un producto y mostrar los productos que tenemos con su precio.
 * (todo esto solicitandoles los datos y las opciones por consola)
 * */

import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        String nombre;
        double precio;
        boolean productoEncontrado;
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner teclado= new Scanner(System.in);

        while (true){
            System.out.println("1. Para introducir productos");
            System.out.println("2. Para ver productos");
            System.out.println("3. Para actualizar producto");
            System.out.println("4. Para borrar producto");
            System.out.println("5. Salir");
            System.out.println("Escriba su opción: ");


            int opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    System.out.println("Ingrese Nombre del producto");
                    nombre = teclado.next();
                    System.out.println("Ingrese precio:");
                    precio = teclado.nextDouble();
                    productos.add(new Producto(nombre,precio));
                    break;
                case 2:
                    for (Producto producto: productos){
                        System.out.println(producto.getNombre()+" "+producto.getPrecio()+"$");
                    }
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("Escriba el nombre del producto a modificar el precio");
                    nombre = teclado.next();
                    productoEncontrado = false;
                    for (Producto producto: productos){
                        if(producto.getNombre().equals(nombre)){
                            System.out.println("Ingrese el valor del producto");
                            precio = teclado.nextDouble();
                            producto.setPrecio(precio);
                             productoEncontrado = true;
                            System.out.println("Precio del producto modificado con éxito.\n");
                            break;
                        }
                    }

                    if (!productoEncontrado) {
                        System.out.println("El producto no existe.\n");
                    }
                    break;
                case 4:
                    System.out.println("Escriba el nombre del producto a eliminar");
                    nombre = teclado.next();
                    productoEncontrado = false;
                    for (Producto producto: productos){
                        if(producto.getNombre().equals(nombre)){
                            productoEncontrado = true;
                            productos.remove(producto);
                            System.out.println("Producto eliminado");
                            break;
                        }

                      }
                    if(!productoEncontrado){
                        System.out.println("El producto que desea eliminar no existe \n");
                        break;
                    }

                case 5:
                    System.exit(0);
                default:
                    System.out.println("Escriba una opción valida");
            }
        }
    }
}