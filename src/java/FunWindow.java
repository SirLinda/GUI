import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

/**
 * The FunWindow class represents a simple Swing GUI window that allows users to input text
 * and counts the number of vowels and consonants as they type.
 *
 * @author Senzo Nkosi
 * @version 1.0
 */
public class FunWindow extends JFrame {

    private final JTextArea inputTextArea;
    private final JLabel outputLabel;

    /**
     * Constructs a new {@code FunWindow} with the necessary components and event listeners.
     */
    public FunWindow() {
        // Set up the JFrame
        super("Fun Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        // Create components
        inputTextArea = new JTextArea();
        inputTextArea.setLineWrap(true);
        inputTextArea.setWrapStyleWord(true);

        outputLabel = new JLabel("Type something:");

        // Set up layout using JPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(outputLabel, BorderLayout.NORTH);
        panel.add(new JScrollPane(inputTextArea), BorderLayout.CENTER);

        // Add components to JFrame
        add(panel);

        // Add DocumentListener to count vowels and consonants
        inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCounts();
            }
        });
    }

    /**
     * Updates the displayed counts of vowels and consonants based on the user's input.
     */
    private void updateCounts() {
        String inputText = inputTextArea.getText();
        int vowelCount = countVowels(inputText);
        int consonantCount = countConsonants(inputText);

        outputLabel.setText("Vowels: " + vowelCount + " | Consonants: " + consonantCount);
    }

    /**
     * Counts the number of vowels in the given text.
     *
     * @param text The input text.
     * @return The number of vowels in the text.
     */
    private int countVowels(String text) {
        // Count vowels in the text
        return (int) text.chars()
                .filter(c -> "aeiouAEIOU".indexOf(c) != -1)
                .count();
    }

    /**
     * Counts the number of consonants in the given text.
     *
     * @param text The input text.
     * @return The number of consonants in the text.
     */
    private int countConsonants(String text) {
        // Count consonants in the text
        return (int) text.codePoints()
                .filter(c -> Character.isLetter(c) && "aeiouAEIOU".indexOf(c) == -1)
                .count();
    }

    /**
     * The main method to launch the FunWindow.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FunWindow funWindow = new FunWindow();
            funWindow.setVisible(true);
        });
    }
}