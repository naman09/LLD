// Open addressing
public class HashTable2<K,V> {
    Entry<K,V>[] table;
    private final Integer INITIAL_SIZE = 4;
    private final Double LOAD_FACTOR_THRESHOLD = 0.75;
    private Integer size;

    HashTable2() {
        table = new Entry[INITIAL_SIZE];
        size = 0;
    }

    private void resize() {
        System.out.println("resizing");
        Integer newTableLen = table.length * 2;
        Entry<K,V>[] oldTable = table;
        table = new Entry[newTableLen];
        
        for(Entry<K,V> entry : oldTable) {
            put(entry.key, entry.val);
        }
    }
    private Integer getHash(K key) {
        return Math.abs(key.hashCode() % table.length);
    }

    void put(K key, V val) {
        if ((double)size/table.length > LOAD_FACTOR_THRESHOLD) {
            resize();
        }
        Integer idx = getHash(key);

        // probe
        while (table[idx] != null && table[idx].key != null && !table[idx].key.equals(key)) {
            idx = (idx + 1) % table.length;
        }

        if (table[idx] == null || table[idx].key == null) {
            size++;
        }
        table[idx] = new Entry<>(key, val);
    }

    V get(K key) {
        Integer idx = getHash(key);

        // probe
        while (table[idx] != null) {
            if (table[idx].key != null && table[idx].key.equals(key)) {
                return table[idx].val;
            }
            idx = (idx + 1) % table.length;
        }
        return null;
    }

    void remove(K key) {
        Integer idx = getHash(key);

        // probe
        while (table[idx] != null) {
            if (table[idx].key != null && !table[idx].key.equals(key)) {
                size--;
                table[idx].key = null; // to allow probing to continue for later elements
                return;
            }
            idx = (idx + 1) % table.length;
        }
    }

    void display() {
        for (Entry<K, V> entry : table) {
            if (entry != null && entry.key != null) {
                System.out.println(entry.key.toString() + ": " + entry.val.toString());
            }
        }
    }
}
