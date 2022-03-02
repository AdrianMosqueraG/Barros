package com.example.barros_proyect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "EVENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @ApiModelProperty(value = "ID del evento", dataType = "Integer",
        position = 1, example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Integer idEvento;

    @ApiModelProperty(value = "Fecha del evento", dataType = "Date",
            position = 2, example = "2022-03-02")
    @NonNull
    @Column(name = "FECHA")
    private Date fecha;

    @ApiModelProperty(value = "Hora de inicio del evento", dataType = "Time",
            position = 3, example = "{\n" +
            "    \"date\": 0,\n" +
            "    \"hours\": 0,\n" +
            "    \"minutes\": 0,\n" +
            "    \"month\": 0,\n" +
            "    \"seconds\": 0,\n" +
            "    \"time\": 0,\n" +
            "    \"year\": 0\n" +
            "  }")
    @NonNull
    @Column(name = "HORA_INICIO")
    private Time horaInicio;

    @ApiModelProperty(value = "Hora de fin del evento", dataType = "Time",
            position = 4, example = "{\n" +
            "    \"date\": 0,\n" +
            "    \"hours\": 0,\n" +
            "    \"minutes\": 0,\n" +
            "    \"month\": 0,\n" +
            "    \"seconds\": 0,\n" +
            "    \"time\": 0,\n" +
            "    \"year\": 0\n" +
            "  }")
    @NonNull
    @Column(name = "HORA_FIN")
    private Time horaFin;

    @ApiModelProperty(value = "Comida o Cena del evento", dataType = "String",
            position = 5, example = "Comida")
    @NonNull
    @Column(name = "COMIDA_CENA")
    private String comidaCena;

    @ApiModelProperty(value = "Numero de comensales del evento", dataType = "Integer",
            position = 6, example = "20")
    @NonNull
    @Column(name = "NUMERO_COMENSALES")
    private Integer numeroComensales;

    @ApiModelProperty(value = "Contrado asociado del evento", dataType = "Integer",
            position = 7, example = "10001")
    @NonNull
    @Column(name = "CONTRATO_ASOCIADO")
    private Integer contratoAsociado;

    @ApiModelProperty(value = "Menu del evento", dataType = "String",
            position = 8, example = "menu")
    @NonNull
    @Column(name = "MENU")
    private String menu;

    @ApiModelProperty(value = "Menu infantil del evento", dataType = "String",
            position = 9, example = "menu infantil")
    @NonNull
    @Column(name = "MENU_INFANTIL")
    private String menuInfantil;

    @ApiModelProperty(value = "Menu especial del evento", dataType = "String",
            position = 10, example = "menu especial")
    @Column(name = "MENU_ESPECIAL")
    private String menuEspecial;

    @ApiModelProperty(value = "Planos del evento", dataType = "String",
            position = 11, example = "planos")
    @NonNull
    @Column(name = "PLANOS")
    private String planos;

    @ApiModelProperty(value = "Dj del evento", dataType = "String",
            position = 12, example = "DJ-Mosquera")
    @Column(name = "DJ")
    private String dj;

    @ApiModelProperty(value = "Musica del salon del evento", dataType = "String",
            position = 13, example = "Jazz")
    @Column(name = "MUSICA_SALON")
    private String musicaSalon;

    @ApiModelProperty(value = "Musica del aperitivo del evento", dataType = "String",
            position = 14, example = "Pop")
    @Column(name = "MUSICA_APERITIVO")
    private String musicaAperitivo;

    @ApiModelProperty(value = "Musica del baile del evento", dataType = "String",
            position = 15, example = "Jazz")
    @Column(name = "MUSICA_BAILE")
    private String musicaBaile;

    @ApiModelProperty(value = "Barra libre del evento", dataType = "String",
            position = 16, example = "Alcohol y agua")
    @Column(name = "BARRA_LIBRE")
    private String barraLibre;

    @ApiModelProperty(value = "Flores del evento", dataType = "String",
            position = 17, example = "Rosas")
    @Column(name = "FLORES")
    private String flores;

    @ApiModelProperty(value = "Ceremonia barros del evento", dataType = "Boolean",
            position = 18, example = "True")
    @Column(name = "CEREMONIA_BARROS")
    private Boolean ceremoniaBarros;

    @ApiModelProperty(value = "Autobuses del evento", dataType = "String",
            position = 19, example = "1 a las 21:00 y otro a la 1:00")
    @Column(name = "AUTOBUSES")
    private String autobuses;

    @ApiModelProperty(value = "Bono autobus del evento", dataType = "Boolean",
            position = 20, example = "False")
    @Column(name = "BONO_AUTOBUS")
    private Boolean bonoAutobus;

    @ApiModelProperty(value = "Bono hotel del evento", dataType = "Boolean",
            position = 21, example = "False")
    @Column(name = "BONO_HOTEL")
    private Boolean bonoHotel;

    @ApiModelProperty(value = "Vinos del evento", dataType = "String",
            position = 22, example = "Tinto y blanco")
    @Column(name = "VINOS")
    private String vinos;

    @ApiModelProperty(value = "Cavas del evento", dataType = "String",
            position = 23, example = "No")
    @Column(name = "CAVA")
    private String cava;

    @ApiModelProperty(value = "Rincones del evento", dataType = "String",
            position = 24, example = "Ninguno")
    @Column(name = "RINCONES")
    private String rincones;

    @ApiModelProperty(value = "Decoraciones del evento", dataType = "String",
            position = 25, example = "Manteles de color rojo")
    @Column(name = "DECORACION")
    private String decoracion;

    @ApiModelProperty(value = "Notas del evento", dataType = "String",
            position = 26, example = "Nada")
    @Column(name = "NOTAS")
    private String notas;

    @ApiModelProperty(value = "ID cliente del evento", dataType = "Cliente",
            position = 27, example = "{\n" +
            "      \"email\": \"dam011.2021@gmail.com\",\n" +
            "      \"idCliente\": 1,\n" +
            "      \"nombre\": \"Adrián\",\n" +
            "      \"observaciones\": \"documentación del proyecto barros\",\n" +
            "      \"primerApellido\": \"Mosquera\",\n" +
            "      \"segundoApellido\": \"García\",\n" +
            "      \"telefono\": 638196003\n" +
            "    }")
    @ManyToMany
    private List<Cliente> clientes;

    /***/
    @JsonIgnore
    @ApiModelProperty(value = "SubSalones del evento", dataType = "List<SubSalon>",
            position = 28)
    @ManyToMany
    private List<SubSalon> subsalones;

    /***/
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty(value = "TipoEvento del evento", dataType = "TipoEvento",
            position = 29)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_EVENTO",nullable = false,updatable = false,insertable = false)
    private TipoEvento tipoEvento;

}
