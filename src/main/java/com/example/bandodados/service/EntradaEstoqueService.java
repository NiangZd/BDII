package com.example.bandodados.service;

import com.example.bandodados.entity.Camisa;
import com.example.bandodados.entity.EntradaEstoque;
import com.example.bandodados.entity.Fornecedor;
import com.example.bandodados.repository.CamisaRepository;
import com.example.bandodados.repository.EntradaEstoqueRepository;
import com.example.bandodados.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // Importe para transações

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EntradaEstoqueService {

    @Autowired
    private EntradaEstoqueRepository entradaEstoqueRepository;
    @Autowired
    private CamisaRepository camisaRepository;

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<EntradaEstoque> listar() {
        return entradaEstoqueRepository.findAll();
    }

    @Transactional
    public EntradaEstoque salvar(EntradaEstoque entrada) {
        Optional<Camisa> camisaOptional = camisaRepository.findById(entrada.getCamisaId());
        if (camisaOptional.isEmpty()) {
            throw new IllegalArgumentException("Camisa com ID " + entrada.getCamisaId() + " não encontrada.");
        }

        Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(entrada.getFornecedorId());
        if (fornecedorOptional.isEmpty()) {
            throw new IllegalArgumentException("Fornecedor com ID " + entrada.getFornecedorId() + " não encontrado.");
        }

        if (entrada.getDataEntrada() == null) {
            entrada.setDataEntrada(LocalDate.now());
        }

        EntradaEstoque entradaSalva = entradaEstoqueRepository.save(entrada);

        Camisa camisa = camisaOptional.get();
        camisa.setQuantidade(camisa.getQuantidade() != null ? camisa.getQuantidade() + entrada.getQuantidade() : entrada.getQuantidade());
        camisaRepository.save(camisa);

        return entradaSalva;
    }

    public Optional<EntradaEstoque> buscarPorId(String id) {
        return entradaEstoqueRepository.findById(id);
    }

    @Transactional
    public void deletar(String id) {
        Optional<EntradaEstoque> entradaOptional = entradaEstoqueRepository.findById(id);
        if (entradaOptional.isEmpty()) {
            throw new IllegalArgumentException("Entrada de estoque com ID " + id + " não encontrada.");
        }

        EntradaEstoque entrada = entradaOptional.get();

        Optional<Camisa> camisaOptional = camisaRepository.findById(entrada.getCamisaId());
        if (camisaOptional.isPresent()) {
            Camisa camisa = camisaOptional.get();
            camisa.setQuantidade(camisa.getQuantidade() != null ? camisa.getQuantidade() - entrada.getQuantidade() : 0);
            if (camisa.getQuantidade() < 0) {
                camisa.setQuantidade(0);
            }
            camisaRepository.save(camisa);
        } else {
            System.err.println("Aviso: Camisa referenciada por EntradaEstoque " + id + " não encontrada ao deletar.");
        }

        entradaEstoqueRepository.deleteById(id);
    }

    @Transactional
    public EntradaEstoque atualizar(String id, EntradaEstoque entradaAtualizada) {
        Optional<EntradaEstoque> existingEntradaOptional = entradaEstoqueRepository.findById(id);
        if (existingEntradaOptional.isEmpty()) {
            throw new IllegalArgumentException("Entrada de estoque com ID " + id + " não encontrada para atualização.");
        }

        EntradaEstoque existingEntrada = existingEntradaOptional.get();

        if (!existingEntrada.getCamisaId().equals(entradaAtualizada.getCamisaId())) {
            if (camisaRepository.findById(entradaAtualizada.getCamisaId()).isEmpty()) {
                throw new IllegalArgumentException("Nova Camisa com ID " + entradaAtualizada.getCamisaId() + " não encontrada.");
            }
        }
        if (!existingEntrada.getFornecedorId().equals(entradaAtualizada.getFornecedorId())) {
            if (fornecedorRepository.findById(entradaAtualizada.getFornecedorId()).isEmpty()) {
                throw new IllegalArgumentException("Novo Fornecedor com ID " + entradaAtualizada.getFornecedorId() + " não encontrado.");
            }
        }

        if (!existingEntrada.getCamisaId().equals(entradaAtualizada.getCamisaId()) ||
                !existingEntrada.getQuantidade().equals(entradaAtualizada.getQuantidade())) {

            Optional<Camisa> oldCamisaOptional = camisaRepository.findById(existingEntrada.getCamisaId());
            if (oldCamisaOptional.isPresent()) {
                Camisa oldCamisa = oldCamisaOptional.get();
                oldCamisa.setQuantidade(oldCamisa.getQuantidade() != null ? oldCamisa.getQuantidade() - existingEntrada.getQuantidade() : 0);
                if (oldCamisa.getQuantidade() < 0) oldCamisa.setQuantidade(0);
                camisaRepository.save(oldCamisa);
            } else {
                System.err.println("Aviso: Camisa antiga referenciada por EntradaEstoque " + id + " não encontrada ao atualizar.");
            }

            Optional<Camisa> newCamisaOptional = camisaRepository.findById(entradaAtualizada.getCamisaId());
            if (newCamisaOptional.isPresent()) {
                Camisa newCamisa = newCamisaOptional.get();
                newCamisa.setQuantidade(newCamisa.getQuantidade() != null ? newCamisa.getQuantidade() + entradaAtualizada.getQuantidade() : entradaAtualizada.getQuantidade());
                camisaRepository.save(newCamisa);
            } else {
                throw new IllegalArgumentException("Camisa com ID " + entradaAtualizada.getCamisaId() + " não encontrada para atualização de estoque.");
            }
        }


        existingEntrada.setCamisaId(entradaAtualizada.getCamisaId());
        existingEntrada.setFornecedorId(entradaAtualizada.getFornecedorId());
        existingEntrada.setQuantidade(entradaAtualizada.getQuantidade());
        existingEntrada.setDataEntrada(entradaAtualizada.getDataEntrada() != null ? entradaAtualizada.getDataEntrada() : LocalDate.now());

        return entradaEstoqueRepository.save(existingEntrada);
    }
}