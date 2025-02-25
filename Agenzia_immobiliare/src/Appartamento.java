public class Appartamento extends Immobile {
    private int numeroVani;
    private int numeroBagni;
    private String piano;

    public Appartamento(String codiceAgenzia, String indirizzo, String cap, String citta, String provincia, int superficie, int prezzo, int numeroVani, int numeroBagni, String piano) {
        super(codiceAgenzia, indirizzo, cap, citta, provincia, superficie, prezzo);
        this.numeroVani = numeroVani;
        this.numeroBagni = numeroBagni;
        this.piano = piano;
    }
    
    public int getNumeroVani() {
        return numeroVani;
    }
    public void setNumeroVani(int numeroVani) {
        this.numeroVani = numeroVani;
    }
    public int getNumeroBagni() {
        return numeroBagni;
    }
    public void setNumeroBagni(int numeroBagni) {
        this.numeroBagni = numeroBagni;
    }
    public String getPiano() {
        return piano;
    }
    public void setPiano(String piano) {
        this.piano = piano;
    }

    @Override
    public String toString() {
        return "Appartamento [numeroBagni=" + numeroBagni + ", numeroVani=" + numeroVani + ", piano=" + piano + "]";
    }
}
