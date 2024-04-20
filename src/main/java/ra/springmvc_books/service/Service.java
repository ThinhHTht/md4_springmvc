package ra.springmvc_books.service;

import ra.springmvc_books.model.Book;

import java.util.List;

public interface Service {
    List<Book> findAll();
    boolean save(Book book);
    Book findById(int id);
    boolean update(Book book);
    boolean delete(int bookId);

}
