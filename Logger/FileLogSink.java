import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//singleton and also file needs to be rotated after a size
public class FileLogSink implements LogSink {
    File logFile;
    FileLogSink(File logFile) {
        this.logFile = logFile;
    }
    public void writeLog(String message) {
        System.out.println("writing message to file: " + message);
        try(FileWriter writer = new FileWriter(this.logFile, true)) {
            writer.write(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 