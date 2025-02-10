

public class Dado{
    int min;
    int max;
    public Dado(int dadi){          
        this.min = dadi;
        this.max = dadi * 6;
    }

    public int LancioDado(){
        return (int)(Math.random() * (this.max - this.min + 1)) + this.min;
    }
}