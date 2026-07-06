package com.techlab.ecommerces.service;

import com.techlab.ecommerces.model.Categoria;
import com.techlab.ecommerces.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoriaService {

    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria guardar(Categoria c) {
        return repository.save(c);
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Categoria obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No se encontró categoría con ID: " + id));
    }
}