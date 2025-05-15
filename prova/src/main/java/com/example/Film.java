package com.example;

public class Film extends DVD {
    private String regista;
 
    public Film(String titolo, int anno, String genere, String trama/* , String regista */) {
        super(titolo, anno, genere, trama);
        this.regista = regista;
    }
 
    @Override
    public String getDettagli() {
        return "Film - Titolo: " + titolo + ", Anno: " + anno + ", Genere: " + genere + ", Regista: " + regista;
    }
}