package ra.springmvc_books.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import ra.springmvc_books.model.Book;
import ra.springmvc_books.repository.Repository;
import ra.springmvc_books.service.Service;

import java.util.List;
@org.springframework.stereotype.Service
public class ServiceImp implements Service {
    @Autowired
    private Repository repository;

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean save(Book book) {
        return repository.save(book);
    }

    @Override
    public Book findById(int id) {
        return repository.getBook(id);
    }

    @Override
    public boolean update(Book book) {
        return repository.update(book);
    }

    @Override
    public boolean delete(int bookId) {
        return repository.delete(bookId);
    }
}
