public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        HashTable<String, Integer> hs = new HashTable<>();
        hs.put("A", 1);
        hs.put("A", 5);
        hs.put("B", 3);

        System.out.println(hs.get("C"));
        System.out.println(hs.get("A"));

        // hs.display();


        ResizableHashTable<String, Integer> rhs = new ResizableHashTable<>();

        rhs.put("A", 2);
        rhs.put("B", 1);
        rhs.put("C", 1);
        // rhs.put("D", 1);
        // rhs.put("E", 1);
        // rhs.put("F", 1);
        rhs.put("G", 1);
        rhs.put("A", 3);
        rhs.put("A", 5);
        rhs.put("A", 20);

        // rhs.display();

        HashTable2<String, Integer> hs2 = new HashTable2<>();

        hs2.put("A", 1);
        System.out.println("value:" + hs2.get("A"));
        hs2.put("A", 2);

        System.out.println("value:" + hs2.get("A"));
        hs2.put("A", 3);
        System.out.println("value:" + hs2.get("A"));
        hs2.put("A", 4);
        hs2.put("A", 5);
        System.out.println("value:" + hs2.get("B"));
        hs2.put("B", 5);
        hs2.put("C", 5);
        // hs2.put("D", 5);
        System.out.println("value:" + hs2.get("A"));

        hs2.display();
    }
}
