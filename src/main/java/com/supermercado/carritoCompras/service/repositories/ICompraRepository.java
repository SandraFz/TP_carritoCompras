package com.supermercado.carritoCompras.service.repositories;

import com.supermercado.carritoCompras.model.entities.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ICompraRepository extends JpaRepository<Compra, Long> {

    @Query (value = "SELECT * FROM compras WHERE fecha = :fecha", nativeQuery = true)
    public List<Compra> findByFecha(Date fecha);

   // @Query (value = "SELECT * FROM compras WHERE fecha BETWEEN :min AND :max", nativeQuery = true)
    //public List<Compra> findBetween(int desde, int hasta);
}
