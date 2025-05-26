public abstract class Auto {
    private String modello;
    private String colore;
    private String marca;
    private boolean motore;
    private int velocita;
    private int[] sogliaMarcia;
    private int marcia;
    private int maxSpeed;
    
    public Auto(String modello, String colore, String marca) {
        this.modello = modello;
        this.colore = colore;
        this.marca = marca;
        this.motore = false;
        this.velocita = 0;
        this.marcia = 0;
        
        setVelocitaMarcia(marca);
    }
    
    private void setVelocitaMarcia(String marca) {
        switch (marca.toLowerCase()) {
            case "fiat" -> {
                this.maxSpeed = 130;
                this.sogliaMarcia = new int[]{1, 15, 16, 30, 31, 50, 51, 80, 81, 130};
            }
            case "audi" -> {
                this.maxSpeed = 250;
                this.sogliaMarcia = new int[]{1, 25, 26, 50, 51, 90, 91, 150, 151, 250};
            }
            case "bmw" -> {
                this.maxSpeed = 300;
                this.sogliaMarcia = new int[]{1, 30, 31, 60, 61, 100, 101, 180, 181, 300};
            }
            case "mercedes" -> {
                this.maxSpeed = 320;
                this.sogliaMarcia = new int[]{1, 35, 36, 70, 71, 120, 121, 200, 201, 320};
            }
            default -> {
                this.maxSpeed = 130;
                this.sogliaMarcia = new int[]{1, 20, 21, 35, 36, 50, 51, 75, 76, 130};
            }
        }
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
    
    public String getModello() {
        return modello;
    }
    
    public String getColore() {
        return colore;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public boolean getStatoMotore() {
        return motore;
    }
    
    public int getVelocita() {
        return velocita;
    }
    
    public int[] getSogliaMarcia() {
        return sogliaMarcia;
    }
    
    public int getMarcia() {
        return marcia;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }
    
    public void setModello(String modello) {
        this.modello = modello;
    }
    
    public void setColore(String colore) {
        this.colore = colore;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public void setMotore(boolean motore) {
        this.motore = motore;
    }
    
    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }
    
    public void setSogliaMarcia(int[] sogliaMarcia) {
        this.sogliaMarcia = sogliaMarcia;
    }
    
    public void setMarcia(int marcia) {
        this.marcia = marcia;
    }
    
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public abstract int accelleraAuto();
    public abstract int deceleraAuto();
}
