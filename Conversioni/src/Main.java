import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        while (true) {
            String scelta = chiediConversione(input);
            if (scelta.equalsIgnoreCase("esci")) {
                terminaProgramma();
                break;
            } else {
                eseguiConversione(scelta, input);
            }
        }

        input.close();
    }

    private static String chiediConversione(Scanner input) {
        System.out.println("Scegli una conversione: Celsius, Fahrenheit o Kelvin? (digita 'esci' per uscire)");
        return input.nextLine();
    }

    private static void terminaProgramma() {
        System.out.println("Programma terminato.");
    }

    private static void eseguiConversione(String scelta, Scanner input) {
        if (scelta.equalsIgnoreCase("celsius")) {
            convertiDaCelsius(input);
        } else if (scelta.equalsIgnoreCase("fahrenheit")) {
            convertiDaFahrenheit(input);
        } else if (scelta.equalsIgnoreCase("kelvin")) {
            convertiDaKelvin(input);
        } else {
            System.out.println("Scelta non valida. Riprova.");
        }
    }
    
    private static void convertiDaCelsius(Scanner input) {
        System.out.println("Inserisci i gradi Celsius da convertire in Fahrenheit o Kelvin:");
        double temp = input.nextDouble();
        input.nextLine();  

        System.out.println("Converti in: Fahrenheit o Kelvin?");
        String destinazione = input.nextLine();

        if (destinazione.equalsIgnoreCase("Fahrenheit")) {
            stampaRisultato(temp, "°C", Conversioni.celsiusToFahrenheit(temp), "°F", Conversioni.getFahrenheitFormula());
        } else if (destinazione.equalsIgnoreCase("Kelvin")) {
            stampaRisultato(temp, "°C", Conversioni.celsiusToKevin(temp), "K", Conversioni.getCelsiusToKevinFormula());
        } else {
            System.out.println("Scelta non valida.");
        }
    }

    private static void convertiDaFahrenheit(Scanner input) {
        System.out.println("Inserisci i gradi Fahrenheit da convertire in Celsius:");
        double temp = input.nextDouble();
        input.nextLine(); 
        stampaRisultato(temp, "°F", Conversioni.fahrenheitToCelsius(temp), "°C", Conversioni.getCelsiusFormula());
    }

    private static void convertiDaKelvin(Scanner input) {
        System.out.println("Inserisci i gradi Kelvin da convertire in Celsius:");
        double temp = input.nextDouble();
        input.nextLine(); 
        stampaRisultato(temp, "K", Conversioni.kevinToCelsius(temp), "°C", Conversioni.getKevinToCelsiusFormula());
    }

    private static void stampaRisultato(double tempIniziale, String unitaIniziale, double tempConvertita, String unitaConvertita, String formula) {
        System.out.println("Inizio: " + tempIniziale + " " + unitaIniziale);
        System.out.println("Convertito: " + tempConvertita + " " + unitaConvertita);
        System.out.println("Formula utilizzata: " + formula);
    }
}
