public interface LogFormatter {
    public String apply(LogLevel logLevel, String loggerName, String message);
}
