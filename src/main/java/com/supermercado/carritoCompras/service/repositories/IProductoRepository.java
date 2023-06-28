package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

    Boolean existsByDni(String dni);
}
