package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.mapper.CarritoMapper;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.service.interfaces.ICarritoService;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarritoServImpl implements ICarritoService {

    @Autowired
    public ICarritoRepository repoCar;

    @Autowired
    public CarritoMapper mapCar;

    @Autowired
    public IClienteRepository repoCli;

    @Autowired
    public ClienteMapper mapCli;

    @Override
    @Transactional
    public CarritoDTO crearCarrito(Long id) {//Crea un nuevo carrito y lo vincula al cliente.

        Carrito car = new Carrito();

        Carrito newCar = repoCar.save(car);

        Cliente cli = repoCli.getById(id);
        cli.setCarrito(newCar);
        repoCli.saveAndFlush(cli);

        CarritoDTO newCarDto = mapCar.carToDtoResponse(newCar);

        return newCarDto;
    }

    @Override
    public ReferenciaDTO agregarReferencia(ReferenciaDTO refDto){

        /*Crear nueva referencia.
        Pasar los valores como parámetro.
        Agregar a la lista de referencias*/

        return null;
    }
/*
    @Override
    public int restarUnidad(int u){

    }

    @Override
    public void vaciarCarrito(){

    }

    @Override
    public CarritoDTO comprar(){

    }*/
}
