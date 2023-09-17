package com.example.LibraryManagementSystem.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Column(unique = true , nullable = false)
    String email;

    @UpdateTimestamp
    Date lastActivity;

    @OneToMany(mappedBy = "author" , cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
}
