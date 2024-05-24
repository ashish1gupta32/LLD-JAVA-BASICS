package lld.iteratorDesignPattern;

import java.util.Iterator;
import java.util.List;

public class LibraryIterator<T> implements Iterator<T> {
    private final List<T> bookList;
    private int index=0;
    LibraryIterator(List<T> bookList){
        this.bookList=bookList;
    }
    @Override
    public boolean hasNext() {
        return index<bookList.size();
    }

    @Override
    public T next() {
        return bookList.get(index++);
    }
}
