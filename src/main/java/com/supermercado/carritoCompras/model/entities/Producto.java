package com.supermercado.carritoCompras.model.entities;

import com.supermercado.carritoCompras.model.entities.enums.Genero;
import com.supermercado.carritoCompras.model.entities.enums.RinioneraFlia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false, length = 4)
    private Long id;

    /*@Column(name="genero", nullable = false, length = 15)
    private Genero genero;*/

    @Column(name="genero", nullable = false, length = 15)
    private String genero;

    @Column(name="familia", nullable = false, length = 15)
    private String familia;

    @Column(name="denominacion")
    private String denominacion;

    @Column(name="precio", nullable = false)
    private int precio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Column(name="stock")
    private int stock;

    /*public void setFamilia(Genero fam) {
        Genero genero = getGenero();
        Genero familia;
        genero.familia;
        switch (fam){
            case CLASICA:
                familia = genero.CLASICA;
                break;

            case

        }

        this.familia = fam;
    }*/
}
/*Métodos:
* Agregar producto;
* Listar todos los productos;
* Buscar productos por nombre;
* Buscar productos por categoría;
* Buscar productos por familia;
* Editar producto;
* Eliminar producto;
* Sunar unidades/ actualizar stock;
* Restar unidades/ actualizar stock;
*  */
