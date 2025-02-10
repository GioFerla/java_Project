import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Campionato campionato = new Campionato();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Aggiungi una squadra");
            System.out.println("2. Rimuovi una squadra");
            System.out.println("3. Visualizza classifica");
            System.out.println("4. Simula una partita");
            System.out.println("5. Esci");
            System.out.print("Scegli un'opzione: ");

            int scelta = input.nextInt();
            input.nextLine(); 

            switch (scelta) {
                case 1:
                    System.out.print("Inserisci il nome della squadra: ");
                    String nomeSquadra = input.nextLine();
                    System.out.print("Inserisci la provenienza della squadra: ");
                    String provenienza = input.nextLine();
                    System.out.print("Inserisci il colore della squadra: ");
                    String colore = input.nextLine();

                    campionato.aggiungiSquadra(new Squadra(nomeSquadra, provenienza, colore));
                    System.out.println("Squadra aggiunta con successo!");
                    break;

                case 2:
                    System.out.print("Inserisci il nome della squadra da rimuovere: ");
                    String squadraDaRimuovere = input.nextLine();
                    campionato.rimuoviSquadra(squadraDaRimuovere);
                    System.out.println("Squadra rimossa con successo!");
                    break;

                case 3:
                    System.out.println("\nClassifica del Campionato:");
                    for (Squadra squadra : campionato.getCampionato()) {
                        System.out.println(squadra.getNome() + " - Punti: " + squadra.getPunti());
                    }
                    break;

                case 4:
                    System.out.print("Inserisci il nome della squadra di casa: ");
                    String casa = input.nextLine();
                    System.out.print("Inserisci il nome della squadra ospite: ");
                    String ospite = input.nextLine();

                    Squadra squadraCasa = campionato.getSquadra(casa);
                    Squadra squadraOspite = campionato.getSquadra(ospite);
                    

                    if (squadraCasa != null && squadraOspite != null) {
                        Tabellone partita = new Tabellone(squadraCasa, squadraOspite);

                        System.out.println("Simulazione partita tra " + squadraCasa.getNome() + " e " + squadraOspite.getNome());
                        boolean partitaAttiva = true;

                        while (partitaAttiva) {
                            System.out.println("\nChi segna un gol?");
                            System.out.println("1. " + squadraCasa.getNome() + " (Casa)");
                            System.out.println("2. " + squadraOspite.getNome() + " (Ospite)");
                            System.out.println("0. Termina la partita");
                            System.out.print("Scegli l'opzione: ");

                            int sceltaGol = input.nextInt();

                            switch (sceltaGol) {
                                case 1:
                                    partita.incrementaCasa();  
                                    System.out.println(squadraCasa.getNome() + " segna un gol!");
                                    break;

                                case 2:
                                    partita.incrementaOspiti();  
                                    System.out.println(squadraOspite.getNome() + " segna un gol!");
                                    break;

                                case 0:
                                    partitaAttiva = false;  
                                    System.out.println("La partita è terminata.");
                                    break;

                                default:
                                    System.out.println("Scelta non valida. Riprova.");
                            }
                            System.out.println(partita);
                        }

                       
                        partita.assegnaPunti();
                        System.out.println("Partita terminata!");
                        System.out.println(partita);
                        campionato.ordinaCompionato(); 
                    } else {
                        System.out.println("Una o entrambe le squadre non esistono.");
                    }
                    break;

                case 5:
                    System.out.println("Arrivederci!");
                    input.close();
                    return;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
}
