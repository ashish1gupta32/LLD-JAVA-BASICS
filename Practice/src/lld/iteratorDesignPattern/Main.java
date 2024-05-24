package lld.iteratorDesignPattern;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookLibrary<Book> bookLibrary=new BookLibrary<>();
        bookLibrary.addBook(new Book("BOOK1","Author1",100));
        bookLibrary.addBook(new Book("BOOK2","Author2",100));
        bookLibrary.addBook(new Book("BOOK3","Author3",100));
        bookLibrary.addBook(new Book("BOOK4","Author4",100));

        Iterator<Book> bookIterator = bookLibrary.createIterator();

        while (bookIterator.hasNext()){
            Book book = bookIterator.next();
            System.out.println(book);
        }
    }
}
