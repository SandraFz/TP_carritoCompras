package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.service.interfaces.IClienteService;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    public IClienteRepository repo;

    @Autowired
    public ClienteMapper mapper;


    @Override
    @Transactional
    public ClienteDTO newCliente(ClienteDTO cliDto) {

        Cliente cli = new Cliente();

        if(!repo.existsByDni(cliDto.getDni())) {
            throw new RuntimeException("El cliente ya existe");
        }
        cli = mapper.dtoToClientRequest(cliDto);
        repo.save(cli);
        ClienteDTO newcliDTo = mapper.clientToDtoResponse(cli);
        return newcliDTo;
    }

    @Override
    public List<ClienteDTO> allClientes() {

        List<Cliente> clientes;
        clientes = repo.findAll();
        List<ClienteDTO> listaCli = new ArrayList<>();
        for (Cliente cli: clientes) {
            listaCli.add(mapper.clientToDtoResponse(cli));
        }
        return  listaCli;
    }

    @Override
    public ClienteDTO findByDni(String dni) {

        Cliente cliDto = new Cliente();
        cli = repo.findCliente(dni);
        mapper.dtoToClientRequest()


        return cliDto;
    }

    @Override
    public ClienteDTO editCliente(ClienteDTO cliDto) {
        return null;
    }

    @Override
    public void deleteCliente(Long id) {

    }
}
