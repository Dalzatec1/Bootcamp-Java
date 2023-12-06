import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        String texto = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme, " +
                "no ha mucho tiempo que vivía un hidalgo de los de lanza en astillero, " +
                "adarga antigua, rocín flaco y galgo corredor.";

        Map<String, Integer> map = Contador(texto);

        // Ordenar las palabras por frecuencia de mayor a menor
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    public static Map<String, Integer> Contador(String texto) {
        String[] palabras = texto.split(" ");
        Map<String, Integer> contador = new TreeMap<>();

        for (String palabra : palabras) {
            if (contador.containsKey(palabra)) {
                contador.put(palabra, contador.get(palabra) + 1);
            } else {
                contador.put(palabra, 1);
            }
        }

        return contador;
    }
}