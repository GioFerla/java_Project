import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String testo, parolaChiave;
        int chiave;
        String alfabetoMescolato = "qwertyuiopasdfghjklzxcvbnm";
        
        System.out.println("Choose:");
        System.out.println("1. Encode with Cesar");
        System.out.println("2. Decode with Cesar");
        System.out.println("3. Encode with Cesar Pro");
        System.out.println("4. Decode with Cesar Pro");
        System.out.println("5. Encode with Vigenere");
        System.out.println("6. Decode with Vigenere");
        System.out.println("7. Encode with nonLinearCesar");
        System.out.println("8. Decode with nonLinearCesar");
        System.out.println("9. Encode with Gabibbo");
        System.out.println("10. Decode with Gabibbo");
        System.out.println("11. Brute Force Gabibbo");
        System.out.print("Choose: ");
        int operazione = scanner.nextInt();
        scanner.nextLine();
        switch (operazione) {
            case 1 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
            
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                cipherBasic cipher = new cipherBasic(testo, chiave);
                System.out.println("Encoded: " + cipher.encode());
            }
            case 2 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
            
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                cipherBasic cipherDec = new cipherBasic(testo, chiave);
                System.out.println("Decoded: " + cipherDec.decode());
            }
            case 3 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
            
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                CipherPro cipherPro = new CipherPro(testo, chiave);
                System.out.println("Encoded(Pro): " + cipherPro.encode());
            }
            case 4 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
            
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                CipherPro cipherProDec = new CipherPro(testo, chiave);
                System.out.println("Decoded(Pro): " + cipherProDec.decode());
            }
            case 5 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();

                System.out.print("Enter a string key: ");
                parolaChiave = scanner.nextLine();
                cipherVigenere cipherVigenere = new cipherVigenere(testo, parolaChiave);
                System.out.println("Encoded(Vigenere): " + cipherVigenere.encode());
            }
            case 6 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();

                System.out.print("Enter a string key: ");
                parolaChiave = scanner.nextLine();
                cipherVigenere cipherVigenereDec = new cipherVigenere(testo, parolaChiave);
                System.out.println("Decoded(Vigenere): " + cipherVigenereDec.decode());
            }
            case 7 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                nonLinearCesar nonLinearCesar = new nonLinearCesar(testo, chiave, alfabetoMescolato);
                System.out.println("Encoded(nonLinearCesar): " + nonLinearCesar.encode());
            }
            case 8 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                nonLinearCesar nonLinearCesarDec = new nonLinearCesar(testo, chiave, alfabetoMescolato);
                System.out.println("Decoded(nonLinearCesar): " + nonLinearCesarDec.decode());
            }
            case 9 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
                chiave = cipherGabibbo.newKey();
                cipherGabibbo cipherGabibbo = new cipherGabibbo(testo, chiave);
                System.out.println("Encoded(Gabibbo): " + cipherGabibbo.encode());
                System.out.println("se ti dimentichi la chiave non puoi decifrare il messaggio key[ " + chiave + " ]");
            }
            case 10 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
                System.out.print("Enter a key: ");
                chiave = scanner.nextInt();
                cipherGabibbo cipherGabibboDec = new cipherGabibbo(testo, chiave);
                System.out.println("Decoded(Gabibbo): " + cipherGabibboDec.decode());
            }
            case 11 -> {
                System.out.print("Enter a string: ");
                testo = scanner.nextLine();
                cipherGabibbo cipherGabibboBrute = new cipherGabibbo(testo, 0);
                try {
                    String[] bruteForce = cipherGabibboBrute.bruteForce(testo);
                    
                } catch (Exception e) {
                }
            }
            default -> System.out.println("Error: Not a valid input.");
        }
    }
}

