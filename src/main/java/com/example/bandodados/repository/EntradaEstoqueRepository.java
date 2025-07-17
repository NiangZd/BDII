package com.example.bandodados.repository;

import com.example.bandodados.entity.EntradaEstoque;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradaEstoqueRepository extends MongoRepository<EntradaEstoque, String> {

}