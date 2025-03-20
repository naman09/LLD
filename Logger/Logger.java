import java.io.File;

public class Logger {
    private LogSink logSink;
    private LogLevel loggerLevel;
    private LogFormatter logFormatter;
    private String loggerName;
    private Logger(String loggerName) {
        this.logSink = new FileLogSink(new File("a.log"));
        this.loggerLevel = new DebugLogLevel();
        this.logFormatter = new DefaultLogFormat();
        this.loggerName = loggerName;
    }

    private static Logger loggerInstance;

    public static Logger getInstance(String loggerName) {
        if (loggerInstance == null) {
            loggerInstance = new Logger(loggerName);
        } 
        return loggerInstance;
    }

    private String formatMessage(String message) {
        // [timestamp][LEVEL]: message
        // [LEVEL]: message
        // [CLASS_NAME][FUNCTION_NAME][LEVEL]: message
        return this.logFormatter.apply(this.loggerLevel, this.loggerName, message);
    }

    public void log(LogLevel level, String message) {
        if (level.getValue() < loggerLevel.getValue()) {
            System.out.println("skipping message: " + message);
            return;
        }
        
        this.logSink.writeLog(formatMessage(message));
    }

    public void setLogSink(LogSink logSink) {
        this.logSink = logSink;
    }

    public void setLoggerLevel(LogLevel loggerLevel) {
        this.loggerLevel = loggerLevel;
    }
    public void setLogFormat(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }
}
