package com.supermercado.carritoCompras.model.entities.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="generos")
public enum Genero {

    RINIONERA(FliaRinio.class),
    MORRAL(FliaMorral.class),
    BOLSO(FliaBolso.class),
    MOCHILA(FliaMochila.class),
    ACCESORIO(FliaAccesorio.class);

    private final Class<? extends Enum<?>> subEnumClass;

    Genero(Class<? extends Enum<?>> subEnumClass) {
        this.subEnumClass =  subEnumClass;
    }
}
