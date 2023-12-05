import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
     Scanner teclado = new Scanner(System.in);
     ArrayList<Integer> lista = new ArrayList<>();
     Integer valor = 0;


        do {
            System.out.println("Escriba un número");
            valor = teclado.nextInt();
            lista.add(valor);


        }while (valor!=-99);
        lista.remove(lista.size()-1);
        Integer suma = suma(lista);
        Integer media = suma/lista.size();

        System.out.println("La suma de la lista es: " + suma + " y la media es: " + media);

    }

    public static  Integer suma(ArrayList<Integer> lista){
        Integer suma = 0;
        for (Integer valor: lista){
            suma +=valor;
        }
        return suma;
    }
}