import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
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
    
    private static final ArrayList<Auto> automobili = new ArrayList<>();
    private static final String GARAGE_FILE = "garage.txt";

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.err.println("Errore nell'impostazione del Look and Feel: " + e.getMessage());
        }

        caricaGarage();

        String[] autoInfo = autoInfo(); 
        boolean isAutomatica = scegliTipoCambio();
        Auto auto;

        if (isAutomatica) {
            auto = new AutoAutomatica(autoInfo[1], autoInfo[2], autoInfo[0]);
        } else {
            auto = new AutoManuale(autoInfo[1], autoInfo[2], autoInfo[0]);
        }
        
        automobili.add(auto);
        System.out.println("Auto aggiunta al garage. Totale auto: " + automobili.size());
        
        salvaGarage();

        if (avviaAuto()) {
            if (auto.accensioneMotore()) {
                createGUI(auto, isAutomatica);
            }
        }
    }

    private static void createGUI(Auto auto, boolean isAutomatica) {
        JFrame frame = new JFrame("Simulatore Automobile - " + auto.getModello());
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

        Timer guiUpdateTimer = new Timer(100, _ -> {
            int speed = auto.getVelocita();
            speedLabel.setText(String.valueOf(speed));
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
        JPanel panel = new JPanel(new GridLayout(1, 4, 10, 0));
        panel.setBorder(createTitledBorder("Informazioni Veicolo"));

        JLabel brandLabel = new JLabel("Marca: " + auto.getMarca());
        JLabel modelLabel = new JLabel("Modello: " + auto.getModello());
        JLabel maxSpeedLabel = new JLabel("Velocità Max: " + auto.getMaxSpeed() + " km/h");
        JLabel garageLabel = new JLabel("Auto nel garage: " + automobili.size());
        garageLabel.setFont(new Font("Arial", Font.BOLD, 12));

        panel.add(brandLabel);
        panel.add(modelLabel);
        panel.add(maxSpeedLabel);
        panel.add(garageLabel);

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

                    timerW = new Timer(100, _ -> {
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

                    timerS = new Timer(100, _ -> {
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
        noKeyTimer = new Timer(900, _ -> {
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
        ArrayList<String[]> autoSalvate = new ArrayList<>();

        File file = new File(GARAGE_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] parts = linea.split(";");
                    if (parts.length >= 3) {
                        autoSalvate.add(parts);
                    }
                }
            } catch (IOException e) {
                System.err.println("Errore nella lettura del garage: " + e.getMessage());
            }
        }

        JDialog dialog = new JDialog((JFrame) null, "Informazioni Automobile", true);
        dialog.setSize(500, 400);
        dialog.setLayout(new GridLayout(6, 2, 10, 10));
        ((JComponent) dialog.getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel existingLabel = new JLabel("Auto nel Garage:");
        JComboBox<String> comboGarage = new JComboBox<>();
        comboGarage.addItem("— Nessuna selezione —");

        for (String[] auto : autoSalvate) {
            comboGarage.addItem(auto[0] + " " + auto[1] + " (" + auto[2] + ")");
        }

        String[] marche = {"Audi", "BMW", "Mercedes", "Volkswagen", "Ford", "Toyota", "Honda", "Fiat", "Ferrari", "Lamborghini"};
        JComboBox<String> brandComboBox = new JComboBox<>(marche);
        brandComboBox.setEditable(true);

        JTextField modelField = new JTextField("A4");
        JTextField colorField = new JTextField("Nero");

        JButton confirmButton = new JButton("Conferma");

        JLabel brandLabel = new JLabel("Marca:");
        JLabel modelLabel = new JLabel("Modello:");
        JLabel colorLabel = new JLabel("Colore:");

        dialog.add(existingLabel);
        dialog.add(comboGarage);
        dialog.add(brandLabel);
        dialog.add(brandComboBox);
        dialog.add(modelLabel);
        dialog.add(modelField);
        dialog.add(colorLabel);
        dialog.add(colorField);
        dialog.add(new JLabel());
        dialog.add(confirmButton);

        final String[] carInfo = new String[3];

        comboGarage.addActionListener(e -> {
            int index = comboGarage.getSelectedIndex();
            if (index > 0) {
                String[] selected = autoSalvate.get(index - 1);
                brandComboBox.setSelectedItem(selected[0]);
                modelField.setText(selected[1]);
                colorField.setText(selected[2]);
            }
        });

        confirmButton.addActionListener(_ -> {
            String brand = (String) brandComboBox.getSelectedItem();
            String model = modelField.getText();
            String color = colorField.getText();

            if (brand == null || brand.trim().isEmpty() || model.trim().isEmpty() || color.trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog,
                    "Tutti i campi sono obbligatori!",
                    "Errore",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            carInfo[0] = brand.trim();
            carInfo[1] = model.trim();
            carInfo[2] = color.trim();
            dialog.dispose();
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
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

        manualeButton.addActionListener(_ -> {
            result[0] = false;
            dialog.dispose();
        });

        automaticoButton.addActionListener(_ -> {
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

        startButton.addActionListener(_ -> {
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
    
    public static int getNumeroAuto() {
        return automobili.size();
    }
    
    public static ArrayList<Auto> getAutomobili() {
        return new ArrayList<>(automobili);
    }
    
    public static boolean rimuoviAuto(int indice) {
        if (indice >= 0 && indice < automobili.size()) {
            automobili.remove(indice);
            salvaGarage();
            return true;
        }
        return false;
    }
    
    public static void salvaGarage() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(GARAGE_FILE))) {
            for (Auto auto : automobili) {
                if (auto != null) {
                    String tipo = (auto instanceof AutoAutomatica) ? "AUTOMATICA" : "MANUALE";
                    writer.println(auto.getMarca() + ";" + auto.getModello() + ";" + auto.getColore() + ";" + tipo);
                }
            }
            System.out.println("Garage salvato in " + GARAGE_FILE);
        } catch (IOException e) {
            System.err.println("Errore nel salvataggio del garage: " + e.getMessage());
        }
    }
    
    public static void caricaGarage() {
        File file = new File(GARAGE_FILE);
        if (!file.exists()) {
            System.out.println("File garage non trovato. Iniziando con garage vuoto.");
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(GARAGE_FILE))) {
            String line;
            int autoCaricate = 0;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    String marca = parts[0];
                    String modello = parts[1];
                    String colore = parts[2];
                    String tipo = parts[3];
                    
                    Auto auto;
                    if ("AUTOMATICA".equals(tipo)) {
                        auto = new AutoAutomatica(modello, colore, marca);
                    } else {
                        auto = new AutoManuale(modello, colore, marca);
                    }
                    
                    automobili.add(auto);
                    autoCaricate++;
                }
            }
            
            System.out.println("Caricate " + autoCaricate + " auto dal garage salvato.");
            
        } catch (IOException e) {
            System.err.println("Errore nel caricamento del garage: " + e.getMessage());
        }
    }
    
    public static void pulisciGarage() {
        automobili.clear();
        salvaGarage();
        System.out.println("Garage pulito!");
    }
    
    public static void esportaGarage(String nomeFile) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeFile))) {
            writer.println("=== GARAGE AUTOMOBILI ===");
            writer.println("Data: " + new java.util.Date());
            writer.println("Totale auto: " + automobili.size());
            writer.println();
            
            for (int i = 0; i < automobili.size(); i++) {
                Auto auto = automobili.get(i);
                if (auto != null) {
                    String tipo = (auto instanceof AutoAutomatica) ? "Automatica" : "Manuale";
                    writer.println((i+1) + ". " + auto.getMarca() + " " + auto.getModello() + 
                                 " - Colore: " + auto.getColore() + " - Cambio: " + tipo);
                }
            }
            
            System.out.println("Garage esportato in " + nomeFile);
        } catch (IOException e) {
            System.err.println("Errore nell'esportazione: " + e.getMessage());
        }
    }
}
