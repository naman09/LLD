package iterator;
public class ArrayIterator<T> implements Iterator<T> {
    private T[] collection;
    private Integer currIdx;
    
    public ArrayIterator(T[] collection) {
        this.collection = collection;
        currIdx = 0;
    }
    
    public Boolean hasNext() {
        return currIdx < this.collection.length;
    }
    public T next(){
        if (!hasNext()) {
            throw new UnsupportedOperationException("no more elements to iterate");
        }
        return this.collection[currIdx++];
    }
}
