package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
//import com.supermercado.carritoCompras.model.entities.enums.Genero;
import com.supermercado.carritoCompras.model.entities.enums.Genero;
import org.springframework.stereotype.Component;


@Component
public class ProductoMapper {

    public Producto dtoToProdResquest(ProductoDTO proDto){

        Producto prod = new Producto();

        prod.setId(proDto.getId());
        prod.setGenero(proDto.getGenero());
        prod.setFamilia(proDto.getFamilia());
        prod.setDenominacion(proDto.getDenominacion());
        prod.setPrecio(proDto.getPrecio());
        prod.setStock(proDto.getStock());

        return prod;
    }

    public ProductoDTO prodToDtoResponse(Producto prod){

        ProductoDTO proDto = new ProductoDTO();

        proDto.setId(prod.getId());
        proDto.setGenero(prod.getGenero());
        proDto.setFamilia(prod.getFamilia());
        proDto.setDenominacion(prod.getDenominacion());
        proDto.setPrecio(prod.getPrecio());
        proDto.setStock(prod.getStock());

        return proDto;
    }
}
