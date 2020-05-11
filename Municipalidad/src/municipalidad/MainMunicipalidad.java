package municipalidad;

import java.util.Scanner;

public class MainMunicipalidad {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("****PLANES MUNICIPALIDAD****");
        System.out.println("Ingrese la cantidad de planes");
        int cantidadPlanes = sc.nextInt();
        sc.nextLine();
        Municipalidad muni = new Municipalidad(cantidadPlanes);
        
        
        for (int i = 0; i < cantidadPlanes; i++) {           
            System.out.println("ingrese el nombre del contribuyente del plan " + (i+1));
            String nombre = sc.nextLine();
            if(i > 0){
                while(muni.existePlan(nombre)){
                    System.out.println("Ya existe un plan para el contribuyente ingresado. Ingrese otro contribuyente");
                    nombre =sc.nextLine();
                }
            }
            System.out.println("ingrese el importe de la deuda del plan " + (i+1));
            float deuda = sc.nextFloat();            
            System.out.println("ingrese la cantidad de cuotas del plan " + (i+1));
            int cantidadCuotas = sc.nextInt();
            sc.nextLine();
            Plan p = new Plan(nombre, deuda, cantidadCuotas);
            muni.agregarPlan(p);
        }
        
        int opcion = 0;
        
        while(opcion != 6){
            System.out.println("\n***MENU***"
                    + "\n(1) - Cargar un nuevo pago"
                    + "\n(2) - Cantidad de planes pagados en su totalidad"
                    + "\n(3) - Sumatoria de las deudas registradas"
                    + "\n(4) - Listado de todos los pagos efectuados por un contribuyente en particular"
                    + "\n(5) - Promedio general de intereses adicionales cobrados"
                    + "\n(6) - Salir");
            
            opcion = sc.nextInt();            
            sc.nextLine();
            
            switch(opcion){
                case 1:                    
                    System.out.println("Ingrese el nombre del contribuyente");
                    String nombre = sc.nextLine();
                    if(muni.existePlan(nombre)){
                        System.out.println("Ingrese el importe");
                        float importe = sc.nextFloat();
                        System.out.println("Ingrese la demora");
                        int demora = sc.nextInt();
                        Pago pago = new Pago(demora, importe);
                        muni.asignarPago(pago, nombre);
                    }
                    else
                        System.out.println("No existe un plan para el contribuyente ingresado");
                    break;
                case 2:
                    System.out.println("Cantidad de planes pagados en su totalidad: " + muni.cantidadPlanesPagados());
                    break;
                case 3:
                    System.out.println("Sumatoria de las deudas registradas: " + muni.sumatoriaDeuda());
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del contribuyente");
                    System.out.println(muni.listadoPagosContribuyente(sc.nextLine()));
                    break;
                case 5:                    
                    System.out.println("Promedio general de intereses adicionales cobrados: " + muni.promedioIntereses());
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("la opcion ingresada no es valida. Intente de nuevo");
                    break;
            }
        }
        System.out.println("El programa ha finalizado.");
    }
    
}
