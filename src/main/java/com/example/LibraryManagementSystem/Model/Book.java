package com.example.LibraryManagementSystem.Model;

import com.example.LibraryManagementSystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "book_table")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    int noOfPages;

    @Enumerated(EnumType.STRING)
    Genre genre;

    double cost;

    boolean isIssued;

    @ManyToOne
    @JoinColumn
    Author author;

    @OneToMany(mappedBy = "book")
    List<Transaction> transactions = new ArrayList<>();

}
