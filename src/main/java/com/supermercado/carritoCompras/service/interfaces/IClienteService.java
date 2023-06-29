package com.supermercado.carritoCompras.service.interfaces;

import com.supermercado.carritoCompras.model.DTO.ClienteDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IClienteService {

public ClienteDTO newCliente(ClienteDTO cliDto);
public List<ClienteDTO> allClientes();
public ClienteDTO findByDni(String dni);
public ClienteDTO editCliente(ClienteDTO cliDto);
public void deleteCliente(Long id);
}
