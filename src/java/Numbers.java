import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Numbers class reads numbers from a file, filters them into even and odd groups,
 * and prints the results.
 * It provides methods to read numbers from a file, filter even and odd numbers, and a main method
 * to execute the processing and display the results.
 *
 *
 * @author Senzo Nkosi
 * @version 1.0
 */
public class Numbers {

    private static final int NONE;
    private static final int TWO_DIVISOR;

    static {
        NONE = 0;
        TWO_DIVISOR = 2;
    }

    /**
     * Reads numbers from the file specified by "numbers.txt".
     *
     * @return A list of integers read from the file.
     */
    private static List<Integer> readNumbersFromFile() {
        List<Integer> numbers = null;
        try (BufferedReader br = new BufferedReader(new FileReader("numbers.txt"))) {
            String line = br.readLine();
            numbers = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }

    /**
     * Filters even numbers from the given list.
     *
     * @param numbers The list of numbers to be filtered.
     * @return A list of even numbers.
     */
    private static List<Integer> filterEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % TWO_DIVISOR == NONE)
                .collect(Collectors.toList());
    }

    /**
     * Filters odd numbers from the given list.
     *
     * @param numbers The list of numbers to be filtered.
     * @return A list of odd numbers.
     */
    private static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % TWO_DIVISOR != NONE)
                .collect(Collectors.toList());
    }

    /**
     * The main method to read numbers from the file, filter even and odd numbers, and print the results.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Step 1: Read numbers from the file
        List<Integer> numbers = readNumbersFromFile();

        // Step 2: Filter even and odd numbers
        List<Integer> evenNumbers = filterEvenNumbers(numbers);
        List<Integer> oddNumbers = filterOddNumbers(numbers);

        // Step 3: Print the results
        System.out.println("Even Numbers: " + evenNumbers);
        System.out.println("Odd Numbers: " + oddNumbers);
    }
}
