package Trabajadores;

import java.util.Scanner;

import static java.lang.System.in;

public class main {
    public static void main(String[] args) {
        Fijo f1 = new Fijo("Ariel", 15, 1, "Cuba", "Diabetes", "Dr" , 150, "Calero");
        Temporales t1 = new Temporales("Juan", 20, 1, "Peru", "Ninguna", 2023, 2025);
        Temporales t2 = new Temporales("Julio", 25, 38, "Brasil", "Diabetes", 2024, 2025);
        Fijo f2 = new Fijo("Pedro", 20, 49, "Cuba", "Dengue", "Scr", 120, "calero");

        Trabajadores[] lista = new Trabajadores[4];
        lista[0] = f1;
        lista[1] = t1;
        lista[2] = t2;
        lista[3] = f2;

        int contF = 0;
        int contT = 0;

        for (int i = 0; i < lista.length; i++) {
            if(lista[i]instanceof Fijo){
                contF ++;
            }
            else{
                contT ++;
            }
        }
        System.out.println("Hay " + contF + " trabajadores fijos y " + contT + " trabajadores temporales");

        for(int i=0;i<lista.length; i++){
            if(lista[i].getTiempo_contrato()<=1){
                System.out.println("Fueron contratados este mes " + lista[i].getNombre());
            }
            else{

            }
        }

        for (int i = 0; i < lista.length; i++) {
            if(lista[i].getTiempo_contrato()>=36){
                System.out.println("Tienen mas de 3 agnos de antiguedad " + lista[i].getNombre());
            }
            else{

            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Dime una zona");
        String zo = input.nextLine();
        int flag = 0;
        for (int i = 0; i < lista.length; i++) {
            if(lista[i] instanceof Fijo){
                Fijo trabajadorFijo = (Fijo) lista[i];
                if(trabajadorFijo.getZona().equalsIgnoreCase(zo)){
                    System.out.println("Los de " + zo + " son " + lista[i].getNombre());
                    flag = 1;
                }
                if(flag==0){
                    System.out.println("No hay");
                    break;
                }
            }
        }

        int contadorMax = 0;
        int auxiliar = 0;
        String mascomun = "";
        String enfermedades[] = new String[4];
        for (int i = 0; i < lista.length; i++) {
            enfermedades[i] = lista[i].getEnfermedades();
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4; j++) {
                if(enfermedades[j]==enfermedades[i]){
                    auxiliar++;
                }
                if(auxiliar>contadorMax){
                    contadorMax=auxiliar;
                    mascomun = enfermedades[i];
                }
                auxiliar=0;
            }
        }
        System.out.println("La enfermedad mas comun es " + mascomun);

    }
}

