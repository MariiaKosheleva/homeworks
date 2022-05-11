package ua.kosheleva.hw16;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private final T[] array;
    private int elementIndex;

    public ArrayIterator(T[] array) {
        this.array = array;
        elementIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return elementIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Reached the end of array");
        }
        return array[elementIndex++];
    }

}
