package com.example.LibraryManagementSystem.Model;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_card_info")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String cardNo; //uuid

    @Enumerated(EnumType.STRING)
    CardStatus cardStatus;

    @CreatedDate
    Date dateOfIssue;

    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "libraryCard" , cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();
}
