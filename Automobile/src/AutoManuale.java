public class AutoManuale extends Auto {
    public AutoManuale(String modello, String colore, String marca) {
        super(modello, colore, marca);
    }
    
    public int cambioMarcia(boolean up) {
        if (up) {
            if (getMarcia() >= 0 && getMarcia() < 5) {
                setMarcia(getMarcia() + 1);
                System.out.println("Passato alla marcia: " + getMarcia());
                return getMarcia();
            }
        } else {
            if (getMarcia() > 0 && getMarcia() <= 5) {
                setMarcia(getMarcia() - 1);
                String marciaText = getMarcia() == 0 ? "N" : String.valueOf(getMarcia());
                System.out.println("Passato alla marcia: " + marciaText);
                return getMarcia();
            }
        }
        return 404;
    }
    
    @Override
    public int accelleraAuto() {
        if (!getStatoMotore()) {
            System.out.println("L'auto è spenta. Accendere il motore prima di accelerare.");
            return getVelocita();
        }
        
        if (getMarcia() == 0) {
            System.out.println("Seleziona una marcia per iniziare.");
            return getVelocita();
        }
        
        int maxVelocitaMarcia = getSogliaMarcia()[getMarcia() * 2 - 1];
        int limiteEffettivo = Math.min(maxVelocitaMarcia, getMaxSpeed());
        
        if (getVelocita() < limiteEffettivo) {
            setVelocita(getVelocita() + 1);
            return getVelocita();
        } else {
            System.out.println("Hai raggiunto la velocità massima per la marcia " + getMarcia() + ". Cambia marcia per accelerare ulteriormente.");
            return getVelocita();
        }
    }
    
    @Override
    public int deceleraAuto() {
        if (getVelocita() > 0) {
            if (getMarcia() > 0) {
                int minVelocitaMarcia = getSogliaMarcia()[(getMarcia() - 1) * 2];
                
                if (getVelocita() <= minVelocitaMarcia) {
                    System.out.println("Velocità troppo bassa per la marcia attuale. L'auto si spegnerà se non cambi marcia.");
                    return 777;
                }
            }
            
            setVelocita(getVelocita() - 1);
            return getVelocita();
        } else {
            System.out.println("L'auto è ferma.");
            return getVelocita();
        }
    }
}
