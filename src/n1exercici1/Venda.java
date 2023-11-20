package n1exercici1;

import java.util.ArrayList;

public class Venda {
    private final ArrayList<Producte> productes= new ArrayList<>();
    private float preuTotal;
    private int cont = 0;

    public Venda(){
        this.preuTotal = 0;
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

    public void afegirProducte(Producte producte){
        productes.add(producte);
    }

}
