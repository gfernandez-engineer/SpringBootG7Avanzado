package com.codigo.persistencia.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
//@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombreProducto
    //@JsonProperty("name_producto")
    @Column(name = "nombre_producto", length = 100, unique = true)
    private String nombre_producto;

    @Column(name = "precio", nullable = false)
    private double precio;


}
