package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "select author.name from Author author where SIZE(author.books) > :x")
    List<String> getAuthorsWithBooksGreaterThanX(int x);
}
