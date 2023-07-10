package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Referencia;
import com.supermercado.carritoCompras.model.mapper.CarritoMapper;
import com.supermercado.carritoCompras.model.mapper.ReferenciaMapper;
import com.supermercado.carritoCompras.service.interfaces.IReferenciaService;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import com.supermercado.carritoCompras.service.repositories.IReferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenciaServImpl implements IReferenciaService {

    @Autowired
    public IReferenciaRepository repoRef;

    @Autowired
    public ReferenciaMapper mapRef;

    @Autowired
    public ICarritoRepository repoCar;

    @Autowired
    public CarritoMapper mapCar;

    @Autowired
    public IClienteRepository repoCli;

    @Override
    public ReferenciaDTO newReferencia(ReferenciaDTO refDto, Long id) {

        Referencia ref = mapRef.dtoToReferencia(refDto);
        repoRef.save(ref);

        Carrito car = repoCar.getById(id);
        car.getReferencias().add(ref);
        repoCar.saveAndFlush(car);

        /*Actualizar stock*/

        ReferenciaDTO newRefDto = mapRef.refToDto(ref);

        return newRefDto;
    }

    @Override
    public List<Referencia> allRef(Long id){

        Carrito car = repoCar.getById(id);
        List<Referencia> referencias =  car.getReferencias();

        return referencias;
    }

    @Override
    public int agregarUnidad(int u) {
        return 0;
    }

    @Override
    public int restarUnidad(int u) {
        return 0;
    }
}
