package com.example.bandodados.service;

import com.example.bandodados.entity.Fornecedor;
import com.example.bandodados.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository repository;

    public List<Fornecedor> listar() {
        return repository.findAll();
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public Optional<Fornecedor> buscarPorId(String id) {
        return repository.findById(id);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public Fornecedor atualizar(String id, Fornecedor atualizado) {
        atualizado.setId(id);
        return repository.save(atualizado);
    }
}
