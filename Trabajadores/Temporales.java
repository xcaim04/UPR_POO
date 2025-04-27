package Trabajadores;
public class Temporales extends Trabajadores{
    private int inicio_contrato;
    private int fin_contrato;

    public Temporales(String nombre, int edad, int tiempo_contrato, String residencia, String enfermedades,int inicio_contrato, int fin_contrato) {
        super(nombre, edad, tiempo_contrato, residencia, enfermedades);
        this.fin_contrato = fin_contrato;
        this.inicio_contrato = inicio_contrato;
    }





    public int getInicio_contrato() {
        return inicio_contrato;
    }

    public void setInicio_contrato(int inicio_contrato) {
        this.inicio_contrato = inicio_contrato;
    }

    public int getFin_contrato() {
        return fin_contrato;
    }

    public void setFin_contrato(int fin_contrato) {
        this.fin_contrato = fin_contrato;
    }

}
