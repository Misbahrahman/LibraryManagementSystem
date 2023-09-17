package com.example.LibraryManagementSystem.Dtos.ResponseDtos;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorResponse {

    String name;

    int age;

    String email;

    String message;
}
