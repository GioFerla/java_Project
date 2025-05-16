public abstract class Auto {
    protected String modello;
    protected String colore;
    protected String marca;
    protected boolean motore;
    protected int velocita;
    protected int[] sogliaMarcia = {1, 20, 21, 35, 36, 50, 51, 75, 76, 130};
    protected int marcia;

    public Auto(String modello, String colore, String marca) {
        this.modello = modello;
        this.colore = colore;
        this.marca = marca;
        this.motore = false;
        this.velocita = 0;
        this.marcia = 0;
    }

    public boolean accensioneMotore() {
        if (!motore) {
            motore = true;
            return true;
        }
        System.out.println("Il motore è già acceso.");
        return false;
    }

    public boolean spegnimentoMotore() {
        if (velocita == 0) {
            motore = false;
            return true;
        }
        System.out.println("Non puoi spegnere il motore mentre l'auto è in movimento!");
        return false;
    }

    public boolean getStatoMotore() {
        return motore;
    }

    public int getVelocita() {
        return velocita;
    }

    public int getMarcia() {
        return marcia;
    }

    public abstract int accelleraAuto();

    public abstract int deceleraAuto();
}
