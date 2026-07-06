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
@DiscriminatorValue("INDUMENTARIA")
public class Indumentaria extends Producto {

    private String depUrb;
    private String sexo;
    private String talle;

    public Indumentaria(String nombre, double precio, Integer stock, String depUrb, String sexo, String talle) {
        super(nombre, precio, stock);
        this.depUrb = depUrb;
        this.sexo = sexo;
        this.talle = talle;
    }
}