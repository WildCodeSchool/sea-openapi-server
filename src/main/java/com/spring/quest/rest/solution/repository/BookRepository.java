package com.spring.quest.rest.solution.repository;

import com.spring.quest.rest.solution.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findByTitleContainingAndAuthorContainingAndDescriptionContaining (String textTitle, String textAuthor, String textDesc);
    //findByTitleContainingOrContentContaining
}
