import java.util.ArrayList;
import java.util.List;

/**
 * The Logger class represents a singleton logger for recording and accessing secrets.
 * It provides a mechanism to record even and odd numbers securely and maintains a list of recorded secrets.
 * The class follows the Singleton design pattern to ensure a single instance is created.
 *
 * @author Senzo Nkosi
 * @version 1.0
 */
public class Logger {

    private static Logger instance;
    private final List<String> secrets;

    /**
     * Private constructor to prevent multiple instances.
     */
    private Logger() {
        secrets = new ArrayList<>();
    }

    /**
     * Gets the single instance of the Logger.
     *
     * @return The single instance of the Logger.
     */
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Gets the list of recorded secrets.
     *
     * @return The list of recorded secrets.
     */
    public List<String> getSecrets() {
        return secrets;
    }
}
