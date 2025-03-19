public class Monolocale extends Stanza {
    private static final int COSTOGIORNALIERO = 75;

    // Costruttore
    public Monolocale(String codice) {
        super(codice);
    }
    
    public static int getCostoGiornaliero() {
        return COSTOGIORNALIERO;
    }

    // Implementazione dei metodi astratti
    @Override
    public double stimaCostoAffitto(int giorniAffitto) {
        return COSTOGIORNALIERO * giorniAffitto;
    }
	@Override
    public double costoAffitto() {
        return COSTOGIORNALIERO * this.getGiorniAffitto();
    }

    // Override del metodo toString
    @Override
    public String toString() {
        return "MONOLOCALE: " + super.toString();
    }
}
