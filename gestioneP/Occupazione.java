public class Occupazione {
    int nStanza = 0;
    private int nTotale = 0;
    public Occupazione(int stanza){      
        this.nStanza = stanza;    
    }
    public void aggiungiUnoallastanza(){
        this.nTotale ++;
    }
    public void rimoviUnoallastanza(){
        if(this.nTotale > 0) this.nTotale --;
    } 
    public int getNStanza(){
        return this.nStanza;
    }
    public int getTotale(){
        return this.nTotale;
    }
    public boolean Libero(){
        return this.nTotale == 0;
    }
}