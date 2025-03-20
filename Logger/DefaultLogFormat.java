import java.time.LocalDateTime;

public class DefaultLogFormat implements LogFormatter {
    public String apply(LogLevel logLevel, String loggerName, String message) {
        return LocalDateTime.now().toString() + ": " + message;
    }
}
