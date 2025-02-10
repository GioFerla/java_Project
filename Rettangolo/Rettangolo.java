

public class Rettangolo{
    double base;
    double altezza;

    public Rettangolo(double base, double altezza){
        this.base = base;
        this.altezza = altezza; 
    }
    public String Stampa() {
        String rettangolo = "";
        for (int i = 0; i < this.altezza; i++) {
            for (int j = 0; j < this.base; j++) {
                if (i == 0 || i == this.altezza - 1 || j == 0 || j == this.base - 1) {
                    rettangolo += " *";
                } else {
                    rettangolo += "  ";
                }
            }
            rettangolo += "\n";
        }
        return rettangolo;
    }

}