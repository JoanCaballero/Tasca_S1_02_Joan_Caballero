package n1exercici1;

public class Venda {
    private final Producte[] productes= new Producte[3];
    private float preuTotal;
    private int cont = 0;

    public Venda(){
        this.preuTotal = 0;
    }

    public Producte[] getProductes() {
        return productes;
    }

    public float getPreuTotal() {
        return preuTotal;
    }

    public void calcularTotal() throws VendaBuidaException {
        //try{
            if(productes[0] != null){
                for(Producte prod : productes){
                    if(productes[cont]!=null){
                        preuTotal+= prod.getPreu();
                        cont++;
                    }
                }
            }
            else{
                throw new VendaBuidaException();
            }
        //}catch(Exception e){
        //    System.out.println(e.getMessage());
        //}


    }

}
