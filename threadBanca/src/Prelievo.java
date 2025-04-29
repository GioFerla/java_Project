public class Prelievo {
    private double cifra;
    private String motivo;
    private contoCorrente contoCorrente;

    public Prelievo(double cifra, String motivo, contoCorrente contoCorrente) {
        this.cifra = cifra;
        this.motivo = motivo;
        this.contoCorrente = contoCorrente;
    }

    public synchronized void run() {
        if (contoCorrente.getSaldo() >= cifra) {
            contoCorrente.preleva(cifra);
            System.out.println("Prelievo di " + cifra + " effettuato per: " + motivo);
        } else {
            System.out.println("Saldo insufficiente per il prelievo di " + cifra);
        }
    }
}
