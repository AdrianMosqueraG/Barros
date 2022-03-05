package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Salon;
import com.example.barros_proyect.service.SalonServiceImpl;
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
@RequestMapping("/salon")
public class SalonController {

    @Autowired
    SalonServiceImpl salonServiceImpl;

    @ApiOperation(value = "Obtener un salon", notes = "Metodo para obtener un salon a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Salon> getSalon(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del salon que se quiere buscar") @PathVariable Integer id) throws Exception {
        Salon salon = salonServiceImpl.getSalon(id);
        return new ResponseEntity<>(salon,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los salones", notes = "Metodo para obtener todos los salones de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Salon>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                              @SearchSpec Specification<Salon> specs){
        Page<Salon> salones = salonServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(salones, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir salones", notes = "Metodo para añadir un salon, el cual necesita recibir todos los campos de salon")
    @PostMapping("/add")
    public ResponseEntity<Salon> addSalon(@ApiParam(name = "Objeto_Salon", type = "Salon", value = "Objeto Salon con los campos que quieres añadir") @RequestBody Salon salon) {
        Salon salonNew = salonServiceImpl.addSalon(salon);
        return new ResponseEntity<>(salonNew, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar Salones", notes = "Metodo para modificar un salon. Se busca el salon por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<Salon> editSalon(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del salon que se quiere modificar") @PathVariable Integer id, @ApiParam(name = "Objeto_Salon", type = "Salon", value = "Objeto Salon con los campos que se quieren modificar") @RequestBody Salon newSalon) throws Exception {
        Salon salonMod = salonServiceImpl.modifySalon(id,newSalon);
        return new ResponseEntity<>(salonMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar salon", notes = "Metodo para eliminar un salon. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteSalon(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del salon que se quiere borrar") @PathVariable Integer id){
        return salonServiceImpl.deleteSalon(id);
    }

}
