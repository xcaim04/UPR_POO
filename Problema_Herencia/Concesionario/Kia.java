public class Kia extends Automovil {
     private boolean colabSony;

    public Kia(boolean disponible ,int agno, boolean clima,boolean asientos_cuero,double peso_motor, String marca_motor,String color, String chapa ,boolean colabSony){

        super(disponible,agno,clima,asientos_cuero,peso_motor,marca_motor,color,chapa);

        this.colabSony=colabSony;
        }

    public boolean isColabSony() {
        return colabSony;
    }

    public void setColabSony(boolean colabSony) {
        this.colabSony = colabSony;
    }

    @Override
        public void setPrecioTotal() {
            precioTotal = base + precioClima + precioAsientos + precioMotor;
            if (colabSony)precioTotal+=300;
        }

    }

