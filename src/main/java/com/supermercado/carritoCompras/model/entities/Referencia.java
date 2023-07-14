package com.supermercado.carritoCompras.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="referencia")
public class Referencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cantidad")
    private Integer cantidad;

    /*@OneToOne(cascade = CascadeType.ALL,
    orphanRemoval = true)
    @JoinColumn(name = "producto")
    private Producto producto;
*/

    //@OneToOne(cascade = CascadeType.ALL,
            //orphanRemoval = true)
    //@JoinColumn(name = "producto")
    @Column(name = "producto")
    private String idProd;
    @Column(name="subtotal")
    private Double subt;

    @ManyToOne
    @JoinColumn(name="carrito")
    private Carrito carrito;
}
/*Métodos:
* Crear nueva referencia/asociar a carrito;
* Sumar unidad/actualizar sutotal/actualizar stock;
* Restar unidad/actualizar subtotal/actualizar stock;
* */
