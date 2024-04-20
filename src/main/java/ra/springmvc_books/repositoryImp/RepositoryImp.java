package ra.springmvc_books.repositoryImp;

import jdk.vm.ci.code.site.Call;
import ra.springmvc_books.model.Book;
import ra.springmvc_books.repository.Repository;
import ra.springmvc_books.util.ConnectionDB;

import java.awt.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Repository
public class RepositoryImp implements Repository {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement calst = null;
        List<Book> listBooks = null;
        try{
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call get_all_book()}");
            ResultSet rs = calst.executeQuery();
            listBooks = new ArrayList<>();
            while (rs.next()){
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
                listBooks.add(book);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return listBooks;
    }

    @Override
    public boolean save(Book book) {
        Connection conn = null;
        CallableStatement calst = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call insert_book(?,?,?)}");
            calst.setString(1, book.getBookName());
            calst.setFloat(2, book.getPrice());
            calst.setBoolean(3, book.isStatus());
            calst.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calst);
        } return result;

    }

    @Override
    public Book getBook(int bookId) {
        Connection conn = null;
        CallableStatement calst = null;
        Book book = null;
        try{
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call get_book_by_id(?)}");
            calst.setInt(1, bookId);
            ResultSet rs = calst.executeQuery();
            book = new Book();
            if(rs.next()){

                book.setBookId(rs.getInt("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setPrice(rs.getFloat("price"));
                book.setStatus(rs.getBoolean("book_status"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return book;
    }

    @Override
    public boolean update(Book book) {
        Connection conn = null;
        CallableStatement calst = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call update_book(?,?,?,?)}");
            calst.setInt(1, book.getBookId());
            calst.setString(2, book.getBookName());
            calst.setFloat(3, book.getPrice());
            calst.setBoolean(4, book.isStatus());
            calst.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calst);
        }return result;
    }

    @Override
    public boolean delete(int bookId) {
        Connection conn = null;
        CallableStatement calst = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            calst = conn.prepareCall("{call delete_book(?)}");
            calst.setInt(1, bookId);
            calst.executeUpdate();
            result = true;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn, calst);
        }
        return result;
    }
}
