package com.semprenotas.semprenotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.semprenotas.semprenotas.model.*;
import com.semprenotas.semprenotas.repository.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @CrossOrigin
    @GetMapping
    public Boolean listar(@RequestBody Usuario usuario){
        List<Usuario> passwordUser = UsuarioRepository.findByName(usuario.getName());

        return passwordUser.get(0).getPassword().equals(usuario.getPassword());
    }
}
