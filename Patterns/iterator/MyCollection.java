package iterator;
public class MyCollection<T> implements Aggregator<T> {
    private T[] myCollection;
    public MyCollection(T[] myCollection) {
        this.myCollection = myCollection;
    }
    public Iterator<T> createIterator() {
        return new ArrayIterator<T>(this.myCollection);
    }
}
