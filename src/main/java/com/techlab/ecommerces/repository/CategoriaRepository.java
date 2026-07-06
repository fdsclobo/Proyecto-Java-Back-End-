package com.techlab.ecommerces.repository;

import com.techlab.ecommerces.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
