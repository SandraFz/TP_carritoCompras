package com.supermercado.carritoCompras.model.entities;

import com.supermercado.carritoCompras.model.entities.enums.Genero;
import com.supermercado.carritoCompras.model.entities.enums.RinioneraFlia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false, length = 4)
    private Long id;

    @Column(name="genero", nullable = false, length = 15)
    private Genero genero;

    @Column(name="familia", nullable = false, length = 15)
    private RinioneraFlia familia;

    @Column(name="denominacion", nullable = false, length = 15)
    private String denominacion;

    @Column(name="precio", nullable = false)
    private int precio;

    /*@ManyToMany(mappedBy = "productos")
    private List<Compra> compras;*/
}
