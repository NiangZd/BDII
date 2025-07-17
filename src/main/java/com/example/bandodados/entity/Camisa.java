package com.example.bandodados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "camisas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Camisa {
    @Id
    private String id;
    private String nome;
    private String time;
    private String tamanho;
    private Double preco;
    private Integer quantidade;
}