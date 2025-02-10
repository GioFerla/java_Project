public class NumeriRazionali {
    private int numeratore;
    private int denominatore;

    public NumeriRazionali(){
        this.numeratore = 0;
        this.denominatore = 1;
    }

    public NumeriRazionali(int numeratore, int denominatore){
        if(denominatore == 0){
            return;
        }else{
            this.numeratore = numeratore;
            this.denominatore = denominatore;
            semplificazione();
        }
    }
    private void semplificazione(){
        int gcd = getGCD(numeratore,denominatore);
        numeratore /= gcd;
        denominatore /= gcd;

        if (denominatore < 0) {
            numeratore = -numeratore;
            denominatore = -denominatore;
        }
    }

    private static int getGCD(int numeratore, int denominatore) {
        while (denominatore != 0) {
            int temp = denominatore;
            denominatore = numeratore % denominatore;
            numeratore = temp;
        }
        return numeratore;
    }

    @Override
    public String toString() {
        return numeratore + "/" + denominatore;
    }

}
