package com.supermercado.carritoCompras.controller;

import com.supermercado.carritoCompras.model.DTO.ReferenciaDTO;
import com.supermercado.carritoCompras.model.entities.Referencia;
import com.supermercado.carritoCompras.service.interfaces.IReferenciaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ref")
public class ReferenciaController {

    @Autowired
    public IReferenciaService servRef;

    @PostMapping("/new/{idCli}/{idProd}")
    public ResponseEntity<ReferenciaDTO> newReferencia(@RequestBody ReferenciaDTO dto, @PathVariable Long idCli, @PathVariable Long idProd){

        ReferenciaDTO ref = servRef.newReferencia(dto, idCli, idProd);
        return ResponseEntity.ok(ref);
    }

    @PostMapping("/new/{idCli}")
    public ResponseEntity<ReferenciaDTO> newReferenciaB(@RequestBody ReferenciaDTO refDto,@PathVariable Long idCli){

        ReferenciaDTO ref = servRef.newReferenciaB(refDto, idCli);
        return ResponseEntity.ok().body(ref);
    }

    @GetMapping("/all/{idCli}")
    public ResponseEntity<List<Referencia>> allReferencias(@PathVariable Long idCli){

        List<Referencia> referencias = servRef.allRef(idCli);

        return ResponseEntity.ok().body(referencias);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ReferenciaDTO> editRef(@RequestBody ReferenciaDTO refDto,@PathVariable Long id){

        ReferenciaDTO dto = servRef.editRef(refDto, id);

        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReferencia(@PathVariable Long id){

        servRef.deleteRef(id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/sumarU/{idRef}/{u}")
    public ResponseEntity<Integer> agregarUnidad(@PathVariable int u,@PathVariable Long idRef){

        int cant = servRef.agregarUnidad(u, idRef);

        return ResponseEntity.ok(cant);
    }

    @PutMapping("/restarU/{idRef}/{u}")
    public ResponseEntity<Integer> restarUnidad(@PathVariable int u,@PathVariable Long idRef){

        int cant = servRef.restarUnidad(u, idRef);

        return ResponseEntity.ok(cant);
    }
}
