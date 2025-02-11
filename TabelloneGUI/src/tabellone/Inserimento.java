import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;

public class Inserimento extends javax.swing.JFrame {

    public static int secondi;
    public static int secondiIniziali;

    // Constructor
    public Inserimento() {
        initComponents();

        // Set sizes for text fields
        nomeCasaText.setSize(200, 100);
        allenatoreCasaText.setSize(200, 100);
        dirigenteCasaText.setSize(200, 100);

        nomeOspiteText.setSize(200, 100);
        allenatoreOspiteText.setSize(200, 100);
        dirigenteOspiteText.setSize(200, 100);
    }

    // Initialization of components (auto-generated code by Swing Designer)
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // Dialogs
        dialogCampiMancanti = new javax.swing.JDialog();
        dialogCampiMancanti.setModal(true);
        dialogCampiMancanti.setSize(320, 150);

        campiMancanti = new javax.swing.JLabel("È necessario inserire tutti i dati richiesti.");
        okCampiMancanti = new javax.swing.JButton("Ok");
        okCampiMancanti.addActionListener(evt -> dialogCampiMancanti.dispose());

        dialogCaratteriNonValidi = new javax.swing.JDialog();
        dialogCaratteriNonValidi.setModal(true);
        dialogCaratteriNonValidi.setSize(320, 150);

        caratteriNonValidi = new javax.swing.JLabel("Non puoi inserire caratteri nello spazio del timer.");
        okCaratteriNonValidi = new javax.swing.JButton("Ok");
        okCaratteriNonValidi.addActionListener(evt -> dialogCaratteriNonValidi.dispose());

        // Main Frame Components
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(400, 150);

        inserimentoSquadre = new JLabel("INSERIMENTO SQUADRE");
        squadraCasa = new JLabel("Squadra in casa");
        squadraOspite = new JLabel("Squadra ospite");
        nomeCasa = new JLabel("Nome");
        nomeOspite = new JLabel("Nome");
        allenatoreCasa = new JLabel("Allenatore");
        allenatoreOspite = new JLabel("Allenatore");
        dirigenteCasa = new JLabel("Dirigente");
        dirigenteOspite = new JLabel("Dirigente");
        tempoInSecondi = new JLabel("Tempo (Secondi)");

        // Text Fields
        nomeCasaText = new JTextField();
        nomeOspiteText = new JTextField();
        allenatoreCasaText = new JTextField();
        allenatoreOspiteText = new JTextField();
        dirigenteCasaText = new JTextField();
        dirigenteOspiteText = new JTextField();
        tempoInSecondiText = new JTextField();

        // Button
        creaSquadre = new JButton("Crea squadre");
        creaSquadre.addActionListener(evt -> creaSquadreActionPerformed());

        // Layout
        layoutComponents();
    }

    private void layoutComponents() {
        // Layout setup (GridBagLayout for flexibility)
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(squadraCasa)
                    .addComponent(nomeCasa)
                    .addComponent(allenatoreCasa)
                    .addComponent(dirigenteCasa)
                    .addComponent(nomeCasaText)
                    .addComponent(allenatoreCasaText)
                    .addComponent(dirigenteCasaText))
                .addGap(100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(squadraOspite)
                    .addComponent(nomeOspite)
                    .addComponent(allenatoreOspite)
                    .addComponent(dirigenteOspite)
                    .addComponent(nomeOspiteText)
                    .addComponent(allenatoreOspiteText)
                    .addComponent(dirigenteOspiteText))
                .addGap(50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tempoInSecondi)
                    .addComponent(tempoInSecondiText))
                .addGap(50))
            .addGroup(layout.createSequentialGroup()
                .addGap(200)
                .addComponent(inserimentoSquadre))
            .addGroup(layout.createSequentialGroup()
                .addGap(250)
                .addComponent(creaSquadre))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGap(20)
            .addComponent(inserimentoSquadre)
            .addGap(30)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(squadraCasa)
                .addComponent(squadraOspite)
                .addComponent(tempoInSecondi))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nomeCasa)
                .addComponent(nomeOspite)
                .addComponent(tempoInSecondiText))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(nomeCasaText)
                .addComponent(nomeOspiteText))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(allenatoreCasa)
                .addComponent(allenatoreOspite))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(allenatoreCasaText)
                .addComponent(allenatoreOspiteText))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dirigenteCasa)
                .addComponent(dirigenteOspite))
            .addGap(20)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(dirigenteCasaText)
                .addComponent(dirigenteOspiteText))
            .addGap(30)
            .addComponent(creaSquadre)
            .addGap(20)
        );

        pack();
    }

    // Event Handlers
    private void creaSquadreActionPerformed() {
        boolean isInteger = Pattern.matches("^\\d*$", tempoInSecondiText.getText());

        if (nomeCasaText.getText().isEmpty() || allenatoreCasaText.getText().isEmpty() || dirigenteCasaText.getText().isEmpty() ||
            nomeOspiteText.getText().isEmpty() || allenatoreOspiteText.getText().isEmpty() || dirigenteOspiteText.getText().isEmpty() ||
            tempoInSecondiText.getText().isEmpty()) {
            dialogCampiMancanti.setVisible(true);
        } else if (!isInteger) {
            tempoInSecondiText.setText("");
            dialogCaratteriNonValidi.setVisible(true);
        } else {
            Squadra squadraCasa = new Squadra(nomeCasaText.getText(), allenatoreCasaText.getText(), dirigenteCasaText.getText());
            Squadra squadraOspite = new Squadra(nomeOspiteText.getText(), allenatoreOspiteText.getText(), dirigenteOspiteText.getText());
            Partita partita = new Partita(squadraCasa, squadraOspite);

            Inserimento.secondi = Integer.parseInt(tempoInSecondiText.getText());
            Inserimento.secondiIniziali = Inserimento.secondi;

            TabelloneFinestra tabellone = new TabelloneFinestra(partita, Inserimento.secondi);
            tabellone.setVisible(true);
            this.dispose();
        }
    }

    // Variables declaration
    private javax.swing.JLabel inserimentoSquadre, squadraCasa, squadraOspite, nomeCasa, nomeOspite, allenatoreCasa, allenatoreOspite, dirigenteCasa, dirigenteOspite, tempoInSecondi;
    private javax.swing.JTextField nomeCasaText, nomeOspiteText, allenatoreCasaText, allenatoreOspiteText, dirigenteCasaText, dirigenteOspiteText, tempoInSecondiText;
    private javax.swing.JButton creaSquadre, okCampiMancanti, okCaratteriNonValidi;
    private javax.swing.JLabel campiMancanti, caratteriNonValidi;
    private javax.swing.JDialog dialogCampiMancanti, dialogCaratteriNonValidi;
}
