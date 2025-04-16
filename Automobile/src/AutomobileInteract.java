import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;

public class AutomobileInteract {
    private static boolean keyPressedW = false;
    private static boolean keyPressedS = false;
    private static Timer timerW;
    private static Timer timerS;
    private static Timer noKeyTimer;
    private static int maxSpeed = 130;

    public static void main(String[] args) {
        String[] autoInfo = autoInfo();
        InfoAutomobile auto = new InfoAutomobile(autoInfo[0], autoInfo[1], autoInfo[2]);
        maxSpeed = setMaxSpeed(autoInfo[0]); 

        if (avviaAuto()) {
            if (auto.accensioneMotore()) {
                System.out.println("L'automobile è accesa!");
            }
        }

        createGUI(auto);
    }

    private static void createGUI(InfoAutomobile auto) {
        JFrame frame = new JFrame("Automobile");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(2, 1));

        JLabel top = new JLabel("Velocità");
        top.setFont(new Font("Arial", Font.BOLD, 12));
        top.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(top);

        JLabel speedLabel = new JLabel("0 km/h");
        speedLabel.setFont(new Font("Arial", Font.BOLD, 60));
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(speedLabel);

        frame.add(panel);
        frame.setVisible(true);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e, auto, speedLabel);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e, auto, speedLabel);
            }
        });
    }

    private static void handleKeyPress(KeyEvent e, InfoAutomobile auto, JLabel speedLabel) {
        if (e.getKeyChar() == 'w' && !keyPressedW) {
            keyPressedW = true;
            stopNoKeyTimer();
            timerW = new Timer(100, event -> {
                auto.accelleraAuto(maxSpeed);
                speedLabel.setText(auto.getVelocita() + " km/h");
            });
            timerW.start();
        } else if (e.getKeyChar() == 's' && !keyPressedS) {
            keyPressedS = true;
            stopNoKeyTimer();
            timerS = new Timer(100, event -> {
                auto.decelleraAuto();
                speedLabel.setText(auto.getVelocita() + " km/h");
            });
            timerS.start();
        }
    }

    private static void handleKeyRelease(KeyEvent e, InfoAutomobile auto, JLabel speedLabel) {
        if (e.getKeyChar() == 'w') {
            keyPressedW = false;
            if (timerW != null) timerW.stop();
        } else if (e.getKeyChar() == 's') {
            keyPressedS = false;
            if (timerS != null) timerS.stop();
        }

        if (!keyPressedW && !keyPressedS) {
            startNoKeyTimer(auto, speedLabel);
        }
    }

    private static void startNoKeyTimer(InfoAutomobile auto, JLabel speedLabel) {
        if (noKeyTimer != null && noKeyTimer.isRunning()) {
            noKeyTimer.stop();
        }
        noKeyTimer = new Timer(900, event -> {
            auto.decelleraAuto();
            speedLabel.setText(auto.getVelocita() + " km/h");
            if (auto.getVelocita() <= 0) {
                noKeyTimer.stop();
                speedLabel.setText("0 km/h");
            }
        });
        noKeyTimer.setRepeats(true);
        noKeyTimer.start();
    }

    private static void stopNoKeyTimer() {
        if (noKeyTimer != null) {
            noKeyTimer.stop();
        }
    }

    public static String[] autoInfo() {
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

    public static boolean avviaAuto() {
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

    public static int setMaxSpeed(String marca) {
        switch (marca.toLowerCase()) {
            case "fiat": return 130;
            case "audi": return 150;
            case "bmw": return 180;
            case "mercedes": return 200;
            case "ferrari": return 250;
            default: return 130;
        }
    }
}
