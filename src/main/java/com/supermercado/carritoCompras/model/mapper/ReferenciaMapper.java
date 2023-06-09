package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Referencia;
import org.springframework.stereotype.Component;

@Component
public class ReferenciaMapper {

    public Referencia dtoToReferencia (ReferenciaDTO refDto){

        Referencia ref = new Referencia();

        ref.setId(refDto.getId());
        ref.setCantidad(refDto.getCant());
        ref.setIdProd(refDto.getIdProd());
        ref.setSubt(refDto.getSubt());
        ref.setCarrito(refDto.getCarrito());

        return ref;
    }

    public ReferenciaDTO refToDto (Referencia ref){

        ReferenciaDTO refDto = new ReferenciaDTO();

        refDto.setId(ref.getId());
        refDto.setCant(ref.getCantidad());
        refDto.setIdProd(ref.getIdProd());
        refDto.setSubt(ref.getSubt());
        refDto.setCarrito(ref.getCarrito());

        return refDto;
    }
}
