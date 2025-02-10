public class Tabellone {
    private Squadra squadraCasa;
    private Squadra squadraOspite;
    private Contatore contatoreCasa;
    private Contatore contatoreOspiti;
    
    public Tabellone(Squadra squadraCasa, Squadra squadraOspite) {
      
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.contatoreCasa = new Contatore();
        this.contatoreOspiti = new Contatore();
    
    }
    public void incrementaCasa(){
        this.contatoreCasa.incrementaGoal();
    }

    public void decrementaCasa(){
        this.contatoreCasa.decrementaGoal();
    }
 
    public void incrementaOspiti(){
        this.contatoreOspiti.incrementaGoal();
    }

    public void decrementaOspiti(){
        this.contatoreOspiti.decrementaGoal();
    }

    public void resetGame(){
        contatoreCasa.reset();
        contatoreOspiti.reset();
    }

    public void assegnaPunti(){
        if(this.contatoreCasa.getGoal()> this.contatoreOspiti.getGoal()){
            this.squadraCasa.vittoria();

        } else if(this.contatoreCasa.getGoal() < this.contatoreOspiti.getGoal()){
                this.squadraOspite.vittoria();

                } else if(this.contatoreCasa.getGoal() == this.contatoreOspiti.getGoal()){
                        this.squadraCasa.pareggio();
                        this.squadraOspite.pareggio();
                        }
    }
    
    

    public Squadra getSquadraCasa() {
        return squadraCasa;
    }
    public Squadra getSquadraOspite() {
        return squadraOspite;
    }
    @Override
    public String toString() {
        return " | Casa=" + squadraCasa.getNome() + " (" + contatoreCasa + " goal)\n" +
                "| Ospite=" + squadraOspite.getNome() + " (" + contatoreOspiti + " goal)";
    }

}