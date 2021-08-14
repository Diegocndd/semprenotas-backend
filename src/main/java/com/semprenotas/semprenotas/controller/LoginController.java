package com.semprenotas.semprenotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.semprenotas.semprenotas.model.*;
import com.semprenotas.semprenotas.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

    @Autowired
    private UsuarioRepository UsuarioRepository;

    @CrossOrigin
    @PostMapping
    public String login(@RequestBody Usuario usuario){
        List<Usuario> passwordUser = UsuarioRepository.findByName(usuario.getName());
        
        if (passwordUser.get(0).getPassword().equals(usuario.getPassword())) {
            String tokenUser = Token.generateRandomToken(20);
            Usuario newUser = new Usuario();
            newUser.setName(usuario.getName());
            newUser.setPassword(usuario.getPassword());
            newUser.setNotas(passwordUser.get(0).getNotas());
            newUser.setToken(tokenUser);
            UsuarioRepository.delete(passwordUser.get(0));
            UsuarioRepository.save(newUser);
            return newUser.getToken();
        } else {
            return "Password or username incorrect";
        }
    }
}
