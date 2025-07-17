package com.example.bandodados.controller;

import com.example.bandodados.entity.Camisa;
import com.example.bandodados.service.CamisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camisas")
@CrossOrigin(origins = "*")
public class CamisaController {
    @Autowired
    private CamisaService service;

    @GetMapping
    public List<Camisa> listar() {
        return service.listar();
    }

    @PostMapping
    public Camisa criar(@RequestBody Camisa camisa) {
        return service.salvar(camisa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camisa> buscarPorId(@PathVariable String id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Camisa>> buscarPorNome(@RequestParam String nome) {
        List<Camisa> camisas = service.buscarPorNome(nome);
        if (camisas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(camisas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camisa> atualizarCamisa(@PathVariable String id, @RequestBody Camisa camisa) {
        Camisa updatedCamisa = service.atualizar(id, camisa);
        if (updatedCamisa != null) {
            return ResponseEntity.ok(updatedCamisa);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}