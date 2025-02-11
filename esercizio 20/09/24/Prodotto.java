
import java.util.Scanner;

public class Prodotto{
    String nome;
    String provenienza;
    double prezzo;
    int quantita;

    public Prodotto()/*costruttore*/{
        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();
        provenienza = scanner.nextLine();
    }
    
    public Prodotto(String nome,String provenienza, double prezzo, int quantita)/*costruttore2*/{
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.provenienza = provenienza;
    }

    public String stampaEtichetta(){
        String etichetta[] = new String[3];
        etichetta[0] = this.nome.toUpperCase();
        etichetta[1] = this.provenienza.toUpperCase();
        etichetta[2] = String.format("%.2f", prezzoScontato(50));
        return String.join("\n", etichetta);
    }
    
    public double prezzoScontato(double sconto) {
        if(sconto > 1){
            sconto = sconto / 100;
        }
        return this.prezzo - this.prezzo * sconto;
    }
}

