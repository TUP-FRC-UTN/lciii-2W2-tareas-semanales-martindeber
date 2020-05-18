package herenciabanco;

public class CuentaCorriente extends Cuenta {
    
    private final double acuerdo;

    public CuentaCorriente(int numero, String nombre, double saldo, double acuerdo) {
        super(numero, nombre, saldo);
        this.acuerdo = acuerdo;
    }
    
    @Override
    public void extraer(double monto){
        double d = getSaldo()-monto;
        if(d >= acuerdo){
            setSaldo(getSaldo()-monto);
            System.out.println("La extraccion de $ " + monto + " se realizo correctamente\nSaldo actual: $ " + getSaldo());
        }
        else
            System.out.println("Saldo insuficiente");
    }
}
