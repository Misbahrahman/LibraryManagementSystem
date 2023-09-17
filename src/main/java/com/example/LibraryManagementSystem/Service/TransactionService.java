package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Enum.TransactionStatus;
import com.example.LibraryManagementSystem.Exceptions.NotFoundException;
import com.example.LibraryManagementSystem.Model.Book;
import com.example.LibraryManagementSystem.Model.LibraryCard;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Model.Transaction;
import com.example.LibraryManagementSystem.Repository.BooksRepository;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Repository.TransactionRepository;
import com.example.LibraryManagementSystem.Transformers.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    BooksRepository booksRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TransactionRepository transactionRepository;
    public ResponseEntity addBook(int studentId, int bookId) {
        Optional<Book> getBook = booksRepository.findById(bookId);

        if(getBook.isEmpty())throw new NotFoundException("Book Not found");
        Book book = getBook.get();

        if(book.isIssued() == true)throw new NotFoundException("Book Already Issued");

        Optional<Student> getStudent = studentRepository.findById(studentId);
        if (getStudent.isEmpty())throw new NotFoundException("Student Not Found");

        Student student = getStudent.get();
        LibraryCard libraryCard = student.getLibraryCard();


        Transaction transaction = Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(libraryCard)
                .build();

        Transaction savedTransaction =  transactionRepository.save(transaction);

        book.getTransactions().add(transaction);
        libraryCard.getTransactions().add(transaction);

        booksRepository.save(book);
        studentRepository.save(student);

        return new ResponseEntity(TransactionTransformer.getTransactionResponse(transaction) , HttpStatus.OK);
    }
}
