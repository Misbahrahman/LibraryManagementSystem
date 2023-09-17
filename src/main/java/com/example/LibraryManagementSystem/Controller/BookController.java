package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.BookRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.BookResponse;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;

    @PostMapping("/addBook")
    ResponseEntity addBook(@RequestBody BookRequest bookRequest){
        try{
            BookResponse response =  service.addBook(bookRequest);
            return new ResponseEntity<>(response , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getBooksHavingPagesBetweenXandY")
    ResponseEntity getBooksHavingPagesBetweenXandY(@RequestParam("x") int x ,@RequestParam("y") int y){
        return service.getBooksHavingPagesBetweenXandY(x , y);
    }
}
