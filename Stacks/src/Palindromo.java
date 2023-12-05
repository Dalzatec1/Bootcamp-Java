import java.util.Stack;

public class Palindromo {
    public static boolean esPalindromo(String cadena) {

        Stack<Character> pila = new Stack<>();

        int longitud = cadena.length();
        int mitad = longitud / 2;

        for (int i = 0; i < mitad; i++) {
            pila.push(cadena.charAt(i));
        }

        for (int i = (longitud % 2 == 0) ? mitad : mitad + 1; i < longitud; i++) {
            if (cadena.charAt(i) != pila.pop()) {
                return false;
            }
        }

        return true;
    }


}
