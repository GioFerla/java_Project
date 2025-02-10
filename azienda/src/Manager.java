public class Manager extends Dipendente {
    private Dipendente segretaria;

    public Manager(String nome, String cognome, int assunzione, int stipendio){
        super(nome, cognome, assunzione, stipendio);
        this.segretaria = null;
    }

    public Manager(String nome, String cognome, int assunzione, int stipendio, Dipendente segretaria) {
        super(nome, cognome, assunzione, stipendio);
        this.segretaria = segretaria;
    }

    @Override
    public void aumentaStipendio(int percentuale){
        this.stipendio += this.stipendio * percentuale / 100;
        this.stipendio += 1000;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSegretaria: " + this.segretaria;
    }

}
