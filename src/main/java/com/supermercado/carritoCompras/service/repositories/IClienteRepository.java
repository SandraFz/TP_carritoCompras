package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Boolean existsByDni(String dni);
}
