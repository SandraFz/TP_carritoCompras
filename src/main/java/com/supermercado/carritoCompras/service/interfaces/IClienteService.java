package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;

import java.util.List;

public interface IClienteService {

public ClienteDTO newCliente(ClienteDTO cliDto);
public List<ClienteDTO> allClientes();
public ClienteDTO findCliente(Long id);
public ClienteDTO editCliente(ClienteDTO cliDto);
public void deleteCliente(Long id);
}
