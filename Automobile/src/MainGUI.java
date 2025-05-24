import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class MainGUI {
    private static boolean keyPressedW = false;
    private static boolean keyPressedS = false;
    private static Timer timerW;
    private static Timer timerS;
    private static Timer noKeyTimer;
    private static JProgressBar speedometer;
    private static JLabel statusMessage;
    private static final Color DARK_GREEN = new Color(0, 120, 0);
    private static final Color DARK_RED = new Color(150, 0, 0);
    private static final DecimalFormat df = new DecimalFormat("0");

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] autoInfo = autoInfo(); 
        boolean isAutomatica = scegliTipoCambio();
        Auto auto;

        if (isAutomatica) {
            auto = new AutoAutomatica(autoInfo[1], autoInfo[2], autoInfo[0]);
        } else {
            auto = new AutoManuale(autoInfo[1], autoInfo[2], autoInfo[0]);
        }

        if (avviaAuto()) {
            if (auto.accensioneMotore()) {
                createGUI(auto, isAutomatica);
            }
        }
    }

    private static void createGUI(Auto auto, boolean isAutomatica) {
        JFrame frame = new JFrame("Simulatore Automobile - " + auto.modello);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(240, 240, 240));

        JPanel mainPanel = createSpeedPanel(auto);
        JPanel controlPanel = createControlPanel(isAutomatica);
        JPanel infoPanel = createInfoPanel(auto);

        statusMessage = new JLabel("L'automobile è accesa!");
        statusMessage.setFont(new Font("Arial", Font.ITALIC, 12));
        statusMessage.setHorizontalAlignment(SwingConstants.CENTER);
        statusMessage.setForeground(DARK_GREEN);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.EAST);
        frame.add(infoPanel, BorderLayout.NORTH);
        frame.add(statusMessage, BorderLayout.SOUTH);

        ((JComponent) frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.requestFocus();

        addKeyboardListener(frame, auto, isAutomatica);
    }

    private static JPanel createSpeedPanel(Auto auto) {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(createTitledBorder("Indicatori di Marcia"));

        JLabel speedLabel = new JLabel("0");
        speedLabel.setFont(new Font("Digital-7", Font.BOLD, 90));
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        speedLabel.setForeground(new Color(30, 30, 30));

        JLabel kmhLabel = new JLabel("km/h");
        kmhLabel.setFont(new Font("Arial", Font.BOLD, 16));
        kmhLabel.setHorizontalAlignment(SwingConstants.CENTER);

        speedometer = new JProgressBar(0, auto.getMaxSpeed());
        speedometer.setValue(0);
        speedometer.setStringPainted(false);
        speedometer.setForeground(new Color(50, 150, 220));

        JLabel gearLabel = new JLabel("N");
        gearLabel.setFont(new Font("Digital-7", Font.BOLD, 70));
        gearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gearLabel.setForeground(new Color(30, 30, 30));
        gearLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(5, 15, 5, 15)));

        JPanel speedPanel = new JPanel(new BorderLayout());
        speedPanel.add(speedLabel, BorderLayout.CENTER);
        speedPanel.add(kmhLabel, BorderLayout.SOUTH);

        panel.add(speedPanel, BorderLayout.CENTER);

        JPanel gearPanel = new JPanel(new BorderLayout());
        JLabel gearTitleLabel = new JLabel("Marcia");
        gearTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gearTitleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        gearPanel.add(gearTitleLabel, BorderLayout.NORTH);
        gearPanel.add(gearLabel, BorderLayout.CENTER);
        gearPanel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

        panel.add(gearPanel, BorderLayout.EAST);
        panel.add(speedometer, BorderLayout.SOUTH);

        Timer guiUpdateTimer = new Timer(100, e -> {
            int speed = auto.getVelocita();
            speedLabel.setText(df.format(speed));
            speedometer.setValue(speed);

            if (speed > auto.getMaxSpeed() * 0.8) {
                speedLabel.setForeground(DARK_RED);
            } else if (speed > auto.getMaxSpeed() * 0.6) {
                speedLabel.setForeground(new Color(200, 100, 0));
            } else {
                speedLabel.setForeground(new Color(30, 30, 30));
            }

            String marciaText = marciaToString(auto.getMarcia());
            gearLabel.setText(marciaText);
        });
        guiUpdateTimer.start();

        return panel;
    }

    private static JPanel createControlPanel(boolean isAutomatica) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(createTitledBorder("Comandi"));

        JLabel acceleraLabel = new JLabel("W - Accelera");
        JLabel frenaLabel = new JLabel("S - Frena");

        panel.add(Box.createVerticalStrut(10));
        panel.add(acceleraLabel);
        panel.add(Box.createVerticalStrut(10));
        panel.add(frenaLabel);

        if (!isAutomatica) {
            JLabel marciaUpLabel = new JLabel("E - Marcia su");
            JLabel marciaDownLabel = new JLabel("Q - Marcia giù");

            panel.add(Box.createVerticalStrut(20));
            panel.add(marciaUpLabel);
            panel.add(Box.createVerticalStrut(10));
            panel.add(marciaDownLabel);
        } else {
            JLabel autoLabel = new JLabel("Cambio Automatico");
            autoLabel.setForeground(new Color(0, 100, 0));
            panel.add(Box.createVerticalStrut(20));
            panel.add(autoLabel);
        }

        panel.add(Box.createVerticalGlue());
        return panel;
    }

    private static JPanel createInfoPanel(Auto auto) {
        JPanel panel = new JPanel(new GridLayout(1, 3, 10, 0));
        panel.setBorder(createTitledBorder("Informazioni Veicolo"));

        JLabel brandLabel = new JLabel("Marca: " + auto.marca);
        JLabel modelLabel = new JLabel("Modello: " + auto.modello);
        JLabel maxSpeedLabel = new JLabel("Velocità Max: " + auto.getMaxSpeed() + " km/h");

        panel.add(brandLabel);
        panel.add(modelLabel);
        panel.add(maxSpeedLabel);

        return panel;
    }

    private static TitledBorder createTitledBorder(String title) {
        return BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                title,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 12),
                Color.DARK_GRAY);
    }

    private static void addKeyboardListener(JFrame frame, Auto auto, boolean isAutomatica) {
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char key = e.getKeyChar();

                if (key == 'w' && !keyPressedW) {
                    keyPressedW = true;
                    if (noKeyTimer != null) noKeyTimer.stop();

                    timerW = new Timer(100, ev -> {
                        int result = auto.accelleraAuto();
                        if (result == auto.getVelocita()) {
                            if (auto.getVelocita() >= auto.getMaxSpeed()) {
                                updateStatus("Velocità massima raggiunta!", DARK_RED);
                            } else if (auto.getMarcia() == 0) {
                                updateStatus("Inserisci una marcia per accelerare!", DARK_RED);
                            }
                        } else {
                            updateStatus("Accelerando...", DARK_GREEN);
                        }
                    });
                    timerW.start();

                } else if (key == 's' && !keyPressedS) {
                    keyPressedS = true;
                    if (noKeyTimer != null) noKeyTimer.stop();

                    timerS = new Timer(100, ev -> {
                        int result = auto.deceleraAuto();
                        if (result == 777) {
                            updateStatus("Velocità troppo bassa per la marcia attuale!", DARK_RED);
                        } else if (auto.getVelocita() <= 0) {
                            updateStatus("Auto ferma", Color.BLUE);
                        } else {
                            updateStatus("Frenando...", Color.ORANGE);
                        }
                    });
                    timerS.start();

                } else if (!isAutomatica && (key == 'e' || key == 'q')) {
                    AutoManuale manuale = (AutoManuale) auto;
                    int result;
                    if (key == 'e') {
                        result = manuale.cambioMarcia(true);
                        if (result == 404) {
                            updateStatus("Non puoi aumentare oltre la 5ª marcia!", DARK_RED);
                        } else {
                            updateStatus("Marcia aumentata: " + result, DARK_GREEN);
                        }
                    } else {
                        result = manuale.cambioMarcia(false);
                        if (result == 404) {
                            updateStatus("Sei già in folle!", DARK_RED);
                        } else {
                            String marciaText = result == 0 ? "N" : String.valueOf(result);
                            updateStatus("Marcia ridotta: " + marciaText, Color.ORANGE);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyRelease(e, auto);
            }
        });
    }

    private static void handleKeyRelease(KeyEvent e, Auto auto) {
        if (e.getKeyChar() == 'w' ) {
            keyPressedW = false;
            if (timerW != null) timerW.stop();
            updateStatus("Rilasciato acceleratore", Color.GRAY);
        } else if (e.getKeyChar() == 's') {
            keyPressedS = false;
            if (timerS != null) timerS.stop();
            updateStatus("Rilasciato freno", Color.GRAY);
        }

        if (!keyPressedW && !keyPressedS) {
            startNoKeyTimer(auto);
        }
    }

    private static void startNoKeyTimer(Auto auto) {
        if (noKeyTimer != null && noKeyTimer.isRunning()) {
            noKeyTimer.stop();
        }
        noKeyTimer = new Timer(900, event -> {
            auto.deceleraAuto();
            if (auto.getVelocita() <= 0) {
                noKeyTimer.stop();
                updateStatus("Auto ferma", Color.BLUE);
            }
        });
        noKeyTimer.setRepeats(true);
        noKeyTimer.start();
    }

    private static void updateStatus(String message, Color color) {
        statusMessage.setText(message);
        statusMessage.setForeground(color);
    }

    private static String[] autoInfo() {
        JDialog info = new JDialog((JFrame) null, "Inserisci informazioni automobile", true);
        info.setSize(500, 300);
        info.setLayout(new GridLayout(4, 2, 10, 10));
        ((JComponent) info.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JTextField brandField = new JTextField("", 15);
        JTextField modelField = new JTextField("", 15);
        JTextField colorField = new JTextField("", 15);
        JButton confirmButton = new JButton("Conferma");
        confirmButton.setBackground(new Color(100, 180, 100));
        confirmButton.setForeground(Color.GRAY);

        JLabel brandLabel = new JLabel("Marca:");
        JLabel modelLabel = new JLabel("Modello:");
        JLabel colorLabel = new JLabel("Colore:");
        Font labelFont = new Font("Arial", Font.BOLD, 14);
        brandLabel.setFont(labelFont);
        modelLabel.setFont(labelFont);
        colorLabel.setFont(labelFont);

        info.add(brandLabel);
        info.add(brandField);
        info.add(modelLabel);
        info.add(modelField);
        info.add(colorLabel);
        info.add(colorField);
        info.add(new JLabel());
        info.add(confirmButton);

        final String[] carInfo = new String[3];

        brandField.setText("Audi");
        modelField.setText("A4");
        colorField.setText("Nero");

        confirmButton.addActionListener(e -> {
            if (brandField.getText().trim().isEmpty() || 
                modelField.getText().trim().isEmpty() || 
                colorField.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(info, 
                    "Tutti i campi sono obbligatori!", 
                    "Errore", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            carInfo[0] = brandField.getText();
            carInfo[1] = modelField.getText();
            carInfo[2] = colorField.getText();
            info.dispose();
        });

        info.setLocationRelativeTo(null);
        info.setVisible(true);
        return carInfo;
    }

    private static boolean scegliTipoCambio() {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        JButton manualeButton = new JButton("Manuale");
        JButton automaticoButton = new JButton("Automatico");

        manualeButton.setBackground(new Color(200, 200, 200));
        automaticoButton.setBackground(new Color(180, 220, 180));

        buttonPanel.add(manualeButton);
        buttonPanel.add(automaticoButton);

        JPanel panel = new JPanel(new BorderLayout(0, 20));
        JLabel questionLabel = new JLabel("Che tipo di cambio vuoi usare?");
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(questionLabel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JDialog dialog = new JDialog((JFrame) null, "Tipo di Cambio", true);
        dialog.setSize(400, 200);
        dialog.add(panel);
        dialog.setLocationRelativeTo(null);

        final boolean[] result = {false};

        manualeButton.addActionListener(e -> {
            result[0] = false;
            dialog.dispose();
        });

        automaticoButton.addActionListener(e -> {
            result[0] = true;
            dialog.dispose();
        });

        dialog.setVisible(true);
        return result[0];
    }

    private static boolean avviaAuto() {
        JDialog avvia = new JDialog((JFrame) null, "Avvia Automobile", true);
        avvia.setSize(350, 200);
        avvia.setLayout(new BorderLayout());

        JLabel iconLabel = new JLabel();
        ImageIcon carIcon = new ImageIcon(MainGUI.class.getResource("/car_icon.png"));
        if (carIcon.getIconWidth() > 0) {
            iconLabel.setIcon(carIcon);
        } else {
            iconLabel.setText("🚗");
            iconLabel.setFont(new Font("Arial", Font.PLAIN, 48));
            iconLabel.setHorizontalAlignment(SwingConstants.CENTER);
        }

        JButton startButton = new JButton("Accendi il Motore");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setBackground(new Color(80, 160, 80));
        startButton.setForeground(Color.GRAY);
        startButton.setFocusPainted(false);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(startButton);

        avvia.add(iconLabel, BorderLayout.CENTER);
        avvia.add(buttonPanel, BorderLayout.SOUTH);

        final boolean[] result = {false};

        startButton.addActionListener(e -> {
            result[0] = true;
            avvia.dispose();
        });

        avvia.setLocationRelativeTo(null);
        avvia.setVisible(true);
        return result[0];
    }

    private static String marciaToString(int marcia) {
        return marcia == 0 ? "N" : String.valueOf(marcia);
    }
}
