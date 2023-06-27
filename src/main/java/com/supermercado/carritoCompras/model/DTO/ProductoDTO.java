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

    @NotNull
    private Long id;

    @NotNull
    private Genero genero;

    @NotNull
    private RinioneraFlia familia;

    @NotNull
    private String denomination;

    @NotNull
    private int precio;
}
