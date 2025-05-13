public class Main {
    public static void main(String[] args) {
        contoCorrente conto = new contoCorrente("Mario", "Rossi", 1000.0);
        System.out.println("Saldo iniziale: " + conto.getSaldo());
        conto.aggiungi(200.0);
        conto.sottrai(150.0);
    }
}
