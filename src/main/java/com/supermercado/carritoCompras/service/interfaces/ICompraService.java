package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.CompraDTO;
import com.supermercado.carritoCompras.model.entities.Compra;

import java.util.Date;
import java.util.List;

public interface ICompraService {

    public CompraDTO newCompra(CompraDTO dto, Long id);

    public Compra findCompraById(Long id);

    public List<Compra> findByCliente(Long id);

    public List<Compra> allCompras();

    public List<Compra> findByFecha(Date fecha);

    public List<Compra> findBetween(int desde, int hasta);
}
