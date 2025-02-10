public class Dipendente {
  /*utilizzo il modificatore di visibilità protected per rendere accessibili le variabili di istanza anche alle sottoclassi(figli) */
    protected String nome;
    protected String cognome;
    protected int assunzione;
    protected int stipendio;
    protected String matricola;
    public static int matricole = 0;

    public Dipendente(String nome, String cognome, int assunzione, int stipendio) {
        this.nome = nome;
        this.cognome = cognome;
        this.assunzione = assunzione;
        this.stipendio = stipendio;
        this.matricole++;
        this.matricola = "A" + this.matricole;
    } 
    
    public void aumentaStipendio(int percentuale) {
        this.stipendio += this.stipendio * percentuale / 100;
    }    

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nCognome: " + this.cognome + "\nAssunzione: " + this.assunzione + "\nStipendio: " + this.stipendio + "\nMatricola: " + this.matricola;
    }
}
