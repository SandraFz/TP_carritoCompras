package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarritoRepository extends JpaRepository<Carrito, Long> {

    //public Boolean contieneRef();
}
