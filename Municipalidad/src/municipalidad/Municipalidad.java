package municipalidad;

public class Municipalidad {
    
    private Plan planes[];
    
    public Municipalidad(int cantidadPlanes){
        planes = new Plan[cantidadPlanes];
    }
    
    public Plan getPlan(int plan){
        return planes[plan];
    }
    
    public void agregarPlan(Plan p){
        for (int i = 0; i < planes.length;i++) {
            if(planes[i] == null){
                planes[i] = p;
                System.out.println("El plan fue agregado correctamente");
                break;
            }
        }
    }
    
    public int cantidadPlanesPagados(){
        int contador = 0;
        for (Plan plan : planes) {
            if(plan.estaPagadoTotalmente()){
                contador++;
            }
        }
        return contador;
    }
    
    public float sumatoriaDeuda(){
        float acumulador = 0;
        for (Plan plan : planes) {
            acumulador += plan.getDeuda();
        }
        return acumulador;
    }
    
    public String listadoPagosContribuyente(String nombre){
        String listado = "No existe un plan para el contribuyente ingresado";
        for (Plan plan : planes) {
            if(plan.getNombre().equalsIgnoreCase(nombre)){
                listado = plan.listadoPagos();
            }
        }
        return listado;
    }
    
    public float promedioIntereses(){
        float acumulador = 0;
        int contador = 0;
        for (Plan plan : planes) {
            acumulador = plan.sumaInteresesCobrados();
        }
        return acumulador / planes.length; // promedio general con respecto a la cantidad de planes
    }
    
    public boolean existePlan(String nombre){
        boolean planEncontrado = false;
        for (int i = 0; i < planes.length; i++) {
            if(planes[i] != null && planes[i].getNombre().equalsIgnoreCase(nombre)){
                planEncontrado = true;
                break;
            }
        }        
        return planEncontrado;
    }

    public void asignarPago(Pago pago, String nombre){
        boolean planEncontrado = false;
        for (int i = 0; i < planes.length; i++) {
            if(planes[i].getNombre().equalsIgnoreCase(nombre)){
                planes[i].agregarPago(pago);
                planEncontrado= true;         
                break;
            }
        }
        if(!planEncontrado){
            System.out.println("No existe un plan para el contribuyente ingresado");
        }        
    }
}


