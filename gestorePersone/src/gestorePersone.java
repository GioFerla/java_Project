
import java.util.Scanner;

public class gestorePersone {
    public static void main(String[] args) {
        String nome,cognome;
        int eta;
        

        Scanner input = new Scanner(System.in);
        // Creazione di due persone
        Persona[] persone = new Persona[3];

        for (int i = 0; i < persone.length; i++) {
            
            System.out.println("dammi l'eta");
            eta = input.nextInt();
            input.nextLine();
            System.out.println("dammi il nome");
            nome = input.nextLine();
            System.out.println("dammi il cognome");
            cognome = input.nextLine();
            persone[i] = new Persona(eta, nome, cognome);
        }

        // Test dei metodi
        System.out.println("Stesso nome?   :" + persone[0].verificaNome(persone[1].getNome()));
        System.out.println("Stesso cognome?   :" +  persone[0].verificaCognome(persone[1].getCognome()));
        System.out.println(""+ persone[0].getNome() +" è più vecchio di" + persone[1].getNome() + "?  : " + persone[0].verificEtaMaggiore(persone[1].getEta()));
        System.out.println(""+ persone[0].getNome() +" è più giovane di" + persone[1].getNome() + "?  : " + persone[0].verificEtaMinore(persone[1].getEta()));
        System.out.println("Sono la stessa persona?   : " + persone[0].verificaClone(persone[1].getNome(),persone[1].getCognome(),persone[1].getEta()));

        int[] anni = new int[persone.length];
        for (int i = 0; i < persone.length; i++) {
            anni[i] = persone[i].getEta();
        }
        double mediaEta = calcolaMedia(anni);
        System.out.println("La media dell'età è: " + mediaEta);
    }

    private static double calcolaMedia(int[] eta){ 
        int somma = 0;
        for(int i = 0; i < eta.length; i++){
            somma += eta[i];
        }
        return somma / eta.length;
    }
}
