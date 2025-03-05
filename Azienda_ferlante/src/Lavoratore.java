public abstract class Lavoratore {
    private String nominativo;
    private String codiceFiscale;
    private int stipendio;

    public Lavoratore(String nominativo, String codiceFiscale/* , int stipendio */) {
        this.nominativo = nominativo;
        this.codiceFiscale = codiceFiscale;
        /* this.stipendio = stipendio; */
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public int getStipendio() {
        return stipendio;
    }

    public void aggiornaStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public abstract int calcolaBonus();    

    @Override
    public String toString() {
        return "Nominativo: " + nominativo + ", Codice Fiscale: " + codiceFiscale + ", Stipendio: " + stipendio;
    }
}
