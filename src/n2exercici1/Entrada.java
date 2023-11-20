package n2exercici1;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Entrada extends Exception{
    static Scanner sca = new Scanner(System.in);
    public Entrada(String errorMessage){
        super(errorMessage);
    }
    public Entrada(String errorMessage, Throwable causa){
        super(errorMessage, causa);
    }
    static boolean correcte = false;
    public static void main(String[] args) {

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
                sca.nextLine();
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
                sca.nextLine();
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
                sca.nextLine();
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
                sca.nextLine();
            }
        }while(!correcte);
        correcte = false;
        do {
            try{
                char inicial = llegirChar("Introdueix la teva inicial:");
                System.out.println("La teva inicial és: " + inicial + ". Aquesta variable és del tipus char.");
                correcte = true;
            }catch (Entrada e){
                System.out.println(e.getMessage());
                sca.nextLine();
            }
        }while(!correcte);
        correcte = false;
        do{
            try{
                String cadena = llegirString("Introdueix una cadena de text:");
                System.out.println("La cadena que has escrit és: " + cadena + ". Aquesta variable és del tipus String.");
                correcte = true;
            }catch(Entrada e){
                System.out.println(e.getMessage());
                sca.nextLine();
            }
        }while(!correcte);
        correcte = false;
        do{
            try{
                boolean siNo = llegirSiNo("Escriu 's' o 'n':");
                System.out.println("La teva resposta és: " + siNo + ". Aquesta variable és del tipus boolean.");
                correcte = true;
            }catch(Entrada e){
                System.out.println(e.getMessage());
                sca.nextLine();
            }
        }while(!correcte);
    }

    public  static byte llegirByte(String missatge) throws Entrada{
        byte edat;
        do {
            System.out.println(missatge);
            try{
                edat = sca.nextByte();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format.", e);
            }
        }while(edat== 0);
        return edat;
    }

    public  static int llegirInt(String missatge) throws Entrada {
        int edat;
        do {
            System.out.println(missatge);
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
        float edat;
        do {
            System.out.println(missatge);
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
        double edat;
        do {
            System.out.println(missatge);
            try{
                edat = sca.nextDouble();
                sca.nextLine();
            }
            catch(InputMismatchException e){
                throw new Entrada("Error de format", e);
            }
        }while(edat==0);
        return edat;
    }

    public static char llegirChar(String missatge) throws Entrada{
        String mstg;
        char inicial = 'º';
        do{
            System.out.println(missatge);
            try{
                mstg = sca.nextLine();
                if(mstg.length() == 1){
                    inicial = mstg.charAt(0);
                }
                else{
                    throw new Entrada("Error de format");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }while(inicial == 'º');
        return inicial;
    }

    public static String llegirString(String missatge) throws Entrada{
        String mstg;
        do{
            System.out.println(missatge);
            try{
                mstg =  sca.next();
                sca.nextLine();
            }catch(Exception e){
                throw new Entrada(e.getMessage());
            }
        }while(mstg.isEmpty());
        return  mstg;
    }

    public static boolean llegirSiNo(String missatge) throws Entrada{
        boolean siNo = false;
        char inicial;
        String mstg;
        correcte = false;
        do{
            System.out.println(missatge);
            try{
                mstg = sca.nextLine();
                if(mstg.length() == 1){
                    inicial = mstg.charAt(0);
                    if(inicial == 's'){
                        siNo = true;
                        correcte = true;
                    }
                    else if(inicial == 'n'){
                        correcte = true;
                    }
                    else{
                        throw new Entrada("El caracter escrit no és: 's' o 'n'");
                    }
                }
                else{
                        throw new Entrada("Error de format");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }while(!correcte);
        return siNo;
    }
}

