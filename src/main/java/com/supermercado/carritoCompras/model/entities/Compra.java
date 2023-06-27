package com.supermercado.carritoCompras.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="fecha_compra")
    private Date fecha;

    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)//https://docs.oracle.com/javaee/6/api/javax/persistence/ManyToOne.html
    @JoinColumn(name = "cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "carrito")
    private Carrito carrito;

    @ManyToMany(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL)//https://docs.oracle.com/javaee/6/api/javax/persistence/ManyToMany.html
    @JoinTable(name="productos_comprados")
    private List<Producto> productos;
}
