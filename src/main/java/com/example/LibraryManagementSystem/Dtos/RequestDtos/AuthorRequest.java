package com.example.LibraryManagementSystem.Dtos.RequestDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class AuthorRequest {

    String name;

    int age;

    String email;

}
