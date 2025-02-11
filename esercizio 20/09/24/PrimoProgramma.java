
import java.util.Scanner;

public class PrimoProgramma{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prodotti[] =new String[5];
        for (int i=0;i<prodotti.length;i++) {
            prodotti[i] = scanner.nextLine();
        }
        for (String prodotto : prodotti) {
            System.out.println(prodotto);
        }
        //Prodotto p = new Prodotto();
        Prodotto p1 = new Prodotto("mele","MI",100,100);

       /* System.out.println(p.nome);
        System.out.println(p.provenienza);
        System.out.println(p.prezzo);
        System.out.println(p.quantita + "\n");
*/
        System.out.println(p1.stampaEtichetta());
    }
}