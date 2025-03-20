import java.util.Map;
import java.util.function.Consumer;
import java.util.HashMap;


public class LRUPolicy implements EvictionPolicy {
    Map<String, Node> keyNodeMap;
    DLL recentlyUsedList;

    LRUPolicy() {
        this.keyNodeMap = new HashMap<>();
        recentlyUsedList = new DLL();
    }

    public String evict(Consumer<String> removeKeyCallback) {
        Node evictNode = this.recentlyUsedList.getTail();
        String evictKey = evictNode.data;
        removeKeyCallback.accept(evictKey);
        this.recentlyUsedList.removeNode(evictNode);
        return evictKey;
    }

    public void refreshKey(String key) {
        if (this.keyNodeMap.containsKey(key)) {
            Node node = keyNodeMap.get(key);
            this.recentlyUsedList.removeNode(node);   
        }
        this.recentlyUsedList.addFront(key);
        keyNodeMap.put(key, this.recentlyUsedList.getHead());    
    }
}
