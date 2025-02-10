public class ProgettoScienzaPunteggio {
    private String nomeProgetto;
    private String idProgetto;
    private String nomePersona;
    private int punteggioCreativita; 
    private int punteggioValoreScientifico; 
    private int punteggioCompletezza; 
    private int punteggioAbilitaTecnica; 
    private int punteggioChiarezza; 

    public static int numeroGiudici;
    private static int massimoPunteggio = 100;

    public ProgettoScienzaPunteggio(String nomeProgetto, String idProgetto, String nomePersona, int punteggioCreativita, int punteggioValoreScientifico, int punteggioCompletezza, int punteggioAbilitaTecnica, int punteggioChiarezza) {
        this.nomeProgetto = nomeProgetto;
        this.idProgetto = idProgetto;
        this.nomePersona = nomePersona;
        this.punteggioCreativita = punteggioCreativita;
        this.punteggioValoreScientifico = punteggioValoreScientifico;
        this.punteggioCompletezza = punteggioCompletezza;
        this.punteggioAbilitaTecnica = punteggioAbilitaTecnica;
        this.punteggioChiarezza = punteggioChiarezza;
    }

    public static void setNumeroGiudici(int numero) {
        numeroGiudici = numero;
    }

    public int calcolaTotalePunteggio() {
        return punteggioCreativita + punteggioValoreScientifico + punteggioCompletezza + punteggioAbilitaTecnica + punteggioChiarezza;
    }

    public static int getMassimoPunteggio() {
        return massimoPunteggio;
    }

    public String visualizzaPunteggio() {
        return "Progetto: " + nomeProgetto + "\nID: " + idProgetto + "\nTotale punteggio: " + calcolaTotalePunteggio();
    }
}
