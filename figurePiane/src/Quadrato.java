public class Quadrato extends Figura {
    private double lato;
    
    public Quadrato(double lato) {
        this.lato = lato;
    }

    @override
    public double area() {
        return lato * lato;
    }

    @override
    public double perimetro() {
        return 4 * lato;
    }

    @Override
    public String toString() {
        return "Quadrato di lato " + this.lato;
    }
}
