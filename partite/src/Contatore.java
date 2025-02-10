

public class Contatore {
    private int goal;

    public void incrementaGoal(){
        this.goal ++;
    }

    public void decrementaGoal(){
        if(controlloGoal()){
            this.goal --;
        }
    }
    private boolean controlloGoal(){
        return this.goal > 0;
    }

    public void reset(){
        this.goal = 0;
    }

    public int getGoal(){
        return this.goal;
    }

    @Override
    public String toString() {
        return String.valueOf(goal);
    }
}
