import java.awt.event.*;  // Per gestire gli eventi
import javax.swing.*;     // Per i componenti della GUI

public class SimpleGUI implements ActionListener {

    // Dichiarazione dei componenti della GUI
    private JFrame frame;
    private JButton button;
    private JLabel label;
    
    // Costruttore per creare l'interfaccia
    public SimpleGUI() {
        // Creazione della finestra
        frame = new JFrame("Simple GUI Example");
        frame.setSize(300, 200);  // Imposta la dimensione della finestra
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Permette di chiudere la finestra

        // Creazione di un'etichetta
        label = new JLabel("Clicca il pulsante!", SwingConstants.CENTER);

        // Creazione di un pulsante
        button = new JButton("Clicca qui");
        button.addActionListener(this);  // Registra il listener per il pulsante

        // Aggiungi i componenti al frame
        frame.getContentPane().add(label, "North");
        frame.getContentPane().add(button, "South");

        // Rendi visibile la finestra
        frame.setVisible(true);
    }

    // Metodo chiamato quando il pulsante viene cliccato
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pulsante cliccato!");
        label.setText("Hai cliccato il pulsante!");
    }

    // Metodo principale per avviare l'applicazione
    public static void main(String[] args) {
        new SimpleGUI();  // Crea un'istanza della GUI
    }
}
