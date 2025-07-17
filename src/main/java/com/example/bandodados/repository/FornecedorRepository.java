package com.example.bandodados.repository;

import com.example.bandodados.entity.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {

}