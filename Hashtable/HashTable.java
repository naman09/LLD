import java.util.LinkedList;

public class HashTable<K,V> {
    LinkedList<Entry<K, V>>[] table;
    private final static Integer INITIAL_SIZE = 5;

    HashTable() {
        table = new LinkedList[INITIAL_SIZE];
        for(Integer i=0;i<INITIAL_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }
    Integer getHashCode(K key) {
        return key.hashCode() % table.length;
    }

    void put(K key, V val) {
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];
        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.val = val;
                return;
            }
        }
        bucket.add(new Entry<>(key, val));
    }
    V get(K key) {
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];
        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.val;
            }
        }
        return null;
    }
    Boolean remove(K key) {
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];
        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                return true;
            }
        }
        return false;
    }

    void display() {
        for(Integer i=0;i<table.length;i++) {
            LinkedList<Entry<K,V>> bucket = table[i];
            for(Entry<K,V> entry : bucket) {
                System.out.println("Key: " + entry.key.toString() + " Val: " + entry.val.toString());
            }
        }
    }
}
