public class Contador {

    private Integer valor;

    public Contador(){
        this.valor=0;
    }
    public Contador(int valor){
        this.valor=valor;
    }
    public Contador(Contador contador){
        this.valor=contador.getValor();
    }
    public Integer getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar(){
        this.valor++;
    }

    public void decrementar(){
        this.valor--;
    }

}
