package com.example;

public class Main {
    public static void main(String[] args) {
        ArchivioDVD archivioDVD = new ArchivioDVD();

/*         archivioDVD.aggiungiDVD(new Film("Inception", 2010, "Sci-Fi", "A thief who steals corporate secrets through the use of dream-sharing technology."));
 */
        DVD dvdTrovato = archivioDVD.cercaPerTitolo("creed II");
        if (dvdTrovato != null) {
            System.out.println("DVD trovato: " + dvdTrovato);
        } else {
            System.out.println("DVD non trovato.");
        }

        System.out.println("Tutti i DVD nell'archivio:");
        for (DVD dvd : archivioDVD.getTutti()) {
            System.out.println(dvd);
        }
    }
}