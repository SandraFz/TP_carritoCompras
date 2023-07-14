package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Referencia;

import java.util.List;

public interface IReferenciaService {

    public ReferenciaDTO newReferencia(ReferenciaDTO dto, Long idCli, Long idProd);

    public ReferenciaDTO newReferenciaB(ReferenciaDTO refDto, Long id);

    //List<Referencia> allRef();

    public List<Referencia> allRef(Long id);

    public void deleteRef(Long id);

    public ReferenciaDTO editRef(ReferenciaDTO refDto, Long id);

    public int agregarUnidad(int u, Long id);

    public int restarUnidad(int u, Long id);
}
