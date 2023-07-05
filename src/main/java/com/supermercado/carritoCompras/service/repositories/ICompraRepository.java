package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompraRepository extends JpaRepository<Compra, Long> {

}
