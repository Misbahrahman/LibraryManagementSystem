package com.example.LibraryManagementSystem.Dtos.RequestDtos;

import com.example.LibraryManagementSystem.Enum.Gender;
import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Model.LibraryCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class StudentRequest {

    String name;

    Gender gender;

    String email;

    int age;

}
