package com.supermercado.carritoCompras.controller;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.service.interfaces.ICarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    public ICarritoService serv;

    @PutMapping("/newRef/{idCli}/{idProd}") //Crea una nueva referencia con los datos recibidos por parámetro y los vincula al cliente cuyo id también se pasa por parámetro.
    public ResponseEntity<ReferenciaDTO> newReferencia(@RequestBody ReferenciaDTO dto,@PathVariable Long idCli, @PathVariable Long idProd){

        ReferenciaDTO ref = serv.agregarReferencia(dto, idCli, idProd);

        return ResponseEntity.ok().body(ref);
    }

    @PutMapping("/vaciar")
    public ResponseEntity<Void> vaciarCarrito(Long id){

        serv.vaciarCarrito(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/comprar")
    public ResponseEntity<String> comprar(Long idCli){

        serv.comprar(idCli);

        return ResponseEntity.ok().build();
    }
}
