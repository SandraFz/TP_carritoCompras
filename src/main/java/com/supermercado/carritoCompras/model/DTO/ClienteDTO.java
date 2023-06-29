package com.supermercado.carritoCompras.model.DTO;

import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Compra;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    @NotNull
    private Long id;

    @NotNull
    private String dni;
    @NotNull
    private String nombre;
    @NotNull
    private Carrito carrito;
    @NotNull
    private List<Compra> compras;
}
