public class AutoAutomatica extends Auto {

    public AutoAutomatica(String modello, String colore, String marca) {
        super(modello, colore, marca);
    }

    private void controlloMarciaAutomatico() {
        if (velocita >= sogliaMarcia[0] && velocita <= sogliaMarcia[1]) {
            marcia = 1;
        } else if (velocita >= sogliaMarcia[2] && velocita <= sogliaMarcia[3]) {
            marcia = 2;
        } else if (velocita >= sogliaMarcia[4] && velocita <= sogliaMarcia[5]) {
            marcia = 3;
        } else if (velocita >= sogliaMarcia[6] && velocita <= sogliaMarcia[7]) {
            marcia = 4;
        } else if (velocita >= sogliaMarcia[8] && velocita <= sogliaMarcia[9]) {
            marcia = 5;
        } else {
            marcia = 0;
        }
    }

    @Override
    public int accelleraAuto() {
        if (marcia == 0 && velocita == 0) {
            marcia = 1;
        }
        controlloMarciaAutomatico();
        int index = marcia * 2 + 1;
        if (index < sogliaMarcia.length && velocita < sogliaMarcia[index]) {
            return ++velocita;
        } else {
            System.out.println("Hai raggiunto la velocità massima per la marcia corrente.");
            return velocita;
        }
    }

    @Override
    public int deceleraAuto() {
        if (velocita > 0) {
            velocita--;
            controlloMarciaAutomatico();
            return velocita;
        } else {
            System.out.println("L'auto è ferma.");
            return velocita;
        }
    }
}
