package com.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject; 

public class ArchivioDVD {
    private ArrayList<DVD> archivio = new ArrayList<>(); // Ensure the DVD class is defined
    private static final String API_KEY = "9c2830a7"; 
    public void aggiungiDVD(DVD dvd) {
        archivio.add(dvd);
    }

    public DVD cercaPerTitolo(String titolo) {
        // Controlla se il DVD è già presente nell'archivio
        for (DVD dvd : archivio) {
            if (dvd.getTitolo().equalsIgnoreCase(titolo)) {
                return dvd;
            }
        }

        // Se non trovato, cerca nell'OMDb API
        DVD dvdDaRestituire = cercaInOmdb(titolo);
        return dvdDaRestituire;
    }

    private DVD cercaInOmdb(String titolo) {
        String urlString = "http://www.omdbapi.com/?t=" + titolo + "&apikey=" + API_KEY;
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(urlString); // Replace with a non-deprecated constructor if needed
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Controlla il codice di risposta
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Analizza la risposta JSON
                JSONObject jsonObject = new JSONObject(response.toString());
                if (jsonObject.getString("Response").equals("True")) {
                    // Crea un nuovo oggetto DVD con le informazioni ottenute
                    String titoloFilm = jsonObject.getString("Title");
                    String anno = jsonObject.getString("Year");
                    String genere = jsonObject.getString("Genre");
                    String trama = jsonObject.getString("Plot");

                    // Crea un nuovo DVD (assicurati che la classe DVD abbia un costruttore appropriato)
                    DVD dvd = new Film(titoloFilm, Integer.parseInt(anno), genere, trama);
                    return dvd;
                } else {
                    System.out.println("Film non trovato: " + jsonObject.getString("Error"));
                }
            } else {
                System.out.println("Richiesta GET fallita: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; 
    }

    public ArrayList<DVD> getTutti() {
        return archivio;
    }
}
 