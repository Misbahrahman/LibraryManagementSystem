package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.BookRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.BookResponse;
import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Exceptions.NotFoundException;
import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {
    @Autowired
    AuthorRepository repository;

    @Autowired
    BooksRepository booksRepository;
    public BookResponse addBook(BookRequest bookRequest) {
        String title = bookRequest.getTitle();
        int noOfPages = bookRequest.getNoOfPages();
        Genre genre = bookRequest.getGenre();
        double cost = bookRequest.getCost();
        int authorId = bookRequest.getAuthorId();

        Optional<Author> response = repository.findById(authorId);
        if(!response.isPresent())throw new NotFoundException("Invalid author id!!!");

        Author author = response.get();
        Book book = new Book();
        book.setAuthor(author);
        book.setCost(cost);
        book.setGenre(genre);
        book.setNoOfPages(noOfPages);
        book.setTitle(title);

        author.getBooks().add(book);
        repository.save(author);

        return new BookResponse(title ,author.getName());

    }


    public ResponseEntity getBooksHavingPagesBetweenXandY(int x, int y) {
        List<Book> list = booksRepository.getBooksHavingPagesBetweenXandY(x , y);
        List<BookResponse> books = new ArrayList<>();

        for(Book book : list){
            books.add(new BookResponse(book.getTitle() , book.getAuthor().getName()));
        }

        return new ResponseEntity(books , HttpStatus.OK);
    }
}
