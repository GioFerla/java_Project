public class Squadra {
    private String nome;
    private String provenienza;
    private String colore;
    private int punti;
    
    
    public Squadra(String nome, String provenienza, String colore) {
        this.nome = nome;
        this.provenienza = provenienza;
        this.colore = colore;
        this.punti = 0;
    }

    public String getNome() {
        return this.nome;
    }

    public String getProvenienza() {
        return provenienza;
    }
    
    public String getColore() {
        return colore;
    }

    public void vittoria(){
        this.punti += 3;
    }

    public void pareggio(){
        this.punti++;
    }
    
    public void resetPunti(){
        this.punti = 0;
    }

    public int getPunti(){
        return this.punti;
    }
    @Override
    public String toString() {
        return "Squadra: " + this.nome;
    }

}
