package com.example.barros_proyect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TIPO_EVENTO")
public class TipoEvento {

    @ApiModelProperty(value = "ID del tipoEvento", dataType = "Integer",
        position = 1, example = "1")
    @Id
    @GeneratedValue
    @Column(name = "ID_TIPO_EVENTO")
    private Integer idTipoEvento;

    @ApiModelProperty(value = "Nombre del tipoEvento", dataType = "String",
        position = 2, example = "ComidaBarros")
    @NonNull
    @Column(name = "NOMBRE_EVENTO")
    private String nombreEvento;

    @JsonIgnore
    @OneToMany(mappedBy ="tipoEvento" ,cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();
}
