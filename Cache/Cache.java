import java.util.HashMap;
import java.util.Map;

public class Cache<T> {
    private Map<String, T> store;
    private EvictionPolicy evictionPolicy;
    private Integer capacity;

    Cache(Integer capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.evictionPolicy = evictionPolicy;
        this.store = new HashMap<>();
    }

    public T get(String key) {
        T value = this.store.get(key);
        this.evictionPolicy.refreshKey(key);
        return value;
    }

    public void put(String key, T value) {
        if (store.containsKey(key)) {
            store.put(key, value);
        } else {
            if (store.size() == capacity) {
                String evictKey = evictionPolicy.evict((someKey) -> this.store.remove(someKey));
                // this.store.remove(evictKey);
            }
            store.put(key, value);
        }
        evictionPolicy.refreshKey(key);
    }
}
