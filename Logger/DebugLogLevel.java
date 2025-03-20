public class DebugLogLevel extends LogLevel {
    public static final LogLevel DEBUG = new DebugLogLevel();  
    public DebugLogLevel() {
        super(3);
    }
}
