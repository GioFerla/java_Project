package giofe;

public abstract class Tabellone {
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

    public void incrementaCasa() {
    }

    public void decrementaCasa() {
    }

    public void incrementaOspiti() {
    }

    public void decrementaOspiti() {
    }

    public void resetGame() {
    }

    public void setcontatoreCasa(Contatore contatoreCasa) {
        this.contatoreCasa = contatoreCasa;
    }

    public void setcontatoreOspiti(Contatore contatoreOspiti) {
        this.contatoreOspiti = contatoreOspiti;
    }

    public Squadra getSquadraCasa() {
        return this.squadraCasa;
    }

    public Squadra getSquadraOspite() {
        return this.squadraOspite;
    }

    public Contatore getContatoreCasa() {
        return this.contatoreCasa;
    }

    public Contatore getContatoreOspiti() {
        return this.contatoreOspiti;
    }

    public void assegnaPunti() {
        if (this.contatoreCasa.getPunto() > this.contatoreOspiti.getPunto()) {
            this.squadraCasa.vittoria();
        } else if (this.contatoreCasa.getPunto() < this.contatoreOspiti.getPunto()) {
            this.squadraOspite.vittoria();
        } else if (this.contatoreCasa.getPunto() == this.contatoreOspiti.getPunto()) {
            this.squadraCasa.pareggio();
            this.squadraOspite.pareggio();
        }
    }
    
}
