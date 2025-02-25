public class Villa extends Appartamento{
    private int mqGiardino;
    private boolean piscina;
    private String piani;

    public Villa(String codiceAgenzia, String indirizzo, String cap, String citta, String provincia, int superficie, int prezzo, int numeroVani, int numeroBagni, String piano, int mqGiardino, boolean piscina, String piani) {
        super(codiceAgenzia, indirizzo, cap, citta, provincia, superficie, prezzo, numeroVani, numeroBagni, piano);
        this.mqGiardino = mqGiardino;
        this.piscina = piscina;
        this.piani = piani;
    }        

    public int getMqGiardino() {
        return mqGiardino;
    }

    public void setMqGiardino(int mqGiardino) {
        this.mqGiardino = mqGiardino;
    }

    public String getPiani() {
        return piani;
    }

    public void setPiani(String piani) {
        this.piani = piani;
    }

}
