import java.util.ArrayList;

public class Persona {

    private String nome;
    private String cognome;
    private String indirizzo;
    private String citta;
    private ArrayList<Contatto> contatti;

    public Persona(String nome, String cognome, String indirizzo, String citta) {
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.contatti = new ArrayList<Contatto>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void addContatto(Contatto cont) {
        this.contatti.add(cont);
    }

    public void removeContatto(Contatto cont) {

    }

    public int indexOfContattoByDato(String dato) {
        for (int i = 0; i < this.contatti.size(); i++) {
            if (this.contatti.get(i).getDato().equals(dato)) {
                return i;
            }

        }

        return -1;
    }

    public Contatto getContattoByDato(String dato) {
        for (Contatto c : this.contatti) {
            if (c.getDato().equals(dato)) {
                return c;
            }
        }
        return null;
    }

    public void deleteContattoByIndex(int index) {
        if (this.contatti.size() <= index) {
            return;
        }
            this.contatti.remove(index);
    }
    
    public void deleteContatto(Contatto c){
        this.contatti.remove(c);
    }
    
    public String toString(){
        String properties = "Nome: " + nome + " " + cognome + " " + "\n Indirizzo: " + indirizzo + "\n Citta: " + citta + "\n";
        for(Contatto c : this.contatti){
            properties += c.toString();
        }
        return properties;
    }
}