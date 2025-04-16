package giofe;

public class Contatore {
    private int Punto;

    public void incrementaPunto(){
        this.Punto ++;
    }

    public void decrementaPunto(){
        if(controlloPunto()){
            this.Punto --;
        }
    }
    private boolean controlloPunto(){
        return this.Punto > 0;
    }

    public void reset(){
        this.Punto = 0;
    }

    public int getPunto(){
        return this.Punto;
    }

    @Override
    public String toString() {
        return String.valueOf(Punto);
    }
}
