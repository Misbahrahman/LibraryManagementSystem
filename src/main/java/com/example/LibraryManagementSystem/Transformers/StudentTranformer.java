package com.example.LibraryManagementSystem.Transformers;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.StudentRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.StudentResponse;
import com.example.LibraryManagementSystem.Model.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentTranformer {

    public static Student RequestToStudentTransformer(StudentRequest studentRequest){
        Student student = Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();

        return student;
    }

    public static StudentResponse StudentToResponseTransformer(Student student){
        StudentResponse studentResponse = StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .cardIssuedNo(student.getLibraryCard().getCardNo())
                .message("Added")
                .build();

        return studentResponse;
    }

}
