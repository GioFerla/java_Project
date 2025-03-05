import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        String path = "lavoratori.txt";
        Azienda azienda = new Azienda("ITSOS SRL");

        // Creazione degli oggetti di tipo dipendente, consulente e stagista
        // Dipendenti
        Dipendente dipendente1 = new Dipendente("mano", "BDUHG246764ASD7A5", "A001");
        dipendente1.setStipendio(3000);
        Dipendente dipendente2 = new Dipendente("pano", "BDUHG246764ASD7A5", "A002");
        dipendente2.setStipendio(3500);
        // Consulenti
        Consulente consulente1 = new Consulente("cano", "BDUHG246764ASD7A5");
        consulente1.aggiornaStipendio(4000);
        Consulente consulente2 = new Consulente("lano", "BDUHG246764ASD7A5");
        consulente2.aggiornaStipendio(4500);
        // Stagisti
        Stagista stagista1 = new Stagista("sano", "BDUHG246764ASD7A5", "IL MAGNIFICO SCHOOL");
        stagista1.aggiornaStipendio(1000);
        stagista1.setOreFormazione(300); 
        Stagista stagista2 = new Stagista("lana", "BDUHG246764ASD7A5", "LA BRO SCHOOL");
        stagista2.aggiornaStipendio(1200);
        stagista2.setOreFormazione(600); 
        // Aggiunta dei dipendenti nella lista dei dipendenti dell'azienda
        azienda.aggiungiLavoratore(dipendente1);
        azienda.aggiungiLavoratore(dipendente2);
        azienda.aggiungiLavoratore(consulente1);
        azienda.aggiungiLavoratore(consulente2);
        azienda.aggiungiLavoratore(stagista1);
        azienda.aggiungiLavoratore(stagista2);
        
        // Salvataggio dei lavoratori nel file lavoratori.txt
        try (FileWriter writer = new FileWriter(path)) {
            // Salvataggio dei dipendenti
            writer.write("dipendenti:\n");
            for (Lavoratore lavoratore : azienda.getLavoratori()) {
                if (lavoratore instanceof Dipendente) {
                    writer.write(lavoratore.toString() + " - Bonus: " + String.format("%d", lavoratore.calcolaBonus()) + "\n");
                }
            }
            // Salvataggio dei consulenti
            writer.write("\nconsulenti:\n");
            for (Lavoratore lavoratore : azienda.getLavoratori()) {
                if (lavoratore instanceof Consulente) {
                    writer.write(lavoratore.toString() + " - Bonus: " + String.format("%d", lavoratore.calcolaBonus()) + "\n");
                }
            }
            // Salvataggio degli stagisti
            writer.write("\nstagisti:\n");
            for (Lavoratore lavoratore : azienda.getLavoratori()) {
                if (lavoratore instanceof Stagista) {
                    writer.write(lavoratore.toString() + " - Bonus: " + String.format("%d", lavoratore.calcolaBonus()) + "\n");
                }
            }
            // Salvataggio stipendio medio
            double stipendioMedio = azienda.stipendioMedio();
            writer.write("\nstipendio medio: " + String.format("%.2f", stipendioMedio) + "\n");

            // Ricerca del lavoratore meno pagato
            Lavoratore lavoratoreMenoPagato = null; // Inizializzato a null perchè altrimenti da errore
            for (Lavoratore lavoratore : azienda.getLavoratori()) {
                if (lavoratoreMenoPagato == null || lavoratore.getStipendio() < lavoratoreMenoPagato.getStipendio()) {
                    lavoratoreMenoPagato = lavoratore;
                }
            }
            // Salvataggio del lavoratore meno pagato
            writer.write("lavoratore meno pagato: " + lavoratoreMenoPagato + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
