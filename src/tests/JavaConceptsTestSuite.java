import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Senzo Nkosi
 * @version 1.0
 */
public class JavaConceptsTestSuite {
    @Test
    void testEvenAndOddNumbers() {
        // Test Part 1: Numbers Magic (Streams and Filters)
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("numbers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.split("\\s+");
                for (String number : numbers) {
                    int num = Integer.parseInt(number);
                    if (num % 2 == 0) {
                        evenNumbers.add(num);
                    } else {
                        oddNumbers.add(num);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(Arrays.asList(2, 4, 6, 8), evenNumbers);
        Assertions.assertEquals(Arrays.asList(1, 3, 5, 7, 9), oddNumbers);
    }
    @Test
    void testVowelAndConsonantCounter() {
        // Test Part 2: Fun Window (GUI with Swing)
        JTextArea textArea = new JTextArea();
        textArea.setText("Hello, Java!");
        int vowels = 0;
        int consonants = 0;
        String text = textArea.getText().toLowerCase();
        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        Assertions.assertEquals(4, vowels);
        Assertions.assertEquals(5, consonants);
    }
    @Test
    void testLoggerInstance() {
        // Test Part 3: Secret Keeper (Singleton Design Pattern)
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        Assertions.assertSame(logger1, logger2);
    }
    @Test
    void testConcurrency() {
        // Test Part 4: Speed Counter (Concurrency)
        Counter counter = new Counter();
        int numThreads = 5;
        Thread[] threads = new Thread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Assertions.assertEquals(5000, counter.getCount());
    }
}
