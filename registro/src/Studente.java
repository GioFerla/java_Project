public class Studente extends Persona {
    private String classe;
    private String cf;

    public Studente(String nome, String cognome, String classe, String cf) {
        super(nome, cognome);
        this.classe = classe;
        this.cf = cf;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }
    @Override
    public String toString() {
        return "Studente{" + "classe=" + classe + ", cf=" + cf + '}';
    }
}
