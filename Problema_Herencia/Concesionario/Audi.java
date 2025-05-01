public class Audi extends Automovil {
    private boolean purificador;

    public Audi(boolean disponible ,int agno, boolean clima,boolean asientos_cuero,double peso_motor,String marca_motor,String color, String chapa ,boolean purificador){

        super(disponible,agno,clima,asientos_cuero,peso_motor,marca_motor,color,chapa);

        this.purificador=purificador;
    }

    public boolean isPurificador() {
        return purificador;
    }

    public void setPurificador(boolean purificador) {
        this.purificador = purificador;
    }

    @Override
    public void setPrecioTotal() {
        precioTotal = base + precioClima + precioAsientos + precioMotor;
        if (purificador)precioTotal+=250;
    }

}

