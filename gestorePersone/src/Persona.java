public class Persona {
    private int eta;
    private String nome, cognome;
    
    public Persona(int eta, String nome, String cognome) {
        if (validitaEta(eta)) {
            this.eta = eta;
        } else {
            this.eta = 707; 
        }
        this.nome = nome;
        this.cognome = cognome;
    }

    public boolean modificaEta(int eta) {
        if (eta != this.eta && validitaEta(eta)) {
            this.eta = eta;
            return true;
        }
        return false;
    }
    
    private boolean validitaEta(int eta) {
        return eta > 0;
    }

    public boolean verificaCognome(String cognome) {
        return cognome.equalsIgnoreCase(this.cognome);
    }

    public boolean verificaNome(String nome) {
        return nome.equalsIgnoreCase(this.nome);
    }

    public boolean verificEtaMaggiore(int eta) {
        return this.eta > eta;
    }

    public boolean verificEtaMinore(int eta) {
        return this.eta < eta;
    }

    public boolean verificaClone(String nome, String cognome, int eta) {
        return nome.equalsIgnoreCase(this.nome) && 
               cognome.equalsIgnoreCase(this.cognome) && 
               eta == this.eta;
    }

    public int getEta() {
        return this.eta;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }
}
