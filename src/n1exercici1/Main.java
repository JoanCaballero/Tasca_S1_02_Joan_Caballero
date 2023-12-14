package n1exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sca = new Scanner(System.in);
    public static void main(String[] args) {
        Venda venda = new Venda();
        int opcio;
        do {
            System.out.println("""
                    Prem 1 si vols introduir un nou producte a la compra.
                    Prem 2 si vols finalitzar la compra.
                    Prem 3 si vols generar l'error de tipus ArrayIndexOutOfBoundsException.
                    Prem 4 si vols finalitzar el programa.""");
            opcio = sca.nextInt();

            switch (opcio) {
                case 1:
                    venda.afegirProducte();
                    break;
                case 2:
                    try{
                        opcio = venda.finalitzarCompra();
                    }
                    catch(VendaBuidaException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    venda.generarErrorArrayIndexOutOfBounds();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Introdueix un valor vàlid.");
            }
        } while (opcio != 4);
        System.out.println("Fins Aviat!");
    }
}