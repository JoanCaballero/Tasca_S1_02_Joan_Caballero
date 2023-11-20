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
                    afegirProducte(venda);
                    break;
                case 2:
                    try{
                        opcio = finalitzarCompra(venda);
                    }
                    catch(VendaBuidaException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    generarErrorArrayIndexOutOfBounds(venda);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Introdueix un valor vàlid.");
            }
        } while (opcio != 4);
        System.out.println("Fins Aviat!");
    }

    private static void afegirProducte(Venda venda) {
        System.out.println("Introdueix el nom del producte que vols afegir a la compra: ");
        String nom = sca.nextLine();
        sca.nextLine();
        boolean correcte = false;
        float preu = 0;
        do {
            try {
                System.out.println("Introdueix el preu del producte anterior:");
                preu = sca.nextFloat();
                correcte = true;
            } catch (Exception e) {
                System.out.println("Introdueix un valor vàlid.");
                sca.nextLine();
            }
        } while (!correcte);
        Producte producte = new Producte(nom, preu);
        venda.afegirProducte(producte);
    }

    private static int finalitzarCompra(Venda venda) throws VendaBuidaException {
        venda.calcularTotal();
        System.out.println("El preu total de la compra es: " + venda.getPreuTotal());
        return 4;
    }

    private static void generarErrorArrayIndexOutOfBounds(Venda venda) {
        ArrayList<Producte> llista = venda.getProductes();
        try {
            Producte prod = llista.get(llista.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}