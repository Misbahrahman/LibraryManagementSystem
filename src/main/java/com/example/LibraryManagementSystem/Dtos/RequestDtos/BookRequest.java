package com.example.LibraryManagementSystem.Dtos.RequestDtos;

import com.example.LibraryManagementSystem.Enum.Genre;
import com.example.LibraryManagementSystem.Model.Author;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookRequest {

    String title;

    int noOfPages;

    Genre genre;

    double cost;

    int authorId;
}
