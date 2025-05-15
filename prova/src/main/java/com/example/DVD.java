package com.example;

public abstract class DVD {
    protected String titolo;
    protected int anno;
    protected String genere;
    protected String trama;
 
    public DVD(String titolo, int anno, String genere, String trama) {
        this.titolo = titolo;
        this.anno = anno;
        this.genere = genere;
        this.trama = trama;
    }
 
    public String getTitolo() { return titolo; }
    public abstract String getDettagli();

    @Override
    public String toString() {
        return "DVD [titolo=" + titolo + ", anno=" + anno + ", genere=" + genere + ", trama=" + trama + "]";
    }
}