import java.util.ArrayList;

public class Azienda {
    private String nomeAzienda;
    private ArrayList<Lavoratore> lavoratori;

    public Azienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
        this.lavoratori = new ArrayList<>();
    }

    public void aggiungiLavoratore(Lavoratore lavoratore) {
        lavoratori.add(lavoratore);
    }

    public void rimuoviLavoratore(Lavoratore lavoratore) {
        lavoratori.remove(lavoratore);
    }

    public int numeroLavoratori() {
        return lavoratori.size();
    }

    public double stipendioMedio() {
        double sommaStipendi = 0;
        for (Lavoratore lavoratore : lavoratori) {
            sommaStipendi += lavoratore.getStipendio();
        }
        return sommaStipendi / lavoratori.size();
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public ArrayList<Lavoratore> getLavoratori() {
        return lavoratori;
    }

    @Override
    public String toString() {
        return "Nome Azienda: " + nomeAzienda + ", Lavoratori: " + lavoratori;
    }
}
