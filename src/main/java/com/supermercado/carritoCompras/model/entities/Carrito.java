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
    @Column(name="id_carrito")
    private Long carrito;

    @OneToOne(mappedBy = "carrito")
    private Cliente cliente;

    @OneToMany(mappedBy = "carrito",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    private List<Compra> compras;
}
