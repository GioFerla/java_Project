
import java.util.Scanner;

public class Automobile {
    public static InfoAutomobile auto;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Marca dell'automobile: ");
        String marca = input.nextLine();

        System.out.println("Modello dell'automobile: ");
        String modello = input.nextLine();

        System.out.println("Colore dell'automobile: ");
        String colore = input.nextLine();

        System.out.println("Vuoi accendere l'automobile? (S/N)");
        String scelta = input.nextLine();

        // Inizializzo l'oggetto InfoAutomobile con i dati inseriti dall'utente
        auto = new InfoAutomobile(modello, colore, marca);

        if (scelta.equalsIgnoreCase("s")) {
            auto.accensioneMotore();
            boolean isRunning = true; // Variabile per controllare se il motore è acceso

            while (isRunning) {
                int velocita = auto.getVelocita();

                if (velocita < 130) {
                    System.out.println("Digita:");
                    System.out.println("1 per accelerare");
                    System.out.println("2 per decelerare");
                    scelta = input.nextLine();

                    switch (scelta) {
                        case "1":
                            auto.accelleraAuto();
                            break;
                        case "2":
                            auto.decelleraAuto();
                            break;
                        default:
                            System.out.println("Scelta non valida. Riprova.");
                    }
                } else if (velocita == 130) {
                    System.out.println("Hai raggiunto la velocità massima. Digita:");
                    System.out.println("1 per decelerare");
                    scelta = input.nextLine();

                    if (scelta.equals("1")) {
                        auto.decelleraAuto();
                    }
                } else if (velocita == 0) {
                    System.out.println("L'auto è ferma. Digita:");
                    System.out.println("1 per accelerare");
                    scelta = input.nextLine();

                    if (scelta.equals("1")) {
                        auto.accelleraAuto();
                    }
                }

                // Mostra la velocità attuale
                System.out.println("Velocità attuale: " + auto.getVelocita());

                // Controlla se l'utente vuole spegnere l'auto
                System.out.println("Vuoi spegnere l'auto? (S/N)");
                String sceltaSpegnimento = input.nextLine();
                if (sceltaSpegnimento.equalsIgnoreCase("s")) {
                    if(auto.spegnimentoMotore()){
                        isRunning = false; // Esci dal ciclo se il motore è spento
                    }
                }
            }

        } else {
            System.out.println("L'automobile non è stata accesa.");
        }

        input.close();
    }
}
