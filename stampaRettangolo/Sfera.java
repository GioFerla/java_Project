
public class Sfera {
    double raggio;
    public Sfera(double raggio){
        this.raggio = raggio;
    }
    public double calcoloVolume(){
        return (4/3) * Math.PI * Math.pow(this.raggio, 2); 
    }
    public double calcoloSuperficie(){
        return 4 * Math.PI * Math.pow(this.raggio, 2);
    }
}
