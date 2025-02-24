public class cipherGabibbo extends Cifrario {
    private static final String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':,.<>?/`~";
    private int key;

    public static int newKey() {
        return (int)(Math.random() * alph.length());
    }

    public cipherGabibbo(String testo, int chiave) {
        super(testo, chiave);
        this.key = chiave;
        }

    @Override
    public String encode() {
    String r = "";
        

        for (int i = 0; i < getTesto().length(); i++) {
            char c = getTesto().charAt(i);
            int index = alph.indexOf(c);
                
            if (index == -1) {
                    r += c;
                } else {
                    int newIndex = (index + this.key) % alph.length();
                    r += alph.charAt(newIndex);
                    }
        }

        return r;
    }

    @Override
    public String decode() {
        String d = "";
        
        // Decifra ogni carattere del testo
        for (int i = 0; i < getTesto().length(); i++) {
            char c = getTesto().charAt(i);
            int index = alph.indexOf(c);
            
            if (index == -1) {
            d += c;
            } else {
            int newIndex = (index - this.key + alph.length()) % alph.length();
            d += alph.charAt(newIndex);
            }
        }

            return d;
    }
}   
