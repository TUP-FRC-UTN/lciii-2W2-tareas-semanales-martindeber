package herenciabanco;

public class Cuenta {
    
    private int numero;
    private String nombre;
    private double saldo;

    public Cuenta(int numero, String nombre, double saldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.saldo = saldo;
    }   
    
    public void depositar(double monto){
        saldo += monto;
        System.out.println("Se depositaron $ " + monto + " - Saldo actual: $ " + saldo);
    }
    
    public void extraer(double monto){
        saldo -= monto;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}
