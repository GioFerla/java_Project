import java.awt.Font;
import java.awt.GridLayout;
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

        String[] autoInfo = autoInfo();
        InfoAutomobile auto = new InfoAutomobile(autoInfo[0], autoInfo[1], autoInfo[2]);
        boolean scelta = avviaAuto();

        if (scelta) {
            if (auto.accensioneMotore()) {
                System.out.println("L'automobile è accesa!");
            }
        }
        input.close();

        JFrame frame = new JFrame("Automobile");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JLabel top = new JLabel("Velocità");
        top.setFont(new Font("Arial", Font.BOLD, 12));
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setVerticalAlignment(SwingConstants.TOP);
        panel.add(top);

        JLabel speedLabel = new JLabel("0");
        speedLabel.setFont(new Font("Arial", Font.BOLD, 60));
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(speedLabel);

        top.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); 
        speedLabel.setBorder(BorderFactory.createEmptyBorder(-30, 0, 0, 0));

        frame.add(panel);
        frame.setVisible(true);

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
                                speedLabel.setText(String.valueOf(auto.getVelocita()) + " km/h");
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
                                speedLabel.setText("0 km/h");
                            } else {
                                if(auto.decelleraAuto() == 777){
                                    erroreMarcia();
                                }
                                speedLabel.setText(String.valueOf(auto.getVelocita()) + " km/h");
                            }
                        }
                    });
                    timerS.start();
                } else if(e.getKeyChar() == ' '){
                    System.out.println(auto.controlloMarciaManuale(true)); 
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    keyPressedW = false;
                    if (timerW != null) {
                        timerW.stop();
                    }
                } else if (e.getKeyChar() == 's') {
                    keyPressedS = false;
                    if (timerS != null) {
                        timerS.stop();
                    }
                }

                if (!keyPressedW && !keyPressedS) {
                    if (auto.getVelocita() == 0) {
                        speedLabel.setText("0 km/h");
                    } else {
                        if (noKeyTimer != null && noKeyTimer.isRunning()) {
                            noKeyTimer.stop();
                        }
                        noKeyTimer = new Timer(900, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (auto.getVelocita() > 0) {
                                    auto.decelleraAuto();
                                    speedLabel.setText(String.valueOf(auto.getVelocita()) + " km/h");
                                } else {
                                    speedLabel.setText("0 km/h");
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

    static public String[] autoInfo(){
        JFrame info = new JFrame("Inserisci informazioni automobile");
        info.setSize(500, 300);
        info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        info.setLayout(new GridLayout(4, 2));

        JLabel marca = new JLabel("Marca:");
        JTextField brandField = new JTextField();
        JLabel modello = new JLabel("Modello:");
        JTextField modelField = new JTextField();
        JLabel colorLabel = new JLabel("Colore:");
        JTextField colorField = new JTextField();
        JButton Button = new JButton("Conferma");

        info.add(marca);
        info.add(brandField);
        info.add(modello);
        info.add(modelField);
        info.add(colorLabel);
        info.add(colorField);
        info.add(new JLabel());
        info.add(Button);

        final String[] carInfo = new String[3];

        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            carInfo[0] = brandField.getText();
            carInfo[1] = modelField.getText();
            carInfo[2] = colorField.getText();
            info.dispose();
            }
        });

        info.setVisible(true);

        while (carInfo[0] == null || carInfo[1] == null || carInfo[2] == null) {
            try {
            Thread.sleep(100);
            } catch (InterruptedException ex) {
            ex.printStackTrace();
            }
        }

        return carInfo;
    }

    static public boolean avviaAuto() {
        JFrame avvia = new JFrame("Avvia Macchina");
        avvia.setSize(500, 300);
        avvia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton Button = new JButton("Avvia");
        boolean[] result = {false};

        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result[0] = true;
                avvia.dispose();
            }
        });

        avvia.add(Button);
        avvia.setVisible(true);

        while (!result[0]) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        

        return result[0];
    }

    static public void erroreMarcia(){
        JOptionPane.showMessageDialog(null, "DEVI ABBASSARE LA MARCIA", "ERRORE", JOptionPane.INFORMATION_MESSAGE);
        try {
            Thread.sleep(2000);
            JOptionPane.getRootFrame().dispose();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
