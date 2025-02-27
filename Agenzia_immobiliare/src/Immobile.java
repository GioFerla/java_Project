public abstract class  Immobile {
    private String indirizzo;
    private String codice;
    private String cap;
    private String citta;
    private String provincia;
    private String descrizione;
    private int superficie;
    private int prezzo;
    public static int contatore;

    //con descrizione
    public Immobile(String codiceAgenzia, String indirizzo,  String cap, String citta, String provincia, int superficie, int prezzo, String descrizione) {
        this.indirizzo = indirizzo;
        this.codice = codiceAgenzia + contatore;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.superficie = superficie;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        contatore++;
    }
    //senza descrizione
    public Immobile(String codiceAgenzia, String indirizzo,  String cap, String citta, String provincia, int superficie, int prezzo) {
        this.indirizzo = indirizzo;
        this.codice = codiceAgenzia + contatore;
        this.cap = cap;
        this.citta = citta;
        this.provincia = provincia;
        this.superficie = superficie;
        this.prezzo = prezzo;
        contatore++;
    }

    public String getIndirizzo() {
        return indirizzo;
    }
    public String getCodice() {
        return codice;
    }
    public String getCap() {
        return cap;
    }
    public String getCitta() {
        return citta;
    }
    public String getProvincia() {
        return provincia;
    }
    public int getSuperficie() {
        return superficie;
    }
    public int getPrezzo() {
        return prezzo;
    }
    public String getDescrizione() {
        return descrizione;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    public void setCap(String cap) {
        this.cap = cap;
    }
    public void setCitta(String citta) {
        this.citta = citta;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }
    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
}
