package singleton;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Logger logger = Logger.getInstance();
        
        List<Thread> jobThreads = new ArrayList<>();
        for(int i=0;i<100;i++) {
            Thread t  = new Thread(() -> {
                try {
                    Logger.getInstance();
                } catch(Exception e) {}
            });
            jobThreads.add(t);
            t.start();
        }

        for(int i=0; i < jobThreads.size(); i++) {
            jobThreads.get(i).join();
        }

        Thread t = new Thread(Logger.getInstance()::execJob);
        t.start();
        t.join();
    }
}
