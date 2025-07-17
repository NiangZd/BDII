package com.example.bandodados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fornecedores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fornecedor {
    @Id
    private String id;
    private String nome;
    private String cnpj;
    private String endereco;
}