package herenciabanco;

import java.util.Scanner;

public class HerenciaBanco {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);        
        CajaDeAhorro ca = new CajaDeAhorro(1, "Carlos", 5000);
        CuentaCorriente cc = new CuentaCorriente(2, "Martin", 3000, 100);
        
        int opcion = 0;
        
        while(opcion != 3){
            
            System.out.println("\n***BANCO***"
                                + "\n (1) - Extraer"
                                + "\n (2) - Depositar"
                                + "\n (3) - Salir");
            
            opcion = sc.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el numero de cuenta");
                    int nroCuenta = sc.nextInt();
                    System.out.println("Ingrese el monto");
                    double monto = sc.nextInt();
                    
                    if(nroCuenta == 1)
                        ca.extraer(monto);
                    else if(nroCuenta == 2)
                        cc.extraer(monto);
                    else
                        System.out.println("No existe esta cuenta");
                    
                    break;
                case 2:
                    System.out.println("Ingrese el numero de cuenta");
                    int nroCuentaD = sc.nextInt();
                    System.out.println("Ingrese el monto");
                    double montoD = sc.nextInt();
                    
                    if(nroCuentaD == 1)
                        ca.depositar(montoD);
                    else if(nroCuentaD == 2)
                        cc.depositar(montoD);
                    else
                        System.out.println("No existe esta cuenta");
                    
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }
        System.out.println("Programa Finalizado.");
    }
    
}
