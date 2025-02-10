import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("numeratore: ");
        int numeratore = input.nextInt();

        System.out.print("denominatore: ");
        int denominatore = input.nextInt();

        NumeriRazionali numero = new NumeriRazionali(numeratore, denominatore);

        System.out.println("la frazione semplificata è: " + numero);
    }
}
