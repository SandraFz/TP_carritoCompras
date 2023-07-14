package com.supermercado.carritoCompras.model.DTO;

import com.supermercado.carritoCompras.model.entities.enums.Genero;
import com.supermercado.carritoCompras.model.entities.enums.RinioneraFlia;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    private Long id;

    private String genero;

    private String familia;

    private String denominacion;

    private int precio;

    private int stock;
}
