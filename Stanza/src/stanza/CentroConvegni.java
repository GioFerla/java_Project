public class CentroConvegni {
    private String numeroStanza;
    private int personePresenti;
    private int capienzaMassima;

    public CentroConvegni(String numeroStanza, int capienzaMassima) {
        this.numeroStanza = numeroStanza;
        this.capienzaMassima = capienzaMassima;
        this.personePresenti = 0;
    }

    public boolean aggiungiPersona() {
        if (personePresenti < capienzaMassima) {
            personePresenti++;
            return true;
        }
        return false; 
    }

    public boolean rimuoviPersona() {
        if (personePresenti > 0) {
            personePresenti--;
            return true;
        }
        return false; 
    }

    public int getPersonePresenti() {
        return personePresenti;
    }

    public boolean isVuota() {
        return personePresenti == 0;
    }

    public boolean isPiena() {
        return personePresenti == capienzaMassima;
    }

    public String getNumeroStanza() {
        return numeroStanza;
    }
}
