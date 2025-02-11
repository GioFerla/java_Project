import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Tabellone {
    public static void main(String[] args) {
        Inserimento inserimento=new Inserimento();
        inserimento.setVisible(true);

        
        
        /*Scanner input= new Scanner(System.in);
        int scelta,scelta2;
        String vincitore;
        Partita partita1;
        String allenatoreLocale,allenatoreOspite,nomeSquadraLocale,nomeSquadraOspite,nomeAllenatoreLocale,nomeAllenatoreOspite,cognomeAllenatoreLocale,cognomeAllenatoreOspite,nomeDirigenteLocale,nomeDirigenteOspite;
        
        do {
            System.out.println("Inserisci nome squadra locale:");
            nomeSquadraLocale=input.nextLine();
            if (nomeSquadraLocale.length()<3) System.out.println("Il nome della squadra deve essere almeno di 3 lettere\n");
        } while(nomeSquadraLocale.length()<3);
        System.out.println("Inserisci nome allenatore squadra locale:");
        nomeAllenatoreLocale=input.nextLine();
        System.out.println("Inserisci cognome allenatore squadra locale:");
        cognomeAllenatoreLocale=input.nextLine();
        System.out.println("Inserisci nome dirigente squadra locale:");
        nomeDirigenteLocale=input.nextLine();
        do {
            System.out.println("Inserisci nome squadra ospite:");
            nomeSquadraOspite=input.nextLine();
            if (nomeSquadraOspite.length()<3) System.out.println("Il nome della squadra deve essere almeno di 3 lettere\n");
        } while(nomeSquadraOspite.length()<3);
        System.out.println("Inserisci nome allenatore squadra ospite:");
        nomeAllenatoreOspite=input.nextLine();
        System.out.println("Inserisci cognome allenatore squadra ospite:");
        cognomeAllenatoreOspite=input.nextLine();
        System.out.println("Inserisci nome dirigente squadra ospite:");
        nomeDirigenteOspite=input.nextLine();
        
        partita1=new Partita(new Squadra(nomeSquadraLocale,nomeAllenatoreLocale,cognomeAllenatoreLocale,nomeDirigenteLocale),new Squadra(nomeSquadraOspite,nomeAllenatoreOspite,cognomeAllenatoreOspite,nomeDirigenteOspite));
        
        
        LocalDateTime a=LocalDateTime.now();
        DateTimeFormatter b= DateTimeFormatter.ofPattern("E dd MMMM yyyy HH:mm:ss");
        String data=a.format(b);
        
       
        do {
            System.out.println("______________________________________________________________________________________________________________________________________________");
            System.out.println("\t\t\t\t\t\t\t\t"+data);
            System.out.println("LOCALI\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tOSPITI");
            System.out.println(partita1.getSquadraLocale().getNomeSquadra().substring(0, 3)+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+partita1.getSquadraOspite().getNomeSquadra().substring(0, 3));
            allenatoreLocale=partita1.getSquadraLocale().getNomeAllenatore().substring(0, 1) + partita1.getSquadraLocale().getCognomeAllenatore().substring(0, 1);
            allenatoreOspite=partita1.getSquadraOspite().getNomeAllenatore().substring(0, 1) + partita1.getSquadraOspite().getCognomeAllenatore().substring(0, 1);
            System.out.println(allenatoreLocale+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+allenatoreOspite);
            System.out.println(partita1.getPuntiSquadraLocale()+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+partita1.getPuntiSquadraOspite());
            System.out.println("\n1)Aggiungi punti locali\t2)Rimuovi punti locali\t0)Azzera punteggio\t5)Finisci partita\t3)Aggiungi punti ospiti\t4)Rimuovi punti ospiti");
            System.out.println("______________________________________________________________________________________________________________________________________________");
            scelta=input.nextInt();
            switch(scelta) {
                case 0:
                    partita1.azzeraPunteggio();
                    break;
                case 1:
                    System.out.println("1)Aggiungi 1 punto\n2)Aggiungi 2 punti\n3)Aggiungi 3 punti\n4)Aggiungi punti random");
                    scelta2=input.nextInt();
                    switch (scelta2) {
                        case 1:
                            partita1.aggiungiPuntiLocali1();
                            break;
                        case 2:
                            partita1.aggiungiPuntiLocali2();
                            break;
                        case 3:
                            partita1.aggiungiPuntiLocali3();
                            break;
                        case 4:
                            partita1.aggiungiPuntiLocaliRandom();
                            break;
                        default: System.out.println("Opzione non valida");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("1)Rimuovi 1 punto\n2)Rimuovi 2 punti\n3)Rimuovi 3 punti");
                    scelta2=input.nextInt();
                    switch (scelta2) {
                        case 1:
                            if (partita1.getPuntiSquadraLocale()-1>=0) 
                                partita1.rimuoviPuntiLocali1();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        case 2:
                            if (partita1.getPuntiSquadraLocale()-2>=0) 
                                partita1.rimuoviPuntiLocali2();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        case 3:
                            if (partita1.getPuntiSquadraLocale()-3>=0) 
                                partita1.rimuoviPuntiLocali3();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        default: System.out.println("Opzione non valida");
                            break;
                    }
                    break;
                
                case 3:
                    System.out.println("1)Aggiungi 1 punto\n2)Aggiungi 2 punti\n3)Aggiungi 3 punti\n4)Aggiungi punti random");
                    scelta2=input.nextInt();
                    switch (scelta2) {
                        case 1:
                            partita1.aggiungiPuntiOspiti1();
                            break;
                        case 2:
                            partita1.aggiungiPuntiOspiti2();
                            break;
                        case 3:
                            partita1.aggiungiPuntiOspiti3();
                            break;
                        case 4:
                            partita1.aggiungiPuntiOspitiRandom();
                            break;
                        default: System.out.println("Opzione non valida");
                            break;
                    }
                    break;
                case 4:
                    System.out.println("1)Rimuovi 1 punto\n2)Rimuovi 2 punti\n3)Rimuovi 3 punti");
                    scelta2=input.nextInt();
                    switch (scelta2) {
                        case 1:
                            if (partita1.getPuntiSquadraOspite()-1>=0) 
                                partita1.rimuoviPuntiOspiti1();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        case 2:
                            if (partita1.getPuntiSquadraOspite()-2>=0) 
                                partita1.rimuoviPuntiOspiti2();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        case 3:
                            if (partita1.getPuntiSquadraOspite()-3>=0) 
                                partita1.rimuoviPuntiOspiti3();
                            else 
                                System.out.println("Non puoi rimuovere questi punti");
                            break;
                        default: System.out.println("Opzione non valida");
                            break;
                    }
                    break;
                case 5:
                    partita1.setFinita();
                    vincitore=partita1.vincitore();
                    if (vincitore==null)
                        System.out.println("Pareggio");
                    else 
                        System.out.println("Vincitore: "+vincitore);
                    break;
                default: System.out.println("Opzione non valida");
                            break;
            }
                    
        } while (!partita1.isFinita());*/
    }
}

