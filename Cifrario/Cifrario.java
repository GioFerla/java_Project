public abstract class Cifrario {
    private String testo;
    private int chiave;
    private String parolaChiave;

    //---Cesare and Cesare Pro
    public Cifrario(String testo, int chiave) {
        this.testo = testo;
        this.chiave = chiave;
    }


    //---Vigenere
    public Cifrario(String testo, String parolaChiave) {
        this.testo = testo;
        this.parolaChiave = parolaChiave;
    }

    //---nonLinearCesar
    public Cifrario(String testo, int chiave, String parolaChiave) {
        this.testo = testo;
        this.chiave = chiave;
        this.parolaChiave = parolaChiave;
    }

    public abstract String encode();

    public abstract String decode();

    public String getTesto() {
        return testo;
    }

    public int getChiave() {
        return chiave;
    }

    public String getParolaChiave(){
        return parolaChiave;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public void setChiave(int chiave) {
        this.chiave = chiave;
    }

    public void setParolaChiave(String parolaChiave){
        this.parolaChiave = parolaChiave;
    }
    protected static char shiftAvanti(char lettera, int chiave) {
        if (Character.isLetter(lettera)) {
            char base = Character.isUpperCase(lettera) ? 'A' : 'a';
            return (char) ((lettera - base + chiave) % 26 + base);
        }
        return lettera;
    }

    protected static char shiftIndietro(char lettera, int chiave) {
        if (Character.isLetter(lettera)) {
            char base = Character.isUpperCase(lettera) ? 'A' : 'a';
            return (char) ((lettera - base - chiave + 26) % 26 + base);
        }
        return lettera;
    }
} 
