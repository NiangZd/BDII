package com.example.bandodados.controller;

import com.example.bandodados.entity.EntradaEstoque;
import com.example.bandodados.service.EntradaEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradas")
@CrossOrigin(origins = "*")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueService service;

    @GetMapping
    public List<EntradaEstoque> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<EntradaEstoque> criar(@RequestBody EntradaEstoque entrada) {
        try {
            EntradaEstoque novaEntrada = service.salvar(entrada);
            return new ResponseEntity<>(novaEntrada, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity("Erro interno ao criar entrada: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaEstoque> buscar(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaEstoque> atualizar(@PathVariable String id, @RequestBody EntradaEstoque entrada) {
        try {
            EntradaEstoque entradaAtualizada = service.atualizar(id, entrada);
            if (entradaAtualizada != null) {
                return ResponseEntity.ok(entradaAtualizada);
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity("Erro interno ao atualizar entrada: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        try {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Erro interno ao deletar entrada: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}