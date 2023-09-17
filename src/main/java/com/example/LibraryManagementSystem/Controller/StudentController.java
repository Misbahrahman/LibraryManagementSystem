package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.Dtos.RequestDtos.StudentRequest;
import com.example.LibraryManagementSystem.Dtos.ResponseDtos.StudentResponse;
import com.example.LibraryManagementSystem.Model.LibraryCard;
import com.example.LibraryManagementSystem.Model.Student;
import com.example.LibraryManagementSystem.Service.StudentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("addStudent")
    ResponseEntity addStudent(@RequestBody StudentRequest student){
        StudentResponse response = service.addStudent(student);
        return new ResponseEntity<>(response , HttpStatus.CREATED);
    }

    @GetMapping("getStudent")
    ResponseEntity getStudent(@RequestParam("regNo") int regNo){
        StudentResponse response = service.getStudent(regNo);
        if(response != null){
            return new ResponseEntity(response , HttpStatus.FOUND);
        }
        return new ResponseEntity("Not Found" , HttpStatus.NOT_FOUND);
    }


    @DeleteMapping("deleteStudent")
    ResponseEntity deleteStudent(@RequestParam("regNo") int regNo){
        service.deleteStudent(regNo);
        return new ResponseEntity("Deleted Successfully" , HttpStatus.OK);
    }

    @PutMapping("updateAge")
    ResponseEntity updateAge(@RequestParam("regNo") int regNo , @RequestParam("age") int age){
        service.updateAge(regNo , age);
        return new ResponseEntity<>("updated" , HttpStatus.OK);
    }

    @GetMapping("getAllStudents")
    ResponseEntity getAllStudents(){
        List<Student> list = service.getAllStudents();
        return new ResponseEntity(list , HttpStatus.OK);
    }

    @GetMapping("getAllMaleStudents")
    ResponseEntity getAllMaleStudents(){
        List<Student> list = service.getAllMaleStudents();
        return new ResponseEntity(list , HttpStatus.OK);
    }





}
