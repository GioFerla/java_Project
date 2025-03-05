public class Consulente extends Lavoratore {
    public Consulente(String nominativo, String codiceFiscale) {
        super(nominativo, codiceFiscale);
    }

    public int calcolaBonus() {
        int bonus = (int) (super.getStipendio() * 0.10);
        return bonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
