public class InfoAutomobile {
    private String modello;
    private String colore;
    private String marca;
    private boolean motore;
    private int velocita;
    private int[] sogliaMarcia = {/* prima */1, 20, /* seconda */ 21, 35,/* terza */ 36, 50, /* quarta */ 51, 75, /* quinta */ 76, 130};
    private int marcia;
    private boolean cambioAutomatico = false;

    public InfoAutomobile(String modello, String colore, String marca) {
        this.modello = modello;
        this.colore = colore;
        this.marca = marca;
        this.motore = false;  
        this.velocita = 0;
        this.marcia = 0;
    }

    // Metodo per accelerare l'auto
    public int accelleraAuto() {
        if (this.velocita < this.sogliaMarcia[this.marcia * 2 + 1]) { 
            if(this.cambioAutomatico){
            controlloMarciaAutomatico();
            }
            return this.velocita += 1;  
        } else {
            System.out.println("hai raggiunto la velocità massima per la marcia corrente!");
            return this.velocita;
        }
        
    }

    //Metodo per decellerare l'auto
    public int decelleraAuto() {
        if (this.velocita > 0) {
            if (this.cambioAutomatico) {
                controlloMarciaAutomatico();
            }
            int min = 0;
            if (this.marcia > 0) {
                min = this.sogliaMarcia[(this.marcia - 1) * 2];
                if (this.velocita < min) {
                    return 777;
                }
            }
            return this.velocita--;
        } else {
            System.out.println("non puoi più decellerare perchè l'auto è ferma");
            return this.velocita;
        }
    }
    public int decelleraAutomatica(){
        if(this.velocita > 0){
            if(this.cambioAutomatico){
                controlloMarciaAutomatico();
            }
            return this.velocita--;
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

    //Metodo per cambiare marcia
    private void controlloMarciaAutomatico(){
        if(getVelocita() >= this.sogliaMarcia[0] && getVelocita()<= this.sogliaMarcia[1]){
            this.marcia = 1;
        }else if(getVelocita() >= this.sogliaMarcia[2] && getVelocita()<= this.sogliaMarcia[3]){
            this.marcia = 2;
            }else if(getVelocita() >= this.sogliaMarcia[4] && getVelocita()<= this.sogliaMarcia[5]){
                this.marcia = 3;
                }else if(getVelocita() >= this.sogliaMarcia[6] && getVelocita()<= this.sogliaMarcia[7]){
                    this.marcia = 4;
                    }else if(getVelocita() >= this.sogliaMarcia[8] && getVelocita()<= this.sogliaMarcia[9]){
                        this.marcia = 5;
                        }else this.marcia = 0;
    }
    //Metodo per cambiare marcia manualmente
    public int controlloMarciaManuale(boolean type){
        if(type){
            if(this.marcia >= 0 && this.marcia < 5){
                this.marcia += 1;
                return this.marcia;
            }else{
                return 404;
            }
        }else{
            if(this.marcia > 0 && this.marcia <= 5){
                this.marcia -= 1;
                return this.marcia;
            }else{
                return 404;
            }
        }
    }
    
    public int getVelocita(){
        return this.velocita;
    }

    public int getMarcia(){
        return this.marcia;
    }
    public boolean getStatoMotore(){
        return this.motore;
    }
}
