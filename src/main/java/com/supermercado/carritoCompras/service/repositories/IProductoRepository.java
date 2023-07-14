package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM productos WHERE denominacion LIKE %:name%", nativeQuery = true)
    public List<Producto> findProd(@Param("name") String name);

    @Query(value = "SELECT * FROM productos WHERE genero = :gen", nativeQuery = true)
    public List<Producto> findByGen(String gen);
}
