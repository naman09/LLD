package iterator;
public class Main {
    public static void main(String[] args) {
        Integer[] l = new Integer[] {1, 4, 6, 7, 10};
        MyCollection<Integer> mc = new MyCollection<>(l);

        Iterator<Integer> it = mc.createIterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
