package ra.springmvc_books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.springmvc_books.model.Book;
import ra.springmvc_books.service.Service;

import java.util.List;

@Controller
@RequestMapping("bookController")

public class BookController {
    @Autowired
    private Service service;

    @GetMapping("getAll")
    public ModelAndView getAllBooks() {
        ModelAndView mav = new ModelAndView("listBooks");
        List<Book> listBooks = service.findAll();
        mav.addObject("listBooks", listBooks);
        return mav;
    }

    @GetMapping("initCreate")
    public String initCreate(ModelMap modelMap) {
        Book bookNew = new Book();
        modelMap.addAttribute("bookNew", bookNew);
        return "addBook";
    }

    @PostMapping("create")
    public String createBook(Book book) {
        boolean result = service.save(book);
        if (result) {
            return "redirect:getAll";
        }
        return "error";
    }

    @GetMapping("/initUpdate")
    public String getBookUpdate(ModelMap modelMap, @RequestParam("bookId") int bookId) {
        Book book = service.findById(bookId);
        modelMap.addAttribute("book", book);
        return "updateBook";
    }

    @PostMapping("/update")
    public String updateBook(Book updateBook) {
        boolean result = service.update(updateBook);
        if (result) {
            return "redirect:getAll";
        }
        return "error";
    }
    @GetMapping("/delete")
    public String deleteBook(int bookId){
        boolean result = service.delete(bookId);
        if(result){
            return "redirect:getAll";
        } return "error";
    }

}
