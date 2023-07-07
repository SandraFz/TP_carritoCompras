package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import org.springframework.stereotype.Component;

@Component
public class CarritoMapper {

    public Carrito dtoToCarRequest(CarritoDTO carDto){

        Carrito car = new Carrito();

        car.setId(carDto.getId());
        car.setCliente(carDto.getCliente());
        car.setReferencias(carDto.getReferencias());
        car.setTotal(carDto.getTotal());

        return car;
    }

    public CarritoDTO carToDtoResponse(Carrito car){

        CarritoDTO carDto = new CarritoDTO();

        carDto.setId(car.getId());
        carDto.setCliente(car.getCliente());
        carDto.setReferencias(car.getReferencias());
        carDto.setTotal(car.getTotal());

        return carDto;
    }
}
