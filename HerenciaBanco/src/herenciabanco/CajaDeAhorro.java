package herenciabanco;

public class CajaDeAhorro extends Cuenta {

    public CajaDeAhorro(int numero, String nombre, double saldo) {
        super(numero, nombre, saldo);
    }
    
    @Override
    public void extraer(double monto){
        if(getSaldo() > monto){
            setSaldo(getSaldo()-monto);
            System.out.println("La extraccion de $ " + monto + " se realizo correctamente\nSaldo actual: $ " + getSaldo());
        }
        else
            System.out.println("Saldo insuficiente");
    }
    
}
