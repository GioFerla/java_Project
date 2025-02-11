import java.util.Scanner;

public class centroC {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Dimmi il numero di stanze:");
        int nstanze = input.nextInt();
        Occupazione[] centroConvegni = new Occupazione[nstanze];
        for(int i=0; i<nstanze;i++){
            System.out.println("Dimmi il numero di stanza " + (i+1) + ":");
            int nstanza = input.nextInt();
            centroConvegni[i] = new Occupazione(nstanza);        
        }
        int numero;
        Occupazione stanzaTrovata = null;
        do{
            System.out.println("Dimmi il numero di stanza a cui vuoi fare una modifica:");
            numero = input.nextInt();
            for (Occupazione occupazione : centroConvegni){
                if (occupazione.getNStanza() == numero){
                    stanzaTrovata = occupazione;
                    break;
                }
            }
            if (stanzaTrovata == null){
                System.out.println("Numero di stanza non valido. Riprova.");
            }
        } while(stanzaTrovata == null);
        System.out.println("1.aggiungi Uno");
        System.out.println("2.Rimovi Uno");
        int scelta = input.nextInt();
        switch(scelta){
            case 1: centroConvegni[numero].aggiungiUnoallastanza();
                     break;
            case 2: centroConvegni[numero].rimoviUnoallastanza();
                     break;
            default : System.out.println("Scelta non valida");
        }
    }
}
