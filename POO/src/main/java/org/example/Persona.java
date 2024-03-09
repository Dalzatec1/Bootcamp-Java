package org.example;

import java.util.Scanner;

public class Persona {
    private String nombre;
    private int edad;
    private final String DNI;
    private char sexo;
    private double peso;
    private double altura;

    private static final char SEXO_DEFECTO = 'H';
    private static final int IMC_BAJO_PESO = -1;
    private static final int IMC_PESO_IDEAL = 0;
    private static final int IMC_SOBREPESO = 1;

    // Constructores
    public Persona() {
        this("", 0, SEXO_DEFECTO, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.DNI = generaDNI();
    }

    // Métodos privados
    private char comprobarSexo(char sexo) {
        return (sexo == 'H' || sexo == 'M') ? sexo : SEXO_DEFECTO;
    }

    private String generaDNI() {
        // Generar número aleatorio de 8 cifras
        long numero = (long) (Math.random() * 90000000L) + 10000000L;
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int indice = (int) (numero % 23);
        return String.valueOf(numero) + letras.charAt(indice);
    }

    // Métodos públicos
    public int calcularIMC() {
        double imc = peso / (altura * altura);
        if (imc < 20) {
            return IMC_BAJO_PESO;
        } else if (imc >= 20 && imc <= 25) {
            return IMC_PESO_IDEAL;
        } else {
            return IMC_SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " + edad + "\nDNI: " + DNI + "\nSexo: " + sexo + "\nPeso: " + peso + " kg\nAltura: " + altura + " m";
    }
}
