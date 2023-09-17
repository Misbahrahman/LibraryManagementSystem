package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.StudentRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.StudentResponse;
import com.example.LibraryManagementSystem.Enum.CardStatus;
import com.example.LibraryManagementSystem.Enum.Gender;
import com.example.LibraryManagementSystem.Model.LibraryCard;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Transformers.LibraryCardTransformer;
import com.example.LibraryManagementSystem.Transformers.StudentTranformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;
    public StudentResponse addStudent(StudentRequest request) {

        //req to student
        Student student = StudentTranformer.RequestToStudentTransformer(request);

        //create library card
        LibraryCard libraryCard = LibraryCardTransformer.prepareLibraryCard(student);


        student.setLibraryCard(libraryCard);  // set librarycard for student
        repository.save(student);// save both student and library card

        return StudentTranformer.StudentToResponseTransformer(student);

    }

    public StudentResponse getStudent(int regNo) {
        Optional<Student> response = repository.findById(regNo);

        if (response.isEmpty()) return null;
        Student student = response.get();
        return StudentTranformer.StudentToResponseTransformer(student);

    }

    public void deleteStudent(int regNo) {
        Optional<Student> response = repository.findById(regNo);
        Student student = response.get();
        if(student != null)repository.delete(student);
    }

    public void updateAge(int regNo, int age) {
        Optional<Student> response = repository.findById(regNo);
        Student student = response.get();
        student.setAge(age);
        repository.save(student);
    }

    public List<Student> getAllStudents() {
        List<Student> list = repository.findAll();
        return list;
    }

    public List<Student> getAllMaleStudents() {
        return repository.findByGender(Gender.MALE);
    }


}
