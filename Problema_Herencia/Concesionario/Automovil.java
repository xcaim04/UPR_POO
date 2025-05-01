public class Automovil {
    //variables
    protected boolean disponible;
    protected int agno;
    protected boolean clima;
    protected boolean asientos_cuero;
    protected double peso_motor;
    protected String marca_motor;
    protected String color;
    protected String chapa;

    //para calcular precio
    protected double base = 2000;
    protected double precioMotor = 200;
    protected double precioClima = 200;
    protected double precioAsientos = 100;
    protected double precioTotal;

    public Automovil(boolean disponible ,int agno, boolean clima, boolean asientos_cuero, double peso_motor,String marca_motor, String color, String chapa) {
        this.disponible=disponible;
        this.agno=agno;
        this.clima=clima;
        this.asientos_cuero=asientos_cuero;
        this.peso_motor=peso_motor;
        this.marca_motor=marca_motor;
        this.color=color;
        this.chapa=chapa;

        if (agno <=2015) {
            base -=base*0.3;
        }
        if (peso_motor > 200) {
            precioMotor = 250;
        }
        if (clima) {
            precioClima = 350;
        }
        if (asientos_cuero) {
            precioAsientos = 200;
        }
    }

    public void setPrecioTotal() {
        precioTotal = base + precioClima + precioAsientos + precioMotor;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public boolean isClima() {
        return clima;
    }

    public void setClima(boolean clima) {
        this.clima = clima;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

    public int getAgno() {
        return agno;
    }

    public void setAgno(int agno) {
        this.agno = agno;
    }

    public double getMotor() {
        return peso_motor;
    }

    public void setPeso_motor(double peso_motor) {
        this.peso_motor = peso_motor;
    }

    public String getMarca_motor() {
        return marca_motor;
    }

    public void setMarca_motor(String marca_motor) {
        this.marca_motor = marca_motor;
    }

    public boolean isAsientos_cuero() {
        return asientos_cuero;
    }

    public void setAsientos_cuero(boolean asientos_cuero) {
        this.asientos_cuero = asientos_cuero;
    }
}
