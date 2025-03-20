package iterator;
public interface Aggregator<T> {
    Iterator<T> createIterator();
}
