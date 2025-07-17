package com.example.bandodados.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "entradas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaEstoque {
    @Id
    private String id;
    private String camisaId;
    private String fornecedorId;
    private Integer quantidade;
    private LocalDate dataEntrada;
}
