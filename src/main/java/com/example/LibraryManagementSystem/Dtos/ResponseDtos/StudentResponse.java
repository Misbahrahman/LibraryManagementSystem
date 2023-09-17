package com.example.LibraryManagementSystem.Dtos.ResponseDtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level =  AccessLevel.PRIVATE)
@Builder

public class StudentResponse {

    String name;

    String email;

    String cardIssuedNo;

    String message;
}
