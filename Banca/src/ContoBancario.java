

public class ContoBancario {
    private String nome;
    private String cognome;
    private int numeroConto;
    private static int incrementale;
    public static final String Stato="IT";
    public static final String Cineuropeo="00";
    public static final String Cin = "I";
    public static final String Abi = "12345";
    private String Cab;

    public ContoBancario(String Cab, String cognome, String nome, int numeroConto) {
        this.Cab = Cab;
        this.cognome = cognome;
        this.nome = nome;
        this.numeroConto = ++incrementale;
    }
    public static int getIncrementale(){
        return incrementale;
    }

    public String setIBAN(){
/*<        String numConto = Integer.toString(this.numeroConto);
        int numCifre = numConto.length();

        for (int i=0; i<12-numCifre; i++) {
            numConto = "0" + numConto;
        } 
 */
        return Stato + Cineuropeo + Cin + Abi + this.Cab + String.format("%012d", numeroConto);
    }

    @Override
    public String toString() {
        return setIBAN();
    }
    

}
