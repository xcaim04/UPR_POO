package Trabajadores;

public class Trabajadores {
    protected String nombre;
    protected int edad;
    protected int tiempo_contrato;
    protected String residencia;
    protected String enfermedades;

    public Trabajadores(String nombre, int edad, int tiempo_contrato, String residencia, String enfermedades){
        this.nombre = nombre;
        this.edad = edad;
        this.tiempo_contrato = tiempo_contrato;
        this.residencia = residencia;
        this.enfermedades = enfermedades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTiempo_contrato() {
        return tiempo_contrato;
    }

    public void setTiempo_contrato(int tiempo_contrato) {
        this.tiempo_contrato = tiempo_contrato;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }
}
