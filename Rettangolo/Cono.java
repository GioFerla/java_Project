

public class Cono{
    double altezza;
    double raggio;
  //double apotema;

    public Cono(double raggio, double altezza){
        this.altezza = altezza;
        this.raggio = raggio;
    }

    public double calcoloApotema(){
        return Math.sqrt(Math.pow(this.altezza,2)+Math.pow(this.raggio,2));
    }

    public double calcoloVolume(){
        return (Math.PI*Math.pow(this.raggio, 2)*this.altezza)/3;
    }
    public double superficieLaterale(){
        return Math.PI * this.raggio * calcoloApotema();
    }
    public double superficieBase(){
        return Math.PI * Math.pow(this.raggio, 2);
    }
    public double superficieTotale(){
        return  superficieBase() + superficieLaterale();
    }
}