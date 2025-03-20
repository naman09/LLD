import java.util.function.Consumer;

public interface EvictionPolicy {
    public String evict(Consumer<String> removeKeyCallback);
    public void refreshKey(String key);
}
