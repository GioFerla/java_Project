import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Agenzia a = new Agenzia("Agenzia", "123");

        Villa v1 = new Villa("123", "via roma", "00100", "roma", "rm", 100, 130000, 3, 2, "1", 100, true, "2", "lusso moderno");
        Villa v2 = new Villa("124", "via milano", "20100", "milano", "mi", 90, 100000, 2, 1, "2", 80, true, "3", "moderno");
        Villa v3 = new Villa("125", "via napoli", "80100", "napoli", "na", 110, 150000, 4, 3, "3", 120, true, "4", "rustico");

        List<Villa> tutteLeVille = new ArrayList<>();
        tutteLeVille.add(v1);
        tutteLeVille.add(v2);
        tutteLeVille.add(v3);

        String inputUtente = "casa a meno di 170000 euro casa con più di 10 mq";
        Map<String, List<String>> risultati = estraiParoleChiave(inputUtente);

        List<Villa> villeCompatibili = new ArrayList<>();

        for (Villa villa : tutteLeVille) {
            boolean soddisfaCondizioni = true;

            for (Map.Entry<String, List<String>> entry : risultati.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                switch (key) {
                    case "Metri Quadri" -> {
                        for (String condizione : values) {
                            int soglia = Integer.parseInt(condizione.substring(1));
                            if (condizione.startsWith(">") && villa.getSuperficie() <= soglia) {
                                soddisfaCondizioni = false;
                            } else if (condizione.startsWith("<") && villa.getSuperficie() >= soglia) {
                                soddisfaCondizioni = false;
                            }
                        }
                    }
                    case "Prezzi" -> {
                        for (String condizione : values) {
                            int soglia = Integer.parseInt(condizione.substring(1));
                            if (condizione.startsWith(">") && villa.getPrezzo() <= soglia) {
                                soddisfaCondizioni = false;
                            } else if (condizione.startsWith("<") && villa.getPrezzo() >= soglia) {
                                soddisfaCondizioni = false;
                            }
                        }
                    }
                    case "Parole Chiave" -> {
                        for (String parola : values) {
                            if (!villa.search(parola)) {
                                soddisfaCondizioni = false;
                            }
                        }
                    }
                }

                if (!soddisfaCondizioni) break;
            }

            if (soddisfaCondizioni) {
                villeCompatibili.add(villa);
            }
        }

        System.out.println("Ville compatibili con la ricerca:");
        for (Villa villaCompatibile : villeCompatibili) {
            System.out.println(villaCompatibile);
        }
    }

    public static Map<String, List<String>> estraiParoleChiave(String testo) {
        List<String> paroleChiave = new ArrayList<>();
        List<String> metriQuadri = new ArrayList<>();
        List<String> prezzi = new ArrayList<>();

        Pattern patternEspressioni = Pattern.compile("(?i)(più di|meno di)\\s*(\\d+)\\s*(mq|metri quadri|euro|€)?");
        Matcher matcherEspressioni = patternEspressioni.matcher(testo);

        while (matcherEspressioni.find()) {
            String confronto = matcherEspressioni.group(1).toLowerCase();
            String valore = matcherEspressioni.group(2);
            String unità = matcherEspressioni.group(3);

            String simbolo = confronto.equals("più di") ? ">" : "<";
            if (unità != null) {
                if (unità.toLowerCase().contains("mq") || unità.toLowerCase().contains("metri")) {
                    metriQuadri.add(simbolo + valore);
                } else if (unità.toLowerCase().contains("euro") || unità.contains("€")) {
                    prezzi.add(simbolo + valore);
                }
            }
        }

        Pattern patternParole = Pattern.compile("\\b(lusso|lussuosa|moderno|moderna|rustico|rustica)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcherParole = patternParole.matcher(testo);
        while (matcherParole.find()) {
            String parola = matcherParole.group(1).toLowerCase();
            if (parola.equals("lussuosa")) {
            parola = "lusso";
            } else if (parola.equals("moderna")) {
            parola = "moderno";
            } else if (parola.equals("rustica")) {
            parola = "rustico";
            }
            paroleChiave.add(parola);
        }
        Map<String, List<String>> risultati = new HashMap<>();
        risultati.put("Parole Chiave", paroleChiave);
        risultati.put("Metri Quadri", metriQuadri);
        risultati.put("Prezzi", prezzi);

        return risultati;
    }
}
