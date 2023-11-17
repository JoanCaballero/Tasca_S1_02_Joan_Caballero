package n2exercici1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entrada extends Exception{
    public Entrada(String errorMessage){
        super(errorMessage);
    }
    public Entrada(String errorMessage, Throwable causa){
        super(errorMessage, causa);
    }
    public static void main(String[] args) {
        boolean correcte = false;
        do {

            try{
                byte edat = llegirByte("Introdueix la teva edat:");
                System.out.println("La teva edat és: " + edat + ". Aquesta variable és del tipus byte.");
                correcte = true;
            }catch (Entrada e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Tipus d'error: " + e.getCause().getClass().getName());
                }
            }
        }while(!correcte);
        correcte = false;
        do {

            try{
                int edat = llegirInt("Introdueix la teva edat:");
                System.out.println("La teva edat és: " + edat + ". Aquesta variable és del tipus int.");
                correcte = true;
            }catch (Entrada e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Tipus d'error: " + e.getCause().getClass().getName());
                }
            }
        }while(!correcte);
        correcte = false;
        do {

            try{
                float edat = llegirFloat("Introdueix la teva edat:");
                System.out.println("La teva edat és: " + edat + ". Aquesta variable és del tipus float.");
                correcte = true;
            }catch (Entrada e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Tipus d'error: " + e.getCause().getClass().getName());
                }
            }
        }while(!correcte);
        correcte = false;
        do {

            try{
                double edat = llegirDouble("Introdueix la teva edat:");
                System.out.println("La teva edat és: " + edat + ". Aquesta variable és del tipus double.");
                correcte = true;
            }catch (Entrada e){
                System.out.println(e.getMessage());
                if(e.getCause() != null){
                    System.out.println("Tipus d'error: " + e.getCause().getClass().getName());
                }
            }
        }while(!correcte);
        //System.out.println("La teva edat és: " + llegirInt("Introdueix la teva edat:" + ". Aquesta variable és del tipus int"));
        //System.out.println("La teva edat és: " + llegirInt("Introdueix la teva edat:" + ". Aquesta variable és del tipus int"));
        //System.out.println("La teva edat és: " + llegirInt("Introdueix la teva edat:" + ". Aquesta variable és del tipus int"));
    }

    public  static byte llegirByte(String missatge) throws Entrada{
        byte edat= 0;
        do {
            System.out.println(missatge);
            Scanner sca = new Scanner(System.in);
            try{
                edat = sca.nextByte();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format.", e);
            }
        }while(edat==0);
        return edat;
    }

    public  static int llegirInt(String missatge) throws Entrada {
        int edat= 0;
        do {
            System.out.println(missatge);
            Scanner sca = new Scanner(System.in);
            try{
                edat = sca.nextInt();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format.", e);
            }
        }while(edat==0);
        return edat;
    }

    public  static float llegirFloat(String missatge) throws Entrada{
        float edat= 0F;
        do {
            System.out.println(missatge);
            Scanner sca = new Scanner(System.in);
            try{
                edat = sca.nextFloat();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format", e);
            }
        }while(edat==0);
        return edat;
    }

    public  static double llegirDouble(String missatge) throws Entrada{
        double edat= 0;
        do {
            System.out.println(missatge);
            Scanner sca = new Scanner(System.in);
            try{
                edat = sca.nextDouble();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format", e);
            }
        }while(edat==0);
        return edat;
    }
}

