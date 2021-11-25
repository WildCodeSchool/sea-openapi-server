package com.spring.quest.rest.solution.controller;

import com.spring.quest.rest.solution.entity.Book;
import com.spring.quest.rest.solution.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public List<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable("id") int id) {
        return bookRepository.findById(id).get();
    }

    @GetMapping("/books/search")
    public List<Book> search(@RequestParam("searchTerm") String searchTerm) {
        return bookRepository.findBooksByTitleContainingOrAuthorContainingOrDescriptionContaining(searchTerm, searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable("id") int id, @RequestBody Book book) {
        Book bookToUodate = bookRepository.findById(id).get();
        bookToUodate.setTitle(book.getTitle());
        bookToUodate.setAuthor(book.getAuthor());
        bookToUodate.setDescription(book.getDescription());

        return bookRepository.save(bookToUodate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable("id") int id){
        bookRepository.deleteById(id);
        return true;
    }

}
