package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Cliente;
import com.example.barros_proyect.service.ClienteServiceImpl;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteServiceImpl;

    @ApiOperation(value = "Obtener un cliente", notes = "Metodo para obtener un cliente a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Cliente> getCliente(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del cliente que se quiere buscar") @PathVariable(name = "id") Integer id) throws Exception {
        Cliente cliente = clienteServiceImpl.getCliente(id);
        return new ResponseEntity<>(cliente,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los clientes", notes = "Metodo para obtener todos los clientes de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Cliente>> getAll(@PageableDefault(size = 5, page = 0)Pageable pageable,
                                                @SearchSpec Specification<Cliente> specs){
        Page<Cliente> clientes = clienteServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(clientes,HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir clientes", notes = "Metodo para añadir a un cliente, el cual necesita recibir todos los campos de cliente")
    @PostMapping("/add")
    public ResponseEntity<Cliente> addCliente(@ApiParam(name = "Objeto_Cliente", type = "Cliente", value = "Objeto Cliente con los campos que quieres añadir") @RequestBody Cliente cliente) {
        Cliente clienteNew = clienteServiceImpl.addCliente(cliente);
        return new ResponseEntity<>(clienteNew, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar clientes", notes = "Metodo para modificar un cliente. Se busca el cliente por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<Cliente> editCliente(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del cliente que se quiere modificar") @PathVariable(name = "id") Integer id, @ApiParam(name = "Objeto_Cliente", type = "Cliente", value = "Objeto Cliente con los campos que se quieren modificar") @RequestBody Cliente newCliente) throws Exception {
        Cliente clienteMod = clienteServiceImpl.modifyCliente(id,newCliente);
        return new ResponseEntity<>(clienteMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar clientes", notes = "Metodo para eliminar un cliente. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteCliente(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del cliente que se quiere borrar") @PathVariable(name = "id") Integer id){
        return clienteServiceImpl.deleteCliente(id);
    }

}
