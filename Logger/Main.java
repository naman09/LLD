public class Main {
    public static void main(String[] args) {
        /*
         * Logging Levels
         * Log Sinks
         * Logger
         */

        Logger logger = Logger.getInstance(Main.class.getName());
        logger.log(DebugLogLevel.DEBUG, "hello");
        logger.log(new InfoLogLevel(), "dwadad");

        logger.setLoggerLevel(new InfoLogLevel());
        logger.setLogFormat((level, name, message)-> {
            return String.format("[%s - %s] %s", name, level, message);
        });

        logger.log(new DebugLogLevel(), "hello2");
        logger.log(new InfoLogLevel(), "dwadad2");
    }
}