public class Cifrario {
    private int chiave;
    private String parola;
 
    public Cifrario(int chiave, String parola) {
        this.chiave = chiave;
        this.parola = parola;
    }
 
    public String codifica(){
        parola = parola.toUpperCase();
        String s =  "";
        for(int i = 0; i < parola.length(); i++){
            if((parola.charAt(i)) >= 'A' && (parola.charAt(i) <= 'Z')){
                s += codificaLet(parola.charAt(i));
            } else{
                s += parola.charAt(i);
            }
        }
        return s;
    }
    public String decodifica(){
        parola = parola.toUpperCase();
        String s =  "";
        for(int i = 0; i < parola.length(); i++){
            if((parola.charAt(i)) >= 'A' && (parola.charAt(i) <= 'Z')){
                s += decodificaLet(parola.charAt(i));
            } else{
                s += parola.charAt(i);
            }
        }
        return s;
    }
    public char codificaLet(char c){
        if((char) c + chiave > 'Z'){
            return (char)(c + chiave - 26);
        } else{
            return (char)(c + chiave);
        }      
    }
    public char decodificaLet(char c){
        if((char) c - chiave < 'A'){
            return (char)(c - chiave + 26);
        } else{
            return (char)(c - chiave);
        } 
    }
    public String getParola() {
        return parola;
    }
 
    public int getChiave() {
        return chiave;
    }    
}