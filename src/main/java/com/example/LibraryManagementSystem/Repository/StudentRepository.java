package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Enum.Gender;
import com.example.LibraryManagementSystem.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @Query("SELECT s FROM Student s WHERE s.gender = 'MALE'")
    List<Student> findByGender(Gender gender);
}
