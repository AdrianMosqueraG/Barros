package com.example.barros_proyect.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario {

    @ApiModelProperty(value = "ID del usuario", dataType = "Integer",
        position = 1, example = "1")
    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @ApiModelProperty(value = "Nombre del usuario", dataType = "String",
        position = 2, example = "barros")
    @NonNull
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @ApiModelProperty(value = "Contraseña del usuario", dataType = "String",
        position = 3, example = "1234")
    @NonNull
    @Column(name = "CONTRASENIA")
    private String contrasenia;
}
