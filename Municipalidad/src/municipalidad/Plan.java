package municipalidad;

public class Plan {
    
    private String nombre;
    private float deuda;
    private int cuotas;
    private Pago pagos[];

    public Plan(String nombre, float deuda, int cantidadPagos) {        
        this.nombre = nombre;
        this.deuda = deuda;
        cuotas = cantidadPagos;
        pagos = new Pago[cuotas];
    }

    public String getNombre(){
        return nombre;
    }
    
    public float getDeuda(){
        return deuda;
    }
    
    public void agregarPago(Pago p){
        boolean pagadoEnSuTotalidad = true;
        for (int i = 0; i < pagos.length; i++) {
            if(pagos[i] == null){
                pagadoEnSuTotalidad = false;
                pagos[i] = p;
                System.out.println("El pago se realizó con éxito");
                break;
            }   
        }
        if(pagadoEnSuTotalidad){
            System.out.println("Error. El plan ya fue pagado en su totalidad");
        }
    }
    
    public boolean estaPagadoTotalmente(){
        boolean pagadoTotalmente = true;
        for (int i = pagos.length-1; i >= 0; i--) {
            if(pagos[i] == null){
                pagadoTotalmente = false;
                break;
            }
        }
        return pagadoTotalmente;
    }
    
    public String listadoPagos(){
        String listado = "";
        int contador = 0;
        for (Pago pago : pagos) {            
            if(pago != null){
                contador++;
                listado +="\npago "+ contador + ": "+ pago.toString();
            }
        }
        if(contador == 0)
            listado = "El contribuyente no ha realizado pagos";
        return listado;
    }
    
    public float sumaInteresesCobrados(){
        float acumulador = 0;
        for (Pago pago : pagos) {
            if(pago != null)
                acumulador += pago.getInteresesAdicionales();
        }
        return acumulador;
    }    
}
