package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {

    public Producto dtoToProdResquest(ProductoDTO proDto){

        Producto prod = new Producto();

        prod.setId(proDto.getId());
        prod.setGenero(proDto.getGenero());
        prod.setFamilia(proDto.getFamilia());
        prod.setDenominacion(proDto.getDenomination());
        prod.setPrecio(proDto.getPrecio());

        return prod;
    }

    public ProductoDTO prodToDtoResponse(Producto prod){

        ProductoDTO proDto = new ProductoDTO();

        proDto.setId(prod.getId());
        proDto.setGenero(prod.getGenero());
        proDto.setFamilia(prod.getFamilia());
        proDto.setDenomination(prod.getDenominacion());
        proDto.setPrecio(prod.getPrecio());

        return proDto;
    }
}
