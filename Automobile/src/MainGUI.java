import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainGUI {
    private static boolean keyPressedW = false;
    private static boolean keyPressedS = false;
    private static Timer timerW;
    private static Timer timerS;
    private static Timer noKeyTimer;
    private static int maxSpeed = 130;

    public static void main(String[] args) {
        String[] autoInfo = autoInfo(); 
        boolean isAutomatica = scegliTipoCambio();
        Auto auto;

        if (isAutomatica) {
            auto = new AutoAutomatica(autoInfo[1], autoInfo[2], autoInfo[0]);
        } else {
            auto = new AutoManuale(autoInfo[1], autoInfo[2], autoInfo[0]);
        }

        maxSpeed = setMaxSpeed(autoInfo[0]);

        if (avviaAuto()) {
            if (auto.accensioneMotore()) {
                System.out.println("L'automobile è accesa!");
            }
        }

        createGUI(auto, isAutomatica);
    }

    private static void createGUI(Auto auto, boolean isAutomatica) {
        JFrame frame = new JFrame("Simulatore Automobile");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JLabel top = new JLabel("Velocità");
        top.setFont(new Font("Arial", Font.BOLD, 14));
        top.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(top);

        JLabel speedLabel = new JLabel("0 km/h");
        speedLabel.setFont(new Font("Arial", Font.BOLD, 60));
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(speedLabel);

        JLabel gearLabel = new JLabel("Marcia: N");
        gearLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(gearLabel);

        frame.add(panel);
        frame.setVisible(true);
        frame.setFocusable(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                if (key == 'w' && !keyPressedW) {
                    keyPressedW = true;
                    if (noKeyTimer != null) noKeyTimer.stop();

                    timerW = new Timer(100, ev -> {
                        auto.accelleraAuto();
                        speedLabel.setText(auto.getVelocita() + " km/h");
                        gearLabel.setText("Marcia: " + marciaToString(auto.getMarcia()));
                    });
                    timerW.start();

                } else if (key == 's' && !keyPressedS) {
                    keyPressedS = true;
                    if (noKeyTimer != null) noKeyTimer.stop();

                    timerS = new Timer(100, ev -> {
                        auto.deceleraAuto();
                        speedLabel.setText(auto.getVelocita() + " km/h");
                        gearLabel.setText("Marcia: " + marciaToString(auto.getMarcia()));
                    });
                    timerS.start();

                } else if (!isAutomatica && (key == 'e' || key == 'q')) {
                    AutoManuale manuale = (AutoManuale) auto;
                    if (key == 'e') {
                        manuale.cambioMarcia(true);
                    } else {
                        manuale.cambioMarcia(false);
                    }
                    gearLabel.setText("Marcia: " + marciaToString(auto.getMarcia()));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e, auto, speedLabel, gearLabel);
            }
        });
    }

    private static void handleKeyRelease(KeyEvent e, Auto auto, JLabel speedLabel, JLabel gearLabel) {
        if (e.getKeyChar() == 'w') {
            keyPressedW = false;
            if (timerW != null) timerW.stop();
        } else if (e.getKeyChar() == 's') {
            keyPressedS = false;
            if (timerS != null) timerS.stop();
        }

        if (!keyPressedW && !keyPressedS) {
            startNoKeyTimer(auto, speedLabel, gearLabel);
        }
    }

    private static void startNoKeyTimer(Auto auto, JLabel speedLabel, JLabel gearLabel) {
        if (noKeyTimer != null && noKeyTimer.isRunning()) {
            noKeyTimer.stop();
        }
        noKeyTimer = new Timer(900, event -> {
            auto.deceleraAuto();
            speedLabel.setText(auto.getVelocita() + " km/h");
            gearLabel.setText("Marcia: " + marciaToString(auto.getMarcia()));
            if (auto.getVelocita() <= 0) {
                noKeyTimer.stop();
                speedLabel.setText("0 km/h");
            }
        });
        noKeyTimer.setRepeats(true);
        noKeyTimer.start();
    }

    private static String[] autoInfo() {
        JDialog info = new JDialog((JFrame) null, "Inserisci informazioni automobile", true);
        info.setSize(500, 300);
        info.setLayout(new GridLayout(4, 2));

        JTextField brandField = new JTextField();
        JTextField modelField = new JTextField();
        JTextField colorField = new JTextField();
        JButton confirmButton = new JButton("Conferma");

        info.add(new JLabel("Marca:"));
        info.add(brandField);
        info.add(new JLabel("Modello:"));
        info.add(modelField);
        info.add(new JLabel("Colore:"));
        info.add(colorField);
        info.add(new JLabel());
        info.add(confirmButton);

        final String[] carInfo = new String[3];
        confirmButton.addActionListener(e -> {
            carInfo[0] = brandField.getText();
            carInfo[1] = modelField.getText();
            carInfo[2] = colorField.getText();
            info.dispose();
        });

        info.setVisible(true);
        return carInfo;
    }

    private static boolean scegliTipoCambio() {
        Object[] options = {"Manuale", "Automatico"};
        int scelta = JOptionPane.showOptionDialog(null,
                "Che tipo di cambio vuoi usare?",
                "Tipo di Cambio",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        return scelta == 1; 
    }

    private static boolean avviaAuto() {
        JDialog avvia = new JDialog((JFrame) null, "Avvia Macchina", true);
        avvia.setSize(300, 150);

        JButton startButton = new JButton("Avvia");
        final boolean[] result = {false};

        startButton.addActionListener(e -> {
            result[0] = true;
            avvia.dispose();
        });

        avvia.add(startButton);
        avvia.setVisible(true);
        return result[0];
    }

    private static int setMaxSpeed(String brand) {
        switch (brand.toLowerCase()) {
            case "fiat": return 130;
            case "audi": return 250;
            case "bmw": return 300;
            case "mercedes": return 320;
            default: return 130;
        }
    }

    private static String marciaToString(int marcia) {
        return marcia == 0 ? "N" : String.valueOf(marcia);
    }
}
