public class Personaggio {
    private String[] coloreOcchi = {"marroni", "verdi", "blu", "nocciola"};
    private String[] coloreCapelli = {"biondi", "castano scuro", "rossi", "nero", "castano chiaro"};
    private String[] tipoCapelli = {"lisci", "mossi", "ricci"};
    private String[] lunghezzaCapelli = {"lunghi", "corti"};
    private String[] colorePelle = {"pallido", "beige", "oliva", "marrone", "nero"};
    private int[] altezzaMaschio = {147, 210};
    private int[] altezzaFemmina = {140, 200};
    private int[] eta = {/*bamino*/ 0, 14, /*ragazzo*/ 15, 21, /*adulto*/ 22, 60, /*anziano*/ 61, 120};
    public String[] capelli = new String[3];
    public String occhi;
    public String colore;
    public String sesso;
    public int altezza;
    public int anni;

    public Personaggio(String sesso, String eta){
        this.capelli[0] = sceltaCasuale(this.coloreCapelli);
        this.capelli[1] = sceltaCasuale(this.tipoCapelli);
        this.capelli[2] = sceltaCasuale(this.lunghezzaCapelli);
        this.occhi = sceltaCasuale(this.coloreOcchi);
        this.colore = sceltaCasuale(this.colorePelle);
        this.sesso = sesso;

        this.anni = sceltaEta(eta);
        this.altezza = sceltaAltezza(sesso);

    }
    private String sceltaCasuale(String[] caratteristica){
        int pos = (int) (Math.random() * caratteristica.length);
        return caratteristica[pos];
    }
    
    private int sceltaEta(String eta){
        if(eta.equalsIgnoreCase("bambino")){
            return (int)(Math.random() * (this.eta[1] - this.eta[0] + 1)) + this.eta[0];
        }else if(eta.equalsIgnoreCase("ragazzo")){
            return (int)(Math.random() * (this.eta[3] - this.eta[2] + 1)) + this.eta[2];
        }else if(eta.equalsIgnoreCase("adulto")){
            return (int)(Math.random() * (this.eta[5] - this.eta[4] + 1)) + this.eta[4];
        }else if(eta.equalsIgnoreCase("anziano")){
            return (int)(Math.random() * (this.eta[7] - this.eta[6] + 1)) + this.eta[6];
        }
        return 0;
    }
    private int sceltaAltezza(String sesso){
        if(sesso.equalsIgnoreCase("maschio")){
            return (int) (Math.random() * (this.altezzaMaschio[1] - this.altezzaMaschio[0]) + this.altezzaMaschio[0]);
        }else if(sesso.equalsIgnoreCase("femmina")){
            return (int) (Math.random() * (this.altezzaFemmina[1] - this.altezzaFemmina[0]) + this.altezzaFemmina[0]);
        }
        return 15;
    }
    }
