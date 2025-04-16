import java.time.LocalDate;
/* 
le stanze hanno pochi attributi perché si suppone che il residence abbia monolocali tutti uguali
e quindi affittati allo stesso costo. Per questo non ci sono caratteristiche come dimensione o posti letto. 
Lo stesso vale per i bilocali. 
*/
public abstract class Stanza {
    private String codice; // è un codice alfanumerico che identifica la stanza
    private String documentoCliente; // le informazioni che seguono indicano i dati di affitto
    private boolean affittata=false;
    private int giorniAffitto;
    private LocalDate dataAffito;

    // Costruttore
    public Stanza(String codice) {
        this.codice = codice;
    }

    // Metodi getter
    public String getCodice() {
        return codice;
    }

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public boolean isAffittata() {
        return affittata;
    }

    public int getGiorniAffitto() {
        return giorniAffitto;
    }

    public LocalDate getDataAffitto() {
        return dataAffito;
    }

    // Metodi setter
    public void setDocumentoCliente(String documentoCliente) {
        if (this.affittata) this.documentoCliente = documentoCliente;
    }

    public void setGiorniAffitto(int giorniAffitto) {
        if (this.affittata) this.giorniAffitto = giorniAffitto;
    }

    // Metodo astratto per stimare il costo di affitto
    public abstract double stimaCostoAffitto(int giorniAffitto);
	
	// Metodo astratto per fornire il costo dell'affitto
    public abstract double costoAffitto();

    // Metodo per il check-in
    public void checkIn(String documentoCliente, int giorniAffitto) {
        if (!this.affittata) {
            this.documentoCliente = documentoCliente;
            this.giorniAffitto = giorniAffitto;
            this.dataAffito = LocalDate.now(); // Inizializza la data con la data di sistema
            this.affittata = true;
        }
    }

    // Metodo per il check-out
    public void checkOut() {
        this.affittata = false;
        this.documentoCliente = null;
		this.dataAffito = null;
    }

    // Metodo toString
    @Override
    public String toString() {
        return  "codiceStanza='" + codice + '\'' +
                ", documento Cliente='" + (documentoCliente != null ? documentoCliente : "Nessuna") + '\'' +
                ", affittata=" + affittata +
                ", giorni affitto=" + giorniAffitto +
                ", data affitto=" + (dataAffito != null ? dataAffito : "Nessuna") +
                '}';
    }

}