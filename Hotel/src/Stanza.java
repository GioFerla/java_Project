
import java.util.Scanner;

public class Stanza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int stanza;

        OccupazioneStanza stanze = new OccupazioneStanza();

        for (int i = 1; i <= 8; i++) {
            System.out.println("persone nella stanza " + i + ": " + stanze.getNumero(i));
        }
        while (true) {
            System.out.println("1. Aggiungi persone a una stanza");
            System.out.println("2. Rimuovi persone da una stanza");
            System.out.println("3. Mostra il numero di persone in ogni stanza");
            System.out.println("4. Mostra il numero totale di persone");
            System.out.println("5. Esci");
            
            int scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il numero della stanza (1-8): ");
                    stanza = input.nextInt();
                    System.out.print("Inserisci il numero di persone da aggiungere: ");
                    int aggiungiPersone = input.nextInt();
                    stanze.aggiungiUnoAllaStanza(stanza, aggiungiPersone);
                    break;

                case 2:
                    System.out.print("Inserisci il numero della stanza (1-8): ");
                    stanza = input.nextInt();
                    System.out.print("Inserisci il numero di persone da rimuovere: ");
                    int rimuoviPersona = input.nextInt();
                    int risultatoRimozione = stanze.rimuoviUnoDallaStanza(stanza, rimuoviPersona);
                    if (risultatoRimozione == 1) {
                        System.out.println("Errore: Non ci sono abbastanza persone nella stanza " + stanza + ".");
                    } else {
                        System.out.println("Rimosse " + rimuoviPersona + " persone dalla stanza " + stanza + ".");
                    }
                    break;

                case 3:
                    for (int i = 1; i <= 8; i++) {
                        System.out.println("Persone nella stanza " + i + ": " + stanze.getNumero(i));
                    }
                    break;

                case 4:
                    System.out.println("Numero totale di persone nelle stanze: " + stanze.getTotale());
                    break;

                case 5:
                    input.close();
                    return;

                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }
    }
}
