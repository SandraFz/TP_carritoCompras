package com.supermercado.carritoCompras.controller;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    public IClienteService serv;

    @PostMapping("/new")
    public ResponseEntity<ClienteDTO> newCliente(@RequestBody ClienteDTO cliDto){

        ClienteDTO cli = serv.newCliente(cliDto);
        //CarritoDTO car = serCar.newCarrito();
        return ResponseEntity.ok().body(cli);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTO>> allClient(){

        List clientes = new ArrayList<ClienteDTO>();
        clientes = serv.allClientes();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ClienteDTO> findById(@PathVariable Long id){

        ClienteDTO cli = serv.findById(id);
        return ResponseEntity.ok().body(cli);
    }

    @GetMapping("/findDni/{dni}")
    public ResponseEntity<ClienteDTO> findByDni(@PathVariable String dni){

        ClienteDTO cli = serv.findByDni(dni);
        return ResponseEntity.ok().body(cli);
    }

    @PutMapping("/edit/{dni}")
    public ResponseEntity<ClienteDTO> editCliente(@RequestBody ClienteDTO cliDto,
                                                  @PathVariable String dni){

        ClienteDTO cli = serv.editCliente(cliDto, dni);
        return ResponseEntity.ok().body(cli);
    }

    @DeleteMapping("/delet/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id){

        serv.deleteCliente(id);
        return ResponseEntity.ok().build();
    }
}
