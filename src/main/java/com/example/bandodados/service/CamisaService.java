package com.example.bandodados.service;

import com.example.bandodados.entity.Camisa;
import com.example.bandodados.repository.CamisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CamisaService {
    @Autowired
    private CamisaRepository repository;

    public List<Camisa> listar() {
        return repository.findAll();
    }

    public Camisa salvar(Camisa camisa) {
        return repository.save(camisa);
    }

    public Optional<Camisa> buscarPorId(String id) {
        return repository.findById(id);
    }

    public List<Camisa> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }

    public void deletar(String id) {
        repository.deleteById(id);
    }

    public Camisa atualizar(String id, Camisa camisaAtualizada) {
        // Find the existing camisa by ID
        Optional<Camisa> existingCamisaOptional = repository.findById(id);

        if (existingCamisaOptional.isPresent()) {
            Camisa existingCamisa = existingCamisaOptional.get();

            existingCamisa.setNome(camisaAtualizada.getNome());
            existingCamisa.setTime(camisaAtualizada.getTime());
            existingCamisa.setTamanho(camisaAtualizada.getTamanho());
            existingCamisa.setPreco(camisaAtualizada.getPreco());
            existingCamisa.setQuantidade(camisaAtualizada.getQuantidade());

            return repository.save(existingCamisa);
        } else {
            return null;
        }
    }
}