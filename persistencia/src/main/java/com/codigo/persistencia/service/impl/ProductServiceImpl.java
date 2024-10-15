package com.codigo.persistencia.service.impl;

import com.codigo.persistencia.entity.ProductEntity;
import com.codigo.persistencia.repository.ProductRepository;
import com.codigo.persistencia.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity guardarProducto(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity obtenerProductoPorId(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Error Producto no encontrado"));
    }

    @Override
    public List<ProductEntity> obtenerTodosLosProductos() {
        return productRepository.findAll();
    }

    @Override
    public ProductEntity actualizarProducto(Long id, ProductEntity productEntity) {
        //Busco el Productoreutilizando el metodo de finBydId
        ProductEntity productoExistente = obtenerProductoPorId(id);
        //Al Producto recuperado, le cambio los valores que me son permitidos(nombreProducto, Precio)
        productoExistente.setNombre_producto(productEntity.getNombre_producto());
        productoExistente.setPrecio(productEntity.getPrecio());
        //Guardo nuevamente el producto con sus cambios.
        return productRepository.save(productoExistente);
    }

    @Override
    public void eliminarProducto(Long id) {
        ProductEntity productoExistente = obtenerProductoPorId(id);
        productRepository.delete(productoExistente);
    }
}
