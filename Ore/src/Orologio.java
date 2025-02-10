
import java.util.Scanner;

public class Orologio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Ora tempo = new Ora();
        int ora;
        int minuti;
        int scelta;

        while (true) {
            System.out.println("1: Inserimento orario in formato 24 H");
            System.out.println("2: Inserimento orario in formato 12 H");
            System.out.println("3: Stampa orario");
            System.out.println("4: Uscita");
            scelta = input.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("dammi l'ora");
                    ora = input.nextInt();
                    System.out.println("dammi i minuti");
                    minuti = input.nextInt();
                    clearScreen();
                    tempo.setOra(ora, minuti);
                    break;
                case 2: 
                    System.out.println("dammi l'ora");
                    ora = input.nextInt();
                    System.out.println("dammi i minuti");
                    minuti = input.nextInt();
                    clearScreen();
                    tempo.setOra(ora, minuti,true);
                    break;
                case 3:
                    if (tempo.getTempo()[2] == 1) {
                        clearScreen();
                        System.out.println("sono le " + tempo.getTempo()[0] + ":" + tempo.getTempo()[1] + " AM" );
                    }else if(tempo.getTempo()[2] == 0){
                        clearScreen();
                        System.out.println("sono le " + tempo.getTempo()[0] + ":" + tempo.getTempo()[1] + " PM");
                    }else{
                        clearScreen();
                        System.out.println("sono le " + tempo.getTempo()[0] + " ore " + tempo.getTempo()[1] + " minuti");
                    }
                    break;
                case 4: 
                    input.close();
                    return;
                default:
                    System.out.println("sei un criminale");
                    break;
            }
        }
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
