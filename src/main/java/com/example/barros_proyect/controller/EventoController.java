package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Evento;
import com.example.barros_proyect.service.EventoServiceImpl;
import com.sipios.springsearch.anotation.SearchSpec;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    EventoServiceImpl eventoServiceImpl;

    @ApiOperation(value = "Obtener un evento", notes = "Metodo para obtener un evento a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Evento> getCliente(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del evento que se quiere buscar") @PathVariable Integer id) throws Exception {
        Evento evento = eventoServiceImpl.getEvento(id);
        return new ResponseEntity<>(evento,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los eventos", notes = "Metodo para obtener todos los eventos de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Evento>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                               @SearchSpec Specification<Evento> specs){
        Page<Evento> eventos = eventoServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir eventos", notes = "Metodo para añadir un evento, el cual necesita recibir todos los campos de evento")
    @PostMapping("/add")
    public ResponseEntity<Evento> addEvento(@ApiParam(name = "Objeto_Evento", type = "Evento", value = "Objeto Evento con los campos que quieres añadir") @RequestBody Evento evento) {
        Evento eventoAdd = eventoServiceImpl.addEvento(evento);
        return new ResponseEntity<>(eventoAdd, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar eventos", notes = "Metodo para modificar un evento. Se busca el evento por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<Evento> editEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del evento que se quiere modificar") @PathVariable Integer id, @ApiParam(name = "Objeto_Evento", type = "Evento", value = "Objeto Evento con los campos que se quieren modificar") @RequestBody Evento newEvento) throws Exception {
        Evento eventoMod = eventoServiceImpl.modifyEvento(id,newEvento);
        return new ResponseEntity<>(eventoMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar eventos", notes = "Metodo para eliminar un evento. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del evento que se quiere borrar") @PathVariable Integer id){
        return eventoServiceImpl.deleteEvento(id);
    }

}
