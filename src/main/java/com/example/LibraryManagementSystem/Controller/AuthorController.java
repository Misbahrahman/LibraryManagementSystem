package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.AuthorRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.AuthorResponse;
import com.example.LibraryManagementSystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService service;

    @PostMapping("/addAuthor")
    ResponseEntity addAuthor(@RequestBody AuthorRequest request){
        AuthorResponse response = service.addAuthor(request);
        return new ResponseEntity(response , HttpStatus.OK);
    }

    @PutMapping("/updateEmail")
    ResponseEntity updateEmail(@RequestParam("id") int AuthorId, @RequestParam("email") String email){
        try{
            ResponseEntity response = service.updateEmail(AuthorId , email);
            return response;
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/getAllBooksByAuthor")
    ResponseEntity getAllBookByAuthor(@RequestParam("id") int id){
        try{
            ResponseEntity response = service.getAllBookByAuthor(id);
            return response;
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAuthorsWithBooksGreaterThanX")
    ResponseEntity getAuthorsWithBooksGreaterThanX(@RequestParam("x") int x){
        return service.getAuthorsWithBooksGreaterThanX(x);
    }

}
