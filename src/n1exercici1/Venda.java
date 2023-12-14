package n1exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Venda {
    private final ArrayList<Producte> productes;
    private float preuTotal;
    private int cont = 0;
    static Scanner sca = new Scanner(System.in);

    public Venda(){
        this.preuTotal = 0;
        productes = new ArrayList<>();
    }

    public ArrayList<Producte> getProductes() {
        return productes;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void calcularTotal() throws VendaBuidaException {
            if(!productes.isEmpty()){
                for(Producte prod : productes){
                    if(productes.get(cont)!=null){
                        preuTotal+= prod.getPreu();
                        cont++;
                    }
                }
            }
            else{
                throw new VendaBuidaException();
            }
    }
    public void afegirProducte(){
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
        productes.add(producte);
    }
    public int finalitzarCompra() throws VendaBuidaException {
        calcularTotal();
        System.out.println("El preu total de la compra es: " + getPreuTotal());
        return 4;
    }
    public void generarErrorArrayIndexOutOfBounds() {
        ArrayList<Producte> llista = getProductes();
        try {
            Producte prod = llista.get(llista.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
