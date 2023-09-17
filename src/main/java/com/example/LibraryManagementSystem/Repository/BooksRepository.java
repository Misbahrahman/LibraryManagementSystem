package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select book from Book book where book.noOfPages > :x and book.noOfPages < :y")
    List<Book> getBooksHavingPagesBetweenXandY(int x, int y);
}
