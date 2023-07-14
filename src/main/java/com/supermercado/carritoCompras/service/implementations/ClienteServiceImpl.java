package com.supermercado.carritoCompras.service.implementations;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.mapper.CarritoMapper;
import com.supermercado.carritoCompras.model.mapper.ClienteMapper;
import com.supermercado.carritoCompras.service.interfaces.IClienteService;
import com.supermercado.carritoCompras.service.repositories.IClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    public IClienteRepository repo;

    @Autowired
    public ClienteMapper mapper;

    @Autowired
    public CarritoServImpl carServ;

    @Autowired
    public CarritoMapper carMapper;

    @Override
    @Transactional
    public ClienteDTO newCliente(ClienteDTO cliDto) {

        Cliente cli;

        if(repo.existsByDni(cliDto.getDni())) {
            throw new RuntimeException("El cliente ya existe");
        } else {
        cli = mapper.dtoToClientRequest(cliDto);
        repo.save(cli);

        /*Desde aquí inserto el código para crear automáticamente un carrito y una lista de compras únicos por cliente*/
            Long idCli = cli.getId();
            carServ.crearCarrito(idCli);
           // List<Compra> compras = new ArrayList<>();
            //cli.getCompras()
            //repo.saveAndFlush(cli);


        return mapper.clientToDtoResponse(cli);}
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
    public ClienteDTO findById(Long id){

        Cliente cli = repo.getReferenceById(id);

        return mapper.clientToDtoResponse(cli);
    }

    @Override
    public ClienteDTO findByDni(String dni) {

        Cliente cli;
        cli = repo.findCliente(dni);

        return mapper.clientToDtoResponse(cli);
    }

    @Override
    @Transactional
    public ClienteDTO editCliente(ClienteDTO cliDto, String dni) {

        Cliente cli = mapper.dtoToClientRequest(findByDni(dni));
        cli.setDni(cliDto.getDni());
        cli.setNombre(cliDto.getNombre());
        cli.setCarrito(cliDto.getCarrito());
        repo.saveAndFlush(cli);

        return mapper.clientToDtoResponse(cli);
    }

    @Override
    public void deleteCliente(Long id) {

        repo.deleteById(id);
    }
}
