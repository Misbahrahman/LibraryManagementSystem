package com.example.LibraryManagementSystem.Model;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.StudentRequest;
import com.example.LibraryManagementSystem.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student_info")
@Builder

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int regNo;

    @Column(name = "student_name")
    String name;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(nullable = false , unique = true)
    String email;

    int age;

    @OneToOne(mappedBy = "student" , cascade = CascadeType.ALL)
    LibraryCard libraryCard;

}
