package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM productos WHERE nombre = :name", nativeQuery = true)
    public Producto findProd(String name);

    @Query(value = "SELECT * FROM productos WHERE genero = :gen", nativeQuery = true)
    public Producto findByGen(String gen);
}
