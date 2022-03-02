package com.example.barros_proyect.controller;

import com.example.barros_proyect.domain.Usuario;
import com.example.barros_proyect.service.UsuarioServiceImpl;
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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @ApiOperation(value = "Obtener un usuario", notes = "Metodo para obtener un usuario a traves de su ID")
    @GetMapping("/get/{id}")
    public ResponseEntity<Usuario> getUsuario(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del usuario que se quiere buscar") @PathVariable Integer id) throws Exception {
        Usuario usuario = usuarioServiceImpl.getUsuario(id);
        return new ResponseEntity<>(usuario,HttpStatus.OK);
    }

    @ApiOperation(value = "Obtener todos los usuarios", notes = "Metodo para obtener todos los usuarios de forma paginada")
    @GetMapping("/getAll")
    public ResponseEntity<Page<Usuario>> getAll(@PageableDefault(size = 5, page = 0) Pageable pageable,
                                                @SearchSpec Specification<Usuario> specs){
        Page<Usuario> usuarios = usuarioServiceImpl.getAll(pageable,specs);
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @ApiOperation(value = "Añadir usuarios", notes = "Metodo para añadir a un usuario, el cual necesita recibir todos los campos de usuario")
    @PostMapping("/add")
    public ResponseEntity<Usuario> addUsuario(@ApiParam(name = "Objeto_Usuario", type = "Usuario", value = "Objeto Usuario con los campos que quieres añadir") @RequestBody Usuario usuario) {
        Usuario usuarioAdd = usuarioServiceImpl.addUsuario(usuario);
        return new ResponseEntity<>(usuarioAdd, HttpStatus.OK);
    }

    @ApiOperation(value = "Modificar usuarios", notes = "Metodo para modificar un usuario. Se busca el usuario por su ID y si existe se modifican sus parametros por los introducidos")
    @PutMapping("/mod/{id}")
    public ResponseEntity<Usuario> editUsuario(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del usuario que se quiere modificar") @PathVariable Integer id, @ApiParam(name = "Objeto_Usuario", type = "Usuario", value = "Objeto Usuario con los campos que se quieren modificar") @RequestBody Usuario newUsuario) throws Exception {
        Usuario usuarioMod = usuarioServiceImpl.modifyUsuario(id,newUsuario);
        return new ResponseEntity<>(usuarioMod,HttpStatus.OK);
    }

    @ApiOperation(value = "Eliminar usuarios", notes = "Metodo para eliminar un usuario. Se busca su ID y si existe se elimina")
    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@ApiParam(example = "1", name = "id", type = "Integer", value = "ID del usuario que se quiere borrar") @PathVariable Integer id){
        return usuarioServiceImpl.deleteUsuario(id);
    }

}
