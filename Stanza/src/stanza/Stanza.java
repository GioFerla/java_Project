import java.util.Scanner;

public class Stanza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("dimmi il numero di stanze: ");
        int nstanze = input.nextInt();
        CentroConvegni[] centroConvegni = new CentroConvegni[nstanze];

        for (int i = 0; i < nstanze; i++) {
            System.out.print("stanza " + (i + 1) + ": dimmi il numero massimo di persone che può contenere: ");
            int capienzaMassima = input.nextInt();
            centroConvegni[i] = new CentroConvegni("stanza " + (i + 1), capienzaMassima);
        }

        while (true) {
            System.out.println("\nScegli un'operazione:");
            System.out.println("1) Aggiungi persone a una stanza");
            System.out.println("2) Rimuovi persona da una stanza");
            System.out.println("3) Visualizza persone in una stanza");
            System.out.println("4) Visualizza totale persone nel centro");
            System.out.println("5) Visualizza stanze vuote");
            System.out.println("6) Visualizza stanze piene");
            System.out.println("0) Esci");

            int scelta = input.nextInt();

            if (scelta == 0) {
                System.out.println("uscito.");
                break;
            }

            switch (scelta) {
                case 1:
                    System.out.print("inserisci il numero della stanza (1-" + nstanze + "): ");
                    int aggiungiStanza = input.nextInt() - 1;
                    if (aggiungiStanza >= 0 && aggiungiStanza < nstanze) {
                        System.out.print("quante persone vuoi aggiungere? ");
                        int personeDaAggiungere = input.nextInt();
                        int personeAggiunte = 0;
                        for (int j = 0; j < personeDaAggiungere; j++) {
                            if (centroConvegni[aggiungiStanza].aggiungiPersona()) {
                                personeAggiunte++;
                            } else {
                                System.out.println("la " + centroConvegni[aggiungiStanza].getNumeroStanza() + " è piena. Non è possibile aggiungere più persone.");
                                break;
                            }
                        }

                        System.out.println("aggiunte " + personeAggiunte + " persone nella " + centroConvegni[aggiungiStanza].getNumeroStanza());
                    } else {
                        System.out.println("numero stanza non valido.");
                    }
                    break;

                case 2:
                    System.out.print("inserisci il numero della stanza (1-" + nstanze + "): ");
                    int rimuoviStanza = input.nextInt() - 1;
                    if (rimuoviStanza >= 0 && rimuoviStanza < nstanze) {
                        if (centroConvegni[rimuoviStanza].rimuoviPersona()) {
                            System.out.println("persona rimossa dalla " + centroConvegni[rimuoviStanza].getNumeroStanza());
                        } else {
                            System.out.println("la " + centroConvegni[rimuoviStanza].getNumeroStanza() + " è già vuota.");
                        }
                    } else {
                        System.out.println("numero stanza non valido.");
                    }
                    break;

                case 3:
                    System.out.print("inserisci il numero della stanza (1-" + nstanze + "): ");
                    int visualizzaStanza = input.nextInt() - 1;
                    if (visualizzaStanza >= 0 && visualizzaStanza < nstanze) {
                        System.out.println("nella " + centroConvegni[visualizzaStanza].getNumeroStanza() + " ci sono " + centroConvegni[visualizzaStanza].getPersonePresenti() + " persone.");
                    } else {
                        System.out.println("numero stanza non valido.");
                    }
                    break;

                case 4:
                    int totalePersone = 0;
                    for (CentroConvegni stanza : centroConvegni) {
                        totalePersone += stanza.getPersonePresenti();
                    }
                    System.out.println("totale persone nel centro: " + totalePersone);
                    break;

                case 5:
                    System.out.println("stanze vuote:");
                    for (CentroConvegni stanza : centroConvegni) {
                        if (stanza.isVuota()) {
                            System.out.println("- " + stanza.getNumeroStanza());
                        }
                    }
                    break;

                case 6:
                    System.out.println("stanze piene:");
                    for (CentroConvegni stanza : centroConvegni) {
                        if (stanza.isPiena()) {
                            System.out.println("- " + stanza.getNumeroStanza());
                        }
                    }
                    break;

                default:
                    System.out.println("no good.");
                    break;
            }
        }

        input.close();
    }
}
