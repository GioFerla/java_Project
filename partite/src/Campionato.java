import java.util.ArrayList;
import java.util.Comparator;

public class Campionato {

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
        this.campionato.removeIf(palle -> palle.getNome().equals(userSquadra));
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

    
}
