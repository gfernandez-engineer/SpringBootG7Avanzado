package com.codigo.persistencia.repository;

import com.codigo.persistencia.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

=======
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    List<ProductEntity> findAllByEstado(int estado);

    @Query("SELECT P FROM ProductEntity P WHERE P.estado=:datoEstado")
    List<ProductEntity> findByEstadoQuery(@Param("datoEstado") int datoEstado);
>>>>>>> f08ac18c919256d0d9fdfcc90211919c2e836a34
}
