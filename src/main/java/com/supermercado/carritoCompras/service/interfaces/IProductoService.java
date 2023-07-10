package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.model.entities.enums.Genero;

import java.util.List;

public interface IProductoService {

    public ProductoDTO newProduct(ProductoDTO dto);

    Producto findProducto(String name);

    public List<Producto> findAllProducto();

    public List<Producto> finByGenero(String gen);

    public ProductoDTO editProducto(ProductoDTO prodDto, Long id);

    public ProductoDTO sumarStock(int u);

    public ProductoDTO restarStock(int u);

    public void deleteProducto(Long id);
}
