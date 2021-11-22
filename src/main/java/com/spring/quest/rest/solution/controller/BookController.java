package com.spring.quest.rest.solution.controller;

import com.spring.quest.rest.solution.entity.Book;
import com.spring.quest.rest.solution.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> mapSearchTerms) {
        String searchTermTitle = mapSearchTerms.get("title");
        String searchTermAuthor = mapSearchTerms.get("author");
        String searchTermDescr = mapSearchTerms.get("description");
        return bookRepository.findByTitleContainingAndAuthorContainingAndDescriptionContaining(searchTermTitle, searchTermAuthor, searchTermDescr);
    }


    @PostMapping("/books")
    public Book create(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        Book bookToUodate = bookRepository.findById(id).get();
        bookToUodate.setTitle(book.getTitle());
        bookToUodate.setAuthor(book.getAuthor());
        bookToUodate.setDescription(book.getDescription());

        return bookRepository.save(bookToUodate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        bookRepository.deleteById(id);
        return true;
    }

}
