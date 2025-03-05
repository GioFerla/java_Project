public class Stagista extends Lavoratore {
    private String enteScolastico;
    private int oreFormazione;
    private static int oreFormazioneMaxBonus = 500;

    public Stagista(String nominativo, String codiceFiscale, String enteScolastico) {
        super(nominativo, codiceFiscale);
        this.enteScolastico = enteScolastico;
    }

    public int getOreFormazione() {
        return oreFormazione;
    }

    public void setOreFormazione(int oreFormazione) {
        this.oreFormazione = oreFormazione;
    }

    public static int getOreFormazioneMaxBonus() {
        return oreFormazioneMaxBonus;
    }

    public int calcolaBonus() {
        int bonus = 0;
        if (oreFormazione < oreFormazioneMaxBonus) {
            bonus = (int) (super.getStipendio() * 0.02);
        }else{
            bonus = (int) (super.getStipendio() * 0.05);
        }
        return bonus + ((int) (oreFormazione / 50) * 10);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", Ente Scolastico: " + enteScolastico + ", Ore Formazione: " + oreFormazione;
    }    
}
