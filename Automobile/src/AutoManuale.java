public class AutoManuale extends Auto {

    public AutoManuale(String modello, String colore, String marca) {
        super(modello, colore, marca);
    }
    public int cambioMarcia(boolean up) {
        if (up) {
            if (marcia >= 0 && marcia < 5) {
                return ++marcia;
            }
        } else {
            if (marcia > 0 && marcia <= 5) {
                return --marcia;
            }
        }
        return 404;
    }

    @Override
    public int accelleraAuto() {
        if (marcia == 0) {
            System.out.println("Seleziona una marcia per iniziare.");
            return velocita;
        }
        if (velocita < sogliaMarcia[marcia * 2 + 1]) {
            return ++velocita;
        } else {
            System.out.println("Hai raggiunto la velocità massima per la marcia corrente.");
            return velocita;
        }
    }

    @Override
    public int deceleraAuto() {
        if (velocita > 0) {
            int min = marcia > 0 ? sogliaMarcia[(marcia - 1) * 2] : 0;
            if (velocita < min) {
                return 777;
            }
            return --velocita;
        } else {
            System.out.println("L'auto è ferma.");
            return velocita;
        }
    }
}
