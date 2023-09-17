package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.Dtos.ResponseDtos.TransactionResponse;
import com.example.LibraryManagementSystem.Model.Transaction;
import lombok.Data;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TransactionTransformer {

    public static TransactionResponse getTransactionResponse(Transaction transaction){
        return TransactionResponse.builder()
                .transactionNumber(transaction.getTransactionNumber())
                .transactionStatus(transaction.getTransactionStatus())
                .studentName(transaction.getLibraryCard().getStudent().getName())
                .bookName(transaction.getBook().getTitle())
                .build();
    }
}
