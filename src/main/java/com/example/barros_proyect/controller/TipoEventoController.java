package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.TipoEvento;
import com.example.barros_proyect.service.TipoEventoServiceImpl;
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
@RequestMapping("/tipoEvento")
public class TipoEventoController {

    @Autowired
    TipoEventoServiceImpl tipoEventoServiceImpl;

    @ApiOperation(value = "Obtener un tipoEvento", notes = "Metodo para obtener un tipoEvento a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<TipoEvento> getTipoEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del tipoEvento que se quiere buscar") @PathVariable Integer id) throws Exception {
        TipoEvento tipoEvento = tipoEventoServiceImpl.getTipoEvento(id);
        return new ResponseEntity<>(tipoEvento,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los tipoEvento", notes = "Metodo para obtener todos los tipoEvento de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<TipoEvento>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                   @SearchSpec Specification<TipoEvento> specs){
        Page<TipoEvento> tipoEvento = tipoEventoServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(tipoEvento, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir tipoEvento", notes = "Metodo para añadir a un tipoEvento, el cual necesita recibir todos los campos de tipoEvento")
    @PostMapping("/add")
    public ResponseEntity<TipoEvento> addTipoEvento(@ApiParam(name = "Objeto_TipoEvento", type = "TipoEvento", value = "Objeto TipoEvento con los campos que quieres añadir") @RequestBody TipoEvento tipoEvento) {
        TipoEvento tipoEventoAdd = tipoEventoServiceImpl.addTipoEvento(tipoEvento);
        return new ResponseEntity<>(tipoEventoAdd, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar tipoEventos", notes = "Metodo para modificar un tipoEvento. Se busca el tipoEvento por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<TipoEvento> editTipoEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del tipoEvento que se quiere modificar") @PathVariable Integer id, @ApiParam(name = "Objeto_TipoEvento", type = "TipoEvento", value = "Objeto TipoEvento con los campos que se quieren modificar") @RequestBody TipoEvento newTipoEvento) throws Exception {
        TipoEvento tipoEventoMod = tipoEventoServiceImpl.modifyTipoEvento(id,newTipoEvento);
        return new ResponseEntity<>(tipoEventoMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar tipoEvento", notes = "Metodo para eliminar un tipoEvento. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteTipoEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del tipoEvento que se quiere borrar") @PathVariable Integer id){
        return tipoEventoServiceImpl.deleteTipoEvento(id);
    }

}
