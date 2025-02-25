public class Main {
    public static void main(String[] args) {
        Agenzia a = new Agenzia("Agenzia", "123");
        Appartamento app = new Appartamento("123", "via roma", "00100", "roma", "rm", 100, 1000, 3, 2, "1");
        Villa v = new Villa("123", "via roma", "00100", "roma", "rm", 100, 1000, 3, 2, "1", 100, true, "2");
        Box b = new Box("123", "via roma", "00100", "roma", "rm", 100, 1000, 1);
        System.out.println(a);
        System.out.println(app);
        System.out.println(v);
        System.out.println(b);

    }
}
