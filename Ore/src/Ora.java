public class Ora {
    private int ore;
    private int minuti;
    private boolean dayRange = true; /* preimposto a mezzanotte */
    private boolean controlloUsoMetodoAM = false;

    public Ora(){
        this.ore = 0;
        this.minuti = 0;
    }
    private boolean validaOre(int ore, int minuti){
        return ore <= 23 && minuti <= 59;
    }
    public void setOra(int ore, int minuti){
        if(validaOre(ore, minuti)){
            this.ore = ore;
            this.minuti = minuti;
        }
    }

    public int[] getTempo() {
        int[] tempo; 
        if(controlloUsoMetodoAM){
            if (dayRange) {
            tempo = new int[]{this.ore, this.minuti, 1};
            } else {
                tempo = new int[]{this.ore, this.minuti, 0};
            }
            return tempo;
        }else{
            return tempo = new int[]{this.ore, this.minuti, 707};
        }
        
    }


    /* Non ho capito come si dovrebbe fare :( ho fatto quello che pensavo si dovesse fare anche se è un po incasinato */
    public void setOra(int ore, int minuti, boolean AM){
        if(validaOre(ore, minuti)){
            if(ore >= 1 && ore <= 12 && AM ){
                this.ore = ore;
                this.minuti = minuti;
                dayRange = true;   
            }else {
                this.ore = ore - 12;
                this.minuti = minuti;
                dayRange = false;
            }
            controlloUsoMetodoAM = true;
        }
        
    } 
}
