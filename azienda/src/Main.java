
public class Main {
    public static void main(String[] args) {
        Dipendente d1 = new Dipendente("Mario", "Rossi", 2010, 1500);
        Dipendente d2 = new Dipendente("Luca", "Verdi", 2015, 2000);
        Manager m1 = new Manager("Giovanni", "Bianchi", 2005, 3000, d1);
        Manager m2 = new Manager("Paolo", "Neri", 2000, 3500, d2);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(m1);
        System.out.println(m2);
        d1.aumentaStipendio(10);
        d2.aumentaStipendio(10);
        m1.aumentaStipendio(10);
        m2.aumentaStipendio(10);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(m1);
        System.out.println(m2);
    }
}

