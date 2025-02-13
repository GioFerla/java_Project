public class main {
    public static void main(String[] args) {
        Cifrario c = new Cifrario(3,"ciao");
        System.out.println(c.codifica());
        System.out.println(c.decodifica());
        Cifrario2 c2 = new Cifrario2(3,"ciao");
        System.out.println(c2.codifica());
        System.out.println(c2.decodifica());
    }
}
