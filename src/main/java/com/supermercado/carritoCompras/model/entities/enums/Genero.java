package com.supermercado.carritoCompras.model.entities.enums;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="generos")
public enum Genero {

    RINIONERA, MORRAL, BOLSO, MOCHILA, ACCESORIO;

}
