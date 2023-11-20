package n1exercici1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws VendaBuidaException {
        Venda venda  = new Venda();
        int opcio, cont = 0;
        float preu;
        Producte[] llista;
        String nom;
        Scanner sca = new Scanner(System.in);
        do {
            System.out.println("""
                    Prem 1 si vols introduir un nou producte a la compra.
                    Prem 2 si vols finalitzar la compra.
                    Prem 3 si vols generar l'error de tipus ArrayIndexOutOfBoundsException""");
            opcio = sca.nextInt();
            switch (opcio) {
                case (1):
                    System.out.println("Introdueix el nom del producte que vols afegir a la compra: ");
                    nom = sca.nextLine();
                    sca.nextLine();
                    System.out.println("Introdueix el preu del producte anterior:");
                    preu = sca.nextFloat();
                    Producte producte = new Producte(nom, preu);
                    llista = venda.getProductes();
                    llista[cont]=producte;
                    cont++;
                    break;
                case (2):
                    try {
                        venda.calcularTotal();
                        System.out.println("El preu total de la compra es: " + venda.getPreuTotal());
                        opcio = 4;
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case(3):
                    llista = venda.getProductes();
                    try {
                        for (int i = 0; i <= llista.length; i++) {
                            llista[i] = new Producte("Llet", 1.5F);
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                        opcio = 4;
                    }
            }
        }while(opcio!=4);
        System.out.println("Fins Aviat!");
    }
}