package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir datos por teclado
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la edad:");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.println("Introduce el sexo (H/M):");
        char sexo = scanner.nextLine().charAt(0);
        System.out.println("Introduce el peso (kg):");
        double peso = scanner.nextDouble();
        System.out.println("Introduce la altura (m):");
        double altura = scanner.nextDouble();

        // Crear objetos Persona
        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();
        persona3.setNombre(nombre);
        persona3.setEdad(edad);
        persona3.setSexo(sexo);
        persona3.setPeso(peso);
        persona3.setAltura(altura);

        // Comprobar IMC y si es mayor de edad
        Persona[] personas = {persona1, persona2, persona3};
        for (Persona persona : personas) {
            int imc = persona.calcularIMC();
            String mensajeIMC;
            switch (imc) {
                case -1:
                    mensajeIMC = "Tiene bajo peso.";
                    break;
                case 0:
                    mensajeIMC = "Está en su peso ideal.";
                    break;
                case 1:
                    mensajeIMC = "Tiene sobrepeso.";
                    break;
                default:
                    mensajeIMC = "No se pudo calcular el IMC.";
            }

            String mensajeEdad = persona.esMayorDeEdad() ? "Es mayor de edad." : "Es menor de edad.";

            System.out.println("\nInformación de la persona:");
            System.out.println(persona.toString());
            System.out.println(mensajeIMC);
            System.out.println(mensajeEdad);
        }

        scanner.close();
    }
}