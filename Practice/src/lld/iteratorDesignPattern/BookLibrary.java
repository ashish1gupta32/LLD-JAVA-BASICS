package lld.iteratorDesignPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookLibrary<T> {
    private List<T> bookList;

    public BookLibrary(){
        this.bookList=new ArrayList<>();
    }
    public void addBook(T book){
        bookList.add(book);
    }
    public Iterator<T> createIterator(){
        return new LibraryIterator(bookList);
    }
}
