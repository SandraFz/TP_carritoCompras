package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.CompraDTO;
import com.supermercado.carritoCompras.model.entities.Compra;
import org.springframework.stereotype.Component;

@Component
public class CompraMapper {

    public Compra dtoToCompResquest(CompraDTO comDto){

        Compra com = new Compra();

        com.setId(comDto.getId());
        com.setFecha(comDto.getFecha());
        com.setCliente(comDto.getCliente());
       // com.setCarrito(comDto.getCarrito());
        //com.setProductos(comDto.getProductos());

        return com;
    }

    public CompraDTO comToDtoResponse(Compra com){

        CompraDTO comDto = new CompraDTO();

        comDto.setId(com.getId());
        comDto.setFecha(com.getFecha());
        comDto.setCliente(com.getCliente());
        //comDto.setCarrito(com.getCarrito());
        //comDto.setProductos(com.getProductos());

        return comDto;
    }
}
