import java.util.Scanner;
public class Concesionario {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int op=0;

        Automovil[] catalogo = new Automovil[6];

        catalogo[0] = new Kia(true, 2015, true, true, 230, "H237y", "gris", "W567R", true);

        catalogo[1]= new Kia(true,2019,false,false,190,"E15rt","azul","W87YT",false);

        catalogo[2]=new Kia(true,2020,true,false,220,"E14WE","blanco","W98UI",true);

        catalogo[3]= new Audi(true,2013,true,false,240,"H78yt","gris","Wyu76",true);

        catalogo[4]=new Audi(true,2023,true,true,190,"Ert54","rojo","WE456",false);

        catalogo[5]=new Audi(true,2015,false,false,180,"Hu765","rojo","W34RT",true);

        int contKia=0;
        Kia [] kias=new Kia[catalogo.length]; //6
        for (int i=0; i<catalogo.length;i++){
            if (catalogo[i] instanceof Kia){
                kias[contKia]= (Kia) catalogo[i];
                contKia++;
            }
        }

        int contAudi=0;
        Audi [] audis=new Audi[catalogo.length];
        for (int i=0; i<catalogo.length;i++){
            if (catalogo[i] instanceof Audi){
                audis[contAudi]= (Audi) catalogo[i];
                contAudi++;
            }
        }

        // calculando precios
        for (Automovil a: catalogo){
            a.setPrecioTotal();
        }

        do {
            System.out.println("Menu de opciones\n" + "Seleccione una opcion");
            System.out.println("1. Mostrar autos disponibles \n" + "2. Vender auto \n" + "3. Buscar autos ecologicos \n" + "4. Buscar autos economicos \n" + "5. Mostrar Kia colaborador de Sony \n" + "6. Mostrar Audi con purificador de aire \n" + "7. Salir");

            op= input.nextInt();

            switch (op){
                case 1:
                    for(Automovil a: catalogo){
                    if (a.isDisponible()){
                        System.out.println("Automovil: " + a.getClass().getName() + " Año: " + a.getAgno() + " Precio" +
                                ": " + a.getPrecioTotal());
                    }
                }break;

                case 2:
                    String chap="";
                    System.out.println("Introduce la chapa del auto");
                    chap= input.next();
                    for (Automovil a: catalogo){
                        if (a.getChapa().equalsIgnoreCase(chap) && a.isDisponible()){
                            System.out.println("Auto encontrado");
                            System.out.println("Auto vendido, gracias por la compra");
                            a.setDisponible(false);
                        }
                    }break;

                case 3:
                    for (Automovil a: catalogo){
                        if (a.getMarca_motor().startsWith("E") && a.isDisponible()){
                            System.out.println(a.getClass().getName() + " Chapa:" + a.getChapa());
                        }
                    }break;

                case 4:
                    for (Automovil a: catalogo){
                        if (a.getPrecioTotal()<2500 && a.isDisponible()){
                            System.out.println(a.getClass().getName() + " Chapa:" + a.getChapa() + " es economico");
                        }
                    }break;

                case 5:
                    for (int i=0;i<contKia;i++){
                        if (kias[i].isColabSony() && kias[i].isDisponible()) {
                            System.out.println(kias[i].getChapa());
                        }
                    }
                    break;

                case 6:
                    for (int i=0;i<contAudi;i++){
                        if (audis[i].isPurificador() && audis[i].isDisponible()) {
                            System.out.println(audis[i].getChapa());
                        }
                    }
                    break;

                case 7:
                    System.out.println("Cerrando menu...");
                    break;
            }
        } while (op!=7);
    }
}
