package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.model.entities.enums.Genero;
import com.supermercado.carritoCompras.model.mapper.ProductoMapper;
import com.supermercado.carritoCompras.service.interfaces.IProductoService;
import com.supermercado.carritoCompras.service.repositories.IProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServImpl implements IProductoService {

    @Autowired
    public IProductoRepository repoProd;

    @Autowired
    public ProductoMapper mapProd;

    @Override
    public ProductoDTO newProduct(ProductoDTO dto) {//Crea un nuevo poducto.

        Producto prod = mapProd.dtoToProdResquest(dto);
        Producto newProd = repoProd.save(prod);
        ProductoDTO newDto = mapProd.prodToDtoResponse(newProd);

        return newDto;
    }

    @Override
    public List<Producto> findProducto(String name) {//Busca todos los productos cuyas denominaciones coincidan parcialmente con el parámetro.

        List<Producto> prod = (List<Producto>) repoProd.findProd(name);

        return prod;
    }

    @Override
    public List<Producto> findAllProducto() {//Lista todos los productos.

        List<Producto> productos = repoProd.findAll();
        return productos;
    }

    @Override
    public List<Producto> findByGenero(String gen) {//Lista según el género.

        List<Producto> productoList = (List<Producto>) repoProd.findByGen(gen);

        return productoList;
    }

    @Override
    public ProductoDTO editProducto(ProductoDTO prodDto, Long id) {//Edita un producto según el id.

        Producto prod = repoProd.getReferenceById(id);
        prod.setGenero(prodDto.getGenero());
        prod.setFamilia(prodDto.getFamilia());
        prod.setDenominacion(prodDto.getDenominacion());
        prod.setPrecio(prodDto.getPrecio());
        prod.setStock(prodDto.getStock());

        repoProd.saveAndFlush(prod);

        return mapProd.prodToDtoResponse(prod);
    }

    @Override
    public ProductoDTO sumarStock(int u, Long idProd) {//Agrega al stock las unidades pasadas por parámetro.

        Producto prod = repoProd.getReferenceById(idProd);
        prod.setStock(prod.getStock() + u);
        repoProd.saveAndFlush(prod);

        return mapProd.prodToDtoResponse(prod);
    }

    @Override
    @Transactional
    public ProductoDTO restarStock(int u, Long idProd) {//Resta al stock las unidades pasadas por parámetro.

        Producto prod = repoProd.getReferenceById(idProd);
        int stock = prod.getStock();

        if(stock <= 0){
            throw new RuntimeException("Sin stock");
        }

        prod.setStock(prod.getStock() - u);
        repoProd.saveAndFlush(prod);

        return mapProd.prodToDtoResponse(prod);
    }

    @Override
    public void deleteProducto(Long id) {//Elimina el producto según el id.

        Producto prod = repoProd.getReferenceById(id);
        repoProd.delete(prod);
    }
}
