package Trabajadores;

public class Fijo extends Trabajadores{
    private double salario;
    private String grado;
    private String zona;

    public Fijo(String nombre, int edad, int tiempo_contrato, String residencia, String enfermedades, String grado, double salario, String zona) {
        super(nombre, edad, tiempo_contrato, residencia, enfermedades);
        this.grado = grado;
        this.salario = salario;
        this.zona = zona;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

}
