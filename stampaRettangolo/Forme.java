import java.util.Scanner;

public class Forme{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dadi;
        double base, altezza, raggio,raggioS, altezzaC, baseP, altezzaP;


        /*      ESTRAZIONE DI UN NUMERO CASUALE TRAMITE UN LANCIO DEI DADI       */
        do{
            System.out.println("quanti dadi vuoi lanciare?: ");
            dadi = input.nextInt();
        }while(!controlloDadi(dadi));
        Dado d = new Dado(dadi);
        System.out.println("il numero uscito è: " + d.LancioDado());


        /*      STAMPA DEL RETTANGOLO        */
        do{
            System.out.print("dammi la base del rettangolo: ");
            base = input.nextDouble();
            System.out.print("dammi l'altezza del rettangolo: ");
            altezza = input.nextDouble();
        }while(!controlloRettangolo(base,altezza));
        Rettangolo r = new Rettangolo(base,altezza);
        System.out.print(r.Stampa());


        /*      CALCOLO APOTEMA, VOLUME E SUPERFICE LATERALE DI UN CONO      */
        do { 
            System.out.print("dammi il raggio del cono: ");
            raggio = input.nextDouble();
            System.out.print("dammi l'altezza del cono: ");
            altezzaC = input.nextDouble();
        } while (!controlloCono(raggio, altezzaC));
        Cono cono = new Cono(raggio, altezzaC);
        System.err.println("l'apotema è: " + cono.calcoloApotema());
        System.err.println("il volume è: " + cono.calcoloVolume());
        System.err.println("la superficie laterale è: " + cono.superficieLaterale());
        System.err.println("la superficie di base è: " + cono.superficieBase());
        System.err.println("la superficie totale è: " + cono.superficieTotale());


        /*      STAMPA VOLUME E SUPERFICIE DI UNA SFERA*/
        do { 
            System.out.print("dammi il raggio del cono: ");
            raggioS = input.nextDouble();
        } while (!controlloSfera(raggioS));
        Sfera sfera = new Sfera(raggioS);
        System.err.println("la superficie titale è: " + sfera.calcoloSuperficie());
        System.err.println("il volume è: " + sfera.calcoloVolume());
        /*      PIRAMIDE         */
        do {
            System.out.print("dammi la base della piramide: ");
            baseP = input.nextDouble();
            System.out.print("dammi l'altezza della piramide: ");
            altezzaP = input.nextDouble();
        } while (!controlloPiramide(baseP,altezzaP));
        input.close();    
    }
    
    public static boolean controlloDadi(int dadi){
        return dadi > 0;
    }
    public static boolean controlloRettangolo(double base, double altezza){
        return base > 0 && base != altezza && altezza > 0;
    }
    public static boolean controlloCono(double raggio, double altezza){
        return raggio > 0 && altezza > 0; 
    }
    public static boolean controlloSfera(double raggio){
        return raggio > 0; 
    }
    public static boolean controlloPiramide(double base, double altezza){
        return base > 0 && altezza > 0;
    }
}