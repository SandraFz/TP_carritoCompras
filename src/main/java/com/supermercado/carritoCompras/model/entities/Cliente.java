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
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",
            nullable = false,
            length = 4)
    private Long id;

    @Column(name="dni")
    private String dni;

    @Column(name="nombre",
            nullable = false,
            length = 30)
    private String nombre;

    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)//https://docs.oracle.com/javaee/6/api/javax/persistence/OneToOne.html
    @JoinColumn(name = "carrito")
    private Carrito carrito;

    @OneToMany(mappedBy = "cliente",
            fetch = FetchType.LAZY,
            orphanRemoval = true,
            cascade = CascadeType.ALL)//https://docs.oracle.com/javaee/6/api/javax/persistence/OneToMany.html
    private List<Compra> compras;

}
