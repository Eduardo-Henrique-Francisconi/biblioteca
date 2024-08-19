package com.biblioteca.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import com.biblioteca.biblioteca.entity.Produto;
import com.biblioteca.biblioteca.entity.Venda;
import com.biblioteca.biblioteca.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }

    public Venda save(Venda venda) {
        double totalValue = venda.getProdutos().stream()
                                  .mapToDouble(Produto::getPreco)
                                  .sum();
                                  
        if (venda.getCliente().getIdade() < 18 && totalValue > 500.00) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor total máximo para clientes menores de 18 anos é de 500 reais.");
        }

        return vendaRepository.save(venda);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }
}

