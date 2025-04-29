package giofe;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PartitaGUI {
    public PartitaGUI(TabelloneCalcio partita, Campionato campionato) {
        JFrame frame = new JFrame("Simulazione Partita");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel labelCasa = new JLabel("Squadra di casa: " + partita.getSquadraCasa().getNome());
        JLabel labelOspite = new JLabel("Squadra ospite: " + partita.getSquadraOspite().getNome());
        JLabel puntiCasaLabel = new JLabel("Punti squadra di casa:");
        JLabel puntiOspiteLabel = new JLabel("Punti squadra ospite:");

        JLabel puntiCasa = new JLabel(String.valueOf(partita.getPuntiCasa()));
        JLabel puntiOspite = new JLabel(String.valueOf(partita.getPuntiOspite()));

        JButton aggiungiPuntiCasa = new JButton("Aggiungi punto casa");
        JButton aggiungiPuntiOspite = new JButton("Aggiungi punto ospite");
        JButton finePartita = new JButton("Fine partita");

        aggiungiPuntiCasa.addActionListener(e -> {
            partita.incrementaCasa();
            puntiCasa.setText(String.valueOf(partita.getPuntiCasa()));
        });

        aggiungiPuntiOspite.addActionListener(e -> {
            partita.incrementaOspiti();
            puntiOspite.setText(String.valueOf(partita.getPuntiOspite()));
        });

        finePartita.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Partita terminata!\n" +
                    "Punti squadra di casa: " + partita.getPuntiCasa() + "\n" +
                    "Punti squadra ospite: " + partita.getPuntiOspite());
            partita.assegnaPunti();
            campionato.ordinaCompionato(); 
            campionato.salvaCampionatoSuFile();
            frame.dispose();
        });

        panel.add(labelCasa);
        panel.add(labelOspite);
        panel.add(puntiCasaLabel);
        panel.add(puntiCasa);
        panel.add(puntiOspiteLabel);
        panel.add(puntiOspite);
        panel.add(aggiungiPuntiCasa);
        panel.add(aggiungiPuntiOspite);
        panel.add(new JLabel()); 
        panel.add(finePartita);

        frame.add(panel);
        frame.setVisible(true);
    }
}
