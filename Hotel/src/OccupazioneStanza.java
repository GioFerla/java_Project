public class OccupazioneStanza {
    private int[] numeroNellaStanza = {0, 0, 0, 0, 0, 0, 0, 0};
    /* private int[] stanzeOccupate = new int[8]; */
    private int numeroTotale;
    
    public void aggiungiUnoAllaStanza(int stanza, int persone){
        aggiornanumeroTotale(persone);
        this.numeroNellaStanza[stanza-1] = this.numeroNellaStanza[stanza-1] + persone;
    }

    public int rimuoviUnoDallaStanza(int stanza, int persone){
        if(this.numeroNellaStanza[stanza-1] - persone < 0){
            return 1;
        }else{
            this.numeroNellaStanza[stanza-1] = this.numeroNellaStanza[stanza-1] - persone;
            return 0;
        }
    }

    /* private boolean verificaDisponibilita(int stanza, int persone){
        return this.numeroNellaStanza[stanza-1] - persone >= 0;
    } */
    private void aggiornanumeroTotale(int persone){
        this.numeroTotale = this.numeroTotale + persone;
    }

    public int getNumero(int stanza){
        return this.numeroNellaStanza[stanza-1];
    }

    public int getTotale(){
        return this.numeroTotale;
    }
}
