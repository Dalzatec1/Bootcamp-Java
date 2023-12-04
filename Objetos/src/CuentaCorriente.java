/**
 * Crea una clase CuentaCorriente, con los métodos: ingreso, egreso, reintegro y transferencia.
 * La clase contendrá un constructor por defecto, uno con parámetros y otro que recibirá una
 * CuentaCorriente de la cual copiará todos sus datos. Además se deben desarrollar los
 * métodos de acceso (para cada variable de instancia de la clase, desarrollar un método
 * set y otro get. Por ejemplo: si la clase tiene una variable double saldo,
 * sus métodos de acceso serán: double getSaldo() y void setSaldo(double s)
 */
public class CuentaCorriente {

    private String cuenta;
    private double saldo;
    public CuentaCorriente() {
        this.cuenta="Sin titular";
        //this.saldo=0.0;
    }

    public CuentaCorriente(String cuenta, double saldo) {
        this.cuenta = cuenta;
        this.saldo = saldo;
    }
    public CuentaCorriente(CuentaCorriente corriente){
        this.cuenta=corriente.getCuenta();
        this.saldo=corriente.getSaldo();
    }

    public String getCuenta() {
        return cuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void ingresos(double ingreso){
        this.saldo+=ingreso;
    }
    public void egreso(double egreso){
        if(this.saldo>=egreso){
            this.saldo-=egreso;
        }
        else{
            System.out.println("No se puede retirar el monto de la cuenta");
            }
    }

    public void reintegro(double valor){
        this.saldo+=valor;
    }
    public void trasnferencia(CuentaCorriente otraCuenta, double valor){

        if(this.saldo>=valor){
            this.egreso(valor);
            otraCuenta.ingresos(valor);

        }
        else {
            System.out.println("el monto total es superior al de la cuenta para esta transferencia");
        }
    }
}
