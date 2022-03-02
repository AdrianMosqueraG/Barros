package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.SubSalon;
import com.example.barros_proyect.service.SubSalonServiceImpl;
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
@RequestMapping("/subSalon")
public class SubSalonController {

    @Autowired
    SubSalonServiceImpl subSalonServiceImpl;

    @ApiOperation(value = "Obtener un subSalon", notes = "Metodo para obtener un subSalon a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<SubSalon> getSubSalon(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del subSalon que se quiere buscar") @PathVariable Integer id) throws Exception {
        SubSalon subSalon = subSalonServiceImpl.getSubsalon(id);
        return new ResponseEntity<>(subSalon,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los subSalones", notes = "Metodo para obtener todos los subSalones de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<SubSalon>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                 @SearchSpec Specification<SubSalon> specs){
        Page<SubSalon> subSalones = subSalonServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(subSalones, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir subSalones", notes = "Metodo para añadir a un subSalon, el cual necesita recibir todos los campos de subSalon")
    @PostMapping("/add")
    public ResponseEntity<SubSalon> addSubSalon(@ApiParam(name = "Objeto_SubSalon", type = "SubSalon", value = "Objeto SubSalon con los campos que quieres añadir") @RequestBody SubSalon subSalon) {
        SubSalon subSalonAdd = subSalonServiceImpl.addSubSalon(subSalon);
        return new ResponseEntity<>(subSalonAdd, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar subSalones", notes = "Metodo para modificar un subSalon. Se busca el subSalon por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<SubSalon> editEvento(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del subSalon que se quiere modificar") @PathVariable Integer id, @ApiParam(name = "Objeto_SubSalon", type = "SubSalon", value = "Objeto SubSalon con los campos que se quieren modificar") @RequestBody SubSalon newSubSalon) throws Exception {
        SubSalon subSalonMod = subSalonServiceImpl.modifySubSalon(id,newSubSalon);
        return new ResponseEntity<>(subSalonMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar subSalones", notes = "Metodo para eliminar un subSalon. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteSubSalon(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del subSalon que se quiere borrar") @PathVariable Integer id){
        return subSalonServiceImpl.deleteSubSalon(id);
    }

}
