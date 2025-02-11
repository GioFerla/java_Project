public class Piramide {
    double base;
    double altezza;
    public Piramide(double base, double altezza){
        this.base = base;
        this.altezza = altezza;
    }

    public double calcoloApotema(){
        return Math.sqrt(Math.pow(this.altezza,2) + Math.pow(this.base/2, 2));
    }

    public double areaBase(){
        return Math.pow(this.base, 2);
    }

    public double areaLaterale(){
        return calcoloApotema() * perimetroBase();
    }  

    public double perimetroBase(){
        return 4*this.base;
    }

    public double volumePiramide(){
        return (areaBase()* this.altezza)/3;
    }
    
    public double areaPiramide(){
        return areaBase()+areaLaterale();
    }
}
