package giofe;

import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainGUI {
    public static void main(String[] args) {
        verificaDirectory();
        Campionato campionato = new Campionato();
        campionato.caricaCampionatoDaFile();

        JFrame menuFrame = new JFrame("Menu Campionato");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(400, 300);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(6, 1));

        JButton aggiungiSquadraButton = new JButton("Aggiungi una squadra");
        JButton rimuoviSquadraButton = new JButton("Rimuovi una squadra");
        JButton visualizzaClassificaButton = new JButton("Visualizza classifica");
        JButton simulaPartitaButton = new JButton("Simula una partita");
        JButton esciButton = new JButton("Esci");

        aggiungiSquadraButton.addActionListener(e -> {
            JFrame aggiungiFrame = new JFrame("Aggiungi Squadra");
            aggiungiFrame.setSize(300, 200);
            JPanel aggiungiPanel = new JPanel(new GridLayout(4, 2));

            JLabel nomeLabel = new JLabel("Nome:");
            JTextField nomeField = new JTextField();
            JLabel provenienzaLabel = new JLabel("Provenienza:");
            JTextField provenienzaField = new JTextField();
            JLabel coloreLabel = new JLabel("Colore:");
            JTextField coloreField = new JTextField();
            JButton confermaButton = new JButton("Conferma");

            confermaButton.addActionListener(ev -> {
            String nome = nomeField.getText();
            String provenienza = provenienzaField.getText();
            String colore = coloreField.getText();
            if (verificaSquadra(campionato, nome)) {
                campionato.aggiungiSquadra(new Squadra(nome, provenienza, colore));
                aggiungiFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(aggiungiFrame, "Squadra già presente nel campionato");
            }
            });

            aggiungiPanel.add(nomeLabel);
            aggiungiPanel.add(nomeField);
            aggiungiPanel.add(provenienzaLabel);
            aggiungiPanel.add(provenienzaField);
            aggiungiPanel.add(coloreLabel);
            aggiungiPanel.add(coloreField);
            aggiungiPanel.add(new JLabel());
            aggiungiPanel.add(confermaButton);

            aggiungiFrame.add(aggiungiPanel);
            aggiungiFrame.setVisible(true);
        });

        rimuoviSquadraButton.addActionListener(e -> {
            JFrame rimuoviFrame = new JFrame("Rimuovi Squadra");
            rimuoviFrame.setSize(300, 200);
            JPanel rimuoviPanel = new JPanel(new GridLayout(campionato.getCampionato().size() + 1, 1));

            for (Squadra squadra : campionato.getCampionato()) {
            JButton squadraButton = new JButton(squadra.getNome());
            squadraButton.addActionListener(ev -> {
                campionato.rimuoviSquadra(squadra.getNome());
                rimuoviFrame.dispose();
            });
            rimuoviPanel.add(squadraButton);
            }

            rimuoviFrame.add(rimuoviPanel);
            rimuoviFrame.setVisible(true);
        });

        visualizzaClassificaButton.addActionListener(e -> {
            JFrame classificaFrame = new JFrame("Classifica");
            classificaFrame.setSize(300, 400);
            JPanel classificaPanel = new JPanel(new GridLayout(campionato.getCampionato().size(), 1));

            for (Squadra squadra : campionato.getCampionato()) {
            JLabel squadraLabel = new JLabel(squadra.getNome() + " - Punti: " + squadra.getPunti());
            classificaPanel.add(squadraLabel);
            }

            classificaFrame.add(classificaPanel);
            classificaFrame.setVisible(true);
        });

        simulaPartitaButton.addActionListener(e -> {
            JFrame simulaFrame = new JFrame("Simula Partita");
            simulaFrame.setSize(400, 300);
            JPanel simulaPanel = new JPanel(new GridLayout(3, 2));

            JLabel casaLabel = new JLabel("Squadra di casa:");
            JComboBox<String> casaComboBox = new JComboBox<>();
            JLabel ospiteLabel = new JLabel("Squadra ospite:");
            JComboBox<String> ospiteComboBox = new JComboBox<>();
            JButton avviaPartitaButton = new JButton("Avvia Partita");

            for (Squadra squadra : campionato.getCampionato()) {
            casaComboBox.addItem(squadra.getNome());
            ospiteComboBox.addItem(squadra.getNome());
            }

            avviaPartitaButton.addActionListener(ev -> {
            String casa = (String) casaComboBox.getSelectedItem();
            String ospite = (String) ospiteComboBox.getSelectedItem();

            Squadra squadraCasa = campionato.getSquadra(casa);
            Squadra squadraOspite = campionato.getSquadra(ospite);

            if (squadraCasa != null && squadraOspite != null && !casa.equals(ospite)) {
                TabelloneCalcio partita = new TabelloneCalcio(squadraCasa, squadraOspite);
                new PartitaGUI(partita, campionato); 
                simulaFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(simulaFrame, "Seleziona squadre valide.");
            }
            });

            simulaPanel.add(casaLabel);
            simulaPanel.add(casaComboBox);
            simulaPanel.add(ospiteLabel);
            simulaPanel.add(ospiteComboBox);
            simulaPanel.add(new JLabel());
            simulaPanel.add(avviaPartitaButton);

            simulaFrame.add(simulaPanel);
            simulaFrame.setVisible(true);
        });

        esciButton.addActionListener(e -> {
            campionato.salvaCampionatoSuFile();
            menuFrame.dispose();
            System.exit(0);
        });

        menuPanel.add(aggiungiSquadraButton);
        menuPanel.add(rimuoviSquadraButton);
        menuPanel.add(visualizzaClassificaButton);
        menuPanel.add(simulaPartitaButton);
        menuPanel.add(esciButton);

        menuFrame.add(menuPanel);
        menuFrame.setVisible(true);
    }

    public static boolean verificaSquadra(Campionato campionato, String nome) {
        for (Squadra squadra : campionato.getCampionato()) {
            if (squadra.getNome().equalsIgnoreCase(nome)) {
                return false; 
            }
        }
        return true; 
    }

    public static void verificaDirectory(){
        try {
            File directory = new File("./data");
            if(!directory.exists()){
                if(directory.mkdir()){
                    File file = new File("./data/data.json");
                    if(!file.exists()){
                        if(file.createNewFile()){
                            
                        }
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
