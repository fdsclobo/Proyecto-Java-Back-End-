package com.techlab.ecommerces.repository;

import com.techlab.ecommerces.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
}
