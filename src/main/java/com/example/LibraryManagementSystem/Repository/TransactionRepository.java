package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction , Integer> {
}
