public class Bilocale extends Stanza {
    private static final int COSTOGIORNALIERO = 120;
    private static final int COSTOFISSOPULIZIA = 20;

    // Costruttore
    public Bilocale(String codice) {
        super(codice);
    }

    public static int getCostoGiornaliero() {
        return COSTOGIORNALIERO;
    }
    
    public static int getCostoFissoPulizia() {
        return COSTOFISSOPULIZIA;
    }

    // Implementazione dei metodi astratti
    @Override
    public double stimaCostoAffitto(int giorniAffitto) {
        return (COSTOGIORNALIERO * giorniAffitto) + COSTOFISSOPULIZIA;
    }
	@Override
    public double costoAffitto() {
        return (COSTOGIORNALIERO * this.getGiorniAffitto()) + COSTOFISSOPULIZIA;
    }

    // Override del metodo toString
    @Override
    public String toString() {
        return "BILOCALE: " + super.toString();
    }
}
