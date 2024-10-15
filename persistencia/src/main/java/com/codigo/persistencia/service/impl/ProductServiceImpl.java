package com.codigo.persistencia.service.impl;

import com.codigo.persistencia.entity.ProductEntity;
import com.codigo.persistencia.repository.ProductRepository;
import com.codigo.persistencia.service.ProductService;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import java.sql.Timestamp;
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
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
<<<<<<< HEAD
=======
        productEntity.setEstado(1);
        productEntity.setCreated_by("ADMIN");
        productEntity.setCreated_date(new Timestamp(System.currentTimeMillis()));
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
        return productRepository.save(productEntity);
    }

    @Override
    public ProductEntity obtenerProductoPorId(Long id) {
        return productRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Error Producto no encontrado"));
    }

    @Override
    public List<ProductEntity> obtenerTodosLosProductos() {
<<<<<<< HEAD
        return productRepository.findAll();
=======
        //return productRepository.findAllByEstado(1);
        return productRepository.findByEstadoQuery(1);
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
    }

    @Override
    public ProductEntity actualizarProducto(Long id, ProductEntity productEntity) {
        //Busco el Productoreutilizando el metodo de finBydId
        ProductEntity productoExistente = obtenerProductoPorId(id);
        //Al Producto recuperado, le cambio los valores que me son permitidos(nombreProducto, Precio)
        productoExistente.setNombre_producto(productEntity.getNombre_producto());
        productoExistente.setPrecio(productEntity.getPrecio());
<<<<<<< HEAD
=======
        //actualziar datos de la auditoria
        productoExistente.setUpdate_by("ADMIN");
        productoExistente.setUpdate_date(new Timestamp(System.currentTimeMillis()));
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
        //Guardo nuevamente el producto con sus cambios.
        return productRepository.save(productoExistente);
    }

    @Override
    public void eliminarProducto(Long id) {
        ProductEntity productoExistente = obtenerProductoPorId(id);
<<<<<<< HEAD
        productRepository.delete(productoExistente);
=======
        //Auditoria de eliminar
        productoExistente.setEstado(0);
        productoExistente.setDelete_by("ADMIN");
        productoExistente.setDelete_date(new Timestamp(System.currentTimeMillis()));
        productRepository.save(productoExistente);
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
    }
}
