package com.spring.quest.rest.solution.repository;

import com.spring.quest.rest.solution.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByTitleContainingOrAuthorContainingOrDescriptionContaining(String title, String author, String description);

}
