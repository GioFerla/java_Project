public class nonLinearCesar extends Cifrario{

    public nonLinearCesar(String testo, int chiave, String parolaChiave) {
        super(testo, chiave, parolaChiave);
    }

    @Override
    public String encode(){
        String stringtoCipher = this.getTesto().toLowerCase();
        String stringaCompleta, concatena = "";
        int position, result;
        int positionPlusChiave;
        for(int i = 0; i < stringtoCipher.length(); i++){
            if (Character.isLetter(stringtoCipher.charAt(i))){
                position = this.getParolaChiave().indexOf(stringtoCipher.charAt(i));
                positionPlusChiave = position + getChiave();
                result = positionPlusChiave % 26;
                concatena += this.getParolaChiave().charAt(result);
            } else{
                concatena += stringtoCipher.charAt(i);
            }
        }
        return concatena;
    }

    @Override
    public String decode(){
        String stringtoCipher = this.getTesto().toLowerCase();
        String stringaCompleta, concatena = "";
        int position, result;
        int positionPlusChiave;
        for(int i = 0; i < stringtoCipher.length(); i++){
            if (Character.isLetter(stringtoCipher.charAt(i))){
                position = this.getParolaChiave().indexOf(stringtoCipher.charAt(i));
                positionPlusChiave = position - getChiave() % 26;
                if (positionPlusChiave < 0){
                    positionPlusChiave += 26;
                }
                //result = positionPlusChiave % 26;
                concatena += this.getParolaChiave().charAt(positionPlusChiave);
            } else{
                concatena += stringtoCipher.charAt(i);
            }
        }
        return concatena;
    }
}
