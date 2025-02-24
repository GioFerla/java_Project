class CipherPro extends cipherBasic {
    public CipherPro(String testo, int chiave) {
        super(testo, chiave);
    }


@Override
    public String encode() {
        StringBuilder risultato = new StringBuilder();
        for (int i = 0; i < getTesto().length(); i++) {
            char lettera = getTesto().charAt(i);
            if (i % 2 == 0) {
                risultato.append(shiftAvanti(lettera, getChiave()));
            } else {
                risultato.append(shiftIndietro(lettera, getChiave()));
            }
        }
        return risultato.toString();
    }

    @Override
    public String decode() {
        StringBuilder risultato = new StringBuilder();
        for (int i = 0; i < getTesto().length(); i++) {
            char lettera = getTesto().charAt(i);
            if (i % 2 == 0) {
                risultato.append(shiftIndietro(lettera, getChiave()));
            } else {
                risultato.append(shiftAvanti(lettera, getChiave()));
            }
        }
        return risultato.toString();
    }
}