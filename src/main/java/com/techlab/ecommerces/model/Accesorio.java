package com.techlab.ecommerces.model;

import jakarta.persistence.Entity;
import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("ACCESORIO")
public class Accesorio extends Producto {

    private String descripcion;

    public Accesorio(String nombre, double precio, Integer stock, String descripcion) {
        super(nombre, precio, stock);
        this.descripcion = descripcion;
    }
}