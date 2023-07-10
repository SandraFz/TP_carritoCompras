package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.entities.Referencia;
import com.supermercado.carritoCompras.model.mapper.CarritoMapper;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.model.mapper.ReferenciaMapper;
import com.supermercado.carritoCompras.service.interfaces.ICarritoService;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import com.supermercado.carritoCompras.service.repositories.IReferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    public ReferenciaServImpl servRef;

    @Autowired
    public IReferenciaRepository repoRef;

    @Autowired
    public ReferenciaMapper mapRef;

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
    public CarritoDTO findCarById(Long id) {//Busca un carrito según el id.

        Carrito car = repoCar.getById(id);
        CarritoDTO carDto = mapCar.carToDtoResponse(car);

        return carDto;
    }

    @Override
    public List<Carrito> allCar() {//Lista todos los carritos.

        List<Carrito> car;
        car = repoCar.findAll();

        return car;
    }

    @Override
    public ReferenciaDTO agregarReferencia(ReferenciaDTO refDto, Long id){//Agrega una referencia.

        ReferenciaDTO ref = servRef.newReferencia(refDto, id);

        return ref;
    }

    @Override
    public void vaciarCarrito(Long id){//Elimina todas las referencias existentes y actualiza el stock devolviendo las unidades.

        Carrito car = repoCar.getReferenceById(id);

        if(!repoCar.contieneRef()){
            throw new RuntimeException("No hay referencias que borrar");
        } else {
            car.getReferencias().clear();
            /*Actualizar stock*/
        }
    }

    @Override
    public String comprar(Long id){//Convierte la lista de referencias en un string y vacía el carrito.

        List<String> compras = new ArrayList<>();
        List<Referencia> refs = servRef.allRef(id);
        for(Referencia ref: refs){
            String referenciaTxt = ref.toString();
            compras.add(referenciaTxt);
        }

        String detalle = String.join("/n", compras);

        /*Agregar a lista de Compras*/
        return detalle;
    }
}
