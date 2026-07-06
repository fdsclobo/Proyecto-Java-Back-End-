package com.techlab.ecommerces.controller;

import com.techlab.ecommerces.model.Carrito;
import com.techlab.ecommerces.service.CarritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carritos")
public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Carrito>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> obtenerCarrito(@PathVariable Integer id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Carrito> crear() {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear());
    }

    @PostMapping("/{carritoId}/productos/{productoId}")
    public ResponseEntity<Carrito> agregarProducto(
            @PathVariable Integer carritoId,
            @PathVariable Integer productoId) {
        return ResponseEntity.ok(service.agregarProducto(carritoId, productoId));
    }

    @DeleteMapping("/{id}/vaciar")
    public ResponseEntity<Carrito> vaciar(@PathVariable Integer id) {
        return ResponseEntity.ok(service.vaciar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.ok().build();
    }
}