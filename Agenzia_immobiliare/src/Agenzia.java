import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Agenzia {
    private final String nome;
    private final String codice;
    private ArrayList<Immobile> immobiliVendita;
    private ArrayList<Immobile> immobiliAffitto;

    public Agenzia(String nome, String codice) {
        this.nome = nome;
        this.codice = codice;
        this.immobiliVendita = new ArrayList<>();
        this.immobiliAffitto = new ArrayList<>();
    }

    public ArrayList<Immobile> getImmobiliVendita() {
        return immobiliVendita;
    }

    public void setImmobiliVendita(ArrayList<Immobile> immobiliVendita) {
        this.immobiliVendita = immobiliVendita;
    }

    public ArrayList<Immobile> getImmobiliAffitto() {
        return immobiliAffitto;
    }

    public void setImmobiliAffitto(ArrayList<Immobile> immobiliAffitto) {
        this.immobiliAffitto = immobiliAffitto;
    }

    public List<Appartamento> filtraAppartamenti(Map<String, List<String>> criteri) {
        List<Appartamento> appartamentiCompatibili = new ArrayList<>();

        for (Immobile immobile : immobiliVendita) {
            if (immobile instanceof Appartamento appartamento) {
                boolean soddisfaCondizioni = true;

                for (Map.Entry<String, List<String>> entry : criteri.entrySet()) {
                    String key = entry.getKey();
                    List<String> values = entry.getValue();

                    switch (key) {
                        case "Metri Quadri" -> {
                            for (String condizione : values) {
                                int soglia = Integer.parseInt(condizione.substring(1));
                                if (condizione.startsWith(">") && appartamento.getSuperficie() <= soglia) {
                                    soddisfaCondizioni = false;
                                } else if (condizione.startsWith("<") && appartamento.getSuperficie() >= soglia) {
                                    soddisfaCondizioni = false;
                                }
                            }
                        }
                        case "Prezzi" -> {
                            for (String condizione : values) {
                                int soglia = Integer.parseInt(condizione.substring(1));
                                if (condizione.startsWith(">") && appartamento.getPrezzo() <= soglia) {
                                    soddisfaCondizioni = false;
                                } else if (condizione.startsWith("<") && appartamento.getPrezzo() >= soglia) {
                                    soddisfaCondizioni = false;
                                }
                            }
                        }
                        case "Parole Chiave" -> {
                            for (String parola : values) {
                                if (!appartamento.search(parola)) {
                                    soddisfaCondizioni = false;
                                }
                            }
                        }
                    }

                    if (!soddisfaCondizioni) break;
                }

                if (soddisfaCondizioni) {
                    appartamentiCompatibili.add(appartamento);
                }
            }
        }

        return appartamentiCompatibili;
    }
}
