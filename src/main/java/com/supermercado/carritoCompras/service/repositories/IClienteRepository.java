package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {

    Boolean existsByDni(String dni);
    @Query(value = "SELECT * FROM productos WHERE nombre = :dni", nativeQuery = true)
    public ClienteDTO findCliente(String dni);
}
