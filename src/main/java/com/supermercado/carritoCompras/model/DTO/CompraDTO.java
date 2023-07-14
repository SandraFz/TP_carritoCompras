package com.supermercado.carritoCompras.model.DTO;

import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Cliente;
import com.supermercado.carritoCompras.model.entities.Producto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraDTO {

    @NotNull
    private Long id;

    @NotNull
    private LocalDate fecha;

    @NotNull
    private Cliente cliente;

    @NotNull
    private String detalle;

    @NotNull
    private List<Producto> productos;
}
