package com.example.barros_proyect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUB_SALON")
public class SubSalon implements Serializable {

    @ApiModelProperty(value = "ID del subSalon", dataType = "Integer",
        position = 1, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SUBSALON")
    private Integer idSubSalon;

    @ApiModelProperty(value = "Nombre del subSalon", dataType = "String",
        position = 2, example = "S1")
    @NonNull
    @Column(name = "NOMBRE_SUBSALON")
    private String nombreSubsalon;

    //@ManyToMany
    //List<Evento> eventos;

    @ApiModelProperty(value = "Nombre del salon", dataType = "Salon",
        position = 3, example = "Barros")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SALON", referencedColumnName = "ID_SALON")
    private Salon salon;

}
