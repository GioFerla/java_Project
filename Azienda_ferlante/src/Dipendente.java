public class Dipendente extends Lavoratore {
    public String matricola;

    public Dipendente(String nominativo, String codiceFiscale, String matricola) {
        super(nominativo, codiceFiscale);
        this.matricola = matricola;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setStipendio(int stipendio) {
        super.aggiornaStipendio(stipendio);
    }

    public int getStipendio() {
        return super.getStipendio();
    }

    public int calcolaBonus() {
        int ventiPercento = (int) (super.getStipendio() * 0.20);
        int bonus = ventiPercento + 500;
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString() + ", Matricola: " + matricola;
    }
}
