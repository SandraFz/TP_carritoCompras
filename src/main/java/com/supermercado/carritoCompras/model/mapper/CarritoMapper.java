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
        car.setCompras(carDto.getCompras());

        return car;
    }

    public CarritoDTO carToDtoResponse(Carrito car){

        CarritoDTO carDto = new CarritoDTO();

        carDto.setId(car.getId());
        carDto.setCliente(car.getCliente());
        carDto.setCompras(car.getCompras());

        return carDto;
    }
}
