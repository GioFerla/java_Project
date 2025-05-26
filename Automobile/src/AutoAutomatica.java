public class AutoAutomatica extends Auto {
    public AutoAutomatica(String modello, String colore, String marca) {
        super(modello, colore, marca);
    }
    
    private void controlloMarciaAutomatico() {
        if (getVelocita() == 0) {
            setMarcia(0);
        } else if (getVelocita() >= getSogliaMarcia()[0] && getVelocita() <= getSogliaMarcia()[1]) {
            setMarcia(1);
        } else if (getVelocita() >= getSogliaMarcia()[2] && getVelocita() <= getSogliaMarcia()[3]) {
            setMarcia(2);
        } else if (getVelocita() >= getSogliaMarcia()[4] && getVelocita() <= getSogliaMarcia()[5]) {
            setMarcia(3);
        } else if (getVelocita() >= getSogliaMarcia()[6] && getVelocita() <= getSogliaMarcia()[7]) {
            setMarcia(4);
        } else if (getVelocita() >= getSogliaMarcia()[8] && getVelocita() <= getSogliaMarcia()[9]) {
            setMarcia(5);
        }
    }
    
    @Override
    public int accelleraAuto() {
        if (!getStatoMotore()) {
            System.out.println("L'auto è spenta. Accendere il motore prima di accelerare.");
            return getVelocita();
        }
        
        if (getMarcia() == 0 && getVelocita() == 0) {
            setMarcia(1);
        }
        
        if (getVelocita() < getMaxSpeed()) {
            setVelocita(getVelocita() + 1);
            controlloMarciaAutomatico();
            return getVelocita();
        } else {
            System.out.println("Hai raggiunto la velocità massima per questo veicolo.");
            return getVelocita();
        }
    }
    
    @Override
    public int deceleraAuto() {
        if (getVelocita() > 0) {
            setVelocita(getVelocita() - 1);
            controlloMarciaAutomatico();
            return getVelocita();
        } else {
            System.out.println("L'auto è ferma.");
            return getVelocita();
        }
    }
}