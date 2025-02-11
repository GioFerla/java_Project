
public class Squadra {
    private String nomeSquadra;
    private String nomeAllenatore;
    private String nomeDirigente;

    public Squadra(String nomeSquadra, String nomeAllenatore, String nomeDirigente) {
        this.nomeSquadra = nomeSquadra;
        this.nomeAllenatore = nomeAllenatore;
        this.nomeDirigente = nomeDirigente;
    }

    public String getNomeSquadra() {
        return nomeSquadra;
    }

    public void setNomeSquadra(String nomeSquadra) {
        this.nomeSquadra = nomeSquadra;
    }

    public String getNomeAllenatore() {
        return nomeAllenatore;
    }

    public void setNomeAllenatore(String nomeAllenatore) {
        this.nomeAllenatore = nomeAllenatore;
    }
    
    public String getNomeDirigente() {
        return nomeDirigente;
    }

    public void setNomeDirigente(String nomeDirigente) {
        this.nomeDirigente = nomeDirigente;
    }
    
}
