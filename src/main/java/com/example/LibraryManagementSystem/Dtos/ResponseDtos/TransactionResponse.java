package com.example.LibraryManagementSystem.Dtos.ResponseDtos;

import com.example.LibraryManagementSystem.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class TransactionResponse {

    String transactionNumber;
    TransactionStatus transactionStatus;
    String bookName;
    String studentName;


}
