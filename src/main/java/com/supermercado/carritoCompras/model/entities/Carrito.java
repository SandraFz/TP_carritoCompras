package com.supermercado.carritoCompras.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToOne(mappedBy = "carrito")
    private Cliente cliente;

    /*@ManyToOne
    @JoinColumn(name = "referencias")
    private Referencia referencia;*/

    @OneToMany(mappedBy = "carrito",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Referencia> referencias;

    @Column(name = "total")
    private double total;
}
/*Métodos:
* Crear carrito/vincular a cliente;
* Agregar producto/actualizar stock;
* Quitar poducto/actualizar stock;
* Comprar/vaciar carrito;
* Vaciar carrito/quitar productos/actualizar stock;
* */