package com.supermercado.carritoCompras.controller;

import com.supermercado.carritoCompras.model.DTO.ProductoDTO;
import com.supermercado.carritoCompras.model.entities.Producto;
import com.supermercado.carritoCompras.service.interfaces.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prod")
public class ProductoController {

    @Autowired
    public IProductoService servProd;

    @PostMapping("/new")
    public ResponseEntity<ProductoDTO> newProduct(@RequestBody ProductoDTO dto){

        ProductoDTO newProd = servProd.newProduct(dto);

        return ResponseEntity.ok(newProd);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Producto>> findProducto(@PathVariable String name){

        List<Producto> prod = servProd.findProducto(name);

        return ResponseEntity.ok(prod);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> allProducts(){

        List<Producto> productos = servProd.findAllProducto();

        return ResponseEntity.ok(productos);
    }

    @GetMapping("/gen/{gen}")
    public ResponseEntity<List<Producto>> findByGenero(@PathVariable String gen){

        List<Producto> productos = servProd.findByGenero(gen);

        return ResponseEntity.ok(productos);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ProductoDTO> editProducto(@RequestBody ProductoDTO dto,@PathVariable Long id){

        ProductoDTO prodDto = servProd.editProducto(dto, id);

        return ResponseEntity.ok(prodDto);
    }

    @PutMapping("/sumar/{idProd}/{u}")
    public ResponseEntity<ProductoDTO> sumarStock(@PathVariable int u,@PathVariable Long idProd){

        ProductoDTO prod = servProd.sumarStock(u, idProd);

        return ResponseEntity.ok(prod);
    }

    @PutMapping("/restar/{idProd}/{u}")
    public ResponseEntity<ProductoDTO> restarStrock(@PathVariable int u,@PathVariable Long idProd){

        ProductoDTO prod = servProd.restarStock(u, idProd);

        return ResponseEntity.ok(prod);
    }

    @DeleteMapping("/delete/{idProd}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long idProd){

        servProd.deleteProducto(idProd);
        return ResponseEntity.ok().build();
    }
}
