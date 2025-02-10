
public class InfoAutomobile {
    String modello;
    String colore;
    String marca;
    boolean motore;
    int velocita;

    public InfoAutomobile(String modello, String colore, String marca) {
        this.modello = modello;
        this.colore = colore;
        this.marca = marca;
        this.motore = false;  
        this.velocita = 0;
    }

    // Metodo per accelerare l'auto
    public int accelleraAuto() {
        if (this.velocita <= 130) {
            return this.velocita+=10;  
        } else {
            System.out.println("hai raggiunto la velocità massima!");
            return 707;
        }
        
    }

    //Metodo per decellerare l'auto
    public int decelleraAuto(){
        if(this.velocita >= 0){
            return this.velocita-=10;
        }else{
            System.out.println("non puoi più decellerare perchè l'auto è ferma");
            return this.velocita;
        }
    }

    // Metodo per controllare lo stato del motore
    public boolean controlloMotore() {
        return this.motore;
    }

    // Metodo per spegnere il motore 
    public boolean spegnimentoMotore() {
        if (this.velocita == 0) {
            this.motore = false;
            return true;
        } else {
            System.out.println("non puoi spegnere il motore mentre l'auto è in movimento!");
            return false;
        }
    }

    //Metodo per accendere il motore
    public boolean accensioneMotore(){
        if (this.motore == false) {
            this.motore = true;
            return true;
        }else{
            System.out.println("non è possibile accendere la macchina se è già accesa");
            return false;
        } 
    }
    public int getVelocita(){
        return this.velocita;
    }
    public boolean getStatoMotore(){
        return this.motore;
    }
}
