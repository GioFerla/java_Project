
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String richiesta = input.nextLine(); 
        Personaggio persona = new Personaggio(riconosciSesso(richiesta), riconosciEta(richiesta));

        System.out.println("Caratteristiche del personaggio:");
        System.out.println("Colore capelli: " + persona.capelli[0]);
        System.out.println("Tipo capelli: " + persona.capelli[1]);
        System.out.println("Colore occhi: " + persona.occhi);
        System.out.println("Lunghezza capelli: " + persona.capelli[2]);
        System.out.println("Colore pelle: " + persona.colore);
        System.out.println("Età: " + persona.anni + " anni");
        System.out.println("Altezza: " + persona.altezza + " cm");
    } 
    private static String riconosciSesso(String richiesta){
        Pattern patterMaschio = Pattern.compile("(uomo|maschio|ragazzo)",Pattern.CASE_INSENSITIVE);
        Pattern patterFemmina = Pattern.compile("(donna|femmina|ragazza)",Pattern.CASE_INSENSITIVE);

        Matcher matcherMaschio = patterMaschio.matcher(richiesta);
        Matcher matcherFemmina = patterFemmina.matcher(richiesta);

        if(matcherMaschio.find()){
            return "maschio";
        }else if(matcherFemmina.find()){
            return "femmina";
            }else return "croissant";
    }

    private static String riconosciEta(String richiesta){
        Pattern patternBambino = Pattern.compile("(bambino|bambina|piccirillo|infante)",Pattern.CASE_INSENSITIVE);
        Pattern patterRagazzo = Pattern.compile("(ragazzo|ragazza|adolescente|giovane|guaglione)",Pattern.CASE_INSENSITIVE);
        Pattern patterAdulto = Pattern.compile("(adulto|signore|signora|donna|uomo)",Pattern.CASE_INSENSITIVE);
        Pattern patterAnziano = Pattern.compile("(anziano|vecchio|attempato|nonna|nonno)",Pattern.CASE_INSENSITIVE);

        Matcher matcherBambino = patternBambino.matcher(richiesta);
        Matcher matcherRagazzo = patterRagazzo.matcher(richiesta);
        Matcher matcherAdulto = patterAdulto.matcher(richiesta);
        Matcher matcherAnziano = patterAnziano.matcher(richiesta);

        if(matcherBambino.find()){
            return "bambino";
        }else if(matcherRagazzo.find()){
            return "ragazzo";
            }else if(matcherAdulto.find()){
                    return "adulto";
                }else if(matcherAnziano.find()){
                        return "anziano";
                    }else return null;
    }
}
