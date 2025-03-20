package singleton;
import java.util.concurrent.*;

public class Logger {
    private Logger() {

    }

    private static Logger loggerInstance;
    private static final Semaphore sem = new Semaphore(1);

    public static Logger getInstance() throws InterruptedException {
        if (loggerInstance == null) {
            sem.acquire();
            if (loggerInstance == null) {
                System.out.println("creating instance");
                loggerInstance = new Logger();
            } else {
                System.out.println("reusing instance 2");
            }
            sem.release();
        } else {
            System.out.println("reusing instance");
        }

        return loggerInstance;
    }

    public void execJob() {
        System.out.println("hello");
    }
    
}
