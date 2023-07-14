package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.TpFinalCarritoComprasApplication;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.model.entities.Referencia;
import com.supermercado.carritoCompras.model.mapper.CarritoMapper;
import com.supermercado.carritoCompras.model.mapper.ReferenciaMapper;
import com.supermercado.carritoCompras.service.interfaces.IProductoService;
import com.supermercado.carritoCompras.service.interfaces.IReferenciaService;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import com.supermercado.carritoCompras.service.repositories.IProductoRepository;
import com.supermercado.carritoCompras.service.repositories.IReferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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

    @Autowired
    public IProductoRepository repoProd;

    @Autowired
    public IProductoService servProd;

    @Override
    //@Transactional
    public ReferenciaDTO newReferencia(ReferenciaDTO dto, Long idCli, Long idProd) {
        //Agrega una referencia y lo asocia al carrito segúnel id del cliente.
        Referencia ref = mapRef.dtoToReferencia(dto);
        ref.setSubt((double) (dto.getCant() * repoProd.getReferenceById(idProd).getPrecio()));
        ref.setIdProd(String.valueOf(idProd));
        repoRef.save(ref);

        //Relacionar la referencia al Carrito.
        Carrito car = repoCli.getReferenceById(idCli).getCarrito();
        car.getReferencias().add(ref);
        repoCar.saveAndFlush(car);

        /*Actualizar stock*/
        /*Producto prod = repoProd.getReferenceById(idProd);
        servProd.restarStock(dto.getCant(), idProd);
        repoProd.saveAndFlush(prod);*/

        ReferenciaDTO newRefDto = mapRef.refToDto(ref);

        return newRefDto;
    }

    @Transactional
    public ReferenciaDTO newReferenciaB(ReferenciaDTO refDto, Long id) {
        //Agrega una referencia y lo asocia al carrito segúnel id del cliente.
        Referencia ref = mapRef.dtoToReferencia(refDto);

        Referencia newRef = repoRef.save(ref);

        //Actualizar producto.
       /* Producto prod = null;
        prod.setGenero(newRef.getProducto().getGenero());
        prod.setFamilia(newRef.getProducto().getFamilia());
        prod.setDenominacion(newRef.getProducto().getDenominacion());
        prod.setPrecio(newRef.getProducto().getPrecio());
        repoProd.saveAndFlush(prod);*/

        /*double subt = ref.getCant() * ref.getProducto().getPrecio();
        ref.setSubt(subt);*/
        //repoRef.saveAndFlush(ref);

        Cliente cli = repoCli.getReferenceById(id);
        //Carrito car = repoCar.getById(id);
       /* Carrito car = cli.getCarrito();
        car.getReferencias().add(ref);
        repoCar.saveAndFlush(car);*/

        /*Actualizar stock*/
        //prod = ref.getProducto();
        //servProd.restarStock(ref.getCant(), prod.getId());

        //prod.setStock(-ref.getCant());
        //repoProd.saveAndFlush(prod);

        ReferenciaDTO newRefDto = mapRef.refToDto(ref);

        return newRefDto;
    }

    @Override
    public List<Referencia> allRef(Long id){//Según el id del cliente.

        Cliente cli = repoCli.getReferenceById(id);
        Carrito car = repoCar.getById(cli.getCarrito().getId());
        List<Referencia> referencias =  car.getReferencias();

        return referencias;
    }

    @Override
    public ReferenciaDTO editRef(ReferenciaDTO refDto, Long id){

        Referencia ref =  repoRef.getReferenceById(id);

        ref.setCantidad(refDto.getCant());
        ref.setCantidad(refDto.getCant());
        ref.setIdProd(refDto.getIdProd());
        //ref.setSubt(refDto.getSubt());
        repoRef.saveAndFlush(ref);

        return mapRef.refToDto(ref);
    }

    @Override
    public void deleteRef(Long id){

        repoRef.deleteById(id);
    }

    @Override
    @Transactional
    public int agregarUnidad(int u, Long idRef) {

        Referencia ref = repoRef.getReferenceById(idRef);

        ref.setCantidad(ref.getCantidad() + u);
        repoRef.saveAndFlush(ref);

        Long idProd = Long.valueOf(ref.getIdProd());
        servProd.restarStock(u, idProd);
        //repoProd.saveAndFlush(prod);

        return ref.getCantidad();
    }

    @Override
    @Transactional
    public int restarUnidad(int u, Long idRef) {

        Referencia ref = repoRef.getReferenceById(idRef);

        ref.setCantidad(ref.getCantidad() - u);
        repoRef.saveAndFlush(ref);

        Long idProd = Long.valueOf(ref.getIdProd());
        servProd.sumarStock(u, idProd);
        //repoProd.saveAndFlush(prod);

        return ref.getCantidad();
    }

    public static void main(String[] args) {


    }

}
