/**
 * Ejercicio 4: Crea una clase Fraccion con métodos necesarios para sumar, restar, multiplicar y dividir fracciones.
 * Todos los métodos deben estar sobrecargados de modo que también puedan usarse para operar entre fracciones
 * y números enteros (por ejemplo: ⅗+2 o ⅝*4)
 */
public class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(){
        this.denominador=1;
    }

    public Fraccion(int numerador, int denominador){
        if (denominador == 0) {
            throw new IllegalArgumentException("El denominador no puede ser cero.");
        }
        this.numerador=numerador;
        this.denominador=denominador;
    }

    public Fraccion(int numerador){
        this.numerador=numerador;
        this.denominador=1;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
    }

    public int denominador(int primero, int segundo){
        return primero*segundo;
    }

    public int sumaNumerador(Fraccion segundo){

        int numerador1=getNumerador()*segundo.getDenominador();
        int numerador2= segundo.getNumerador()*getDenominador();

        return numerador1+numerador2;
    }

    public int restaNumerador(Fraccion segundaFraccion){

        int numerador1=getNumerador()*segundaFraccion.getDenominador();
        int numerador2= segundaFraccion.getNumerador()*getDenominador();

        return numerador1-numerador2;
    }
    public int multiplicarNumerador(Fraccion segundaFraccion){

        return  getNumerador()* segundaFraccion.getNumerador();
    }
    public void sumar(Fraccion segundaFraccion){
        this.numerador=sumaNumerador(segundaFraccion);
        this.denominador=denominador(getDenominador(),segundaFraccion.getDenominador());
        simplificar();
    }
    public void restar(Fraccion segundaFraccion){
        this.numerador=restaNumerador(segundaFraccion);
        this.denominador=denominador(getDenominador(),segundaFraccion.getDenominador());
        simplificar();
    }

    public void multiplicar(Fraccion segundaFraccion){
        this.numerador=multiplicarNumerador(segundaFraccion);
        this.denominador=denominador(getDenominador(), segundaFraccion.getDenominador());
        simplificar();
    }

    public void dividir(Fraccion segundaFraccion){
        this.numerador *= segundaFraccion.getDenominador();
        this.denominador *=segundaFraccion.getNumerador();
        simplificar();
    }
    public boolean esEntero(){
        return this.denominador==1;
    }

    public void simplificar() {
        int mcd = calcularMCD(this.numerador, this.denominador);
        this.numerador /= mcd;
        this.denominador /= mcd;
    }

    private int calcularMCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        if(esEntero()){
            return String.valueOf(getNumerador());
        }
        else{
            return getNumerador() + "/" + getDenominador();
        }

    }
}
