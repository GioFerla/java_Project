
import java.util.Scanner;

public class AutomobilePRthread {
    public static InfoAutomobile auto;
    public static String stop = "n";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("marca dell'automobile: ");
        String marca = input.nextLine();

        System.out.println("modello dell'automobile: ");
        String modello = input.nextLine();

        System.out.println("colore dell'automobile: ");
        String colore = input.nextLine();

        System.out.println("vuoi accendere l'automobile? S/N");
        String scelta = input.nextLine();

        // Inizializzo l'oggetto InfoAutomobile con i dati inseriti dall'utente
        auto = new InfoAutomobile(modello, colore, marca);        

        if (scelta.equalsIgnoreCase("s")) {
            auto.accensioneMotore();
        }
        // Thread per simulare il movimento dell'auto
        Thread accelerazione = new Thread(() -> {
            while (!stop.equalsIgnoreCase("S")) {  
                if (auto.accelleraAuto() == 707) {
                    break;
                }else{
                    clearScreen();
                    System.out.println("velocità attuale: " + auto.accelleraAuto());
                    System.out.print("vuoi fermarti? (S/N): ");
                }
                try {
                    Thread.sleep(500);  
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
            }
            Thread.currentThread().interrupt();
            System.out.println("l'auto è in velocità costante.");
            
        }); 

        Thread decelerazione = new Thread(() -> {
            while (!stop.equalsIgnoreCase("S")) {  
                System.out.println("velocità attuale: " + auto.decelleraAuto());
                System.out.print("vuoi fermarti? (S/N): ");

                try {
                    Thread.sleep(900);  
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
                if (auto.decelleraAuto() == 0) {
                    System.out.println("l'auto è ferma");
                    break;
                    
                }else{
                    System.out.println("l'auto è in velocità costante.");
                    Thread.currentThread().interrupt();
                    
                }
            }
        });

        // Thread per ottenere input dall'utente
        Thread inputUtente = new Thread(() -> {
            Scanner rUtente = new Scanner(System.in);
            while (true) {
                stop = rUtente.nextLine();
                if (stop.equalsIgnoreCase("S")) {
                    break;  
                }
            }
            rUtente.close();  
        });

        accelerazione.start();
        inputUtente.start();
        if(!stop.equalsIgnoreCase("S")){
            try {
                Thread.sleep(6000);
                accelerazione.interrupt(); 
                System.out.println(accelerazione.isInterrupted());

                System.out.println(inputUtente.isInterrupted());
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
        }
        stop  = "";
        decelerazione.start();
        
         
        /* while (auto.getStatoMotore()) {              
            // Controlla se l'auto ha una velocità valida
            int velocita = auto.getVelocita();
            
            // Condizioni di controllo della velocità
            if (velocita > 0 && velocita < 130) {
                System.out.println("digita");
                System.out.println("1 per accellerare");
                System.out.println("2 per decelerare");
                scelta = input.nextLine();
    
                if (scelta.equalsIgnoreCase("1")) {
                    accelerazione.start();  
                    inputUtente.start();
                } else if (scelta.equalsIgnoreCase("2")) {
                    decelerazione.start();  
                    inputUtente.start();
                }
                
                }else if (velocita == 130) {
                System.out.println("Hai raggiunto la velocità massima. Digita:");
                System.out.println("1 per decelerare");
                scelta = input.nextLine();
    
                if (scelta.equalsIgnoreCase("1")) {
                    decelerazione.start();  
                    inputUtente.start();
                }
            } else if (velocita == 0) {
                System.out.println("L'auto è ferma. Digita:");
                System.out.println("1 per accellerare");
                scelta = input.nextLine();
        
                if (scelta.equalsIgnoreCase("1")) {
                    accelerazione.start();  
                    inputUtente.start();
                }
            }
            System.out.println("vuoi spegnere l'auto? S/N");
            scelta = input.nextLine();
            if (scelta.equalsIgnoreCase("s")) {
                auto.spegnimentoMotore();
            }
            if (accelerazione.isAlive()) {
                stop = "S"; // Interrompi il thread di accelerazione
            }
            if (decelerazione.isAlive()) {
                stop = "S"; // Interrompi il thread di decelerazione
            }
            
        } */     
          
    }
    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
