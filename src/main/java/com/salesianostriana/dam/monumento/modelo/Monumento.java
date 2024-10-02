package com.salesianostriana.dam.monumento.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Monumento {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    /*poner en cada uno el column si quieres qeu aparezca como columna*/
    @Column(name = "cod_pais")
    private String codPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    private String descripcion;
    private String imagen;
}
