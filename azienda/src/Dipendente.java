public class Dipendente {
    private String nome;
    private String cognome;
    private int assunzione;
    private double stipendio;
    private String matricola;
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

    public void aumentaStipendio(double stipendio, double bonus) {
        this.stipendio += stipendio + bonus;
    }

    public double getStipendio() {
        return this.stipendio;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nCognome: " + this.cognome + "\nAssunzione: " + this.assunzione + "\nStipendio: " + this.stipendio + "\nMatricola: " + this.matricola + "\n";
    }
}
