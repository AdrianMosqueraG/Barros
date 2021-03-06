package com.example.barros_proyect.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente implements Serializable {

    @ApiModelProperty(value = "ID del cliente", dataType = "Integer",
            position = 1, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @ApiModelProperty(value = "Nombre del cliente", dataType = "String",
            position = 2, example = "Adrián")
    @NonNull
    @Column(name = "NOMBRE")
    private String nombre;

    @ApiModelProperty(value = "Primer apellido del cliente", dataType = "String",
        position = 3, example = "Mosquera")
    @NonNull
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;

    @ApiModelProperty(value = "Segundo apellido del cliente", dataType = "String",
        position = 4, example = "García")
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @ApiModelProperty(value = "Telefono del cliente", dataType = "Integer",
        position = 5, example = "638196003")
    @NonNull
    @Column(name = "TELEFONO")
    private Integer telefono;

    @ApiModelProperty(value = "Email del cliente", dataType = "String",
        position = 6, example = "dam011.2021@gmail.com")
    @Column(name = "EMAIL")
    private String email;

    @ApiModelProperty(value = "Observaciones del cliente", dataType = "String",
        position = 7, example = "documentación del proyecto barros")
    @Column(name = "OBSERVACIONES")
    private String observaciones;

    //@ManyToMany
    //private List<Evento> eventos;
}
