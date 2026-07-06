package com.techlab.ecommerces.service;

import com.techlab.ecommerces.exception.ProductoNoEncontradoException;
import com.techlab.ecommerces.model.Producto;
import com.techlab.ecommerces.model.Categoria;
import com.techlab.ecommerces.repository.ProductoRepository;
import com.techlab.ecommerces.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public Producto guardar(Producto p) {
        if (p.getCategoria() != null && p.getCategoria().getId() != null) {
            Categoria categoriaCompleta = categoriaRepository.findById(p.getCategoria().getId())
                    .orElse(null);
            p.setCategoria(categoriaCompleta);
        }
        return repository.save(p);
    }

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public Producto obtenerPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(
                        "No se encontró producto con ID: " + id));
    }

    public Producto actualizar(Integer id, Producto datos) {
        Producto p = obtenerPorId(id);
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setStock(datos.getStock());

        if (datos.getCategoria() != null && datos.getCategoria().getId() != null) {
            Categoria categoriaCompleta = categoriaRepository.findById(datos.getCategoria().getId())
                    .orElse(null);
            p.setCategoria(categoriaCompleta);
        }

        return repository.save(p);
    }

    public void eliminar(Integer id) {
        repository.delete(obtenerPorId(id));
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombreContaining(nombre);
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaNombreContainingIgnoreCase(categoria);
    }
}