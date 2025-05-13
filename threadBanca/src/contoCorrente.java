public class contoCorrente {
    private double saldo;
    private String nome;
    private String cognome;

    public contoCorrente(String nome, String cognome, double saldo) {
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
    }

    public void deposita(double quantita) {
        saldo += quantita;
    }

    public void preleva(double quantita) {
        saldo -= quantita;
    }

    public double getSaldo() {
        return saldo;
    }

    public double aggiungi(double cifra) {
        Deposito deposito = new Deposito(cifra, "Deposito generico", this);
        deposito.run();
        return getSaldo();
        
    }

    public double sottrai(double cifra) {
        Prelievo prelievo = new Prelievo(cifra, "Sottrazione generica", this);
        prelievo.run();
        return getSaldo();
    }


}