package com.supermercado.carritoCompras.model.mapper;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.model.entities.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente dtoToClientRequest(ClienteDTO cliDto){

        Cliente cli = new Cliente();

        cli.setId(cliDto.getId());
        cli.setNombre(cliDto.getNombre());
        cli.setCarrito(cliDto.getCarrito());
        cli.setCompras(cliDto.getCompras());

        return cli;
    }

    public ClienteDTO clientToDtoResponse(Cliente cli){

        ClienteDTO cliDto = new ClienteDTO();

        cliDto.setId(cli.getId());
        cliDto.setNombre(cli.getNombre());
        cliDto.setCarrito(cli.getCarrito());
        cliDto.setCompras(cli.getCompras());

        return cliDto;
    }
}
