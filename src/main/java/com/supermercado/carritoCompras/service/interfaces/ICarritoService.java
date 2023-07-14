package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Referencia;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;

import java.util.List;

public interface ICarritoService {

    public CarritoDTO crearCarrito (Long id);

    public CarritoDTO findCarById (Long id);

    public List<Carrito> allCar();

    public ReferenciaDTO agregarReferencia (ReferenciaDTO refDto, Long idCli, Long idProd);

    public void vaciarCarrito(Long id);

    public String comprar(Long id);
}
