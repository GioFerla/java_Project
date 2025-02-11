
public class Partita {
    private Squadra squadraLocale;
    private Squadra squadraOspite;
    private int puntiSquadraLocale;
    private int puntiSquadraOspite;
    private boolean finita=false;

    public Partita(Squadra squadraLocale, Squadra squadraOspite) {
        this.squadraLocale = squadraLocale;
        this.squadraOspite = squadraOspite;
    }

    public Squadra getSquadraLocale() {
        return squadraLocale;
    }

    public void setSquadraLocale(Squadra squadraLocale) {
        this.squadraLocale = squadraLocale;
    }

    public Squadra getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(Squadra squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public boolean isFinita() {
        return finita;
    }

    public void setFinita() {
        this.finita = true;
    }

    public int getPuntiSquadraLocale() {
        return puntiSquadraLocale;
    }

    public int getPuntiSquadraOspite() {
        return puntiSquadraOspite;
    }
    
    public void aggiungiPuntiLocali1 () {
        this.puntiSquadraLocale+=1;
    }
    
    public void aggiungiPuntiLocali2 () {
        this.puntiSquadraLocale+=2;
    }
    
    public void aggiungiPuntiLocali3 () {
        this.puntiSquadraLocale+=3;
    }
    
    public void aggiungiPuntiLocaliRandom () {
        this.puntiSquadraLocale+=Math.random()*4;
    }
    
    public void aggiungiPuntiOspiti1 () {
        this.puntiSquadraOspite+=1;
    }
    
    public void aggiungiPuntiOspiti2 () {
        this.puntiSquadraOspite+=2;
    }
    
    public void aggiungiPuntiOspiti3 () {
        this.puntiSquadraOspite+=3;
    }
    
    public void aggiungiPuntiOspitiRandom () {
        this.puntiSquadraOspite+=Math.random()*4;
    }
    
    public void rimuoviPuntiLocali1 () {
        this.puntiSquadraLocale-=1;
    }
    
    public void rimuoviPuntiLocali2 () {
        this.puntiSquadraLocale-=2;

    }
    
    public void rimuoviPuntiLocali3 () {
        this.puntiSquadraLocale-=3;
    }
    
    public void rimuoviPuntiOspiti1 () {
        this.puntiSquadraOspite-=1;

    }
    
    public void rimuoviPuntiOspiti2 () {
        this.puntiSquadraOspite-=2;
    }
    
    public void rimuoviPuntiOspiti3 () {
        this.puntiSquadraOspite-=3;
    }
    
    public void setPuntiSquadraLocale(int puntiSquadraLocale) {
        this.puntiSquadraLocale = puntiSquadraLocale;
    }

    public void setPuntiSquadraOspite(int puntiSquadraOspite) {
        this.puntiSquadraOspite = puntiSquadraOspite;
    }
    
    public void azzeraPunteggio () {
        this.puntiSquadraLocale=0;
        this.puntiSquadraOspite=0;
    }
    
    public String vincitore() {
    if (this.puntiSquadraLocale==this.puntiSquadraOspite)
        return null;
    if (this.puntiSquadraLocale>this.puntiSquadraOspite)
        return this.squadraLocale.getNomeSquadra();
    else return this.squadraOspite.getNomeSquadra();
    }
        
    
    
}
