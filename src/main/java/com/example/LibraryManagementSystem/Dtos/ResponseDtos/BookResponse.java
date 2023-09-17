package com.example.LibraryManagementSystem.Dtos.ResponseDtos;

import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Model.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookResponse {
    String title;
    String  author;
}
