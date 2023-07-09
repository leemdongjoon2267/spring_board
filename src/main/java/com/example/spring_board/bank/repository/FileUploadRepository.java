package com.example.spring_board.bank.repository;

import com.example.spring_board.bank.domain.FileUpload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUpload, Long>{

    Optional<Object> findByEmail(String email);
}
