/**
 * Crea una clase Fecha. La clase contendrá además de los constructores que consideres
 adecuados, métodos de acceso y el método toString, tal como lo explicamos en el ejercicio
 anterior, un método para comprobar si la fecha es correcta y otro para sumarle un día al valor
 actual de la fecha. Se debe investigar y utilizar la clase GregorianCalendar para implementar
 los métodos y constructores de Fecha
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
public class Fecha {

     private GregorianCalendar fecha;


    public Fecha(int year, int month, int day) {

            if (comprobarFecha(year, month, day)) {
                this.fecha = new GregorianCalendar(year, month - 1, day);
                }
            else {
                System.err.println("Formato no válido");
            }

    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        int dia = getFecha().get(GregorianCalendar.DAY_OF_MONTH);
        int mes = getFecha().get(GregorianCalendar.MONTH);
        int year= getFecha().get(Calendar.YEAR);
        return dia + "/" + mes + "/" + year;
    }

    public void sumarDia(){

        fecha.add(GregorianCalendar.DAY_OF_MONTH,1);
    }
    public boolean comprobarFecha(int year, int month, int day) {

        return (comprobarDia(year, month, day) && comprobarMes(month));

    }
    public boolean comprobarDia(int year, int month, int day) {
        try {
            int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            if (month < 1 || month > 12) {
                throw new ArrayIndexOutOfBoundsException("Mes no válido");

            }

            return (day >= 1 && day <= diasPorMes[month - 1]) || (esBisiesto(year) && (month == 2 && day == 29));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }

    public boolean comprobarMes(int month){
        return (month >= 1 && month <= 12);
    }

    private static boolean esBisiesto(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
