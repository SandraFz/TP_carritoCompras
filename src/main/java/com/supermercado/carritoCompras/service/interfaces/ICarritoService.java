package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;

public interface ICarritoService {

    public CarritoDTO crearCarrito (Long id);

    public ReferenciaDTO agregarReferencia (ReferenciaDTO refDto);
/*
    public ReferenciaDTO restarUnidad (ReferenciaDTO referenciaDTO);

    public void vaciarCarrito ();

    public CarritoDTO comprar();*/
}
