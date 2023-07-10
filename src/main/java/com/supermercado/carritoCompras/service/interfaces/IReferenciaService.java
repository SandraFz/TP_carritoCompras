package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Referencia;

import java.util.List;

public interface IReferenciaService {

    public ReferenciaDTO newReferencia(ReferenciaDTO refDto, Long id);

    //List<Referencia> allRef();

    List<Referencia> allRef(Long id);

    public int agregarUnidad(int u);

    public int restarUnidad(int u);
}
