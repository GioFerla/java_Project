package giofe;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        verificaDirectory();
        Scanner input = new Scanner(System.in);
        Campionato campionato = new Campionato();
        campionato.caricaCampionatoDaFile();

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
                case 1 -> {
                    System.out.print("Inserisci il nome della squadra: ");
                    String nomeSquadra = input.nextLine();
                    System.out.print("Inserisci la provenienza della squadra: ");
                    String provenienza = input.nextLine();
                    System.out.print("Inserisci il colore della squadra: ");
                    String colore = input.nextLine();
                    if(verificaSquadra(campionato, nomeSquadra)){
                        campionato.aggiungiSquadra(new Squadra(nomeSquadra, provenienza, colore));
                    }
                    System.out.println("Squadra già presente nel campionato");
                }

                case 2 -> {
                    System.out.print("Inserisci il nome della squadra da rimuovere: ");
                    for (Squadra squadra : campionato.getCampionato()) {
                        System.out.println(squadra.getNome());
                    }
                    String squadraDaRimuovere = input.nextLine();
                    campionato.rimuoviSquadra(squadraDaRimuovere);
                }

                case 3 -> {
                    System.out.println("\nClassifica del Campionato:");
                    for (Squadra squadra : campionato.getCampionato()) {
                        System.out.println(squadra.getNome() + " - Punti: " + squadra.getPunti());
                    }
                }

                case 4 -> {
                    stampaSquadre(campionato);
                    System.out.print("Inserisci il nome della squadra di casa: ");
                    String casa = input.nextLine();
                    System.out.print("Inserisci il nome della squadra ospite: ");
                    String ospite = input.nextLine();

                    Squadra squadraCasa = campionato.getSquadra(casa);
                    Squadra squadraOspite = campionato.getSquadra(ospite);
                    

                    if (squadraCasa != null && squadraOspite != null) {
                        TabelloneCalcio partita = new TabelloneCalcio(squadraCasa, squadraOspite);

                        System.out.println("Simulazione partita tra " + squadraCasa.getNome() + " e " + squadraOspite.getNome());
                        boolean partitaAttiva = true;
                        boolean salva = true;

                        while (partitaAttiva) {
                            System.out.println("\nChi segna un gol?");
                            System.out.println("1. " + squadraCasa.getNome() + " (Casa)");
                            System.out.println("2. " + squadraOspite.getNome() + " (Ospite)");
                            System.out.println("3. Seconda pagina");
                            System.out.println("0. Termina la partita");
                            System.out.print("Scegli l'opzione: ");

                            int sceltaGol = input.nextInt();

                            switch (sceltaGol) {
                                case 1 -> {
                                    partita.incrementaCasa();  
                                    System.out.println(squadraCasa.getNome() + " segna un gol!");
                                }

                                case 2 -> {
                                    partita.incrementaOspiti();  
                                    System.out.println(squadraOspite.getNome() + " segna un gol!");
                                }

                                case 3 -> {
                                    System.out.println("\nSeconda pagina: ");
                                    System.out.println("1. Termina partita senza assegnare un punteggio");
                                    System.out.println("2. Rimuovi goal a "+ squadraCasa.getNome() + "(CASA)");
                                    System.out.println("3. Rimuovi goal a " + squadraOspite.getNome()+ "(OSPITE)");
                                    System.out.println("4. Ricomincia la partita");
                                    System.out.println("0. torna indientro");

                                    scelta = input.nextInt();

                                    switch(scelta){
                                        case 1 -> {
                                            partitaAttiva = false;
                                            salva = false;
                                        }

                                        case 2 -> {
                                            partita.decrementaCasa();
                                            System.out.println("Gol rimosso a " + squadraCasa.getNome() + "(CASA)");
                                        }

                                        case 3 -> {
                                            partita.decrementaOspiti();
                                            System.out.println("Gol rimosso a "+ squadraOspite.getNome()+ "(OSPITE)");
                                        }

                                        case 4 -> {
                                            partita.resetGame();
                                            System.out.println("Partita resettata");
                                        }

                                        case 0 -> {

                                        }
                                    }

                                    
                                }

                                case 0 -> {
                                    partitaAttiva = false;  
                                    System.out.println("La partita è terminata.");
                                }

                                default -> System.out.println("Riprova.");
                            }
                            System.out.println(partita);
                        }
                        
                        if(salva){
                            partita.assegnaPunti();
                            System.out.println("Partita terminata");
                            System.out.println(partita);
                            campionato.ordinaCompionato(); 
                        }
                        
                    } else {
                        System.out.println("Una o entrambe le squadre non esistono.");
                    }
                }

                case 5 -> {
                    input.close();
                    campionato.salvaCampionatoSuFile();
                    return;
                }

                default -> System.out.println("Sezione non disponibile");
            }
        }
    }

    public static boolean verificaSquadra(Campionato campionato, String nuovaSquadra) {
        for (Squadra squadra : campionato.getCampionato()) {
            if (squadra.getNome().equalsIgnoreCase(nuovaSquadra)) {
                return false;
            }
        }
        return true;
    }

    public static void stampaSquadre(Campionato campionato){
        for (Squadra squadra : campionato.getCampionato()) {
            System.out.println(squadra.getNome());
        }
    }

    public static void verificaDirectory(){
        try {
            File directory = new File("./data");
            if(!directory.exists()){
                if(directory.mkdir()){
                    File file = new File("./data/data.json");
                    if(!file.exists()){
                        if(file.createNewFile()){
                            
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
