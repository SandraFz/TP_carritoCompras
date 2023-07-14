package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.model.entities.enums.Genero;

import java.util.List;

public interface IProductoService {

    public ProductoDTO newProduct(ProductoDTO dto);

    public List<Producto> findProducto(String name);

    public List<Producto> findAllProducto();

    public List<Producto> findByGenero(String gen);

    public ProductoDTO editProducto(ProductoDTO prodDto, Long id);

    public ProductoDTO sumarStock(int u, Long idProd);

    public ProductoDTO restarStock(int u, Long idProd);

    public void deleteProducto(Long id);
}
