class cipherBasic extends Cifrario {
    public cipherBasic(String testo, int chiave) {
        super(testo, chiave);
    }

    @Override
    public String encode() {
        StringBuilder risultato = new StringBuilder();
        for (char lettera : getTesto().toCharArray()) {
            risultato.append(shiftAvanti(lettera, getChiave()));
        }
        return risultato.toString();
    }

    @Override
    public String decode() {
        StringBuilder risultato = new StringBuilder();
        for (char lettera : getTesto().toCharArray()) {
            risultato.append(shiftIndietro(lettera, getChiave()));
        }
        return risultato.toString();
    }
}