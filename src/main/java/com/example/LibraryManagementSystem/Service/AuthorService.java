package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.AuthorRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.AuthorResponse;
import com.example.LibraryManagementSystem.Exceptions.NotFoundException;
import com.example.LibraryManagementSystem.Model.Author;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;
    public AuthorResponse addAuthor(AuthorRequest request) {

        String name = request.getName();

        int age = request.getAge();

        String email = request.getEmail();

        Author author = new Author();
        author.setName(name);
        author.setAge(age);
        author.setEmail(email);

        repository.save(author);

        return new AuthorResponse(author.getName(), author.getAge(), author.getEmail(), "Author Added");

    }

    public ResponseEntity updateEmail(int AuthorId, String email) {
        Optional<Author> responce = repository.findById(AuthorId);
        if(!responce.isPresent())throw new NotFoundException("Author Not Found");
        Author author = responce.get();
        author.setEmail(email);
        repository.save(author);
        return new ResponseEntity("SuccessFully change to " + author.getEmail() , HttpStatus.OK);

    }

    public ResponseEntity getAllBookByAuthor(int id) {
        Optional<Author> response = repository.findById(id);
        if(!response.isPresent())throw new NotFoundException("Author Not found");
        Author author = response.get();
        List<Book> list = author.getBooks();
        List<String> books = new ArrayList<>();
        for(Book book : list)books.add(book.getTitle());
        return new ResponseEntity<>(books , HttpStatus.OK);
    }

    public ResponseEntity getAuthorsWithBooksGreaterThanX(int x) {
        List<String> response = repository.getAuthorsWithBooksGreaterThanX(x);
//        if(!response.isPresent())return new ResponseEntity("No Author Found" , HttpStatus.OK);
        return new ResponseEntity(response , HttpStatus.OK);
    }
}
