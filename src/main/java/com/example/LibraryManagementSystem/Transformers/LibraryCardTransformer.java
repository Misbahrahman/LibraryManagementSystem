package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Model.LibraryCard;
import com.example.LibraryManagementSystem.Model.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class LibraryCardTransformer {

    public static LibraryCard prepareLibraryCard(Student student){
        LibraryCard libraryCard = LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .student(student)
                .build();

        return libraryCard;
    }


}
