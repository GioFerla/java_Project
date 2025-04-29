public class Deposito implements Runnable {
    private final double cifra;
    private final String motivo;
    private final contoCorrente contoCorrente;

    public Deposito(double cifra, String motivo, contoCorrente contoCorrente) {
        this.cifra = cifra;
        this.motivo = motivo;
        this.contoCorrente = contoCorrente;
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        synchronized (contoCorrente) {
            if (contoCorrente.getSaldo() >= cifra) {
                contoCorrente.deposita(cifra);
                System.out.println("Deposito di " + cifra + " effettuato per: " + motivo);
            } else {
                System.out.println("Saldo insufficiente per il deposito di " + cifra);
            }
        }
    }
}
