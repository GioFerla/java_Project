public class Cifrario2 extends Cifrario {
    public Cifrario2(int chiave,String parola){
        super(chiave,parola);
    }
    @Override
    public String codifica(){
        String s =  "";
        String parola = getParola().toUpperCase();
        for(int i = 0; i < parola.length(); i++){
            if((parola.charAt(i)) >= 'A' && (parola.charAt(i) <= 'Z')){
                if(i%2 == 0){
                    s += codificaLet(parola.charAt(i));                    
                } else {
                    s += decodificaLet(parola.charAt(i));   
                }
            } else{
                s += parola.charAt(i);
            }
        }
        return s;
    }    
    @Override
    public String decodifica(){
        String s =  "";
        String parola = getParola().toUpperCase();
        for(int i = 0; i < parola.length(); i++){
            if((parola.charAt(i)) >= 'A' && (parola.charAt(i) <= 'Z')){
                if(i%2 == 0){
                    s += decodificaLet(parola.charAt(i));                    
                } else {
                    s += codificaLet(parola.charAt(i));   
                }
            } else{
                s += parola;
            }
        }
        return s;      
    }    
}