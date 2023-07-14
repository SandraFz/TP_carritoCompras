package com.supermercado.carritoCompras.controller;

import com.supermercado.carritoCompras.model.DTO.CompraDTO;
import com.supermercado.carritoCompras.model.entities.Compra;
import com.supermercado.carritoCompras.service.interfaces.ICompraService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    public ICompraService servCom;

    @PostMapping("/new")
    public ResponseEntity<CompraDTO> newCompra(CompraDTO dto, Long id){

        CompraDTO com = servCom.newCompra(dto, id);

        return ResponseEntity.ok(com);
    }

    @GetMapping("/findById")
    public ResponseEntity<Compra> findCompras(Long id){

        Compra com = servCom.findCompraById(id);

        return ResponseEntity.ok(com);
    }

    @GetMapping("/allByCliente")
    public ResponseEntity<List<Compra>> allByCliente(Long id){

        List<Compra> compras = servCom.findByCliente(id);

        return ResponseEntity.ok(compras);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Compra>> allCompras(){

        List<Compra> compras = servCom.allCompras();

        return ResponseEntity.ok(compras);
    }

    @GetMapping("/findByFecha")
    public ResponseEntity<List<Compra>> findByFecha(Date fecha){

        List<Compra> compras = servCom.findByFecha(fecha);

        return ResponseEntity.ok(compras);
    }

    @GetMapping("/findBetween")
    public ResponseEntity<List<Compra>> findBetween(int desde, int hasta){

        List<Compra> compras = servCom.findBetween(desde, hasta);

        return ResponseEntity.ok(compras);
    }
}
