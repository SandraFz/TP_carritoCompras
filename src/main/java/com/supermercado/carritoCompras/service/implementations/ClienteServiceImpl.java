package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.service.interfaces.IClienteService;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        return null;
    }

    @Override
    public List<ClienteDTO> allClientes() {
        return null;
    }

    @Override
    public ClienteDTO findCliente(Long id) {
        return null;
    }

    @Override
    public ClienteDTO editCliente(ClienteDTO cliDto) {
        return null;
    }

    @Override
    public void deleteCliente(Long id) {

    }
}
