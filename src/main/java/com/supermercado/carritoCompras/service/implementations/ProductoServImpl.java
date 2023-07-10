package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.model.mapper.ProductoMapper;
import com.supermercado.carritoCompras.service.interfaces.IProductoService;
import com.supermercado.carritoCompras.service.repositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductoServImpl implements IProductoService {

    @Autowired
    public IProductoRepository repoProd;

    @Autowired
    public ProductoMapper mapProd;

    @Override
    public ProductoDTO newProduct(ProductoDTO dto) {

        Producto prod = mapProd.dtoToProdResquest(dto);
        Producto newProd = repoProd.save(prod);
        ProductoDTO newDto = mapProd.prodToDtoResponse(newProd);

        return newDto;
    }

    @Override
    public Producto findProducto(String name) {

        Producto prod = repoProd.findProd(name);

        return prod;
    }

    @Override
    public List<Producto> findAllProducto() {

        repoProd.findAll();
        return null;
    }

    @Override
    public List<Producto> finByGenero(String gen) {

        List<Producto> productoList = (List<Producto>) repoProd.findByGen(gen);

        return productoList;
    }

    @Override
    public ProductoDTO editProducto(ProductoDTO prodDto, Long id) {


        return null;
    }

    @Override
    public ProductoDTO sumarStock(int u) {
        return null;
    }

    @Override
    public ProductoDTO restarStock(int u) {
        return null;
    }

    @Override
    public void deleteProducto(Long id) {

    }
}
