package ra.springmvc_books.repository;

import ra.springmvc_books.model.Book;

import java.util.List;

public interface Repository {
    List<Book> findAll();
    boolean save(Book book);
    Book getBook(int bookId);
    boolean update(Book book);
    boolean delete (int bookId);
}
