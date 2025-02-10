public class Main {
    public static void main(String[] args) {

        ProgettoScienzaPunteggio.setNumeroGiudici(3);
        System.out.println("Numero di giudici " + ProgettoScienzaPunteggio.numeroGiudici);
        System.out.println("Massimo punteggio possibile " + ProgettoScienzaPunteggio.getMassimoPunteggio());

        ProgettoScienzaPunteggio progetto1 = new ProgettoScienzaPunteggio("A", "001", "maremma banana", 25, 28, 14, 13, 9);

        System.out.println(progetto1.visualizzaPunteggio());

        ProgettoScienzaPunteggio progetto2 = new ProgettoScienzaPunteggio("B", "002", "thomas samoht", 30, 30, 15, 15, 10);

        System.out.println(progetto2.visualizzaPunteggio());
    }
}
