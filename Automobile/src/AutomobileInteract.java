import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class AutomobileInteract {
    private static boolean keyPressedW = false;
    private static boolean keyPressedS = false;
    private static Timer timerW;
    private static Timer timerS;
    private static Timer noKeyTimer;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Marca dell'automobile: ");
        String marca = input.nextLine();

        System.out.println("Modello dell'automobile: ");
        String modello = input.nextLine();

        System.out.println("Colore dell'automobile: ");
        String colore = input.nextLine();

        InfoAutomobile auto = new InfoAutomobile(modello, colore, marca);

        System.out.println("Vuoi accendere l'automobile? S/N");
        String scelta = input.nextLine();

        if (scelta.equalsIgnoreCase("S")) {
            if (auto.accensioneMotore()) {
                System.out.println("L'automobile è accesa!");
            }
        }
        input.close();

        JFrame frame = new JFrame("Automobile Interact");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'w' && !keyPressedW) {
                    keyPressedW = true;
                    if (noKeyTimer != null) {
                        noKeyTimer.stop();
                    }
                    timerW = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            auto.accelleraAuto();
                            if (auto.getVelocita() != 707) {
                                clearScreen();
                                System.out.println("Velocità attuale: " + auto.getVelocita() + " km/h la marcia inserita è: " + auto.getMarcia());
                            }
                        }
                    });
                    timerW.start();
                } else if (e.getKeyChar() == 's' && !keyPressedS) {
                    keyPressedS = true;
                    if (noKeyTimer != null) {
                        noKeyTimer.stop();
                    }
                    timerS = new Timer(100, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (auto.getVelocita() == 0) {
                                System.out.println("L'auto è ferma");
                            } else {
                                auto.decelleraAuto();
                                clearScreen();
                                System.out.println("Velocità attuale: " + auto.getVelocita() + " km/h la marcia inserita è: " + auto.getMarcia());
                            }                            
                        }
                    });
                    timerS.start();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    keyPressedW = false;
                    if (timerW != null) {
                        timerW.stop();
                    }
                    System.out.println("Velocità costante");
                } else if (e.getKeyChar() == 's') {
                    keyPressedS = false;
                    if (timerS != null) {
                        timerS.stop();
                    }
                    System.out.println("Velocità costante");
                }

                if (!keyPressedW && !keyPressedS) {
                    if (auto.getVelocita() == 0) {
                        clearScreen();
                        System.out.println("L'auto è ferma");
                    } else {
                        if (noKeyTimer != null && noKeyTimer.isRunning()) {
                            noKeyTimer.stop();
                        }
                        noKeyTimer = new Timer(900, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (auto.getVelocita() > 0) {
                                    auto.decelleraAuto();
                                    clearScreen();
                                    System.out.println("Velocità attuale: " + auto.getVelocita() + " km/h la marcia inserita è: " + auto.getMarcia());
                                } else {
                                    clearScreen();
                                    System.out.println("L'auto è ferma");
                                    noKeyTimer.stop();
                                }
                            }
                        });
                        noKeyTimer.setRepeats(true);
                        noKeyTimer.start();
                    }
                }
            }
        });

        frame.setVisible(true);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
