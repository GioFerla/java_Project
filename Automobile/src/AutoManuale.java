public class AutoManuale extends Auto {
    public AutoManuale(String modello, String colore, String marca) {
        super(modello, colore, marca);
    }
    
    public int cambioMarcia(boolean up) {
        if (up) {
            if (marcia >= 0 && marcia < 5) {
                marcia++;
                System.out.println("Passato alla marcia: " + marcia);
                return marcia;
            }
        } else {
            if (marcia > 0 && marcia <= 5) {
                marcia--;
                String marciaText = marcia == 0 ? "N" : String.valueOf(marcia);
                System.out.println("Passato alla marcia: " + marciaText);
                return marcia;
            }
        }
        return 404;
    }
    
    
    @Override
    public int accelleraAuto() {
        if (!motore) {
            System.out.println("L'auto è spenta. Accendere il motore prima di accelerare.");
            return velocita;
        }
        
        if (marcia == 0) {
            System.out.println("Seleziona una marcia per iniziare.");
            return velocita;
        }
        
        int maxVelocitaMarcia = sogliaMarcia[marcia * 2 - 1];
        
        int limiteEffettivo = Math.min(maxVelocitaMarcia, maxSpeed);
        
        if (velocita < limiteEffettivo) {
            velocita++;
            return velocita;
        } else {
            System.out.println("Hai raggiunto la velocità massima per la marcia " + marcia + ". Cambia marcia per accelerare ulteriormente.");
            return velocita;
        }
    }
    
    @Override
    public int deceleraAuto() {
        if (velocita > 0) {
            if (marcia > 0) {
                int minVelocitaMarcia = sogliaMarcia[(marcia - 1) * 2];
                
                if (velocita <= minVelocitaMarcia) {
                    System.out.println("Velocità troppo bassa per la marcia attuale. L'auto si spegnerà se non cambi marcia.");
                    return 777;
                }
            }
            
            velocita--;
            return velocita;
        } else {
            System.out.println("L'auto è ferma.");
            return velocita;
        }
    }
}
