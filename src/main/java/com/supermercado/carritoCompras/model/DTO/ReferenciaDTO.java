package com.supermercado.carritoCompras.model.DTO;

import com.supermercado.carritoCompras.model.entities.Carrito;
import com.supermercado.carritoCompras.model.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReferenciaDTO {

    private Long id;

    private Integer cant;

    private Producto producto;

    private double subt;

    private Carrito carrito;
}
