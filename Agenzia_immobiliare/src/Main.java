import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;
 
public class Main {
    public static void main(String[] args) {
        Agenzia a = new Agenzia("Agenzia", "123");
        Appartamento app = new Appartamento("123", "via roma", "00100", "roma", "rm", 100, 1000, 3, 2, "1");
        Villa v = new Villa("123", "via roma", "00100", "roma", "rm", 100, 140000, 3, 2, "1", 100, true, "2", "lusso moderno");
        Box b = new Box("123", "via roma", "00100", "roma", "rm", 100, 1000, 1);
 
 /*        System.out.println(a);
        System.out.println(app);
        System.out.println(v);
        System.out.println(b); */
 
        String inputUtente = "il mio budget e 140000 euro casa di moderno con più di  mq";
        Map<String, List<String>> risultati = estraiParoleChiave(inputUtente);
 
 
        for (Map.Entry<String, List<String>> entry : risultati.entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();  
       
            for (String elem : values) {
                System.out.println(values);
                if(v.search(elem)){
                    System.out.println(v.toString());
                }
            }
        }
       
 
       
        System.out.println("Parole chiave: " + (risultati.get("Parole Chiave")));
        System.out.println("Metri Quadri: " + risultati.get("Metri Quadri"));
        System.out.println("Prezzi: " + risultati.get("Prezzi"));
    }
 
    public static Map<String, List<String>> estraiParoleChiave(String testo) {
        String regex = "\\b(lusso|moderno)\\b|(?i)(\\d+)(\\s?(mq|metri quadri|€|euro|eur|e))?";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(testo);
 
        List<String> paroleChiave = new ArrayList<>();
        List<String> metriQuadri = new ArrayList<>();
        List<String> prezzi = new ArrayList<>();
 
        while (matcher.find()) {
            if (matcher.group(1) != null) {  
                paroleChiave.add(matcher.group(1));
            } else if (matcher.group(2) != null) {  
                String numero = matcher.group(2);
                String unità = matcher.group(4);
               
                if (unità != null) {
                    if (unità.equalsIgnoreCase("mq") || unità.equalsIgnoreCase("metri quadri")) {
                        metriQuadri.add(numero);
                    } else if (unità.equalsIgnoreCase("€") || unità.equalsIgnoreCase("euro") || unità.equalsIgnoreCase("eur") || unità.equalsIgnoreCase("e")) {
                        prezzi.add(numero);
                    }
                } else {
                    paroleChiave.add(numero);
                }
            }
        }
 
        Map<String, List<String>> risultati = new HashMap<>();
        risultati.put("Parole Chiave", paroleChiave);
        risultati.put("Metri Quadri", metriQuadri);
        risultati.put("Prezzi", prezzi);
       
        return risultati;
    }
}
 