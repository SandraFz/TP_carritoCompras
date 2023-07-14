package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.CarritoDTO;
import com.supermercado.carritoCompras.model.DTO.CompraDTO;
import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.*;
import com.supermercado.carritoCompras.model.mapper.*;
import com.supermercado.carritoCompras.service.interfaces.ICarritoService;
import com.supermercado.carritoCompras.service.repositories.ICarritoRepository;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import com.supermercado.carritoCompras.service.repositories.IProductoRepository;
import com.supermercado.carritoCompras.service.repositories.IReferenciaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    //@Autowired
    //public ClienteServiceImpl servCli;
    @Autowired
    public ReferenciaServImpl servRef;

    @Autowired
    public IReferenciaRepository repoRef;

    @Autowired
    public ReferenciaMapper mapRef;

    @Autowired
    public IProductoRepository repoProd;

    @Autowired
    public ProductoMapper mapProd;

    @Autowired
    public ProductoServImpl servProd;

    @Autowired
    public CompraServImpl servCom;

    @Autowired
    public CompraMapper mapCom;

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
    public CarritoDTO findCarById(Long id) {//Busca un carrito según su propio id.

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
    @Transactional
    public ReferenciaDTO agregarReferencia(ReferenciaDTO refDto, Long idCli, Long idProd){//Agrega una referencia.

        Carrito car = repoCli.getReferenceById(idCli).getCarrito();

        //List<Referencia> refs = repoCli.getReferenceById(idCli).getCarrito().getReferencias();

        //int stock = refDto.getProducto().getStock();

        if(repoProd.getReferenceById(idProd).getStock() <= 0){
            throw new RuntimeException("Sin stock");
        } else {
            ReferenciaDTO ref = servRef.newReferencia(refDto, idCli, idProd);

            car.getReferencias().add(mapRef.dtoToReferencia(refDto));
            double total = car.getTotal();

            for (Referencia elem : car.getReferencias()) {
                total += elem.getSubt();
            }

            return ref;
        }

    }

    @Override
    @Transactional
    public void vaciarCarrito(Long id){//Elimina todas las referencias existentes y actualiza el stock devolviendo las unidades.

        Carrito car = repoCar.getReferenceById(id);

        for(Referencia ref : car.getReferencias()){

        int cant = ref.getCantidad();
        Producto prod = repoProd.getReferenceById(Long.valueOf(ref.getIdProd()));
        int stockInicial = prod.getStock();
        int stockFinal = stockInicial + cant;
        prod.setStock(stockFinal);

        repoProd.saveAndFlush(prod);
        }

        if(car.getReferencias().isEmpty()){
            throw new RuntimeException("No hay referencias que borrar");
        } else {
            car.getReferencias().clear();
        }
    }

    @Override
    @Transactional
    public String comprar(Long id){//Convierte la lista de referencias en un string y vacía el carrito.

        List<String> compras = new ArrayList<>();
        List<Referencia> refs = servRef.allRef(id);
        for(Referencia ref: refs){
            String referenciaTxt = ref.toString();
            compras.add(referenciaTxt);
        }

        String detalle = String.join("/n", compras);

        Carrito car = repoCli.getReferenceById(id).getCarrito();
        car.getReferencias().clear();

        /*Agregar a lista de Compras*/
        Cliente cli = repoCli.getReferenceById(id);
        Compra com = new Compra();
        com.setFecha(LocalDate.now());
        com.setCliente(cli);
        com.setDetalle(detalle);
        CompraDTO comDto = mapCom.comToDtoResponse(com);

        Compra newCom = mapCom.dtoToCompResquest(servCom.newCompra(comDto, id));
        cli.getCompras().add(newCom);

        return detalle;
    }

}
