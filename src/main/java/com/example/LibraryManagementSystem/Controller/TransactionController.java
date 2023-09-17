package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public ResponseEntity issueBook(@RequestParam("stId") int studentId ,@RequestParam("bkId") int bookId){

        try{
            return transactionService.addBook(studentId , bookId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage() , HttpStatus.NOT_FOUND);
        }

    }

}
