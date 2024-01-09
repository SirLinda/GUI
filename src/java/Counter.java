/**
 * The Counter class represents a simple counter with thread-safe incrementation.
 * It can be used in a multithreaded environment where the count needs to be updated safely.
 *
 * @author Senzo Nkosi
 * @version 1.0
 */
public class Counter {
    private int count;
    private static final int START;

    static {
        START = 0;
    }

    /**
     * Constructs a new Counter with an initial count of 0.
     */
    public Counter() {
        this.count = START;
    }

    /**
     * Increments the counter in a thread-safe manner.
     */
    public synchronized void increment() {
        count++;
    }

    /**
     * Gets the current count of the counter.
     *
     * @return The current count of the counter.
     */
    public int getCount() {
        return count;
    }
}