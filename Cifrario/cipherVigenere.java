
public class cipherVigenere extends Cifrario {
    
    public cipherVigenere(String testo, String parolaChiave) {
        super(testo, parolaChiave);
    }

    @Override
    public String encode() {
        String stringtoCipher = this.getTesto().toLowerCase(); // converto tutto in lowercase
        String stringEncoded = "";
        int parolaChiaveLenght = this.getParolaChiave().length(); //Prendo la lunghezza della parola chiave
        int TextLenght = this.getTesto().length();
        for(int i = 0; i < TextLenght; i++){
            if(i < parolaChiaveLenght){
                //traduco
                int valoreShift = getParolaChiave().charAt(i) % 97;
                stringEncoded += shiftAvanti(stringtoCipher.charAt(i), valoreShift);
            }else{
                //calcolo il resto e traduco
                int valoreShift = getParolaChiave().charAt(i%parolaChiaveLenght) % 97;
                stringEncoded += shiftAvanti(stringtoCipher.charAt(i), valoreShift);
            }
        }
        return stringEncoded;
    }


    @Override
    public String decode(){
        String stringtoCipher = this.getTesto().toLowerCase();
        String stringEncoded = "";
        int parolaChiaveLenght = this.getParolaChiave().length();
        int TextLenght = this.getTesto().length();
        for(int i = 0; i < TextLenght; i++){
            if(i < parolaChiaveLenght){
                int valoreShift = getParolaChiave().charAt(i) % 97;
                stringEncoded += shiftIndietro(stringtoCipher.charAt(i), valoreShift);
            } else{
                int valoreShift = getParolaChiave().charAt(i%parolaChiaveLenght) % 97;
                stringEncoded += shiftIndietro(stringtoCipher.charAt(i), valoreShift);
            }
        }
        return stringEncoded;
    }
}
