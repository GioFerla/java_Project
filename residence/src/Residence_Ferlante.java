import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Residence_Ferlante {
    public static void main(String[] args) {
        ArrayList<Stanza> stanze = new ArrayList<Stanza>();
        Scanner scanner = new Scanner(System.in);
        String path = "stanze.txt";
        int scelta;

        
        while (true) {
            printMenu();
            scelta = scanner.nextInt();
            
            switch (scelta) {
                case 1:
                    aggiungiStanza(scanner, stanze);
                    break;
                case 2:
                    ricercaStanza(scanner, stanze);
                    break;
                case 3:
                    localiLiberi(stanze);
                    break;
                case 4:
                    calcolaCostiAffitto(scanner, stanze);
                    break;
                case 5:
                    checkIn(scanner, stanze);
                    break;
                case 6:
                    checkOut(scanner, stanze);
                    break;
                case 7:
                    prospettoCosti(stanze);
                    break;
                case 8:
                    localiLiberiDettagli(stanze);
                    break;
                case 9:
                    stampaSuFile(stanze, path);
                    break;
                case 10:
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nMENU\n1. Aggiungi stanza\n2. Ricerca stanza\n3. Locali liberi\n4. Costi di affitto\n5. Check-in\n6. Check-out\n7. Prospetto costi\n8. Locali liberi\n9. Stampa su file\n10. Esci\n");
    }

    private static void aggiungiStanza(Scanner scanner, ArrayList<Stanza> stanze) {       
        Stanza stanza = nuovaStanza(scanner);
        if (stanza != null) {
            stanze.add(stanza);
        }
    }

    private static void ricercaStanza(Scanner scanner, ArrayList<Stanza> stanze) {
        for (Stanza stanza : stanze) {
            System.out.println(stanza);
        }

        System.out.println("Inserisci il codice della stanza da cercare: ");
        String codiceCercato = scanner.next();
        for (Stanza stanza : stanze) {
            if (stanza.getCodice().equals(codiceCercato)) {
                System.out.println(stanza);
            }
        }
    }

    private static void localiLiberi(ArrayList<Stanza> stanze) {
        System.out.println("Locali liberi");
        System.out.println("\nMONOLOCALI\n");
        int[] flag = new int[2];

        for (Stanza stanza : stanze) {
            if (stanza instanceof Monolocale && !stanza.isAffittata()) {
                flag[0] = 1;
            }
        }

        System.out.println("\nBILOCALI\n");
        for (Stanza stanza : stanze) {
            if (stanza instanceof Bilocale && !stanza.isAffittata()) {
                flag[1] = 1;
            }
        }

        if (flag[0] == 1) {
            System.out.println("Sono presenti monolocali liberi");
        }else{
            System.out.println("Non sono presenti monolocali liberi");
        }
        if (flag[1] == 1) {
            System.out.println("Sono presenti bilocali liberi");
        }else{
            System.out.println("Non sono presenti bilocali liberi");
        }
    }

    private static void calcolaCostiAffitto(Scanner scanner, ArrayList<Stanza> stanze) {
        System.out.println("Inserisci il tipo di stanza (1. Monolocale, 2. Bilocale): ");
        int tipo = scanner.nextInt();
        System.out.println("Inserisci i giorni di affitto");
        int giorniAffitto = scanner.nextInt();
    
        if (tipo == 1) {
            for (Stanza stanza : stanze) {
                if (stanza instanceof Monolocale) {
                    System.out.println(stanza.stimaCostoAffitto(giorniAffitto));
                    break; 
                }
            }
        } else if (tipo == 2) {
            for (Stanza stanza : stanze) {
                if (stanza instanceof Bilocale) {
                    System.out.println(stanza.stimaCostoAffitto(giorniAffitto));
                    break; 
                }
            }
        }
    }
    

    private static void checkIn(Scanner scanner, ArrayList<Stanza> stanze) {
        System.out.println("Inserisci il tipo di stanza (1. Monolocale, 2. Bilocale): ");
        int tipo = scanner.nextInt();
        System.out.println("Inserisci i giorni di affitto");
        int giorniAffitto = scanner.nextInt();
    
        System.out.println("Documento personale: ");
        String documento = scanner.next();
    
        if (tipo == 1) {
            for (Stanza stanza : stanze) {
                if (stanza instanceof Monolocale && !stanza.isAffittata()) {
                    stanza.checkIn(documento, giorniAffitto);
                    break; 
                }
            }
        } else if (tipo == 2) {
            for (Stanza stanza : stanze) {
                if (stanza instanceof Bilocale && !stanza.isAffittata()) {
                    stanza.checkIn(documento, giorniAffitto);
                    break;
                }
            }
        }
    }
    
    private static void checkOut(Scanner scanner, ArrayList<Stanza> stanze) {
        System.out.println("Inserisci il codice della stanza da liberare: ");
        String codiceLiberare = scanner.next();
        for (Stanza stanza : stanze) {
            if (stanza.getCodice().equals(codiceLiberare)) {
                stanza.checkOut();
            }
        }
    }

    private static void prospettoCosti(ArrayList<Stanza> stanze) {
        double totale = 0;
        for (Stanza stanza : stanze) {
            if (stanza instanceof Monolocale && stanza.isAffittata()) {
                totale += ((Monolocale) stanza).costoAffitto();
            } else if (stanza instanceof Bilocale && stanza.isAffittata()) {
                totale += ((Bilocale) stanza).costoAffitto();
            }
        }
        System.out.println("Il totale: " + totale);
    }

    private static void localiLiberiDettagli(ArrayList<Stanza> stanze) {
        System.out.println("Locali liberi");
        System.out.println("\nMONOLOCALI\n");
        for (Stanza stanza : stanze) {
            if (stanza instanceof Monolocale && !stanza.isAffittata()) {
                System.out.println(stanza);
            }
        }
        System.out.println("\nBILOCALI\n");
        for (Stanza stanza : stanze) {
            if (stanza instanceof Bilocale && !stanza.isAffittata()) {
                System.out.println(stanza);
            }
        }
    }

    private static void stampaSuFile(ArrayList<Stanza> stanze, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (Stanza stanza : stanze) {
                writer.write(stanza.toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Stanza nuovaStanza(Scanner scanner) {
        System.out.println("Inserisci il codice della stanza: ");
        String codice = scanner.next();
        System.out.println("Inserisci il tipo di stanza (1. Monolocale, 2. Bilocale): ");
        int tipo = scanner.nextInt();

        if (tipo == 1) {
            return new Monolocale(codice);
        } else if (tipo == 2) {
            return new Bilocale(codice);
        }
        return null;
    }
}
