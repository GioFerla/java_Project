package giofe;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class Campionato {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private String filePath = "./data/data.json";
    private  ArrayList<Squadra> campionato = new ArrayList<>();
    

    public Campionato(){
        this.campionato = new ArrayList<>();
    }
    public void aggiungiSquadra(Squadra squadra){
        this.campionato.add(squadra);
        if(this.campionato.size()>1){
            ordinaCompionato();
        }
    }

    public void rimuoviSquadra(String userSquadra){
        this.campionato.removeIf(squadra -> squadra.getNome().equals(userSquadra));
    }

    public void ordinaCompionato(){
        this.campionato.sort(Comparator.comparingInt(Squadra::getPunti).reversed());
    }

    public Squadra getSquadra(String userSquadra){
        for (Squadra squadra : this.campionato) {
            if(squadra.getNome().equals(userSquadra)){
                return squadra;
            }
        }
        return null;
    }
    
    public ArrayList<Squadra> getCampionato() {
        return campionato;
    }
//              SALVATAGGIO E LETTURA CON JSON
    public void salvaCampionatoSuFile() {
        try (FileWriter salvataggio = new FileWriter(this.filePath)) {
            gson.toJson(this.campionato, salvataggio);
            System.out.println("Campionato salvato" + this.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void caricaCampionatoDaFile() {
    try (FileReader leggi = new FileReader(this.filePath)) {
        Type listType = new TypeToken<ArrayList<Squadra>>() {}.getType();
        ArrayList<Squadra> caricato = gson.fromJson(leggi, listType);
        if (caricato != null) {
            this.campionato = caricato;
        } else {
            this.campionato = new ArrayList<>();
        }
        System.out.println("Campionato caricato con successo da " + this.filePath);
    } catch (IOException e) {
        e.printStackTrace();

        this.campionato = new ArrayList<>();
    }
}

//              SALVATAGGIO CON CSV
/*     public void salvaDati() {
        String nomeFile = "dati.csv";
        try (FileWriter writer = new FileWriter(nomeFile)) {
            for (Squadra squadra : this.campionato) {
                 writer.write(squadra.getNome() + "," + squadra.getProvenienza() + "," + squadra.getPunti() + "\n");
            }
            System.out.println("Dati salvati correttamente nel file " + nomeFile);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei dati su file.");
            e.printStackTrace();
        }
    } */
    
}
