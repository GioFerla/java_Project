package giofe;

public class TabelloneCalcio extends Tabellone {
    public TabelloneCalcio(Squadra squadraCasa, Squadra squadraOspite) {
        super(squadraCasa, squadraOspite);
    }

    public void incrementaCasa(int valore) {
        for(int i = 0; i < valore; i++){
            super.getContatoreCasa().incrementaPunto();
        }
    }

    public void incrementaOspiti(int valore) {
        for(int i = 0; i < valore; i++){
            super.getContatoreOspiti().incrementaPunto();
        }
    }

    public void decrementaCasa(int valore) {
        for(int i = 0; i < valore; i++){
            super.getContatoreCasa().decrementaPunto();
        }
    }

    public void decrementaOspiti(int valore) {
        for(int i = 0; i < valore; i++){
            super.getContatoreOspiti().decrementaPunto();
        }
    }
    public int getPuntiCasa() {
        return super.getContatoreCasa().getPunto();
    }
    
    public int getPuntiOspite() {
        return super.getContatoreOspiti().getPunto();
    }
    

    @Override
    public void resetGame() {
        super.getContatoreCasa().reset();
        super.getContatoreOspiti().reset();
    }

    /*private Squadra squadraCasa;
    private Squadra squadraOspite;
    private Contatore contatoreCasa;
    private Contatore contatoreOspiti;
    
    public TabelloneCalcio(Squadra squadraCasa, Squadra squadraOspite) {
      
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.contatoreCasa = new Contatore();
        this.contatoreOspiti = new Contatore();
    
    }
    public void incrementaCasa(){
        this.contatoreCasa.incrementaPunto();
    }

    public void decrementaCasa(){
        this.contatoreCasa.decrementaPunto();
    }
 
    public void incrementaOspiti(){
        this.contatoreOspiti.incrementaPunto();
    }

    public void decrementaOspiti(){
        this.contatoreOspiti.decrementaPunto();
    }

    public void resetGame(){
        contatoreCasa.reset();
        contatoreOspiti.reset();
    }

    public void assegnaPunti(){
        if(this.contatoreCasa.getPunto()> this.contatoreOspiti.getPunto()){
            this.squadraCasa.vittoria();

        } else if(this.contatoreCasa.getPunto() < this.contatoreOspiti.getPunto()){
                this.squadraOspite.vittoria();

                } else if(this.contatoreCasa.getPunto() == this.contatoreOspiti.getPunto()){
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
        return " | Casa=" + squadraCasa.getNome() + " (" + contatoreCasa + " Punto)\n" +
                "| Ospite=" + squadraOspite.getNome() + " (" + contatoreOspiti + " Punto)";
    } */

}