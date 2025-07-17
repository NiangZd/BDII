package com.example.bandodados.repository;

import com.example.bandodados.entity.Camisa;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CamisaRepository extends MongoRepository<Camisa, String> {
    List<Camisa> findByNomeContainingIgnoreCase(String nome);
}