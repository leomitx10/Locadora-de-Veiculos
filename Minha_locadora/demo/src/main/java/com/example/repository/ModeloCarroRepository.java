package com.example.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.ModeloCarro;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarro, Long> {
}
