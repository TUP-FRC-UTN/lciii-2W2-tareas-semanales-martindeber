package municipalidad;

public class Pago {
    
    private int demora;
    private float importe;
    private float interesesAdicionales;    

    public float getInteresesAdicionales() {
        return interesesAdicionales;
    }

    public void setInteresesAdicionales(float interesesAdicionales) {
        this.interesesAdicionales = interesesAdicionales;
    }

    public Pago(int demora, float importe) {
        this.demora = demora;
        this.importe = importe; // seria conveneniente que el importe sea igual a la deuda total dividido en la cantidad de cuotas...
        interesesAdicionales = demora * importe * 0.005f;
    }
    
    @Override
    public String toString(){
        return "importe: $ " + importe + " || demora: " + demora + " dias " + " || intereses adicionales: $ " + interesesAdicionales;
    }
}
