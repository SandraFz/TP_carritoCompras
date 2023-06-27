package com.supermercado.carritoCompras.model.DTO;

import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.entities.Compra;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarritoDTO {

    @NotNull
    private Long id;

    @NotNull
    private Cliente cliente;

    @NotNull
    private List<Compra> compras;

}
