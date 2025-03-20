import java.util.LinkedList;

public class ResizableHashTable<K,V> {
    private LinkedList<Entry<K,V>>[] table;
    private final Integer INITIAL_SIZE = 5;
    private final Double LOAD_FACTOR_THRESHOLD = 0.7;
    private Integer size;

    public ResizableHashTable() {
        table = new LinkedList[INITIAL_SIZE];
        size = 0;
        for(Integer i=0;i<INITIAL_SIZE;i++) {
            table[i] = new LinkedList<>();
        }
    }

    private Integer getHashCode(K key) {
        return key.hashCode() % table.length;
    }

    private void resize() {
        System.out.println("Resizing");
        Integer newTableLen = table.length * 2;
        LinkedList<Entry<K,V>>[] newTable = new LinkedList[newTableLen];
        for(Integer i=0;i<newTableLen;i++) {
            newTable[i] = new LinkedList<>();
        }
        for(Integer i=0;i<table.length;i++) {
            LinkedList<Entry<K,V>> bucket = table[i];
            for(Entry<K,V> entry : bucket) {
                Integer newTableIdx = getHashCode(entry.key);
                newTable[newTableIdx].add(new Entry<>(entry.key, entry.val));
            }
        } 
        table = newTable;
    }

    public void put(K key, V val) {
        if ((double)size/table.length > LOAD_FACTOR_THRESHOLD) {
            System.out.println("size:" + size);
            resize();
        }
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];

        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.val = val;
                return;
            }
        }
        bucket.add(new Entry<>(key, val));
        size++;
    }

    public V get(K key) {
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];

        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.val;
            }
        }
        return null;
    }

    public Boolean remove(K key) {
        Integer tableIdx = getHashCode(key);
        LinkedList<Entry<K,V>> bucket = table[tableIdx];

        for(Entry<K,V> entry : bucket) {
            if (entry.key.equals(key)) {
                bucket.remove(entry);
                size--;
                return true;
            }
        }
        return false;
    }

    public void display() {
        for(Integer i=0;i<table.length;i++) {
            LinkedList<Entry<K,V>> bucket = table[i];
            for(Entry<K,V> entry : bucket) {
                System.out.println("Key: " + entry.key.toString() + " Val: " + entry.val.toString());
            }
        }
    }
}
